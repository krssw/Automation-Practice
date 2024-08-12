Feature: View details

  Scenario: View user details

    Given user is on the main page
    And a 'USER' exists
    When user clicks view 'USER' details
    Then the 'USER' details are shown