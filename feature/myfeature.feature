Feature: Dont get angry

  Scenario: Start a new game and when you press the roll button and the players turn should change
    Given Start a new game
    When It is your turn and press the roll button
    Then The players turn should change
