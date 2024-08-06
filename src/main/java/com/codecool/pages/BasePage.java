package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='/home']")
    private WebElement homeButton;

    @FindBy(xpath = "//a[@href='/games']")
    public WebElement allGamesButton;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickHome(){
        homeButton.click();
    }

    public void clickAllGamesButton(){
        allGamesButton.click();
    }

}
