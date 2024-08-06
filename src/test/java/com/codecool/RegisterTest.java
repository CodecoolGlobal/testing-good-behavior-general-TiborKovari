package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest extends BaseTest{
    private final String validUsername = "test4";
    private final String validEmail = "test4@test.com";
    private final String validPassword = "Test1234";
    private final String SUCCESSFUL_REGISTRATION_MESSAGE = "Thank you for registering to our website!";

    @BeforeEach
    public void preCondition() {
        openNewDriver("register");
    }

    @Test
    public void testRegisterWithValidCredentials() throws InterruptedException {
        registerUser(validUsername, validEmail, validPassword);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        alert = wait.until(ExpectedConditions.alertIsPresent());

        // Assert the alert message
        assertEquals(SUCCESSFUL_REGISTRATION_MESSAGE, alert.getText());

        // Accept the alert (click "OK")
        alert.accept();
    }

    @AfterEach
    public void postCondition() {
        quitDriver();
    }
}
