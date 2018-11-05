package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProvider1 {

	private static WebDriver driver;

	static int i=0;
 

  // Here we are calling the Data Provider object with its Name
 
  /*@Test(dataProvider="DataProvider")
  public void test(String Username, String Password,String msg) {

	  System.out.println(System.getProperty("user.dir"));
	  driver = new FirefoxDriver();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("http://www.store.demoqa.com");

      driver.findElement(By.xpath(".//*[@id='account']/a")).click();

      driver.findElement(By.id("log")).sendKeys(Username);

      driver.findElement(By.id("pwd")).sendKeys(Password);

      driver.findElement(By.id("login")).click();
      
      System.out.println("Done msg"+msg);

      //driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

      driver.quit();

  }*/
	@Test(dataProvider="DataProvider")
	  public void test(Object[][]data) {
		
		

		  System.out.println(System.getProperty("user.dir"));
		  driver = new FirefoxDriver();

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      driver.get("http://www.store.demoqa.com");

	      driver.findElement(By.xpath(".//*[@id='account']/a")).click();

	      driver.findElement(By.id("log")).sendKeys(data[i][0].toString());

	      driver.findElement(By.id("pwd")).sendKeys(data[i][1].toString());

	      driver.findElement(By.id("login")).click();
	      
	      System.out.println("Done msg"+data[i][2].toString());

	      i++;
	      //driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

	      driver.quit();

	  }
  
  @DataProvider(name="DataProvider")
  public static Object[][] getContent() throws IOException{
	  

		FileInputStream file = new FileInputStream(new File("D:\\Example.xlsx"));
		XSSFWorkbook workbook1 = new XSSFWorkbook(file);
		XSSFSheet sheet1=workbook1.getSheet("Employee Data");
		
		int rows=sheet1.getPhysicalNumberOfRows();
		int cols=sheet1.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] dataset = new Object[rows-1][cols];
	    for (int rowCount = 1; rowCount < rows; rowCount++) {
	        for (int colCount = 0; colCount < cols; colCount++) {
	            dataset[rowCount-1][colCount] = sheet1.getRow(rowCount).getCell(colCount).toString();
	        }
	    }
		
		return dataset;
  
  }

}

