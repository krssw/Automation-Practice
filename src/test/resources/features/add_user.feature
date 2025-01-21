Feature: User creation

  Scenario: Add a valid user

    Given user is on the main page
    When user clicks add new user
    And fills in the details 'ADAM' 'MALYSZ' 'mail@gmail.com'
    And confirms the user creation
    Then a new user is present in the list 'ADAM' 'MALYSZ'