package com.codecool.stepdefinitions;

import com.codecool.pages.AllGamesPage;
import com.codecool.pages.HomeLoggedInPage;
import com.codecool.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class SearchSteps extends Utils {
    private AllGamesPage allGamesPage;
    private HomeLoggedInPage homeLoggedInPage;
    private HomePage homePage;
    private String username;
    private String email;
    private String password;
    private String gameName;

    @Given("the user is on the all games page with {string} {string} {string}")
    public void the_user_is_on_the_all_games_page(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

        openNewDriver("register");
        registerUser(username, email, password);
        String alertMessage = getAlertMessage();
        if (!validateRegistrationSuccess(alertMessage)) {
            throw new RuntimeException("Registration failed");
        }

        homePage = new HomePage(webDriver);
        homePage.clickLoginButton();
        loginUser(email, password);
        if (!validateLogInSuccess()) {
            throw new RuntimeException("Login failed");
        }

        homeLoggedInPage = new HomeLoggedInPage(webDriver);
        By welcomeMessageLocator = By.xpath("//b[text()='" + username + "']");
        waitForElementVisibility(welcomeMessageLocator);
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
