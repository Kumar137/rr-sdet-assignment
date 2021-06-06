package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebdriverUtils;

import java.util.List;

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
        act.clickAndHold(canvas).moveByOffset(200,10).click().build().perform();
        System.out.println(canvas.getSize());
        System.out.println(canvas.getLocation());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        act.clickAndHold(canvas).moveByOffset(225,115).click().build().perform();
    }

    @FindBy(xpath = "//img[@alt='EDGE icon not selected']")
    WebElement edgeBtn;

    @FindBy(xpath = "//img[@alt='REGION icon not selected']")
    WebElement regionBtn;

    @FindBy(xpath="//input[@id='root_name']")
    WebElement nameTextbox;

    @FindBy(xpath = "//div[@class='ant-input-number-input-wrap']//input[@name='root_id']")
    WebElement xPosTextBox;

    @FindBy(xpath = "//div[@class='ant-input-number-input-wrap']//input[@name='root_pos_y']")
    WebElement yPosTextBox;

    @FindBy(xpath = "//span[text()='Save changes']")
    WebElement saveChangesBtn;

    @FindBy(xpath = "//span[text()='autobootstrap']")
    WebElement profileBtn;

    @FindBy(xpath = "//span[@aria-label='logout']")
    WebElement logoutBtn;

    @FindBy(xpath = "//a[@class='ant-notification--notice-close']/span/span/svg/path")
    WebElement popupCloseBtn;

    public void clickEdgeBtn()
    {
        webdriverUtils.waitForElement(edgeBtn,"edgeBtn");
        edgeBtn.click();
    }

    public void drawEdge(int xStart,int yStart,int xEnd,int yEnd)
    {

        Actions act=new Actions(driver);
        act.moveToElement(canvas,xStart,yStart).perform();
        act.clickAndHold(canvas).moveByOffset(xEnd,yEnd).click().build().perform();
    }

    public void clickRegionBtn()
    {
        webdriverUtils.waitForElement(regionBtn,"regionBtn");
        regionBtn.click();
    }

    public void drawRegion(int xStart,int yStart,int xEnd,int yEnd)
    {
        Actions act=new Actions(driver);
        act.moveToElement(canvas,xStart,yStart).perform();
        act.clickAndHold(canvas).moveByOffset(xEnd,yEnd).release().build().perform();

    }

    public void editCoordinates()
    {
        webdriverUtils.waitForElement(xPosTextBox,"xPosTextBox");
        long xCoordinate=Long.parseLong(xPosTextBox.getAttribute("value"))+1;
        System.out.print(yPosTextBox.getAttribute("value"));
        double yCoordinate= Double.parseDouble((yPosTextBox.getAttribute("value"))+1);
        Actions act=new Actions(driver);
        act.moveToElement(xPosTextBox).perform();
        act.sendKeys(xCoordinate+"");
        yPosTextBox.click();
        yPosTextBox.clear();
        yPosTextBox.sendKeys(yCoordinate+"");
    }

    public void saveChabnges()
    {
        try {
            webdriverUtils.waitForElement(saveChangesBtn, "saveChangesBtn");
            saveChangesBtn.click();
            Thread.sleep(2000);
            List<WebElement> lst=driver.findElements(By.xpath("//span[text()='Save changes'"));
            if(lst.size()>0)
            {
                System.out.print("Error in saving");
            }
            else{
                System.out.print("Saved");
            }
        }
        catch (Exception ex)
        {

        }

    }
    public void logout()
    {

        try {
            webdriverUtils.waitForElement(popupCloseBtn, "popupCloseBtn");
            popupCloseBtn.click();
            webdriverUtils.waitForElement(profileBtn, "profileBtn");
            Actions act = new Actions(driver);
            act.moveToElement(profileBtn).perform();
            webdriverUtils.waitForElement(logoutBtn, "logoutBtn");
            logoutBtn.click();
        }
        catch (Exception ex)
        {
            webdriverUtils.waitForElement(profileBtn, "profileBtn");
            Actions act = new Actions(driver);
            act.moveToElement(profileBtn).perform();
            webdriverUtils.waitForElement(logoutBtn, "logoutBtn");
            logoutBtn.click();
        }
    }



}
