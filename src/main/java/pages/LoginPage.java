package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebdriverUtils;

public class LoginPage {

    WebDriver driver;
    WebdriverUtils webdriverUtils;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        webdriverUtils=new WebdriverUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@data-id='username']")
    WebElement usernameEdit;

    @FindBy(xpath = "//input[@data-id='password']")
    WebElement passwordEdit;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    public void login(String username,String password)
    {
        webdriverUtils.waitForElement(usernameEdit,"usernameEdit");
        usernameEdit.sendKeys(username);
        webdriverUtils.waitForElement(passwordEdit,"passwordEdit");
        passwordEdit.sendKeys(password);
        webdriverUtils.waitForElement(loginBtn,"loginBtn");
        loginBtn.click();
    }
}
