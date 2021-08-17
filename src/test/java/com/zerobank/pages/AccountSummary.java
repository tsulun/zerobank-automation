package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import com.zerobank.utilities.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountSummary extends BasePage{

    public void clickAccount(String str){
        WebElement webElement = Driver.get().findElement(By.xpath("//a[text()='"+ new StringUtils().capitalizeWord(str)  +"']"));
        webElement.click();
    }

    public String getTitle(){
        return new AccountSummary().getTitle();
    }



}
