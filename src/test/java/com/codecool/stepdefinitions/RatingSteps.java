package com.codecool.stepdefinitions;

import com.codecool.pages.SingleGamePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RatingSteps extends Utils {
    private final String AUTH_EMAIL = "AutomTest@test.com";
    private final String AUTH_USERNAME = "AutomTest";
    private final String AUTH_PASSWORD = "AutomTest0123";
    private final String REVIEW_MESSAGE = "Test review";
    private boolean IS_RATING_SUCCESSFUL = false;
    private SingleGamePage singleGamePage;

    @Given("The user is logged in and is on the chosen board game's page")
    public void given() throws InterruptedException {
        openNewDriver("login");
        loginUser(AUTH_EMAIL, AUTH_PASSWORD);
        Thread.sleep(2000);
        singleGamePage = new SingleGamePage(webDriver);
        webDriver.get(BASE_URL + "games/b5374b9a-51da-4ac0-be15-4b38511debe5"); // TODO: replace this TEMPORARY solution
        Thread.sleep(1000);
    }

    @When("The user rates the board game to {double} stars by clicking and submits it by clicking on the submit button")
    public void when(double value) throws InterruptedException {
        IS_RATING_SUCCESSFUL = singleGamePage.submitRatingByValue(value);

    }

    @Then("The selected rating is saved and cannot be changed")
    public void then() {
        assertTrue(IS_RATING_SUCCESSFUL);
        quitDriver();
    }
}
