Feature: Registration

    Scenario: Successful registration with valid credentials
        Given a user is on the registration page
        When the user enters valid registration details and confirms the popup by clicking
        Then the user should be registered successfully and redirected to the home page

    Scenario: Unsuccessful registration with invalid credentials
        Given a user is on the registration page
        When the user enters invalid registration details and confirms the popup by clicking
        Then the user shouldn't be registered successfully