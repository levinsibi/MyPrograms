package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ColorVerification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		/*driver.get("https://www.linkedin.com/");
		String result=driver.findElement(By.id("registration-submit")).getCssValue("background-color");
		System.out.println("result color is "+result);*/
		
		driver.get("http://newtours.demoaut.com/");
		String result=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).getCssValue("text-decoration");
		System.out.println("result decor is "+result);
		
		
	}

}
