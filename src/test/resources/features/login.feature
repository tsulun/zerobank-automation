@login
Feature: Users should be able to login

  Background:

    Given the user is logged in


    Scenario: Login as a customer
      When the user enters customer information
      Then the user should be login

    @seda
    Scenario: User logs in with valid credentials
      When user logs in with valid credentials
      Then "Account Summary" page should be displayed
    @seda
    Scenario: User logs in with invalid credentials
       When user logs in with invalid credentials
       Then error message should be displayed
