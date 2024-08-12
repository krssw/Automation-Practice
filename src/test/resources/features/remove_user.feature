Feature: User deletion

  Scenario: Remove user from the list

    Given user is on the main page
    And a 'USER' exists
    When user clicks remove 'USER'
    Then 'USER' is removed from the list