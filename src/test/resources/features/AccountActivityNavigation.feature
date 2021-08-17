@accountActivity
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is logged in
    When the user enters customer information
#
#  Scenario: Savings account redirect
#    When the user clicks on "Savings" link on the Account Summary page
#    Then the "Account Activity" page should be displayed
#    And Account drop down should have "Savings" selected
#
#  Scenario: Brokerage account redirect
#    When the user clicks on "Brokerage" link on the Account Summary page
#    Then the "Account Activity" page should be displayed
#    And Account drop down should have "Brokerage" selected
#
#  Scenario: Checking account redirect
#    When the user clicks on "Checking" link on the Account Summary page
#    Then the "Account Activity" page should be displayed
#    And Account drop down should have "Checking" selected
#
#  Scenario: Credit Card account redirect
#    When the user clicks on "Credit card" link on the Account Summary page
#    Then the "Account Activity" page should be displayed
#    And Account drop down should have "Credit Card" selected
#
#  Scenario: Loan account redirect
#    When the user clicks on "Loan" link on the Account Summary page
#    Then the "Account Activity" page should be displayed
#    And Account drop down should have "Loan" selected
#
  Scenario Outline: Redirect to different <link> accounts
    When the user clicks on "<link>" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "<Selected AcDrDo>" selected

    Examples:
      | link        | Selected AcDrDo |
      | Savings     | Savings         |
      | Brokerage   | Brokerage       |
      | Checking    | Checking        |
      | Credit card | Credit card     |
      | Loan        | Loan            |

#  Account Activity page should have the title Zero –Account activity.
#  In the Account drop down default option should be Savings.
#  Account drop down should have the following options: Savings, Checking, Loan, Credit Card, Brokerage.
#  Transactions table should have column names Date, Description, Deposit, Withdrawal.
  @wip
  Scenario: Checking Account Activity page elements
    When The user navigates to "Account Activity" module
    Then "Account Activity" page should have the title "Zero - Account activity"
    And In the Account drop down default option should be "Savings"
    And Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    And Transactions table should have following column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |

