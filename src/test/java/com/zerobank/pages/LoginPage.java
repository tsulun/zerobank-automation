package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement loginInput;

    @FindBy(css = "#user_password")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//button[@id='details-button']")
    public WebElement advance;

    @FindBy(xpath = "//*[text()='Proceed to zero.webappsecurity.com (unsafe)']")
    public WebElement clickToCont;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    public void loginAsCustomer() throws InterruptedException {
         String username = ConfigurationReader.get("username");
         String password = ConfigurationReader.get("password");
         loginInput.sendKeys(username);
         passwordInput.sendKeys(password);
         signInButton.click();
    }

    public void userAtLoginPage(){
        Driver.get().get("http://zero.webappsecurity.com/login.html");
    }

    public void loginWithWrongCredentials(){
        loginInput.sendKeys("Invalid Username");
        passwordInput.sendKeys("Invalid Password");
        signInButton.click();
    }

    public void loginWithBlankCredentials(){
        loginInput.sendKeys("");
        passwordInput.sendKeys("");
        signInButton.click();
    }

    public boolean errorMessageIsDisplayed(){
        return new LoginPage().errorMessage.isDisplayed();
    }
}
