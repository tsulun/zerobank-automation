package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import com.zerobank.utilities.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummary extends BasePage{

    public void clickAccount(String str){
        WebElement webElement = Driver.get().findElement(By.xpath("//a[text()='"+ new StringUtils().capitalizeWord(str)  +"']"));
        webElement.click();

    }

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//thead)[3]//th")
    public List<WebElement> creditAccountsColumns;



}
