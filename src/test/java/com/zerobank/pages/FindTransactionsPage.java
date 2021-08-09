package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FindTransactionsPage {

    public FindTransactionsPage(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(xpath = "//a[contains(text(),'Find Transactions')]")
    public WebElement findTransctionTab;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement fromDate;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchBtn;

    @FindBy(id = "aa_description")
    public WebElement descritptionField;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[1]")
    public List<WebElement> firstColumn;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[1]")
    public List<WebElement> secondColumn;

    public WebElement datesFromTo(int i){
        return Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[1]"));
    }

    public WebElement resultContains(int i){
        return Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr["+i+"]/td[2]"));
    }

    public WebElement resultDeposit(int i){
        return Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr["+i+"]/td[3]"));
    }

    public WebElement resultWithdrawal(int i){
        return Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr["+i+"]/td[4]"));
    }



    @FindBy(xpath = "//div[contains(text(),'No results')]")
    public WebElement noResults;

    @FindBy(xpath = "//select[@id='aa_type']")
    public WebElement typeOptions;

    public Select typeOptionsList(){

        return new Select(typeOptions);
    }
}
