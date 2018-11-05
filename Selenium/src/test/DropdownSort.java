package test;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DropdownSort {

	private static WebDriver driver;

	static int i=0;
 

		
		public static void main(String[]args)
		{

		  
		  driver = new FirefoxDriver();

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      driver.get("http://newtours.demoaut.com/");

	

	      driver.findElement(By.xpath("//a[contains(.,'REGISTER')]")).click();
	    
	      
	      WebElement drp=driver.findElement(By.xpath("//select[@name='country']"));
	      Select s1=new Select(drp);
	      List<WebElement>options=s1.getOptions();
	      List<String>drpValues=new ArrayList<String>();
	      for(WebElement element:options)
	      {
	    	  drpValues.add(element.getText());
	    	  System.out.println(element.getText());
	      }
	     
	      List<String>sortedList=new ArrayList<String>();
	      sortedList.addAll(drpValues);
	      Collections.sort(sortedList);
	      if(sortedList.equals(drpValues))
	      {
	    	  System.out.println("is sorted");
	      }
	      else
	      {
	    	  System.out.println("Not sorted");
	      }
		}
	  }
  
 


