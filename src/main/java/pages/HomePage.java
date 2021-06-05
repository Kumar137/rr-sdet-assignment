package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebdriverUtils;

public class HomePage {

    WebDriver driver;
    WebdriverUtils webdriverUtils;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        webdriverUtils=new WebdriverUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//img[@alt='rapyuta robotics logo']")
    WebElement homepageLogo;

    @FindBy(xpath = "//img[@alt='settings icon not selected']")
    WebElement settingIcon;

    @FindBy(xpath="//div[text()='Maps']")
    WebElement mapTab;

    @FindBy(xpath = "//div[@class='rramr-list-card__footer']/button[2]")
    WebElement startBtn;

    public void validatePage()
    {
        webdriverUtils.waitForElement(homepageLogo,"homepageLogo");
    }
    public void clickSettingIcon()
    {
        webdriverUtils.waitForElement(settingIcon,"settingIcon");
        settingIcon.click();
    }

    public void switchMapTab()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webdriverUtils.waitForElement(mapTab,"mapTab");
        mapTab.click();
    }

    public void clickstartBtn()
    {
        webdriverUtils.waitForElement(startBtn,"startBtn");
        startBtn.click();
    }

}
