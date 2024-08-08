Feature: Review Board Games
  As a logged in user
  I want to write reviews for board games
  So other users can see my reviews about the board games

  Scenario Outline: Successful review addition
    Given I am logged in as a user "<email>" "<username>" "<password>" and I am on the chosen "<game>" board game's page
    When I open the write review dropdown form and I submit my review "<review>"
    Then I and other users should be able to see it "<review>" "<username>" where reviews are shown

    Examples:
      | email                 | username  | password      | game              | review        |
      | ramsay6123@test.com   | ramsay61  | RamsayTest01  | A Feast for Odin  | Test review   |