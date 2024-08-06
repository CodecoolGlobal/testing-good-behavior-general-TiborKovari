package com.codecool.exceptions;

public class RatingValueOutOfRangeException extends RuntimeException {
    public RatingValueOutOfRangeException() {
        super("Value is out of range! It should be between 0 and 10");
    }
}
