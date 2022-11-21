package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    //global variable declaration for webdriver
    public static WebDriver driver;

    //method declaration and implementation for open browser
    public void openBrowser(String baseUrl){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        //Launch the URL
        driver.get(baseUrl);
        //Maximize window
        driver.manage().window().maximize();
        //we give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //method declaration and implementation for close browser
    public void closeBrowser(){
        driver.quit(); //quit() method will close entire webdriver session and close all window from browser which is opened by webdriver
    }

}
