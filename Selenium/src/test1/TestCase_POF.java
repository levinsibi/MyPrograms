
package test1;
		

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

import org.openqa.selenium.support.PageFactory;

public class TestCase_POF {

	 static WebDriver driver;

	 @FindBy(how = How.XPATH, using = ".//*[@id='account']/a")

	 static WebElement lnk_MyAccount;

	 @FindBy(how = How.ID, using = "log")

	 static WebElement txtbx_UserName;

	 @FindBy(how = How.ID, using = "pwd")

	 static WebElement txtbx_Password;

	 @FindBy(how = How.NAME, using = "submit")

	 static WebElement btn_Login ;

	 @FindBy(how = How.XPATH, using = ".//*[@id='account_logout']/a")

	 static WebElement lnk_LogOut;
	 
	 @FindBy(how= How.XPATH,using="//a[@href='http://store.demoqa.com/']")
	 static WebElement home;

	public static void main(String[] args) throws InterruptedException{

	    driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.store.demoqa.com");

        PageFactory.initElements(driver, TestCase_POF.class);

        lnk_MyAccount.click();

        txtbx_UserName.sendKeys("testuser_1");

        txtbx_Password.sendKeys("Test@123");

        btn_Login.click();

        home.click();

        driver.quit();

	}

}