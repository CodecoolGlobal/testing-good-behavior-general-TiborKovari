package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
    private final String validEmail = "AutomTest@test.com";
    private final String validPassword = "AutomTest0123";
    private final String invalidEmail = "invalid@invalid.com";
    private final String invalidPassword = "invalid";
    private final String INVALID_CREDENTIALS_ALERT_MESSAGE = "Bad username/password";

    @BeforeEach
    public void precondition() {
        openNewDriver("login");
    }

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
        loginUser(validEmail, validPassword);
        Thread.sleep(1000);
        assertEquals(BASE_URL, webDriver.getCurrentUrl()); // TODO: assert to welcome message OR dropdown at the top
    }

    @Test
    public void testLoginWithInvalidCredentials() throws InterruptedException {
        loginUser(invalidEmail, invalidPassword);
        Thread.sleep(1000);
        alert = webDriver.switchTo().alert();
        assertEquals(INVALID_CREDENTIALS_ALERT_MESSAGE, alert.getText());
    }

    @AfterEach
    public void postcondition() {
        closeDriver();
    }
}
