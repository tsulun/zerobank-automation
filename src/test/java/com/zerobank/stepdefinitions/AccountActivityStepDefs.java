package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.StringUtils;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AccountActivityStepDefs {
    AccountActivity accountActivity = new AccountActivity();

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
        Assert.assertTrue("verify relevant condition is selected", accountActivity.whichAccountIsSelected(string));
    }

    @When("The user navigates to {string} module")
    public void the_user_navigates_to_module(String string) {
        BasePage basePage = new BasePage();
        basePage.navigateToModule(new StringUtils().capitalizeWord(string));
    }

    @Then("{string} page should have the title {string}")
    public void page_should_have_the_title(String string, String string2) {
        Assert.assertEquals("verify page has given title", new StringUtils().capitalizeWord(string2), Driver.get().getTitle());
    }

    @Then("In the Account drop down default option should be {string}")
    public void in_the_Account_drop_down_default_option_should_be_Savings(String string) {
        Assert.assertTrue(accountActivity.whichAccountIsSelected(string));

    }

    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> expected) {
        // System.out.println("Arrays.toString(expected) = " + Arrays.toString(expected.toArray()));
        // System.out.println("Arrays.toString(accountActivity.elementsOfDropDown()) = " + Arrays.toString(accountActivity.elementsOfDropDown().toArray()));
        Assert.assertTrue(accountActivity.similarityOfTwoList(accountActivity.elementsOfDropDown(), expected));
    }

    @Then("Transactions table should have following column names")
    public void transactions_table_should_have_following_column_names(List<String> expected) {
        Assert.assertTrue(accountActivity.similarityOfTwoList(BrowserUtils.getElementsText(accountActivity.tableHeadColumns), expected));
        //we can also use assertEquals in there but in case of tehre is a certain situation like only these options
        //should be available etc.
        //if the meaning of step definations is should contains following options, things getting challenging
        //so for that i create a method which is compare items of two list
    }


}
