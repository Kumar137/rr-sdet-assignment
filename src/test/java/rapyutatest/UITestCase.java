package rapyutatest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DrawPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Constant;
import utils.LaunchBrowser;

public class UITestCase {

    LoginPage loginPage;
    LaunchBrowser launchBrowser;
    WebDriver driver;
    HomePage homePage;
    DrawPage drawPage;

    @BeforeTest
    public void initialize()
    {

        launchBrowser=new LaunchBrowser();
        driver=launchBrowser.getWebDriverInstance();
        driver.get(Constant.URL);
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        drawPage=new DrawPage(driver);
    }

    @Test
    public void login()
    {

        loginPage.login("autobootstrap","autobootstrap");
        homePage.validatePage();
        homePage.clickSettingIcon();
        homePage.switchMapTab();
        homePage.clickstartBtn();
        drawPage.draw();
    }
}
