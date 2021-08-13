
  Feature: Find Transactions in Account Activity

    Background:
      Given the user is logged in
      And the user enters customer information
      And the user navigates "account-activity" page
      And the user clicks on "Find Transactions"
    @seda
    Scenario Outline: Search date range
      When the user enters date range from "<startDate>" to "<endDate>"
      And the user clicks on "search"
      Then results table should only show transactions dates between "<startDate>" to "<endDate>"
      And  the results should be sorted by most recent date

      Examples:
        | startDate  | endDate    |
        | 2012-09-01 | 2012-09-06 |
        | 2012-09-02 | 2012-09-06 |

    Scenario:Results table should not contain "2012-09-01"
      When the user enters date range from "2012-09-02" to "2012-09-06"
      And  the user clicks on "search"
      Then the results table should only not contain transactions dated "2012-09-01"

    Scenario Outline: Search description
      When  the user enters description "<DescEntered>"
      And   the user clicks on "search"
      Then  results table should only show descriptions containing "<contained>"
      But   results table should not show descriptions containing "<notContained>"

      Examples:
        | DescEntered | contained | notContained |
        | ONLINE      | ONLINE    | OFFICE       |
        | OFFICE      | OFFICE    | ONLINE       |
        | online      | ONLINE    | OFFICE       |
