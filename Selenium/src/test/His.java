package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class His {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://air.his-j.com/fb/shop/airfaresearch.htm?ln=en");
		driver.manage().window().maximize();

	}

}
