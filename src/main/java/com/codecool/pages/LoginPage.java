package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement showPasswordCheckbox;

    @FindBy(xpath = "//button[@type='submit' and @id='login']")
    private WebElement logInBtn;

    @FindBy(xpath = "//a[@href='/' and text()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//a[@href='/register' and text()='Register']")
    private WebElement registerRedirectBtn;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillEmailField(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    public void clickShowPasswordCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(showPasswordCheckbox)).click();
    }

    public void clickLogIn() {
        wait.until(ExpectedConditions.visibilityOf(logInBtn)).click();
    }

    public void clickCancel() {
        wait.until(ExpectedConditions.visibilityOf(cancelBtn)).click();
    }

    public void clickRegisterRedirect() {
        wait.until(ExpectedConditions.visibilityOf(registerRedirectBtn)).click();
    }

}
