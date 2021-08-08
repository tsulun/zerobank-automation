@login
Feature: Users should be able to login

  Background:

    Given the user navigates to login page


    Scenario: Login as a customer
      When the user enters customer information
      Then the user should be login

  Scenario: Login as a customer
    When the user enters customer information
    And navigate to module "Pay Bills"
