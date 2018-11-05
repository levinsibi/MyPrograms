package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoItExample {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
					
		System.setProperty("webdriver.chrome.driver",
				"D:\\selenium\\Jars_SeleniumProject\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();	
			
		    driver.get("https://www.freepdfconvert.com/");			
		    			
		    Thread.sleep(1000);
		    driver.findElement(By.xpath(".//*[@id='clientUpload']")).click();	
		    // below line execute the AutoIT script .
		     Runtime.getRuntime().exec("D:\\FileUpload.exe");		
		    

}
}