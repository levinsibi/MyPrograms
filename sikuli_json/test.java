package sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "D:\\selenium\\Jars_SeleniumProject\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	     	        driver.get("http://google.com");
	     	        
	    WebElement img1=driver.findElement(By.xpath(".//*[@id='hplogo']/a/img"));
	    
	    Boolean ans=img1.isDisplayed();
	    if(ans)
	    {
	    	System.out.println("Present");
	    }
	    else
	    {
	    	System.out.println("Not present");
	    }
	}

}
