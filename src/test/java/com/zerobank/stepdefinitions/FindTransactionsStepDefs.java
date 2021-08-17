package com.zerobank.stepdefinitions;

import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FindTransactionsStepDefs {

    FindTransactionsPage findTransactionsPage = new FindTransactionsPage();


    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        findTransactionsPage.findTransctionTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String dateF, String dateT) {
        findTransactionsPage.enteringDateRangeMethod(dateF,dateT);
    }

    @When("clicks search")
    public void clicks_search() {
        findTransactionsPage.searchBtn.click();
        BrowserUtils.waitFor(1);
        //because it is over laping with the previous dates after search button is clicked , the fields are cleared.
        findTransactionsPage.clearFromDateField();
        findTransactionsPage.clearToDateField();
        findTransactionsPage.clearDescriptionField();

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String dateF, String dateT) throws ParseException {
        findTransactionsPage.inBetweenDatesAssertion(dateF,dateT);

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException { //ParseException it is autmatically generated as the same as like Thread.sleep()
        findTransactionsPage.descendingSortedOrderChecker();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) throws ParseException {
       findTransactionsPage.notContaningTheGivenTransactionDate(date);
    }

    //the user enters description "ONLINE"
    //When the user enters description "OFFICE"
    @When("the user enters description {string}")
    public void the_user_enters_description(String str) {
        findTransactionsPage.descritptionField.sendKeys(str);
    }

    //Then results table should only show descriptions that containing "ONLINE"
    //Then results table should only show descriptions that containing "OFFICE"
    @Then("results table should only show descriptions that containing {string}")
    public void results_table_should_only_show_descriptions_that_containing(String str) {
        findTransactionsPage.searchResultsContainsTheGivenTextChecker(str);
        }


    //But results table should not show descriptions containing "OFFICE"
    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String str) {
        the_user_enters_description(str);
        findTransactionsPage.searchResultsContainsTheGivenTextChecker(str);
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String str) {
        findTransactionsPage.valueCheckerUnderGivenColumnName(str);
    }

    @When("user selects type {string}")
    public void user_selects_type(String str) {
        findTransactionsPage.selectOption(str);
        clicks_search();   //After select type feature step, there should be "click search" step, unfortunately, it is not done,
                            //hence,the click find button method is called here, as it should be clicked otherwise it will not work
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String str) {
        findTransactionsPage.noResultUnderGivenColumnName(str);
    }










}
