Feature: User creation

  Scenario: Add a valid user

    Given user is on the main page
    When user clicks add new user
    And fills in the 'USER' details
    And confirms the user creation
    Then a new 'USER' is present in the list