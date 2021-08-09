package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityStepDefs {
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_on_the_page(String string) {
        AccountSummary accountSummary = new AccountSummary();
        accountSummary.clickAccount(string);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String string) {
        Assert.assertTrue("verify relevant page is displayed", Driver.get().getTitle().contains(string));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {
        AccountActivity accountActivity = new AccountActivity();
        Assert.assertTrue("verify relevant condition is selected",accountActivity.whichAccountIsSelected(string));
    }


}
