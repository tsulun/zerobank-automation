@addNewPayee
Feature: Add new payee under pay bills

  Scenario: Add a new payee
    Given Add New PayeetabAndcreates new payee usingfollowing information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Samest, Anytown, USA, 10001          |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message The new payee The Law Offices of Hyde, Price & Scharks was successfully created