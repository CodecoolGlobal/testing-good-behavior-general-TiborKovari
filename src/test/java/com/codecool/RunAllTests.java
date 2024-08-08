package com.codecool;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "com.codecool.stepdefinitions", // Package where your step definitions are located
        // dryRun = true, // Only runs tests which have codes
        plugin = {"pretty", "html:target/reports", "json:target/cucumber.json"}
)
public class RunAllTests {
}
