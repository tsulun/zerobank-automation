package com.zerobank.stepdefinitions;

import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


public class FindTransactionsStepDefs {

    FindTransactionsPage f=new FindTransactionsPage();

    @Given("the user navigates {string} page")
    public void the_user_navigates_page(String tabName) {
       f.navigateToMdl(tabName);
    }

    @Given("the user clicks on {string}")
    public void the_user_clicks_on(String tabName) {
        if(tabName.toLowerCase().equals("find transactions")){
            BrowserUtils.waitForClickablility(f.findTransactionsTab,5);
            f.findTransactionsTab.click();
        }else if(tabName.toLowerCase().equals("search")) {
            BrowserUtils.waitForClickablility(f.searchBtn,5);
            f.searchBtn.click();
        }
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(3);
        f.datesFrom.sendKeys(fromDate);
        f.datesTo.sendKeys(toDate);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {
        Date date1 = BrowserUtils.convertStringToDate(fromDate);
        Date date2 = BrowserUtils.convertStringToDate(toDate);

        BrowserUtils.scrollToElement(f.searchBtn);
        BrowserUtils.waitFor(4);

        List<WebElement> resultTableDates = f.ResultTableDates;
        List<String> stringDates = BrowserUtils.getElementsText(resultTableDates);

        for (int i = 0; i < stringDates.size(); i++) {
            Date d = BrowserUtils.convertStringToDate(stringDates.get(i));
            Assert.assertTrue(d.after(date1) && d.before(date2));
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {
        List<WebElement> resultTableDates = f.ResultTableDates;

        List<String> stringDates = BrowserUtils.getElementsText(resultTableDates);

        for (int i = 0; i < stringDates.size()-1; i++) {
            Date date1 = BrowserUtils.convertStringToDate(stringDates.get(i));
            Date date2=BrowserUtils.convertStringToDate(stringDates.get(i+1));
            Assert.assertTrue(date1.after(date2));
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated (String date){

        List<WebElement> resultTableDates = f.ResultTableDates;
        List<String> stringDates = BrowserUtils.getElementsText(resultTableDates);

        for (String eachDate : stringDates) {
            Assert.assertFalse(eachDate.equals(date));
        }
    }
    @When("the user enters description {string}")
    public void the_user_enters_description (String descEntered){
        f.description.sendKeys(descEntered);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing (String string){

        //!!
    }
    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing (String string){

        //!!
    }



}
