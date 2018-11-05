package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;




public class PageFactorytest {

	@FindBy(how=How.NAME,using="uid")
	static WebElement uid;
	@FindBy(how=How.ID,using="btn")
	static WebElement btn;
	@FindBy(how=How.NAME,using="password")
	static WebElement password;
	@FindBy(how=How.XPATH,using="html/body/form/table/tbody/tr[3]/td[2]/input[1]")
	static WebElement login;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		PageFactory.initElements(driver, PageFactorytest.class);
		driver.get("http://demo.guru99.com/V4/");					
		uid.sendKeys("dsadad");					
		password.sendKeys("dsadad");	
		login.click();
		driver.quit();
		   		

	}

}
