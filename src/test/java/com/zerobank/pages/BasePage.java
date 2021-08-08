package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.BrokenBarrierException;

public class BasePage {


public void navigateToModule(String Tab){

    WebElement tabElement = Driver.get().findElement(By.linkText(Tab));
    BrowserUtils.waitForClickablility(tabElement , 5);
    tabElement.click();
}


}