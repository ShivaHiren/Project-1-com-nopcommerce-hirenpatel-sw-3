package computer;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.HashMap;
import java.util.Map;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    //Launching browser
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test//1
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

        Actions actions = new Actions(driver);
        //1.1 Click on computer menu
        WebElement computers = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(computers).moveToElement(computers).click().build().perform();

        //1.2 Click on Desktop
        WebElement desktops = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        actions.moveToElement(desktops).moveToElement(desktops).click().build().perform();

        //1.3 Select sort by position name Z to A
        Select productOrder = new Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));
        productOrder.selectByIndex(2);
        Thread.sleep(1000);

        //1.4 Verify the Product will arrange in Descending order
        String expectedMessage = "Build your own computer";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//a[contains(text(),'Build your own computer')]"));
        String actualMessage = actualTextMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test//2

    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        Actions actions = new Actions(driver);
        //2.1 Click on computer menu
        WebElement computers = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(computers).moveToElement(computers).click().build().perform();

        //2.2 Click on Desktop
        WebElement desktops = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        actions.moveToElement(desktops).moveToElement(desktops).click().build().perform();

        //2.3 Select sort by position name  A to Z
        Select productOrder = new Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));
        productOrder.selectByIndex(1);
        Thread.sleep(1000);

        //2.4 Click on "Add to cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        //2.5 Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//a[contains(text(),'Build your own computer')]"));
        String actualMessage = actualTextMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Select obj1 = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_1']")));
        obj1.selectByIndex(1);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//option[@value='1']")).click();

        // 2.7.Select "8GB [+$60.00]" using Select class.
        driver.findElement(By.xpath("//option[@value='5']")).click();

        //2.8 Select HDD radio "400 GB [+$100.00]"
        driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        driver.findElement(By.xpath("//input[@id='product_attribute_4_9']")).click();

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();
        Thread.sleep(2000);

        //2.11 Verify the price "$1,475.00"
        String expectedMessage1 = "$1,475.00";
        WebElement actualTextMessageElement1 = driver.findElement(By.xpath("//span[@id='price-value-1']"));
        String actualMessage1 = actualTextMessageElement1.getText();
        Assert.assertEquals(expectedMessage, actualMessage);


        //2.12 Click on " ADD TO CART" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage2 = "The product has been added to your shopping cart";
        WebElement actualTextMessageElement2 = driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        String actualMessage2 = actualTextMessageElement2.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(2000);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        clickOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));

        //2.15 Verify the message "Shopping cart"
        String expectedMessage3 = "The product has been added to your shopping cart";
        WebElement actualTextMessageElement3 = driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        String actualMessage3 = actualTextMessageElement3.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        //2.16  Change the Qty to "2" and Click on "Update shopping cart"
        clearTheText(By.xpath("//td[@class='quantity']/input"));
        sendTextToElement(By.xpath("//td[@class='quantity']/input"), "2");
        clickOnElement(By.id("updatecart"));

        //2.17  Verify the Total"$2,950.00"
        String expectedMessage4 = "$2,950.00";
        WebElement actualTextMessageElement4 = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        String actualMessage4 = actualTextMessageElement4.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        //  2.18 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //  2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage5 = "“Welcome, Please Sign In!";
        WebElement actualTextMessageElement5 = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage5 = actualTextMessageElement5.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        //  2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //   2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Jhon");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Wick");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "jhon@gmail.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"), "Google");
        sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), " 1 Palace road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "LL01 1LL");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "0123456789");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));


        //  2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));


        //   2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //   2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        //    2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        //   2.27 Select “Master card” From Select credit card dropdown
        sendTextToElement(By.xpath("//select[@id='CreditCardType']"), "Master card");

        //   2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Jhon Wick");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "4");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2027");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "227");

        //  2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //   2.30 Verify “Payment Method” is “Credit Card”
        verifyTextFromElements(By.xpath("//li[@class='payment-method']"), "Payment Method: Credit Card");

        //   2.32 Verify “Shipping Method” is “Next Day Air”
        verifyTextFromElements(By.xpath("//li[@class='shipping-method']"), "Shipping Method: Ground");

        //   2.33 Verify Total is “$2,950.00”
        verifyTextFromElements(By.xpath("//tr[@class='order-total']/td[2]"),"$2,950.00");

        //  2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        //  2.35 Verify the Text “Thank You”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");

        //  2.36 Verify the message “Your order has been successfully processed!”
        verifyTextFromElements(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");

        //  2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        //  2.37 Verify the text “Welcome to our store”
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");

    }
    @After
    public void testDown() {
        closeBrowser();
    }

}
