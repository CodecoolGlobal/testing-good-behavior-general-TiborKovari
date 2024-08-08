package com.codecool.stepdefinitions;

import com.codecool.pages.AllGamesPage;
import com.codecool.pages.HomeLoggedInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;

public class SearchSteps extends Utils {
    private AllGamesPage allGamesPage;
    private HomeLoggedInPage homeLoggedInPage;
    private String gameName;

    @Given("the user is on the all games page with {string} {string} {string}")
    public void the_user_is_on_the_all_games_page(String username, String email, String password) {
        openNewDriver();
        registerUser(username, email, password);
        String alertMessage = getAlertMessage();
        if (!validateRegistrationSuccess(alertMessage)) {
            throw new RuntimeException("Registration failed");
        }

        loginUser(email, password);

        By welcomeMessageLocator = By.xpath("//b[text()='" + username + "']");
        waitForElementVisibility(welcomeMessageLocator);

        homeLoggedInPage = new HomeLoggedInPage(webDriver);
        homeLoggedInPage.clickAllGamesButton();
        allGamesPage = new AllGamesPage(webDriver);
    }

    @When("the user clicks on the advanced search button")
    public void the_user_clicks_on_the_advanced_search_button() {
        allGamesPage.clickOnAdvancedSearch();
    }

    @When("the user fills in the game input with valid game name {string}")
    public void the_user_fills_in_the_game_input_with_valid_game_name(String gameName) {
        this.gameName = gameName;
        allGamesPage.fillGameField(gameName);
    }

    @Then("the user should see valid game name in the search results")
    public void the_user_should_see_valid_game_name_in_the_search_results() {
        assertTrue(allGamesPage.isGameNamePresent(gameName));
        quitDriver();
    }
}
