package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
