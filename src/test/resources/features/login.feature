@login
Feature: Users should be able to login

  Background:

    Given the user is at the login page


    Scenario: Only authorised users should be able to login
      When the user enters customer information
      Then the page should have "Zero - Account Summary" title


    Scenario: Users with wrong username or password
      When user logs in with invalid credentials
      Then error message should be displayed


    Scenario: Users with blank username or password
       When user logs in with blank credentials
       Then error message should be displayed
