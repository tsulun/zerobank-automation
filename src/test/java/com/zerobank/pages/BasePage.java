package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.BrokenBarrierException;

public class BasePage {
    public BasePage () {
        PageFactory.initElements(Driver.get(), this);
    }

public void navigateToModule(String Tab){

    try {
        BrowserUtils.waitForClickablility(By.linkText(Tab), 5);
        WebElement tabElement = Driver.get().findElement(By.linkText(Tab));
        tabElement.click();
    }catch (Exception e) {
        BrowserUtils.clickWithWait(By.linkText(Tab), 5);
    }
}




}