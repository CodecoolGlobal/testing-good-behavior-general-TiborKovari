package com.codecool.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class RegisterStepDefinitions extends Utils{

    private String popupMessage;

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
       openNewDriver("register");
    }

    @When("user enters {string}, {string} and {string} and confirms the popup by clicking")
    public void user_enters_username_email_and_password_and_confirms_the_popup_by_clicking(String username, String email, String password) {
        registerUser(username, email, password);
        popupMessage = getAlertMessage();
    }

    @Then("user should be registered successfully and redirected to the home page")
    public void user_should_be_registered_successfully_and_redirected_to_the_home_page() {
        assertTrue(validateRegistrationSuccess(popupMessage));
        assertEquals(BASE_URL, webDriver.getCurrentUrl());
        quitDriver();
    }

    @Then("user shouldn't be registered successfully")
    public void user_should_not_be_registered_successfully() {
        assertFalse(validateRegistrationSuccess(popupMessage));
        assertNotEquals(BASE_URL, webDriver.getCurrentUrl());
        quitDriver();
    }
}
