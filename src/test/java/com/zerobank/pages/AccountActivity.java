package com.zerobank.pages;

import com.zerobank.utilities.StringUtils;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountActivity extends BasePage {

    @FindBy(css = "#aa_accountId")
    public WebElement accountDropDown;

    public Boolean whichAccountIsSelected(String string){
        Select accountDrops = new Select(accountDropDown);
        return accountDrops.getFirstSelectedOption().getText().equals(new StringUtils().capitalizeWord(string));


    }



}
