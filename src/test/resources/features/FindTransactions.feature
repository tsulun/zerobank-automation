@tedros
Feature:Find Transactions in Account Activity

  Background:
    Given the user is logged in
    When the user enters customer information
    Then the user should be login
    And the user clicks on Savings link on the "Account Activity" page

Scenario: Search date range
    Given the user accesses the Find Transactions tab
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-10"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"
@wip
Scenario: Search description
    Given the user accesses the Find Transactions tab
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions that containing "ONLINE"
    When the user enters description "OFFICE"
    And clicks search
    Then results table should only show descriptions that containing "OFFICE"
    But results table should not show descriptions containing "OFFICE"