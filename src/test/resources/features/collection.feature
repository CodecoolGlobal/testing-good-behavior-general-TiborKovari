Feature: Collection

  Scenario Outline: Adding games successfully to favorites collections
      Given user is logged in with "<registeredEmail>" and "<password>" as "<username>" and is on the all games page
      When user clicks on the selected "<game>" and is able to add that game to the collections
      Then user should see the chosen "<game>" in user's collections

    Examples:
      | registeredEmail  | password  | username   | game                                |
      | test30@test.com  | Test1234  | test30     | Twilight Imperium: Fourth Edition   |
