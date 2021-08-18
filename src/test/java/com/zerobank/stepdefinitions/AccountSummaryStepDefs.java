package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {
    @Then("the page should have {string} title")
    public void the_page_should_have_title(String AccountSummary) {
        Assert.assertEquals(AccountSummary, Driver.get().getTitle());
    }

    @Then("the page should have following account types")
    public void the_page_should_have_following_account_types(List<String> accountTypes) {
        Assert.assertEquals(accountTypes,new AccountSummary().accountTypes());
    }
    @Then("Credit Accounts table must have following columns")
    public void credit_Accounts_table_must_have_following_columns(List<String> columnNames) {
        Assert.assertEquals(columnNames,new AccountSummary().creditAccountsTableColumns());
    }
}


