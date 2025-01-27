Feature: Update user

  Scenario: Update user details

    Given there is a 'USER' user
    And 'USER' user is present in the list
    When user clicks update 'USER'
    And makes and confirms the 'USER' changes
    Then 'USER' details are updated