Feature: View user details

  Scenario: Check user is successfully added to the list of users

    Given user is on the main page
    When user clicks view user details
    Then the details are shown