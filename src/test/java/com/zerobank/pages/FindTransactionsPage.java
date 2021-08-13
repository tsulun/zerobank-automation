package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindTransactionsPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(),'Find Transactions')]")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "aa_fromDate")
    public WebElement datesFrom;

    @FindBy(id = "aa_toDate")
    public WebElement datesTo;

    @FindBy(id="aa_fromAmount")
    public WebElement amountsFrom;

    @FindBy(id = "aa_toAmount")
    public WebElement amountsTo;

    @FindBy(id="aa_type")
    public WebElement type;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//td[1]")
    public List<WebElement> ResultTableDates;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//td[2]")
    public List<WebElement> ResultTableDescriptions;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//td[3]")
    public List<WebElement> ResultTableDeposits;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//td[4]")
    public List<WebElement> ResultTableWithdrawals;


}
