Feature: Rating Board Games
  As a logged in user
  I want to rate board games from 1-10 stars depending my preference
  So I can contribute to the average rating of a board game which other users can see

  Scenario Outline: Successful rating addition
    Given The user is logged in and is on the chosen board game's page
    When The user rates the board game to <value> stars by clicking and submits it by clicking on the submit button
    Then The selected rating is saved and cannot be changed

    Examples:
      | value |
      |  2.5  |