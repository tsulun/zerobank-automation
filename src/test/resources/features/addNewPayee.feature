@addNewPayee
Feature: Add new payee under pay bills

  Background:
    Given the user navigates to login page
    When the user enters customer information
    Then the user should be login
    And navigate to module "Pay Bills"

  @wip
  Scenario: Add a new payee
    Given Add New Payeetab
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Samest, Anytown, USA, 10001          |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message The new payee The Law Offices of Hyde, Price & Scharks was successfully created