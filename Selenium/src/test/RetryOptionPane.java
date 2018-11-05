package test;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RetryOptionPane {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=null;
		try
		{
			 driver=new FirefoxDriver();
			 driver.get("https://portal2.bsnl.in/myportal/quickrecharge.do");
			 //driver.findElement(By.xpath("//input[@id='phoneno']")).sendKeys("654644");
		}
		catch(Exception ex)
		{
			
		}
		finally
		{

			String str11=JOptionPane.showInputDialog(" retry????...........");
			System.out.println("result is "+str11);
			
			if(str11.equals("yes"))
			{
				
				driver.get("https://portal2.bsnl.in/myportal/quickrecharge.do");
				Thread.sleep(15000);
				driver.findElement(By.xpath("//a[contains(.,' Prepaid Landline')]")).click();
				driver.findElement(By.xpath("//a[contains(.,' CDMA Prepaid Recharge')]")).click();
				driver.findElement(By.xpath("//a[contains(.,' Mobile Re-Verification New')]")).click();
			}
		}
	}

}
