package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/register']")
    private WebElement registerButtonOnBasePage;

    @FindBy(id = "name")
    private WebElement usernameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='checkbox' and following-sibling::label[text()='Show Password']]")
    private WebElement showPasswordCheckbox;

    @FindBy(id = "register")
    private WebElement registerButton;

    @FindBy(id = "cancel")
    private WebElement cancelButton;


    public void fillUsernameField(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
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

    public void clickRegister() {
        wait.until(ExpectedConditions.visibilityOf(registerButton)).click();
    }

    public void clickCancel() {
        wait.until(ExpectedConditions.visibilityOf(cancelButton)).click();
    }
}
