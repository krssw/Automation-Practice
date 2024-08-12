@API
Feature: Using UPDATE to update user using API

  Scenario: Update user

    Given I set PUT user table API endpoint
    When I send PUT HTTP request
    Then the API should respond with status code 202