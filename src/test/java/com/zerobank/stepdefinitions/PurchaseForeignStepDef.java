package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.FirstPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PurchaseForeign;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jsoup.Connection;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.List;

public class PurchaseForeignStepDef {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        BasePage basePage = new BasePage();
        basePage.navigateToModules("Pay Bills","Purchase Foreign Currency");


    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencyOptions ) {
   List<String> actualCurrency = BrowserUtils.getElementsText(new PurchaseForeign().currencyInput);
   Assert.assertEquals(currencyOptions,actualCurrency);


    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
    PurchaseForeign purchaseForeign = new PurchaseForeign();
    purchaseForeign.calculateCostsBtn.click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        String alertMessage = Driver.get().switchTo().alert().getText();

        BrowserUtils.waitFor(3);
        alert.accept();

        boolean contains = alertMessage.contains("Please, ensure that you have filled all the required fields with valid values.");
        Assert.assertTrue(contains);




    }

}
