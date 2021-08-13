Feature: Account Summary Page

  Background: Given the user is logged in

  Background: And the user is on the "Account Summary" page

  @seda
  Scenario: Page title should be correct
    Then the page should have "Zero - Account Summary" title

  @seda
  Scenario: Page should have some account types
    Then the page should have following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  @seda
  Scenario: Credit Accounts table columns
    Then  "Credit Accounts" table must have following columns
      | Account     |
      | Credit Card |
      | Balance     |

