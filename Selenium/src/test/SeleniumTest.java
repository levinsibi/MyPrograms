package test;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		try
		{
			driver=new FirefoxDriver();
		
		driver.get("http://toolsqa.com/mobile-automation/appium/install-android-sdk-adb-on-windows/");
		driver.manage().window().maximize();
		System.out.println("Tilte is"+driver.getTitle());
		//driver.quit();
		driver.findElement(By.xpath("/0/span[@class='menu-text']"));
		driver.findElement(By.xpath("//a[@class='submit text-disable']")).click();
		driver.findElement(By.xpath("//input[@name='s']")).sendKeys("467767");
		}
	catch(Exception ex){
		
	}
		
		finally
		{
			String str=JOptionPane.showInputDialog("you name please...........");
			System.out.println("result is "+str);
			
			if(str.equals("yes"))
			{
				
				driver.get("http://toolsqa.com/mobile-automation/appium/install-android-sdk-adb-on-windows/");
				driver.manage().window().maximize();
				System.out.println("Tilte is"+driver.getTitle());
				//driver.quit();
				driver.findElement(By.xpath("/0/span[@class='menu-text']"));
				driver.findElement(By.xpath("//a[@class='submit text-disable']")).click();
				driver.findElement(By.xpath("//input[@name='s']")).sendKeys("467767");
			}
		}
	}

}
