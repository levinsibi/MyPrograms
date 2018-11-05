package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import login.Login;
import login.SignIn;
import login.Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import customFunctions.CustomFunctions;




public class DataProviderTest {
	
	
	@BeforeTest
	public void startReport()
	{
		
	}
	@AfterTest
	public void endTest()
	{
	CustomFunctions.afterTest();
	}
	private static WebDriver driver=null;
	@Test(dataProvider = "dp")
	public void startTest( String TCname,String Tcstatus) throws Exception {
		
		
		
		Utility.SetTestName(TCname);
		CustomFunctions.launch();
		Login.enterUname();
		Login.enterPassword();
		Login.signIn();
		SignIn.verifyTitle();
		
		
		
	}	
	
	@DataProvider(name = "dp")
	public static Object[][] getTest() throws IOException {
		
		
		FileInputStream file = new FileInputStream(new File("D:\\dp.xlsx"));
		XSSFWorkbook workbook1 = new XSSFWorkbook(file);
		XSSFSheet sheet1=workbook1.getSheet("Sheet1");
		int i=0;
		int rows=sheet1.getPhysicalNumberOfRows();
		int cols=sheet1.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] dataset = new Object[rows][cols];
		
	    for (int rowCount = 0; rowCount < rows; rowCount++) {
	        for (int colCount = 0; colCount < cols; colCount++) {
	        	
	            //dataset[rowCount][colCount] = sheet1.getRow(rowCount).getCell(colCount).toString();
	            String status=sheet1.getRow(rowCount).getCell(1).toString();
	            System.out.println(status);
	            if(status.equalsIgnoreCase("Y"))
	            {
	            	
	            	 i++;
	            	 break;
	            	
	            	 
	            }
	            
	           
	        }
	    }
		System.out.println("row value"+i);
		Object[][] dataset2 = new Object[i][2];
		int k=0;
		rows=sheet1.getPhysicalNumberOfRows();
		cols=sheet1.getRow(0).getPhysicalNumberOfCells();
		for (int rowCount = 0; rowCount < rows; rowCount++) {
	        for (int colCount = 0; colCount < cols; colCount++) {
	        	
	            //dataset[rowCount][colCount] = sheet1.getRow(rowCount).getCell(colCount).toString();
	            String status=sheet1.getRow(rowCount).getCell(1).toString();
	            System.out.println(status);
	            if(status.equalsIgnoreCase("Y"))
	            {
	            	
	            	 
	            	
	            	 dataset2[k][0] = sheet1.getRow(rowCount).getCell(0).toString();
	            	 System.out.println("data set value"+dataset2[k][0].toString());
	            	 dataset2[k][1] = sheet1.getRow(rowCount).getCell(1).toString();
	            	 k++;
	            	 break;
	            }
	            
	           
	        }
	    }
		
		return dataset2;
	}
}
