package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class WebdriverUtils {

    private static WebDriver driver;
    private WebDriverWait webDriverWait;

    public WebdriverUtils(WebDriver driver)
    {
        this.driver=driver;
    }

    public void waitForElement(WebElement element, String elementName) throws NoSuchElementException {
        try{
            webDriverWait = new WebDriverWait(driver, 20);
            webDriverWait.until(ExpectedConditions.visibilityOf(element));

        }catch (Exception e){

            throw new NoSuchElementException("Unable to wait for given element :"+elementName,e);
        }
    }


}
