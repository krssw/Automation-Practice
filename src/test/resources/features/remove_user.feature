Feature: User deletion

  Scenario: Remove user from the list

    Given there is a 'USER' user
    And 'USER' user is present in the list
    When user clicks remove 'USER'
    Then 'USER' is removed from the list