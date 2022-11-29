package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import browserfactory.BaseTest;
import org.junit.Assert;
import utilities.Utility;

import javax.swing.text.Utilities;

import static browserfactory.BaseTest.driver;

//        1.1 create method with name "selectMenu" it has one parameter name "menu" of type
//        string
//        1.2 This method should click on the menu whatever name is passed as parameter.
//        1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
//        select the Menu and click on it and verify the page navigation.

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    //Launching browser
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(By by) {
        WebElement click = driver.findElement(by);
        selectMenu(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
    }

    @Test
    public void verifyPageNavigation() {


        //selectMenu(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        //This is requirement
        String expectedMessage = "Computers";

        //Find the welcome test element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String actualMessage = actualTextMessageElement.getText();
        //This is requirement
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @After
    public void testDown() {

        closeBrowser();
    }
}
