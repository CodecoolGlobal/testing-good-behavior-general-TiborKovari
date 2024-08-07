package com.codecool.stepdefinitions;

import com.codecool.pages.LoginPage;
import com.codecool.pages.RegisterPage;
import org.openqa.selenium.Alert;
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

    public String registerUser(String username, String email, String password) {
        RegisterPage registerPage;
        registerPage = new RegisterPage(webDriver);
        registerPage.fillUsernameField(username);
        registerPage.fillEmailField(email);
        registerPage.fillPasswordField(password);
        registerPage.clickRegister();
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
    public boolean validateLogInSuccess() {
        return webDriver.getCurrentUrl().equals(BASE_URL); // TODO: assert to welcome message OR dropdown at the top
    }

}
