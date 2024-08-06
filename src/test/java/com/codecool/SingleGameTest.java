package com.codecool;

import com.codecool.pages.SingleGamePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleGameTest extends BaseTest {
    private final String validEmail = "AutomTest@test.com";
    private final String validPassword = "AutomTest0123";
    private SingleGamePage singleGamePage;

    @BeforeEach
    public void precondition() throws InterruptedException {
        openNewDriver("login");
        loginUser(validEmail, validPassword);
        Thread.sleep(1000);
        singleGamePage = new SingleGamePage(webDriver);
        webDriver.get(BASE_URL + "games/e0f13c9b-0f7f-43f3-888f-b8eb6d2769ac"); // TODO: replace this TEMPORARY solution
    }

    @Test
    public void testRatingCanBeSubmitted() throws InterruptedException {
        boolean result = singleGamePage.submitReviewByValue(2.5);
        assertTrue(result);
    }

    @AfterEach
    public void postcondition() {
        quitDriver();
    }
}
