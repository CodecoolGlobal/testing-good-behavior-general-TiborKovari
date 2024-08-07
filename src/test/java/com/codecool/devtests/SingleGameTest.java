package com.codecool.devtests;

import com.codecool.pages.SingleGamePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleGameTest extends BaseTest {
    private final String AUTH_EMAIL = "AutomTest@test.com";
    private final String AUTH_USERNAME = "AutomTest";
    private final String AUTH_PASSWORD = "AutomTest0123";
    private final String REVIEW_MESSAGE = "Test review";
    private SingleGamePage singleGamePage;

    @BeforeEach
    public void precondition() throws InterruptedException {
        openNewDriver("login");
        loginUser(AUTH_EMAIL, AUTH_PASSWORD);
        Thread.sleep(1000);
        singleGamePage = new SingleGamePage(webDriver);
        webDriver.get(BASE_URL + "games/00651364-3047-46a4-8c3e-a51434fa28f7"); // TODO: replace this TEMPORARY solution
    }

    @Test
    public void testRatingCanBeSubmitted() throws InterruptedException {
        boolean result = singleGamePage.submitRatingByValue(2.5);
        assertTrue(result);
    }

    @Test
    public void testReviewSubmission() {
        singleGamePage.clickOnWriteReviewDropdown();
        singleGamePage.fillReviewField(REVIEW_MESSAGE);
        singleGamePage.clickOnAddReviewButton();

        singleGamePage.clickOnReviewsDropdown();
        boolean result = singleGamePage.validateReviewSuccess(REVIEW_MESSAGE, AUTH_USERNAME);
        assertTrue(result);
    }

    @Test
    public void testAddingToFavorites() {
        singleGamePage.clickOnAddToFavorites();
        boolean result = singleGamePage.validateFavoriteAddingSuccess();
        assertTrue(result);
    }

    @AfterEach
    public void postcondition() {
        quitDriver();
    }
}
