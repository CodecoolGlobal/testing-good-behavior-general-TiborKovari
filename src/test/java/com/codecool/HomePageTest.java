package com.codecool;
import com.codecool.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        openNewDriver();
        homePage = new HomePage(webDriver);
    }

    @Test
    public void testClickRegisterButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.allGamesButton));


        homePage.clickAllGamesButton();
    }

    @AfterEach
    public void tearDown() {
        quitDriver();
    }
}