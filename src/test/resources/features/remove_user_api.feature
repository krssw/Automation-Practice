@API
Feature: Using DELETE to remove user using API

  Scenario: Remove user

    Given I set DELETE user table API endpoint
    When I send a DELETE HTTP request
    Then the API should respond with status code 202