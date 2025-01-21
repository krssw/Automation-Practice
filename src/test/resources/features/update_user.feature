Feature: Update user

  Scenario: Update user details

    Given user is on the main page
    When user clicks update user
    And makes the changes
    And confirms user update
    Then user details are updated