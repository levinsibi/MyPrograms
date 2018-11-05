package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumTestTest {

	WebDriver driver=null;
  @Test(invocationCount=4,threadPoolSize=2)
  public void main() {
	  
		
		driver.get("http://toolsqa.com/mobile-automation/appium/install-android-sdk-adb-on-windows/");
		driver.manage().window().maximize();
		System.out.println("Tilte is"+driver.getTitle());
		
		driver.findElement(By.xpath(".//*[@id='primary-menu']/li[1]/a/span[1]/span/span")).click();
    
  }
  @BeforeTest
  @Parameters("browser")
  public void Browser(String browser)
  {
	  if(browser=="Chrome")
	  {
		  System.setProperty("webdriver.chrome.driver","D:\\selenium\\Jars_SeleniumProject\\chromedriver.exe");
		  driver =new ChromeDriver();
	  }
	  else if(browser=="firefox")
	  {
		  driver =new FirefoxDriver();
	  }
  }
}
