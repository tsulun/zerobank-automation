@YA
Feature: Account Summary Page



  Scenario: Page title should be correct
    Given the user is logged in
    Given the user enters customer information
    Then the page should have "Zero - Account Summary" title

  Scenario: Page should have some account types
    Given the user is logged in
    Given the user enters customer information
    Then the page should have following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Credit Accounts table columns
    Given the user is logged in
    Given the user enters customer information
    Then  Credit Accounts table must have following columns
      | Account     |
      | Credit Card |
      | Balance     |

