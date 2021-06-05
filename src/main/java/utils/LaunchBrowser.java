package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

    public static WebDriver webDriver;

    public static WebDriver getWebDriverInstance(){
        try {
            if(webDriver == null) {
                System.setProperty("webdriver.chrome.driver", "DriverFiles/chromedriver");
                webDriver = new ChromeDriver();
            }else{
                return webDriver;
            }

        }catch(Exception e){

        }
        return webDriver;
    }


}
