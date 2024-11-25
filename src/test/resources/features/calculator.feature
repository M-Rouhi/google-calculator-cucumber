@calculator
Feature: Calculator

  Background:
    Given I am on the Google search page
    When I search for "calculator"
    And the calculator should be visible

  Scenario Outline: Basic arithmetic operations
    When I enter <first_number>
    And I press "<operator>"
    And I enter <second_number>
    And I press "="
    Then the result should be <expected_result>

    Examples:
      | first_number | operator | second_number | expected_result |
      | 5            | +        | 3             | 8               |
      | 10           | −        | 4             | 6               |
      | 6            | ×        | 7             | 42              |
      | 15           | ÷        | 3             | 5               |

  Scenario: Clearing the display
    When I enter 565
    And I press "CE"
    Then the display should be cleared


  Scenario: Multiple operations in sequence
    When I enter 2
    And I press "+"
    And I enter 3
    And I press "×"
    And I enter 4
    And I press "="
    Then the result should be 14

    Scenario: Division by zero
      When I enter 17
      And I press "÷"
      And I enter 0
      And I press "="
      Then the result should be "Infinity"