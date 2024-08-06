package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLoggedInPage extends HomePage{

    @FindBy(xpath = "//p[contains(text(), 'Welcome:') and contains(@class, 'MuiTypography-body1')]")
    private WebElement welcomeDropdownButton;

    @FindBy(xpath = "//button[contains(text(), 'Favourite games')]")
    private WebElement favouriteGamesButton;

    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    public HomeLoggedInPage(WebDriver driver) {
        super(driver);
    }

    public void clickWelcomeDropdownButton(){
        welcomeDropdownButton.click();
    }

    public WebElement getWelcomeDropdownButton() {
        return welcomeDropdownButton;
    }

    public void clickFavouriteGamesButton(){
        favouriteGamesButton.click();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public WebElement getFavouriteGamesButton() {
        return favouriteGamesButton;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

}
