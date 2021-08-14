Feature: Purchase Foreign Currency

  Background:
    Given the user is logged in
    When the user enters customer information

  @wip
  Scenario: Available currencies
    Given the user accesses the Purchase foreign currency cash tab
    Then following currencies should be available
      |  Australia (dollar)    |
      |  Canada (dollar)       |
      |  Switzerland (franc)   |
      |  China (yuan)          |
      |  Denmark (krone)       |
      |  Eurozone (euro)       |
      |  Great Britain (pound) |
      |  Japan (yen)           |
      |  Mexico (peso)         |
      |  Norway (krone)        |
      |  New Zealand (dollar)  |
      |  Singapore (dollar)    |


  Scenario: Error message for not selecting currency
    Given the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed
