package rapyutatest;

import basetest.UIBaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DrawPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Constant;
import utils.LaunchBrowser;

public class UITestCase extends UIBaseTest {

    LoginPage loginPage;
    LaunchBrowser launchBrowser;
    HomePage homePage;
    DrawPage drawPage;

    @BeforeClass
    public void initialize()
    {
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        drawPage=new DrawPage(driver);
    }

    @Test
    public void login() throws InterruptedException {
        //Login to Application
        loginPage.login("autobootstrap","autobootstrap");
        homePage.validatePage();
        //Click on Setting button
        homePage.clickSettingIcon();
        //Switch to Map tab
        homePage.switchMapTab();
        homePage.clickstartBtn();
        //Draw points
        drawPage.draw();
        drawPage.clickEdgeBtn();
        //Draw Edge
        drawPage.drawEdge(200,10,225,115);
        drawPage.clickRegionBtn();
        Thread.sleep(2000);
        //Draw Region
        drawPage.drawRegion(200,10,225,115);
        Thread.sleep(2000);
        //Edit Region Coordinate
        drawPage.editCoordinates();
        //Save the region
        drawPage.saveChabnges();
        //Log out
        drawPage.logout();
        Assert.assertTrue(loginPage.isLoginpage());
    }
}
