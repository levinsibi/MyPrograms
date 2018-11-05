package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ChromePOM {
	
	static WebDriver driver;
	 @FindBy(how=How.ID,using= "trigger1")
	    
	    public static WebElement eservices;

	public  void start(WebDriver driver)
	
	{
		
		System.out.println("Entered eservices");
    	
    	driver.get("https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/web/guest/home");
    	driver.manage().window().maximize();
        eservices.click();
        System.out.println("After click");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		driver=new FirefoxDriver();
		
		
		
		//ChromePOM pom=new ChromePOM(driver);
		
		
	}

}