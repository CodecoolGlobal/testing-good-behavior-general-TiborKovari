package com.codecool.devtests;

import com.codecool.pages.LoginPage;
import com.codecool.pages.RegisterPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {
    protected WebDriver webDriver;
    protected Alert alert;
    protected final String BASE_URL = "http://localhost:3456/";
    protected LoginPage loginPage;
    protected RegisterPage registerPage;

    public void openNewDriver() {
        webDriver = new FirefoxDriver();
        webDriver.get(BASE_URL);
    }

    public void openNewDriver(String urlFromRoot) {
        webDriver = new FirefoxDriver();
        webDriver.get(BASE_URL + urlFromRoot);
    }

    public void registerUser(String username, String email, String password) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillUsernameField(username);
        registerPage.fillEmailField(email);
        registerPage.fillPasswordField(password);
        registerPage.clickRegister();
    }

    public void loginUser(String email, String password) {
        loginPage = new LoginPage(webDriver);
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickLogIn();
    }

    public void quitDriver() {
        webDriver.quit();
    }
}
