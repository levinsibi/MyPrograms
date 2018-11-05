package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProvider2 {

	private static WebDriver driver;
	public static Object[][] dataset;
  
 

  // Here we are calling the Data Provider object with its Name
 
  @Test(dataProvider="DataProvider")
  public void test(Map<Object,Object>map) {

	  driver = new FirefoxDriver();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("http://www.store.demoqa.com");

      driver.findElement(By.xpath(".//*[@id='account']/a")).click();

      driver.findElement(By.id("log")).sendKeys(map.get("NAME").toString());

      driver.findElement(By.id("pwd")).sendKeys(map.get("LASTNAME").toString());

      driver.findElement(By.id("login")).click();




      driver.quit();

  }
  
  @DataProvider(name="DataProvider")
  public static Object[][] getContent() throws IOException{
	  

		FileInputStream file = new FileInputStream(new File("D:\\Example.xlsx"));
		XSSFWorkbook workbook1 = new XSSFWorkbook(file);
		XSSFSheet sheet1=workbook1.getSheet("Employee Data");
		
		
		
		int lastRowNum = sheet1.getLastRowNum() ;
	    int lastCellNum = sheet1.getRow(0).getLastCellNum();
		 dataset = new Object[lastRowNum][1];
	    for (int i = 0; i < lastRowNum; i++) {
	    	Map<Object, Object> datamap = new HashMap<>();
	        for (int j = 0; j < lastCellNum; j++) {
	        	datamap.put(sheet1.getRow(0).getCell(j).toString(), sheet1.getRow(i+1).getCell(j).toString());
	        }
	        dataset[i][0]=datamap;
	    }	
	    
		
		return dataset;
  
  }

}

