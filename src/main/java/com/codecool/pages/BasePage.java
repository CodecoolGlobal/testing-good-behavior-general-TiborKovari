package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/home']")
    protected WebElement homeButton;

    @FindBy(xpath = "//a[@href='/games']")
    public WebElement allGamesButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickHome(){
        homeButton.click();
    }

    public void clickAllGamesButton(){
        allGamesButton.click();
    }

}
