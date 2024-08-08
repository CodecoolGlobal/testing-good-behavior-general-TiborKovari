Feature: Search

  Scenario Outline: User can search for board games
    Given the user is on the all games page with "<username>" "<email>" "<password>"
    When the user clicks on the advanced search button
    And the user fills in the game input with valid game name "<gameName>"
    Then the user should see valid game name in the search results

    Examples:
      | username   | email                | password | gameName                           |
      | okoko | okoko@jojo.com  | Jojo8888 | Twilight Imperium: Fourth Edition  |
