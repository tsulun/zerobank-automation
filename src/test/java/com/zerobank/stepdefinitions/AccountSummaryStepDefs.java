package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {

    AccountSummary accountSummary = new AccountSummary();

    @Then("the page should have {string} title")
    public void the_page_should_have_title(String expectedTile) {
        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals("Verify the title",expectedTile,actualTitle);
    }

    @Then("the page should have following account types")
    public void the_page_should_have_following_account_types(List<String> expectedAccountTypes) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(accountSummary.accountTypes);

        Assert.assertEquals("Verify the account types",expectedAccountTypes,actualAccountTypes);
    }

    @Then("Credit Accounts table must have following columns")
    public void credit_Accounts_table_must_have_following_columns(List<String> expectedCreditAccountsColumns) {
        List<String> actualCreditAccountsColumns = BrowserUtils.getElementsText(accountSummary.creditAccountsColumns);

        Assert.assertEquals("Verify columns in Credit Account",expectedCreditAccountsColumns,actualCreditAccountsColumns);
    }


}
