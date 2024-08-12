Feature: Update user

  Scenario: Update user details

    Given user is on the main page
    And a 'USER' exists
    When user clicks update 'USER'
    And makes the changes
    And confirms update
    Then 'USER' details are updated