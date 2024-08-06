package com.codecool.pages;

import com.codecool.exceptions.RatingValueOutOfRangeException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class SingleGamePage extends BasePage {

    @FindBy(xpath = "//button[@type='button' and text()='Add to favorites']")
    private WebElement addToFavoritesBtn;

    @FindBy(xpath = "//button[@type='button' and text()='Submit']")
    private WebElement submitBtn;

    //<h4>Thank you for your rating!</h4>
    @FindBy(xpath = "//h4[text()='Thank you for your rating!']")
    private WebElement reviewMessage;

    @FindBy(id = "panel1a-header")
    private WebElement writeReviewDropdown;

    @FindBy(xpath = "//input[@id='description' and @type='text']")
    private WebElement reviewField;

    @FindBy(xpath = "//button[@type='submit' and text()='Add review']")
    private WebElement addReviewBtn;

    @FindBy(id = "panel1a-header")
    private WebElement allReviewsDropdown;

    public SingleGamePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddToFavorites() {
        wait.until(ExpectedConditions.visibilityOf(addToFavoritesBtn)).click();
    }

    public boolean submitReviewByValue(double value) throws InterruptedException {
        if (value < 0 || value > 10) throw new RatingValueOutOfRangeException();

        By starContainerBy = By.xpath(".//span[@class='MuiRating-root MuiRating-sizeMedium css-1i1gfbe']");

        int starAmount = (int) Math.ceil(value);
        int base = (int) value;
        double fraction = value - base;
        int fractionalStarAmount = (int) (fraction * 10);

        // Wait to load the page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiCardContent-root css-1qw96cp']")));

        // Hover on star container
        Thread.sleep(2000);
        WebElement starContainer = driver.findElement(starContainerBy);
        List<WebElement> stars = starContainer.findElements(By.xpath(".//span[@class='MuiRating-decimal css-79elbk']"));
        WebElement toHover = stars.get(starAmount - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(toHover).perform();

        // Click on star
        Thread.sleep(2000);
        List<WebElement> labels = toHover.findElements(By.xpath(".//label"));
        labels.get(fractionalStarAmount - 1).click();

        // Click on Submit
        Thread.sleep(2000);
        submitBtn.click();

        return validateReviewSuccess();
    }

    private boolean validateReviewSuccess() {
        return isElementPresent(reviewMessage);
    }

    public void clickOnWriteReviewDropdown() {
        wait.until(ExpectedConditions.visibilityOf(writeReviewDropdown)).click();
    }

    public void fillReviewField(String input) {
        wait.until(ExpectedConditions.visibilityOf(reviewField)).sendKeys(input);
    }

    public void clickOnAddReviewButton() {
        wait.until(ExpectedConditions.visibilityOf(addReviewBtn)).click();
    }

    public void clickOnReviewsDropdown() {
        wait.until(ExpectedConditions.visibilityOf(allReviewsDropdown)).click();
    }

}
