Feature: Search

  Scenario: User can search for board games
    Given the user is on the all games page
    When the user clicks on the advanced search button
    And the user fills in the game input with valid game name
    Then the user should see valid game name in the search results

