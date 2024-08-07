package com.codecool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;

public class FavoritesPage extends BasePage{

    public FavoritesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody[@class='MuiTypography-root']//tr[1]//a")
    private WebElement firstResultLink;

    @FindBy(xpath = "//a[@class='MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineAlways css-1y1tct7']")
    private WebElement reviewsLink;

    @FindBy(xpath = "//p[contains(text(), 'Click to see your reviews!')]")
    private WebElement clickToSeeReviewsText;

    @FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 css-1anx036']")
    private WebElement reviewDetail;

    @FindBy(xpath = "//button[contains(text(), 'Delete from favorites')]")
    private WebElement deleteFromFavoritesButton;

    public String getClickToSeeReviewsText() {
        return clickToSeeReviewsText.getText();
    }

    public String getReviewDetailText() {
        return reviewDetail.getText();
    }

    public void clickDeleteFromFavorites() {
        deleteFromFavoritesButton.click();
    }

    public boolean isGameNamePresent(String gameName) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + gameName + "')]")));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
