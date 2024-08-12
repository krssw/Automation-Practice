@API
Feature: Using GET to view user using API

  Scenario: View user

    Given I set GET user table API endpoint
    When I send GET HTTP request
    Then the API should respond with status code 202