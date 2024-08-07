Feature: User deletion

  Scenario: Remove user from the list

    Given user is on the main page
    When user clicks remove user
    Then user is removed from the list