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

    @FindBy(xpath = "(//input[@type='text' and contains(@class, 'MuiInputBase-input')])[1]")
    private WebElement gameField;

    // Updated locator for the min player field
    @FindBy(xpath = "(//input[@type='number' and contains(@class, 'MuiInputBase-input')])[1]")
    private WebElement minPlayerField;

    // Updated locator for the max player field
    @FindBy(xpath = "(//input[@type='number' and contains(@class, 'MuiInputBase-input')])[2]")
    private WebElement maxPlayerField;

    @FindBy(xpath = "(//input[@type='text' and contains(@class, 'MuiInputBase-input')])[2]")
    private WebElement descriptionField;

    @FindBy(id = "select-publisher")
    private WebElement publisherDropdown;

    @FindBy(id = "select-category")
    private WebElement categoryDropdown;

    @FindBy(xpath = "(//input[@type='number' and contains(@class, 'MuiInputBase-input')])[3]")
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

    public void clickOnExactGameLink(String boardGameName) {
        WebElement boardNameLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + boardGameName + "')]")));
        boardNameLink.click();
    }

    public String getFirstResultLinkText() {
        return firstResultLink.getText();
    }
}
