#!/bin/bash

# VARIABLES
DB_NAME="bytebattlers"
DB_USER="bytebattlers"
DB_HOST="postgres"
DB_PORT="5432"
DB_PASSWORD="bytebattlers"
CONTAINER_NAME="postgres"

# SCRIPT
container=$(docker ps | grep postgres | awk '{print $1}')

#
docker exec "$container" chmod +x /docker-entrypoint-initdb.d/import.sql

# Database credentials

# Set the PGPASSWORD environment variable
export PGPASSWORD="$DB_PASSWORD"

# Run the SQL script using psql
docker exec -e PGPASSWORD="$DB_PASSWORD" -i "$CONTAINER_NAME" psql -U "$DB_USER" -d "$DB_NAME" <<EOF
DO
\$\$
DECLARE
    rec RECORD;
BEGIN
    -- Drop all views
    FOR rec IN (SELECT schemaname, viewname FROM pg_views WHERE schemaname = 'public') LOOP
        EXECUTE 'DROP VIEW IF EXISTS ' || quote_ident(rec.schemaname) || '.' || quote_ident(rec.viewname) || ' CASCADE';
    END LOOP;

    -- Drop all materialized views
    FOR rec IN (SELECT schemaname, matviewname FROM pg_matviews WHERE schemaname = 'public') LOOP
        EXECUTE 'DROP MATERIALIZED VIEW IF EXISTS ' || quote_ident(rec.schemaname) || '.' || quote_ident(rec.matviewname) || ' CASCADE';
    END LOOP;

    -- Drop all tables
    FOR rec IN (SELECT schemaname, tablename FROM pg_tables WHERE schemaname = 'public') LOOP
        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(rec.schemaname) || '.' || quote_ident(rec.tablename) || ' CASCADE';
    END LOOP;

    -- Drop all sequences
    FOR rec IN (SELECT schemaname, sequencename FROM pg_sequences WHERE schemaname = 'public') LOOP
        EXECUTE 'DROP SEQUENCE IF EXISTS ' || quote_ident(rec.schemaname) || '.' || quote_ident(rec.sequencename) || ' CASCADE';
    END LOOP;

     -- Drop all extensions
    FOR rec IN (SELECT extname FROM pg_extension WHERE extname != 'plpgsql') LOOP
        EXECUTE 'DROP EXTENSION IF EXISTS ' || quote_ident(rec.extname) || ' CASCADE';
    END LOOP;

    -- Drop all functions
    FOR rec IN (SELECT n.nspname as schemaname,
                       p.proname as funcname,
                       pg_catalog.pg_get_function_identity_arguments(p.oid) as funcargs
                FROM pg_catalog.pg_proc p
                     LEFT JOIN pg_catalog.pg_namespace n ON n.oid = p.pronamespace
                WHERE n.nspname = 'public') LOOP
        EXECUTE 'DROP FUNCTION IF EXISTS ' || quote_ident(rec.schemaname) || '.' || quote_ident(rec.funcname) || '(' || rec.funcargs || ') CASCADE';
    END LOOP;


END
\$\$;
EOF

unset PGPASSWORD

echo "Every has been wiped successfully!"

PSQL_COMMAND="PGPASSWORD=$DB_PASSWORD psql -U $DB_USER -h $DB_HOST -p $DB_PORT -d $DB_NAME"
docker exec -i $container bash -c "$PSQL_COMMAND < /docker-entrypoint-initdb.d/import.sql"

echo "Database got initialized with default data successfully!"
