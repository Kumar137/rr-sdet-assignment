package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebdriverUtils;

public class DrawPage {

    WebDriver driver;
    WebdriverUtils webdriverUtils;

    public DrawPage(WebDriver driver)
    {
        this.driver=driver;
        webdriverUtils=new WebdriverUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='Edit map']")
    WebElement editMapBtn;

    @FindBy(xpath = "//img[@alt='NODE icon not selected']")
    WebElement nodeBtn;

    @FindBy(xpath = "//canvas[1]")
    WebElement canvas;

    public void draw()
    {
        webdriverUtils.waitForElement(editMapBtn,"editMapBtn");
        editMapBtn.click();
        webdriverUtils.waitForElement(nodeBtn,"nodeBtn");
        nodeBtn.click();
        Actions act=new Actions(driver);
        act.clickAndHold(canvas).moveByOffset(30,10).click().build().perform();
        System.out.println(canvas.getSize());
        System.out.println(canvas.getLocation());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        act.clickAndHold(canvas).moveByOffset(50,15).click().build().perform();
    }


}
