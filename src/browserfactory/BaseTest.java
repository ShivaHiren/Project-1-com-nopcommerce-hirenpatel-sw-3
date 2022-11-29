package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;



    public void openBrowser(String baseUrl){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver(options);//object of chrome driver
        // Launch the URL
        driver.get(baseUrl);
        //Maximise Window
        driver.manage().window().maximize();
        // We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser(){
        //Closing windows
        driver.quit();
    }

}
