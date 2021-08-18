@addNewPayee
Feature: Add new payee under pay bills

  Background:
    Given the user is logged in
    When the user enters customer information
    Then the user should be login
    And the user clicks on Savings link on the "Pay Bills" page


  Scenario: Add a new payee
    Given Add New Payeetab
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Samest, Anytown, USA, 10001          |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message The new payee The Law Offices of Hyde, Price & Scharks was successfully created