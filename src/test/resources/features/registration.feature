Feature: Registration

    Scenario Outline: Successful registration with valid credentials
        Given user is on the registration page
        When user enters "<Username>", "<Email>" and "<Password>" and confirms the popup by clicking
        Then user should be registered successfully and redirected to the home page

    Examples:
      | Username | Email             | Password |
      | test19   | test19@test.com   | Test1234        |


    Scenario Outline: Unsuccessful registration with invalid credentials
        Given user is on the registration page
        When user enters "<Username>", "<Email>" and "<Password>" and confirms the popup by clicking
        Then user shouldn't be registered successfully

    Examples:
      | Username | Email             | Password |
      | t        | test19test.com    | test1234         |