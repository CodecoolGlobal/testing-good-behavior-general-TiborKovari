package com.codecool.stepdefinitions;

import com.codecool.pages.SingleGamePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReviewSteps extends Utils {
    private SingleGamePage singleGamePage;

    @Given("I am logged in as a user {string} {string} {string} and I am on the chosen {string} board game's page")
    public void the_user_is_logged_in_and_is_on_the_chosen_board_games_page(String email, String username, String password, String game) throws InterruptedException {
        openNewDriver();
        registerUser(username, email, password);
        getAlertMessage();
        loginUser(email, password);

        By welcomeMessageLocator = By.xpath("//b[text()='" + username + "']");
        waitForElementVisibility(welcomeMessageLocator);
        clickOnAllGamesButton();
        selectBoardGame(game);
        singleGamePage = new SingleGamePage(webDriver);
    }

    @When("I open the write review dropdown form and I submit my review {string}")
    public void I_open_the_write_review_dropdown_form_and_I_submit_my_review(String review) throws InterruptedException {
        singleGamePage.clickOnWriteReviewDropdown();
        singleGamePage.fillReviewField(review);
        singleGamePage.clickOnAddReviewButton();
        Thread.sleep(1000);
    }

    @Then("I and other users should be able to see it {string} {string} where reviews are shown")
    public void I_and_other_users_should_be_able_to_see_it_where_reviews_are_shown(String review, String username) throws InterruptedException {
        webDriver.navigate().refresh();
        Thread.sleep(2000);
        singleGamePage.clickOnReviewsDropdown();
        boolean result = singleGamePage.validateReviewSuccess(review, username);
        assertTrue(result);
        quitDriver();
    }

}
