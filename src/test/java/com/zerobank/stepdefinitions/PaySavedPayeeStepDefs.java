package com.zerobank.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaySavedPayeeStepDefs {
    @When("user tries to make a payment with valid happy input data")
    public void user_tries_to_make_a_payment_with_valid_happy_input_data() {

    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user tries to make a payment without entering the amount or date")
    public void user_tries_to_make_a_payment_without_entering_the_amount_or_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("Amount field should not accept alphabetical or special characters")
    public void amount_field_should_not_accept_alphabetical_or_special_characters() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Date	field should not accept alphabetical characters")
    public void date_field_should_not_accept_alphabetical_characters() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
