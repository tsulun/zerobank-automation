package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTransactionsPage extends BasePage {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

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

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[2]")
    public List<WebElement> secondColumn;

    public WebElement datesFromTo(int i) {
        return Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[1]"));
    }

    public WebElement resultContains(int i) {
        return Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[2]"));
    }

    public WebElement resultDeposit(int i) {
        return Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[3]"));
    }

    public WebElement resultWithdrawal(int i) {
        return Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[4]"));
    }


    @FindBy(xpath = "//div[contains(text(),'No results')]")
    public WebElement noResults;

    @FindBy(xpath = "//select[@id='aa_type']")
    public WebElement typeOptions;

    public void selectOption(String str) {
        Select selectedDropDown = new Select(typeOptions);
        selectedDropDown.selectByVisibleText(str);  //select from the dropdown by text
        selectedDropDown.getFirstSelectedOption(); //the selected drop down is set as the first option to be clicked

    }

    public void enteringDateRangeMethod(String from, String to) {
        fromDate.sendKeys(from);
        toDate.sendKeys(to);
    }

    public void clearFromDateField() {
        fromDate.clear();
    }

    public void clearToDateField() {
        toDate.clear();
    }

    public void clearDescriptionField() {
        descritptionField.clear();
    }

    public void inBetweenDatesAssertion(String dateF, String dateT) throws ParseException {
        //changing to date format instead of string format
        Date dateFF = format.parse(dateF);
        Date dateTT = format.parse(dateT);
        //finding the number of rows
        int sizeOfRows = firstColumn.size();
        for (int i = 1; i <= sizeOfRows; i++) {
            Date dates = format.parse(datesFromTo(i).getText());
            //dateTT.after(dates) the same as dateTT > dates and dateFF.before(dates) same as dateFF < dates
            Assert.assertTrue(dateTT.after(dates) && dateFF.before(dates) || dateTT.equals(dates) || dateFF.equals(dates));

        }
    }


    public void descendingSortedOrderChecker() throws ParseException {
        //finding the row numbers
        int sizeOfRows = firstColumn.size();
        // "<sizeOfRows because  datesFromTo(i+1) is i+1 the last one already taken
        for (int i = 1; i < sizeOfRows; i++) {
            Date date1 = format.parse(datesFromTo(i).getText()); //first value from the list
            Date date2 = format.parse(datesFromTo(i + 1).getText()); //second value from the list
            Assert.assertTrue(date1.after(date2)); //check the most recent date is above the later date

        }
    }

    public void notContaningTheGivenTransactionDate(String givenDate) throws ParseException {
        int sizeOfRows = firstColumn.size(); //number of rows
        Date date1 = format.parse(givenDate);
        for (int i = 1; i <= sizeOfRows; i++) {
            //check for each the dates that the given date is not equal to the number rows dates.
            Date date2 = format.parse(datesFromTo(i).getText());
            Assert.assertNotEquals(date1, date2);
        }
    }

    public void searchResultsContainsTheGivenTextChecker(String str) {
        int sizeOfRows2 = secondColumn.size(); //number of rows
        if (sizeOfRows2 > 0) {
            for (int i = 1; i <= sizeOfRows2; i++) {
                //fetch the text from the rows
                String textContainingStr = resultContains(i).getText();
                Assert.assertTrue(textContainingStr.contains(str));
            }
        } else {
            String textContainingStr = noResults.getText();
            //the assertion is for case insensitivity but the case is not case insensitive, hence it fails for
            // for lower case strings.
            Assert.assertTrue("verify it is case insensitive", textContainingStr.contains(str));
        }
    }


    public void searchResultShouldNotContainTheGivenTextChecker(String str) {
        int sizeOfRows2 = secondColumn.size();

        for (int i = 1; i <= sizeOfRows2; i++) {
            //fetch the text from the rows
            String textContainingStr = resultContains(i).getText();
            //asserting that the text is not contained is false , (it is show the text on the table)=> False + ! = true
            Assert.assertFalse(!textContainingStr.contains(str));
        }
    }

    public void valueCheckerUnderGivenColumnName(String str) {
        int sizeOfRows2 = secondColumn.size();
        boolean fa = false;
        if (str.equals("Deposit")) {
            for (int i = 1; i <= sizeOfRows2; i++) {
                //if it finds one under deposit the boolean becomes true and it breaks no need to continue the loop
                // if any idea on shorting this part part or other its most welcome guys.
                if (!resultDeposit(i).getText().isEmpty()) {
                    fa = true;
                    break;
                }
            }
            Assert.assertTrue(fa);
        } else if (str.equals("Withdrawal")) {
            for (int i = 1; i <= sizeOfRows2; i++) {
                //if it finds one under deposit the boolean becomes true and it breaks no need to continue the loop
                // if any idea on shorting this part part or other its most welcome guys.
                if (!resultWithdrawal(i).getText().isEmpty()) {
                    fa = true;
                    break;
                }
            }
            Assert.assertTrue(fa);
        }
    }

    public void noResultUnderGivenColumnName(String str) {
        int sizeOfRows2 = secondColumn.size();
        if (str.equals("Withdrawal")) {
            for (int i = 1; i <= sizeOfRows2; i++) {
                //if it is empty it good according to the requirement
                //else if it finds any in the number of rows, it will become false and fail, and
                //Will it automatically breaks the loop if it fails to satisfy the condition?
                Assert.assertTrue(resultWithdrawal(i).getText().isEmpty());

            }
        } else if (str.equals("Deposit")) {
            for (int i = 1; i <= sizeOfRows2; i++) {
                //if it is empty it good according to the requirement
                //else if it finds any in the number of rows, it will become false and fail, and
                //Will it automatically breaks the loop if it fails to satisfy the condition?
                Assert.assertTrue(resultDeposit(i).getText().isEmpty());
            }
        }


    }

}
