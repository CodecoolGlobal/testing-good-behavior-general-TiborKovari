package com.codecool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllGamesPage extends BasePage{

    public AllGamesPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
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

    public void clickOnAdvancedSearch() {
        advancedSearchButton.click();
    }

    public void fillGameField(String input) {
        gameField.sendKeys(input);
    }

    public void fillMinPlayerField(String input) {
        minPlayerField.sendKeys(input);
    }

    public void fillMaxPlayerField(String input) {
        maxPlayerField.sendKeys(input);
    }

    public void fillDescriptionField(String input) {
        descriptionField.sendKeys(input);
    }

    public void openPublisherDropdown() {
        publisherDropdown.click();
    }

    public void selectOption(String optionText) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));

        List<WebElement> options = webDriver.findElements(By.xpath("//ul[@role='listbox']//li"));

        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
                option.click();
                break;
            }
        }
    }

    public void openCategoryDropdown() {
        categoryDropdown.click();
    }

    public void fillRatingField(String input) {
        ratingField.sendKeys(input);
    }

    @FindBy(xpath = "//tbody[@class='MuiTableBody-root']//tr[1]//a")
    private WebElement firstResultLink;

    public void clickFirstResultLink() {
        firstResultLink.click();
    }

    public String getFirstResultLinkText() {
        return firstResultLink.getText();
    }
}
