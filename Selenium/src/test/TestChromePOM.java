package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class TestChromePOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		
		PageFactory.initElements(driver, ChromePOM.class);
		
		ChromePOM pom=new ChromePOM();
		pom.start(driver);
		
		
		
	}

}
