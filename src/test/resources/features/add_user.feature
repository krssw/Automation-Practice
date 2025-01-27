Feature: User creation

  Scenario: Add a valid user from main page

    Given there is a 'USER' user
    When user clicks add new user
    And fills in the 'USER' details
    Then new 'USER' is present in the list