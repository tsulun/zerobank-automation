package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.StringUtils;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivity extends BasePage {

    @FindBy(css = "#aa_accountId")
    public WebElement accountDropDown;

    @FindBy(xpath = "//table[@class='table table-condensed table-hover']/thead//th")
    public List<WebElement> tableHeadColumns;

    public Boolean whichAccountIsSelected(String string) {
        Select accountDrops = new Select(accountDropDown);
        return accountDrops.getFirstSelectedOption().getText().equals(new StringUtils().capitalizeWord(string));

    }

    public List<String> elementsOfDropDown() {
        Select accountDrops = new Select(accountDropDown);
        List<String> dropdownElements = BrowserUtils.getElementsText(accountDrops.getOptions());
        return dropdownElements;
    }

    public boolean similarityOfTwoList(List<String> list1, List<String> list2) {
    boolean var = list1.stream().anyMatch(element -> list2.contains(element));
    return var;
}
}
