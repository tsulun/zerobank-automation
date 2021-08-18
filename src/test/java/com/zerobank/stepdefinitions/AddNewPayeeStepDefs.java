package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Map;

public class AddNewPayeeStepDefs {
    @Given("Add New Payeetab")
    public void add_New_Payeetab() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.addNewPayee.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String > userInfo) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payeeName.sendKeys(userInfo.get("Payee Name"));
        payBillsPage.payeeAddress.sendKeys(userInfo.get("Payee Address"));
        payBillsPage.account.sendKeys(userInfo.get("Account"));
        payBillsPage.payeeDetails.sendKeys(userInfo.get("Payee details"));
        payBillsPage.add.click();
    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created() {
        Assert.assertTrue(new PayBillsPage().succesfulMessage.isDisplayed());
    }




}
