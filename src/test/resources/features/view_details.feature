Feature: View details

  Scenario: View user details

    Given there is a 'USER' user
    And 'USER' user is present in the list
    When user clicks view 'USER' details
    Then the 'USER' details are shown