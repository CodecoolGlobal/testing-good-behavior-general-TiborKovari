package com.codecool.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class RegisterStepDefinitions extends Utils{

    private final String validUsername = "test21";
    private final String validEmail = "test21@test.com";
    private final String validPassword = "Test1234";
    private final String inValidUsername = "";
    private final String inValidEmail = "test7test.com";
    private final String inValidPassword = "test1234";
    private String popupMessage;

    @Given("a user is on the registration page")
    public void the_user_is_on_the_registration_page() {
       openNewDriver("register");
    }

    @When("the user enters valid registration details and confirms the popup by clicking")
    public void the_user_enters_valid_registration_details_and_confirms_the_popup_by_clicking() {
        registerUser(validUsername, validEmail, validPassword);
        popupMessage = getAlertMessage();
    }

    @Then("the user should be registered successfully and redirected to the home page")
    public void the_user_should_be_registered_successfully_and_redirected_to_the_home_page() {
        assertTrue(validateRegistrationSuccess(popupMessage));
        assertEquals(BASE_URL, webDriver.getCurrentUrl());
        quitDriver();
    }

    @When("the user enters invalid registration details and confirms the popup by clicking")
    public void the_user_enters_invalid_registration_details_and_confirms_the_popup_by_clicking() {
        registerUser(inValidUsername, inValidEmail, inValidPassword);
    }

    @Then("the user shouldn't be registered successfully")
    public void the_user_shouldn_t_be_registered_successfully() {
        assertNotEquals(BASE_URL, webDriver.getCurrentUrl());
        quitDriver();
    }
}
