@emi
Feature: Account Summary Page

  Background:
    Given the user is logged in
    And the user enters customer information

  Scenario: Page title should be correct
    Then the page should have "Zero - Account Summary" title

  Scenario: Page should have some account types
    Then the page should have following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts table columns
    Then  Credit Accounts table must have following columns
      | Account     |
      | Credit Card |
      | Balance     |

