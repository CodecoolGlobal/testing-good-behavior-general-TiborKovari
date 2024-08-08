package com.codecool.stepdefinitions;

import com.codecool.pages.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;

public abstract class Utils {
    protected WebDriver webDriver;
    protected Alert alert;
    protected final String BASE_URL = "http://localhost:3456/";
    protected final String SUCCESSFUL_REGISTRATION_MESSAGE = "Thank you for registering to our website!";
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private HomePage homePage;

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
        homePage = new HomePage(webDriver);
        homePage.clickRegisterButton();
        registerPage.fillUsernameField(username);
        registerPage.fillEmailField(email);
        registerPage.fillPasswordField(password);
        registerPage.clickRegister();
    }

    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertMessage = alert.getText();
            alert.accept();
            return alertMessage;
        } catch (TimeoutException e) {
            return "No alert present";
        }
    }

    public boolean validateRegistrationSuccess(String alertMessage) {
        return SUCCESSFUL_REGISTRATION_MESSAGE.equals(alertMessage);
    }

    public void loginUser(String email, String password) {
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        homePage.clickLoginButton();
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

    public void clickOnAllGamesButton() {
        HomeLoggedInPage homeLoggedInPage;
        homeLoggedInPage = new HomeLoggedInPage(webDriver);
        homeLoggedInPage.clickAllGamesButton();
    }

    public void executeDatabaseSetupScript() {
        try {
            String[] cmd = {"/bin/sh", "setupdb.sh"};
            Process process = Runtime.getRuntime().exec(cmd);
            // Optionally, read the output of the script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Script executed successfully.");
            } else {
                System.err.println("Script execution failed with exit value: " + exitVal);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
