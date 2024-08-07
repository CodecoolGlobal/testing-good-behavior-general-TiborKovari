package com.codecool.devtests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegisterTest extends BaseTest{
    private final String validUsername = "test6";
    private final String validEmail = "test6@test.com";
    private final String validPassword = "Test1234";
    private final String inValidUsername = "";
    private final String inValidEmail = "test6test.com";
    private final String inValidPassword = "test1234";
    private final String SUCCESSFUL_REGISTRATION_MESSAGE = "Thank you for registering to our website!";

    @BeforeEach
    public void preCondition() {
        openNewDriver("register");
    }

    @Test
    public void testRegisterWithValidCredentials() {
        registerUser(validUsername, validEmail, validPassword);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        alert = wait.until(ExpectedConditions.alertIsPresent());

        assertEquals(SUCCESSFUL_REGISTRATION_MESSAGE, alert.getText());

        alert.accept();
    }

    @Test
    public void testRegisterWithInValidCredentials() {
        registerUser(inValidUsername, inValidEmail, inValidPassword);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        boolean isAlertPresent = false;

        try {
            alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertMessage = alert.getText();
            System.out.println("Alert Message: " + alertMessage);

            if (alertMessage.equals(SUCCESSFUL_REGISTRATION_MESSAGE)) {
                isAlertPresent = true;
            }

            alert.accept();
        } catch (TimeoutException e) {
            System.out.println("No alert present, registration likely failed as expected.");
        }

        assertFalse(isAlertPresent, "The success message should not be present for invalid credentials.");
    }

    @AfterEach
    public void postCondition() {
        quitDriver();
    }
}
