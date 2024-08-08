package com.codecool.stepdefinitions;

import com.codecool.pages.SingleGamePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReviewSteps extends Utils {
    private final String AUTH_EMAIL = "AutomTest@test.com";
    private final String AUTH_USERNAME = "AutomTest";
    private final String AUTH_PASSWORD = "AutomTest0123";
    private final String REVIEW_MESSAGE = "Test review";
    private SingleGamePage singleGamePage;

    @Given("I am logged in as a user and I am on the chosen board game's page")
    public void I_am_logged_in_as_a_user_and_I_am_on_the_chosen_board_games_page() throws InterruptedException {
        openNewDriver("login");
        loginUser(AUTH_EMAIL, AUTH_PASSWORD);
        Thread.sleep(2000);
        singleGamePage = new SingleGamePage(webDriver);
        webDriver.get(BASE_URL + "games/b5374b9a-51da-4ac0-be15-4b38511debe5"); // TODO: replace this TEMPORARY solution
        Thread.sleep(1000);
    }

    @When("I open the write review dropdown form and I submit my review")
    public void I_open_the_write_review_dropdown_form_and_I_submit_my_review() throws InterruptedException {
        singleGamePage.clickOnWriteReviewDropdown();
        singleGamePage.fillReviewField(REVIEW_MESSAGE);
        singleGamePage.clickOnAddReviewButton();
        Thread.sleep(1000);
    }

    @Then("I and other users should be able to see it where reviews are shown")
    public void I_and_other_users_should_be_able_to_see_it_where_reviews_are_shown() {
        singleGamePage.clickOnReviewsDropdown();
        boolean result = singleGamePage.validateReviewSuccess(REVIEW_MESSAGE, AUTH_USERNAME);
        assertTrue(result);
        quitDriver();
    }

}
