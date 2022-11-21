package utilites;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {
    //This method will click on element

    public void clickOnElement(By by){
        //Find element  and click on element
        driver.findElement(by).click();
    }
    //This method will enter data into field
    public void sendTextToElement(By by, String text){
        //Find element and enter data into element
        driver.findElement(by).sendKeys(text);
    }
    //Find the element and get the text from element
    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();

    }


}
