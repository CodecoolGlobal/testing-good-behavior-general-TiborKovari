package com.codecool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllGamesPage extends BasePage{

    public AllGamesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Advanced search')]")
    private WebElement advancedSearchButton;

    @FindBy(id = ":rfs:")
    private WebElement gameField;

    @FindBy(id = ":rft:")
    private WebElement minPlayerField;

    @FindBy(id = ":rfu:")
    private WebElement maxPlayerField;

    @FindBy(id = ":rfv:")
    private WebElement descriptionField;

    @FindBy(id = "select-publisher")
    private WebElement publisherDropdown;

    @FindBy(id = "select-category")
    private WebElement categoryDropdown;

    @FindBy(id = ":rg2:")
    private WebElement ratingField;

    @FindBy(xpath = "//tbody[@class='MuiTypography-root']//tr[1]//a")
    private WebElement firstResultLink;

    public void clickOnAdvancedSearch() {
        wait.until(ExpectedConditions.visibilityOf(advancedSearchButton)).click();
    }

    public void fillGameField(String input) {
        wait.until(ExpectedConditions.visibilityOf(gameField)).sendKeys(input);
    }

    public void fillMinPlayerField(String input) {
        wait.until(ExpectedConditions.visibilityOf(minPlayerField)).sendKeys(input);
    }

    public void fillMaxPlayerField(String input) {
        wait.until(ExpectedConditions.visibilityOf(maxPlayerField)).sendKeys(input);
    }

    public void fillDescriptionField(String input) {
        wait.until(ExpectedConditions.visibilityOf(descriptionField)).sendKeys(input);
    }

    public void openPublisherDropdown() {
        wait.until(ExpectedConditions.visibilityOf(publisherDropdown)).click();
    }

    public void selectOption(String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));

        List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']//li"));

        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
                option.click();
                break;
            }
        }
    }

    public void openCategoryDropdown() {
        wait.until(ExpectedConditions.visibilityOf(categoryDropdown)).click();
    }

    public void fillRatingField(String input) {
        wait.until(ExpectedConditions.visibilityOf(ratingField)).sendKeys(input);
    }

    public void clickFirstResultLink() {
        wait.until(ExpectedConditions.visibilityOf(firstResultLink)).click();
    }

    public String getFirstResultLinkText() {
        return firstResultLink.getText();
    }
}
