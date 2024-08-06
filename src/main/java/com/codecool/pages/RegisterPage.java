package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
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

    public void clickRegisterOnBasePage() {
        registerButtonOnBasePage.click();
    }

    public void fillUsernameField(String username) {
        usernameField.sendKeys(username);
    }

    public void fillEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void fillPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickShowPasswordCheckbox() {
        showPasswordCheckbox.click();
    }

    public void clickRegister() {
        registerButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }
}
