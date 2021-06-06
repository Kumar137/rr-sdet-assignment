package basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utils.Constant;
import utils.LaunchBrowser;
import utils.ReportUtil;

public class UIBaseTest extends ReportUtil {

    LaunchBrowser launchBrowser;
    public WebDriver driver;

    @BeforeClass
    public void init()
    {
        launchBrowser=new LaunchBrowser();
        driver=launchBrowser.getWebDriverInstance();
        driver.get(Constant.URL);

    }

    @AfterClass
    public void closeDriver()
    {
        driver.quit();
    }
}
