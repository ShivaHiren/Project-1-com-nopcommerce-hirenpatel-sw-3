package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
       loginLink.click();
    }

    /**
     * This method send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /*
     *This method will accept alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    /*
     *This method will dismiss alert
     */

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
    /*
    This method will get text from alert
     */

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    /*
    This method will send text to alert
     */

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys("");
    }


    //Homework 4 method acceptAlert, dismissAlert, String getTextFromAlert, sendTextToAlert(String text)

    //************************Select Class Methods***********************************

    /*
     * This method will select option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(By.name("country"));
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /*
     * This method will select option by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);


    }

    /*
     * This method will select option by Index
     */
    public void selectByIndex(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);


    }
    /*
     * This method will select option by contains text
     */

    public void selectByContainsText(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }

    }
    //*************************Window Handel ******************************

    //*************************Action class *******************************

    //mouseHoverToElement(By by),mouseHoverToElementAndClick(By by)

    /*
    This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /*
     * This method will use to hover mouse on element and click
     */

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();

    }
    public void clearTheText(By by) {
        WebElement delete = driver.findElement(by);
        delete.clear();
    }
    public void verifyTextFromElements(By by, String expectedText) {
        WebElement actualText = driver.findElement(by);
        String actual = actualText.getText();
        Assert.assertEquals(expectedText, actual);
    }

    }