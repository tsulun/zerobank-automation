@login
Feature: Users should be able to login

  Background:

    Given the user is logged in


    Scenario: Login as a customer
      When the user enters customer information
      Then the user should be login


