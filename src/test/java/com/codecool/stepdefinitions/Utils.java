package com.codecool.stepdefinitions;

import com.codecool.pages.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Utils {
    protected WebDriver webDriver;
    protected Alert alert;
    protected final String BASE_URL = "http://localhost:3456/";
    protected final String SUCCESSFUL_REGISTRATION_MESSAGE = "Thank you for registering to our website!";
    private RegisterPage registerPage;


    public void openNewDriver() {
        webDriver = new FirefoxDriver();
        webDriver.get(BASE_URL);
    }
    public void openNewDriver(String urlFromRoot) {
        webDriver = new FirefoxDriver();
        webDriver.get(BASE_URL + urlFromRoot);
    }
    public void quitDriver() {
        webDriver.quit();
    }

    public void registerUser(String username, String email, String password) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillUsernameField(username);
        registerPage.fillEmailField(email);
        registerPage.fillPasswordField(password);
        registerPage.clickRegister();
    }

    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;
    }

    public boolean validateRegistrationSuccess(String alertMessage) {
        return SUCCESSFUL_REGISTRATION_MESSAGE.equals(alertMessage);
    }

    public void loginUser(String email, String password) {
        LoginPage loginPage;
        loginPage = new LoginPage(webDriver);
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickLogIn();
    }

    public void selectBoardGame(String boarGameName) {
        AllGamesPage allGamesPage;
        allGamesPage = new AllGamesPage(webDriver);
        allGamesPage.clickOnAdvancedSearch();
        allGamesPage.fillGameField(boarGameName);
        allGamesPage.clickOnExactGameLink(boarGameName);
    }

    public void waitForElementVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception ignored) {
        }
    }

    public void addToFavorites() {
        SingleGamePage singleGamePage;
        singleGamePage = new SingleGamePage(webDriver);
        singleGamePage.clickOnAddToFavorites();
    }

    public boolean validateIfAddToFavoritesWasSuccessful(String boardName) {
        HomeLoggedInPage homeLoggedInPage;
        homeLoggedInPage = new HomeLoggedInPage(webDriver);
        homeLoggedInPage.clickWelcomeDropdownButton();
        homeLoggedInPage.clickFavouriteGamesButton();

        FavoritesPage favoritesPage;
        favoritesPage = new FavoritesPage(webDriver);
        return favoritesPage.isGameNamePresent(boardName);
    }

    public boolean validateLogInSuccess() {
        return webDriver.getCurrentUrl().equals(BASE_URL); // TODO: assert to welcome message OR dropdown at the top
    }

    public void clickOnAllGamesButton() {
        HomeLoggedInPage homeLoggedInPage;
        homeLoggedInPage = new HomeLoggedInPage(webDriver);
        homeLoggedInPage.clickAllGamesButton();
    }

}
