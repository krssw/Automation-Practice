@API
Feature: Using POST to create user using API

  Scenario: Create new user

    Given I set POST user table API endpoint
    When I send a POST HTTP request
    Then the API should respond with status code 202