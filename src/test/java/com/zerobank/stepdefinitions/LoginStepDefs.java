package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.FirstPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user navigates to login page")
    public void the_user_navigates_to_login_page() {
       String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        FirstPage firstPage = new FirstPage();
        BrowserUtils.waitFor(2);
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
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("verification to log in succesfully","Zero - Account Summary",actualTitle);
    }


    @When("navigate to module {string}")
    public void navigate_to_module(String string) {
        BasePage basePage = new BasePage();
        BrowserUtils.waitFor(3);
        basePage.navigateToModule(string);
        BrowserUtils.waitFor(5);
    }
}
