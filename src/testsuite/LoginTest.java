package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.Utility;

public class LoginTest extends Utility {
    //Url stored into baseUrl
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials(){
        //Enter username
        sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith");
        //Enter password
        sendTextToElement(By.xpath("//input[@id = 'password']"),"SuperSecretPassword!");
        //click on login
        clickOnElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']"));
        String expectedMessage = "Secure Area";
        // Find the Secure area element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h2[text()=' Secure Area']"));
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter username
        sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith1");
        //Enter password
        sendTextToElement(By.xpath("//input[@id = 'password']"),"SuperSecretPassword!");
        //click on login
        clickOnElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']"));
        String expectedMessage = "Your username is invalid!\n" + "×";
        String actualMessage = getTextFromElement(By.xpath("//div[@id = 'flash']"));
        //Validate actual and expected message
        Assert.assertEquals("Text Match ",expectedMessage,actualMessage);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter username
        sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith");
        //Enter password
        sendTextToElement(By.xpath("//input[@id = 'password']"),"SuperSecretPassword");
        //click on login
        clickOnElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']"));
        String expectedMessage = "Your password is invalid!\n" + "×";
        String actualMessage = getTextFromElement(By.xpath("//div[@class = 'flash error']"));
        //Validate actual and expected message
        Assert.assertEquals("Text Match ",expectedMessage,actualMessage);

    }

    @After
    public void tearDown(){
        //This method close the web browser
        closeBrowser();
    }
}
