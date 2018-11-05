package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sun.xml.internal.fastinfoset.algorithm.IntEncodingAlgorithm;

public class Cargo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*System.setProperty("webdriver.ie.driver",
				"D:\\Framework_Jars\\IEDriverServer.exe");*/
		/*DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

		ieCapabilities.setCapability("nativeEvents", false);    
		ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
		ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
		ieCapabilities.setCapability("disable-popup-blocking", true);
		ieCapabilities.setCapability("enablePersistentHover", true);

		//WebDriver driver= new InternetExplorerDriver(ieCapabilities);
		*/
		WebDriver driver= new FirefoxDriver();
		driver.get("https://icargo-lap.lcag.fra.dlh.de/icargo");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='Ecom_User_ID']")).clear();
		driver.findElement(By.xpath("//input[@name='Ecom_User_ID']")).sendKeys("U134171");
		driver.findElement(By.xpath("//input[@name='Ecom_Password']")).clear();
		driver.findElement(By.xpath("//input[@name='Ecom_Password']")).sendKeys("Lh123477");
		driver.findElement(By.xpath("//input[@id='de_login']")).click();
		for(String winHandle : driver.getWindowHandles()){
	        driver=driver.switchTo().window(winHandle);
	        System.out.println(winHandle);
	      }
		
		/*driver.findElement(By.xpath(".//*[@id='flightNumber_flightNo']")).click();
		driver.findElement(By.xpath(".//*[@id='flightNumber_flightNo']")).sendKeys("456");*/
		driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/form/div/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/form/div/div/input")).sendKeys("FLT005");
		
			}

}
