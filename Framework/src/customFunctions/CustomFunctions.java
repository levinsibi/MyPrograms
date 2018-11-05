package customFunctions;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;




import java.text.DecimalFormat;
import java.util.Iterator;




















import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import login.Utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class CustomFunctions extends Utility{
	

	public static String report_path="D:\\Selenium_Reports\\";
	public static String html_report_path=report_path+"HtmlReport\\Results.html";
	public static String snap_shot_path=report_path+"Snapshots\\"+Utility.tcname+".PNG";
	//public static ExtentReports extent=new ExtentReports(html_report_path);
	public static ExtentReports extent=new ExtentReports(html_report_path, true);
	public static ExtentTest test;
	
	
	//public static ExtentTest test;
	
	
	
	public static String getCellvalue(String filename,String SheetName,String Row,String Column) throws IOException
	{
		int columnIndex=-1;
		int rowindex=0;
		int f=0;
		FileInputStream fis=new FileInputStream(new File(filename));
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(SheetName);
		Iterator<Row>rows=sheet.rowIterator();
		while(rows.hasNext())
		{
			Row row=rows.next();
			for (Cell cell : row) {

                if (String.valueOf(getCellValue(cell)).equals(Column)) {

                       columnIndex = cell.getColumnIndex();
                       
                       f=1;
                       break;
                }
			}
			if(f==1)
				break;
		}
		
		rows=sheet.rowIterator();
		while(rows.hasNext())
		{
			f=0;
			Row row=rows.next();
			for (Cell cell : row) {

                if (String.valueOf(getCellValue(cell)).equals(Row)) {

                       
                       rowindex=row.getRowNum();
                       f=1;
                       break;
                }
			}
			if(f==1)
				break;
		}
		
		
		String str=sheet.getRow(rowindex).getCell(columnIndex).toString();
		System.out.println(str);
		return str;
		
	}
		private static Object getCellValue(Cell cell){
		     XSSFCell hssfCell = (XSSFCell) cell;
		     if (XSSFCell.CELL_TYPE_NUMERIC == hssfCell.getCellType()) {
		            return hssfCell.getNumericCellValue();}
		            else if (XSSFCell.CELL_TYPE_NUMERIC == hssfCell.getCellType()) {
		            DecimalFormat df = new DecimalFormat("#.000000000");
		            String numeric = df.format(cell.getNumericCellValue());
		            numeric = numeric + "";
		            String[] strArray = (numeric.replace(".", "-")).split("-");
		            if(strArray.length > 1 ){
		                  if((strArray[1].replace("0", "")).trim().length() == 0 ){
		                         numeric =  strArray[0];
		                  }                          
		            }
		            return numeric;

		     } else if (XSSFCell.CELL_TYPE_STRING == hssfCell.getCellType()) {
		            return hssfCell.getStringCellValue();
		     } else if (XSSFCell.CELL_TYPE_NUMERIC == hssfCell.getCellType()) {
		            return hssfCell.getNumericCellValue();
		     }else if (XSSFCell.CELL_TYPE_BOOLEAN == hssfCell.getCellType()) {
		            return hssfCell.getBooleanCellValue();
		     } else if (XSSFCell.CELL_TYPE_BLANK == hssfCell.getCellType()) {
		            return "";
		     } 
		     return "";
		}
		
		public static By getLocator(String ElementName) throws Exception {
		    //Read value using the logical name as Key
		    String locator = ElementName;
		    System.out.println(ElementName);
		    //Split the value which contains locator type and locator value
		    String locatorType = locator.split(":")[0];
		    String locatorValue = locator.split(":")[1];
		    //Return a instance of By class based on type of locator
		      if(locatorType.toLowerCase().equals("id"))
		            return By.id(locatorValue);
		      else if(locatorType.toLowerCase().equals("name"))
		            return By.name(locatorValue);
		      else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
		            return By.className(locatorValue);
		      else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
		            return By.className(locatorValue);
		      else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
		            return By.linkText(locatorValue);
		      else if(locatorType.toLowerCase().equals("partiallinktext"))
		            return By.partialLinkText(locatorValue);
		      else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
		            return By.cssSelector(locatorValue);
		      else if(locatorType.toLowerCase().equals("xpath"))
		            return By.xpath(locatorValue);
		      else
		              throw new Exception("Locator type '" + locatorType + "' not defined!!");
		    }
		
		public static void enterText(By locator,String Data)
		{
			try {
				
				
				//waitTillOverlayDisappear(element, driver);
				waitTillDisplay(driver,locator);

				driver.findElement(locator).sendKeys(Data);
			}

			catch (Exception e) {
				System.out.println("Text is not entered for xpath : " );
			}
			
		}
		public static void setup()
		{
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		public static void launch()
		{
			
			
			driver.get("http://newtours.demoaut.com/");
			driver.manage().window().maximize();
		}
		public static void click(By locator)
		{
			try {
				
				
				//waitTillOverlayDisappear(element, driver);
				waitTillDisplay(driver,locator);

				driver.findElement(locator).click();
			}

			catch (Exception e) {
				System.out.println("Text is not entered for xpath : " );
			}
			
		}
		public static void waitTillDisplay(WebDriver driver,By locator)
		{
			WebDriverWait wait =new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		public static String getTitle()
		{
			return driver.getTitle();
		}
		
		public static void createReport(String expResult,String actualResult,String Tcname) throws AWTException, IOException
		{
			
			
			 test=extent.startTest(Utility.tcname, "TestSteps");
			 
			
			if(actualResult.equalsIgnoreCase(expResult)) {
				 test.log(LogStatus.INFO,Tcname );
		         test.log(LogStatus.INFO, "Expected Result : "+expResult);
		         test.log(LogStatus.PASS, "Actual Result : "+actualResult);
			}
			else{
				
				 Robot robot=new Robot();
				 Rectangle rectangle=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				 BufferedImage BI=robot.createScreenCapture(rectangle);
				 ImageIO.write(BI, "PNG", new File("D:\\Selenium_Reports\\Snapshots\\"+Tcname+".PNG"));
				 test.log(LogStatus.INFO, Tcname);
		         test.log(LogStatus.INFO, "Expected Result : "+expResult);
		         test.log(LogStatus.FAIL, "Actual Result : "+actualResult);
		         test.log(LogStatus.INFO, "Failure Snapshot : " +                test.addScreenCapture(snap_shot_path));
		        
			}
			 
		}
		public static void afterTest()
		{
			/*if individual reports are needed ,place this code inside createreoprt 
			method and place extent objects as local.*/
			
			/*if multiple results are neded in reports place this code here and inside createreoprt 
			method and place extent objects test as local.*/
			extent.endTest(test);
			extent.flush();
			driver.close();
			driver.quit();
		}
		
		
}
