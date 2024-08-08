Feature: Collection

  Scenario Outline: Adding games successfully to favorites collections
      Given user is logged in with "<email>" and "<password>" as "<username>" and is on the all games page
      When user clicks on the selected "<game>" and is able to add that game to the collections
      Then user should see the chosen "<game>" in user's collections

    Examples:
      | email  | password  | username   | game                                |
      | test34@test.com  | Test1234  | test34     | Twilight Imperium: Fourth Edition   |
