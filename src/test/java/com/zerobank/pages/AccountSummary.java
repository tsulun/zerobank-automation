package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSummary extends BasePage{

    public void clickAccount(String str){
        WebElement webElement = Driver.get().findElement(By.xpath("//a[text()='"+ new StringUtils().capitalizeWord(str)  +"']"));
        webElement.click();

    }

    public List<String> accountTypes(){
        List<String> accountOptions = BrowserUtils.getElementsText(Driver.get().findElements(By.cssSelector(".board-header")));
        return accountOptions;
    }

    public List<String> creditAccountsTableColumns(){
        List<String> tableColumns = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/table[1]/thead[1]/tr[1]/th")));
        return tableColumns;
    }



}
