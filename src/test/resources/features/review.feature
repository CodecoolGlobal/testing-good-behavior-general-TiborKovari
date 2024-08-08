Feature: Review Board Games
  As a logged in user
  I want to write reviews for board games
  So other users can see my reviews about the board games

  Scenario: Successful review addition
    Given I am logged in as a user and I am on the chosen board game's page
    When I open the write review dropdown form and I submit my review
    Then I and other users should be able to see it where reviews are shown
