package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.FirstPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.StringUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
       String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        FirstPage firstPage = new FirstPage();
        BrowserUtils.waitFor(1);
        firstPage.signIn.click();

    }

    @When("the user enters customer information")
    public void the_user_enters_customer_information() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsCustomer();
        //BrowserUtils.waitFor(2);
        loginPage.advance.click();
        loginPage.clickToCont.click();
    }

    @Then("the user should be login")
    public void the_user_should_be_login() {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("verification to log in succesfully","Zero - Account Summary",actualTitle);
    }


    @When("the user clicks on Savings link on the {string} page")
    public void the_user_clicks_on_Savings_link_on_the(String string) {
        BasePage basePage = new BasePage();
        basePage.navigateToModule(new StringUtils().capitalizeWord(string));
    }
}
