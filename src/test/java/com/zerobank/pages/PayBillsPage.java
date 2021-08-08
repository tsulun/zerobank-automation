package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage extends BasePage{
    @FindBy(css = "[href='#ui-tabs-2']")
    public WebElement addNewPayee;

    @FindBy(css="[id='sp_payee'[id='sp_payee']")
    public WebElement payee;

    @FindBy(css = "[id='sp_account']")
    public WebElement account;

    @FindBy(css ="[id='sp_amount'][name='amount']")
    public WebElement amount;

    @FindBy(css = "[class='span4 hasDatepicker']")
    public WebElement date;

    @FindBy(css = "[name='description']")
    public WebElement description;

public void selectPayee(String selectPayee){
    Select payeeDropdown= new Select(payee);
    payeeDropdown.selectByVisibleText(selectPayee);

}

}
