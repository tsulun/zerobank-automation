package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PurchaseForeign extends BasePage{

    @FindBy(id = "pc_currency")
    public List<WebElement> currencyInput;

    @FindBy(css = "#pc_calculate_costs")
    public WebElement calculateCostsBtn;

}
