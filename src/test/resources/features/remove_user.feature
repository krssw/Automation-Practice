Feature: Remove user from list of users

  Scenario: Check user is successfully removed from the list of users

    Given user is on the main page
    When user clicks remove user
    Then user is removed from the list