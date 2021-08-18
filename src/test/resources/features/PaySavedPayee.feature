@paysavedpayee
Feature: Pay Bills page

  Background:
    Given the user is logged in
    When the user enters customer information
    When The user navigates to "Pay Bills" module
    Then "Pay Bills" page should have the title "Zero - Pay Bills"

  Scenario Outline: user completes a successful Pay operation
    When user tries to make a payment with valid happy input data
    Then "The payment was successfully submitted." should be displayed

    Examples:
      | Payee  | Account | Amount | Date           | Description |
      | Sprint | Savings | 100    | 25 august 2021 | lorem ipsom |

  Scenario: user completes a invalid Pay operation
    When user tries to make a payment without entering the amount or date
    Then "Please	fill out this field	message." should be displayed

  Scenario Outline: Amount field input criteria check
    When enters "<character>" to Amount field
    Then Amount field should not accept alphabetical or special characters
    Examples:
      | character |
      | qwe       |
      | sadfg     |
      | #         |
      | ^&        |

  Scenario Outline: Date field input criteria check
    When enters "<character>" to Date field
    Then Date	field should not accept alphabetical characters
    Examples:
      | character |
      | qwe       |
      | sadfg     |


