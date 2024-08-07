package com.codecool.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class AddToCollectionsStepDefinitions extends Utils{

    @Given("user is logged in with {string} and {string} as {string} and is on the all games page")
    public void user_is_logged_in_and_is_on_the_all_games_page (String registeredEmail, String password, String username) {
        openNewDriver("login");
        loginUser(registeredEmail, password);

        By welcomeMessageLocator = By.xpath("//b[text()='" + username + "']");
        waitForElementVisibility(welcomeMessageLocator);

        clickOnAllGamesButton();
    }

    @When("user clicks on the selected {string} and is able to add that game to the collections")
    public void user_clicks_on_the_selected_game_and_is_able_to_add_that_game_to_the_collections(String game) {
        selectBoardGame(game);
        addToFavorites();
    }

    @Then("user should see the chosen {string} in user's collections")
    public void user_should_see_the_chosen_game_in_user_s_collections(String game) {
        assertTrue(validateIfAddToFavoritesWasSuccessful(game));
        quitDriver();
    }
}
