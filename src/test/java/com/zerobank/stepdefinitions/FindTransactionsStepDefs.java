package com.zerobank.stepdefinitions;

import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FindTransactionsStepDefs {

    FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        findTransactionsPage.findTransctionTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String dateF, String dateT) {
        findTransactionsPage.fromDate.sendKeys(dateF);
        findTransactionsPage.toDate.sendKeys(dateT);
    }

    @When("clicks search")
    public void clicks_search() {
        findTransactionsPage.searchBtn.click();
        BrowserUtils.waitFor(1);
        //because it is over laping with the previous dates after search button is clicked , the fields are cleared.
        findTransactionsPage.fromDate.clear();
        findTransactionsPage.toDate.clear();

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String dateF, String dateT) throws ParseException {
        //changing to date format instead of string format
        Date dateFF = format.parse(dateF);
        Date dateTT = format.parse(dateT);
        //finding the number of rows
        int sizeOfRows = findTransactionsPage.firstColumn.size();
        boolean fa = false;
        for (int i = 1; i <= sizeOfRows; i++) {
            Date dates = format.parse(findTransactionsPage.datesFromTo(i).getText());
            //dateTT.after(dates) the same as dateTT > dates and dateFF.before(dates) same as dateFF < dates
            Assert.assertTrue(dateTT.after(dates) && dateFF.before(dates) || dateTT.equals(dates) || dateFF.equals(dates) );

        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException { //ParseException it is autmatically generated as the same as like Thread.sleep()
        //finding the row numbers
        int sizeOfRows = findTransactionsPage.firstColumn.size();
        // "<sizeOfRows because  datesFromTo(i+1) is i+1 the last one already taken
        for (int i = 1; i < sizeOfRows; i++) {
            Date date1 = format.parse(findTransactionsPage.datesFromTo(i).getText());
            Date date2 = format.parse(findTransactionsPage.datesFromTo(i+1).getText());
            Assert.assertTrue(date1.after(date2));

        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date11) throws ParseException {
        int sizeOfRows = findTransactionsPage.firstColumn.size();
        Date date1 = format.parse(date11);
        for (int i = 1; i <= sizeOfRows; i++) {
            Date date2 = format.parse(findTransactionsPage.datesFromTo(i).getText());
            Assert.assertNotEquals(date1, date2);
        }
    }

}
