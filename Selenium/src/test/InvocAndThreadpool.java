package test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class InvocAndThreadpool {
	static int i=0;
  @Test(invocationCount=4,threadPoolSize=2)
  public void start() {
  
	  WebDriver driver=new FirefoxDriver();
	 

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("http://www.store.demoqa.com");

      driver.findElement(By.xpath(".//*[@id='account']/a")).click();

      driver.findElement(By.id("log")).sendKeys("test1");

      driver.findElement(By.id("pwd")).sendKeys("test2");

      driver.findElement(By.id("login")).click();
      
      System.out.println("Done msg"+i++);
      
  
  }
}
