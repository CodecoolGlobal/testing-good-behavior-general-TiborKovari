package com.codecool.stepdefinitions;

import com.codecool.pages.AllGamesPage;
import com.codecool.pages.SingleGamePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RatingSteps extends Utils {
    private boolean IS_RATING_SUCCESSFUL = false;
    private SingleGamePage singleGamePage;

    @Given("The user is logged in with {string} {string} {string} and is on the chosen board game's {string} page")
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

    @When("The user rates the board game to {double} stars by clicking and submits it by clicking on the submit button")
    public void the_user_rates_the_board_game_by_clicking_on_star_and_submits_it_by_clicking_on_the_submit_button(double value) throws InterruptedException {
        IS_RATING_SUCCESSFUL = singleGamePage.submitRatingByValue(value);
    }

    @Then("The selected rating is saved and cannot be changed")
    public void the_selected_rating_is_saved_and_cannot_be_changed() {
        assertTrue(IS_RATING_SUCCESSFUL);
        quitDriver();
    }
}
