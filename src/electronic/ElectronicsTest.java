package electronic;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    //Launching browser
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test//1

    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        Actions actions = new Actions(driver);
        //    1.1 Mouse Hover on “Electronics” Tab
        //    1.2 Mouse Hover on “Cell phones” and click
        WebElement electronic = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        WebElement cellphone = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(electronic).moveToElement(cellphone).click().build().perform();

        //   1.3 Verify the text “Cell phones
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

    }

    @Test//2
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);
//        2.1 Mouse Hover on “Electronics” Tab
//        2.2 Mouse Hover on “Cell phones” and click
        WebElement electronic = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        WebElement cellphone = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        actions.moveToElement(electronic).moveToElement(cellphone).click().build().perform();

//        2.3 Verify the text “Cell phones”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

//        2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1500);

//        2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        // clickOnElement(By.linkText("Nokia Lumia 1020"));

//        2.6 Verify the text “Nokia Lumia 1020”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");
        Thread.sleep(1500);

//        2.7 Verify the price “$349.00”
        verifyTextFromElements(By.xpath("//span[@id='price-value-20']"), "$349.00");

//        2.8 Change quantity to 2
        clearTheText(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        Thread.sleep(1500);

//        2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

//        2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyTextFromElements(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");
        Thread.sleep(1500);

//        After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        Thread.sleep(1500);

//        2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions actions1 = new Actions(driver);
        WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement gotocart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        actions.moveToElement(shoppingCart).moveToElement(gotocart).click().build().perform();
       // clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(1500);

//        2.12 Verify the message "Shopping cart"
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        Thread.sleep(1500);

//        2.13 Verify the quantity is 2
       verifyTextFromElements(By.xpath("//span[contains(text(),'(2)')]"), "(2)");
        //Thread.sleep(1500);


//        2.14 Verify the Total $698.00
        verifyTextFromElements(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"), "$698.00");
        Thread.sleep(1500);

//        2.15 click on checkbox “I agree with the terms of service”
        //clickOnElement(By.xpath("//input[@id='termsofservice']"));
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();


//        2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));


//        2.17 Verify the Text “Welcome, Please Sign In!”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
        Thread.sleep(1500);

//        2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

//        2.19 Verify the text “Register”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Register')]"), "Register");


//        2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Jhon");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Wick");
        sendTextToElement(By.xpath("//input[@id='Email']"), "jhon4@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Company']"), "Google");
        sendTextToElement(By.xpath("//input[@id='Password']"), "London");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "London");

//        2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

//        2.22 Verify the message “Your registration completed”
        verifyTextFromElements(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");


//        2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));


//        2.24 Verify the text “Shopping cart”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");


//        2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));


//        2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));


//        2.27 Fill the Mandatory fields
        sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), " 1 Palace road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "LL01 1LL");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "0123456789");


//        2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));


//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));


//        2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));


//        2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));


//        2.32 Select “Visa” From Select credit card dropdown
        sendTextToElement(By.xpath("//select[@id='CreditCardType']"), "Master card");


//        2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Jhon Wick");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "4");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2027");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "227");


//        2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));


//        2.35 Verify “Payment Method” is “Credit Card”
        verifyTextFromElements(By.xpath("//li[@class='payment-method']"), "Payment Method: Credit Card");


//        2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyTextFromElements(By.xpath("//li[@class='shipping-method']"), "Shipping Method: 2nd Day Air");


//        2.37 Verify Total is “$698.00”
        verifyTextFromElements(By.xpath("//tr[@class='order-total']/td[2]"), "$698.00");


//        2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));


//        2.39 Verify the Text “Thank You”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");


//        2.40 Verify the message “Your order has been successfully processed!”
        verifyTextFromElements(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");


//        2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));


//        2.42 Verify the text “Welcome to our store”
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");


//        2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));


//        2.44 Verify the URL is “https://demo.nopcommerce.com/
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://demo.nopcommerce.com/");


    }
    @After
    public void testDown() {

        closeBrowser();
    }
}
