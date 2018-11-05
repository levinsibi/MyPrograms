package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public  class Utility extends ExcelRead {

	
	public static WebDriver driver;
	public HashMap<String, String> parameters = new HashMap<String, String>();
	/**** Reporting ****/
	//public static String report_path = "D:\\Selenium_Reports\\";
	
	public static String report_path =System.getProperty("user.dir")+"\\reports\\";
	public static String time=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());;
	public static String html_report_path = report_path+ "HtmlReport\\ExtentReport"+time+".html";
	
	public static String excel_report_path = report_path + "ExcelReports\\";
	public static String snap_shot_path = report_path + "Snapshots\\";
	
	public static ExtentReports extent = new ExtentReports(html_report_path,	true);
	//public static ExtentReports extent = null;
		
	//public static ExtentTest test;
	public static ExtentTest test;
	Logger logger;
	//Snapshot index
	public int snapShotIndex=1;
	public static WiniumDriver windriver;
	//winium driver exe path
	
		public static String winium_driver_path="D:\\Framework_Jars\\Winium.Desktop.Driver.exe";
		
	
	//Flags
		public static boolean noRetryFlag=true;
	       
        //Set the Flag to true , if retry of failed cases is required 
        
        public static boolean retryExecutionFlag=false;

	
	
	 public static boolean passFlag=false;
	 
	
	//Messaging
		
		public static String message_format =System.getProperty("user.dir")+"\\messages\\formats\\";
		public static String message_files =System.getProperty("user.dir")+"\\messages\\files\\";
	
	
	
	/*******SIKULI********/
	public  String sikuli_images = "D:\\sikuli_images\\"+dataSheetName+"\\";
	
	
	 //dataSheet
	public static String dataSheetName;

	public String objectSheet = "Objectsheet";
	public String dataSheet = "Datasheet";
	public String expectedResult = "";
	
	/***** PROPERTY FILE ****/
	
	public String propertyFile="ApplnParameters.properties";
	
	/******COUNT OCCURENCES****/
	
	public static int countOccurances=0;
	
	
	public void waitTillOverlayDisappear(By locator, WebDriver driver) {
		try {
			(new WebDriverWait(driver, 30)).until(ExpectedConditions
					.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			// System.out.println("Object did not display");
		}
   
	}

	
	
	
  public static int countOccurence(String value,String exp)
  {
	try
	{
		if(countOccurances==0)
		{
			return 0;
		}
		else
		{
			return countOccurances;
		}
		
	}
	
	finally
	{
		countOccurances++;
	}
	  
	  
	 
  }
	

	public void sleep(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) {

		try {
			Thread.sleep(Integer.parseInt(parameter));
		}

		catch (Exception e) {

		}
	}
	public void sleep(int sleep)
	{try {
		Thread.sleep(sleep);
	}

	catch (Exception e) {

	}
		
	}

	public By getElement(String object) {

		try {

			/*By element=null;
			String locatorType=object.split(";")[0].toString();
			String locatorName=object.split(";")[1].toString();
			
			
			
			if(locatorType.contains("xpath"))
			{

				element=By.xpath(locatorName);
			}
			else if(locatorType.contains("name"))
			{
				element=By.name(locatorName);
			}
			else if(locatorType.contains("id"))
			{
				element=By.id(locatorName);
			}
			*//*****waitTillOverlayDisappear(element, driver);***//*
			waitTillOverlayDisappear(element, driver);

			return element;*/
			By element=null;
			String locatorType=null;
			String locatorName=null;
			boolean deskTopAppln=false;
			
			if(object.startsWith("win"))
			{
				deskTopAppln=true;
				 locatorType=object.split(";")[1].toString();
				 locatorName=object.split(";")[2].toString();	
			}
			
			else
			{
				 locatorType=object.split(";")[0].toString();
				 locatorName=object.split(";")[1].toString();	
			}
			
			
			//Finding the element
			if(locatorType.contains("xpath"))
			{

				element=By.xpath(locatorName);
			}
			else if(locatorType.contains("name"))
			{
				element=By.name(locatorName);
			}
			else if(locatorType.contains("id"))
			{
				element=By.id(locatorName);
			}
			/*****waitTillOverlayDisappear(element, driver);***/
			
			if(deskTopAppln==true)
			{
				System.out.println("ddddddddddddddddddddd"+element);
				waitTillOverlayDisappear(element, windriver);
			}
			else
			{
			waitTillOverlayDisappear(element, driver);
			}

			return element;
			
			
			
			
		}

		catch (Exception e) {
			return null;
		}
		
	     

	}

	public void select(String text) {

	}

	
	public WebDriver setUpBrowser(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) {
		
		
		if (parameter.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (parameter.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Framework_Jars\\chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver", "res/chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("user-data-dir=D:/temp/");
			capabilities.setCapability("chrome.binary","res/chromedriver.exe");
			capabilities.setCapability(ChromeOptions.CAPABILITY,options);
			 driver = new ChromeDriver(capabilities);
			

			
		}
	 else if (parameter.equalsIgnoreCase("Headless")) {
		 
		
		
		/* String[] cli_args = new String[]{ "--ignore-ssl-errors=true" };
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setJavascriptEnabled(true); // not really needed: JS enabled by default
		 caps.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
		 caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 caps.setCapability("browserType", "phantomjs");
		 caps.setCapability( PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args );
		 //caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D://path//phantomjs.exe");
		 File src=new File("D:\\path\\phantomjs.exe");
			System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
		 
		 caps.setCapability("takesScreenshot", true);
		driver = new PhantomJSDriver(caps);  */
		 
		 String[] cli_args = new String[]{ "--ignore-ssl-errors=true","--web-security=no", "--ignore-ssl-errors=yes"};
		
		 DesiredCapabilities caps = DesiredCapabilities.phantomjs();
		 caps.setCapability( PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args );
		 caps.setCapability( PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D://path//phantomjs.exe");
		 driver =  new PhantomJSDriver( caps );
		
		   
		/* File src=new File("D:\\path\\phantomjs.exe");
		System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
		driver=new PhantomJSDriver();*/

	}else {
			System.setProperty("webdriver.ie.driver",
					"D:\\Framework_Jars\\IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

			ieCapabilities.setCapability("nativeEvents", false);    
			ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			ieCapabilities.setCapability("disable-popup-blocking", false);
			ieCapabilities.setCapability("enablePersistentHover", true);
			ieCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
			ieCapabilities.setCapability(InternetExplorerDriver.
			  INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			ieCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			driver = new InternetExplorerDriver(ieCapabilities);
			
		
			
		}

		return driver;
	}




	public String captureScreenShot(String vp) throws IOException {
		
		String destination = snap_shot_path + vp + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File(destination);

		FileUtils.copyFile(source, dest);
		
		System.out.println("vp"+vp);
		String imagePath="..\\Snapshots\\"+ vp + ".png";

		//return destination;
		return imagePath;

	}
	
	/******** DATE FORMATTING*******/
	
	/*public enum dateFormats {currentDate,nextDate}
	public void createDateFormats(String condition,String dateFormat,String excelColumn,int rowVal) throws ParseException
	{
		
		
		
		
	
		switch (dateFormats.valueOf(condition)) {
		
		
	      
		case currentDate:
		
		
			Date date = new Date();

			DateFormat fmt = new SimpleDateFormat(dateFormat);

			String formattedDate = fmt.format(date);

			setCellValue(dataSheet,parameters.get("testcaseName"),rowVal, excelColumn,formattedDate);

			break;
		case nextDate:




		
			DateFormat fmt1 = new SimpleDateFormat(dateFormat.split(";")[0].toString());

			Calendar c = Calendar.getInstance();

			c.add(Calendar.DATE, Integer.parseInt(dateFormat.split(";")[1].toString()));  // number of days to add


			String formattedDate2  = fmt1.format(c.getTime());

			setCellValue(dataSheet,parameters.get("testcaseName"),rowVal, excelColumn,formattedDate2);

			break;

		}
	}
	*/
	
	
	
	
	public enum dateFormats {nextDate, dateFormat, convertDateFormat}
	public String createDateFormats(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws ParseException
	{
		
		//convertDateFormat,ddMMMYY,Date,
		
		//format=currentDate,ddMMMyyyyHHmmss
		System.out.println("Reached utility");
		
		String condition=parameter.split(",")[0].toString();
		String dateFormat=parameter.split(",")[1].toString();
		String dateFormat2;
		String excelColumn=parameter.split(",")[2].toString();
		String excelColumn2;
		//int rowVal=getRowIndex(String excelName,String sheetName,String rowValue)
		String formattedDate ="";
		DateFormat df;
		DateFormat df2;
		Calendar calobj;
		Date date;
		int rowVal=getRowIndex(dataSheet,dataSheetName , tcName);
		switch (dateFormats.valueOf(condition)) 
		{

			case dateFormat:

				 df= new SimpleDateFormat(dateFormat);
				 calobj = Calendar.getInstance();
				int addValue=Integer.parseInt(parameter.split(",")[3].split("=")[1].toString());
				if(parameter.contains("day"))
				{
					calobj.add(Calendar.DATE, addValue);
				}

				else if(parameter.contains("month"))
				{
					calobj.add(Calendar.MONTH, addValue); 
				}
				else if(parameter.contains("year"))
				{
					calobj.add(Calendar.YEAR, addValue); 
				}
				formattedDate = df.format(calobj.getTime()).toString()
						.trim();           




				if(excelColumn.length()>0)
					setCellValue(dataSheet,dataSheetName,rowVal, excelColumn,formattedDate);

			break;
			case convertDateFormat:
				if(!excelColumn.contains("value"))
				{
					excelColumn=getCellValue(dataSheet, dataSheetName,
							tcName, excelColumn);
				}
				else if(parameter.contains("value"))
				{
					excelColumn=parameter.split("=")[1].toString();
				}
				
				 df = new SimpleDateFormat(dateFormat);
				 dateFormat2=parameter.split(",")[4].toString();
				 excelColumn2=parameter.split(",")[3].toString();
				 df2=new SimpleDateFormat(dateFormat2);
				 date=df.parse(excelColumn);
				 formattedDate= df2.format(date);
				 System.out.println("New Formatted Date is: "+formattedDate);
				 setCellValue(dataSheet,dataSheetName,rowVal, excelColumn2,formattedDate);
				

			break;
		default:
			break;


		}
		return formattedDate;
	}

/****PROPERTY FILE READING*****/
	
	
	
    public String readData(String propValue) {
        
	String s2 = System.getProperty("user.dir");
	
	 String filePath = s2 +"\\applnproperties\\"+ propertyFile; 
        
      
                     
        try {
               File file = new File(filePath);
               FileInputStream fileInput = new FileInputStream(file);
               Properties properties = new Properties();
               properties.load(fileInput);
               
               fileInput.close();

               String sPropVal = properties.getProperty(propValue);
        
               
               return sPropVal;
               }
        catch (FileNotFoundException e) {
               e.printStackTrace();
               return "";
               
        } catch (IOException e) {
               e.printStackTrace();
               return "";
               
        }
 }
    
    /****WRITING TO PROPERTY FILE****/
     
    
public boolean writeData(String valToStore, String propValue) {
        
        
        
	String s2 = System.getProperty("user.dir");
	
	 String filePath = s2 +"\\applnproperties\\"+ propertyFile; 
                     
        try {
               File file = new File(filePath);
               FileInputStream fileInput = new FileInputStream(file);
               Properties properties = new Properties();
               properties.load(fileInput);
               fileInput.close();
               properties.setProperty(propValue, valToStore);
         
        
       
         File f = new File(filePath);
         OutputStream out = new FileOutputStream( f );
         properties.store(out, "Details");
         return true;
     }
     catch (Exception e ) {
         e.printStackTrace();
         return false;
     }
 }
/*****SET UP EXTENT REPORT****/	
public void setUpReport(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap)
{
	
	test =extent.startTest(tcName, parameter);
	
}
/*****CLOSE EXTENT REPORT****/	
public void closeReport(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap)
{
	

	extent.endTest(test);
	   
	 extent.flush();
	
}

/*****EXTENT REPORT*****/

	
	public void extentReports(String status, String filePath,
			String expectedResult, String actualResult, String info,String testCase) {
		
		
		
		if (status.equalsIgnoreCase("Pass")) {
			
		
			
			test.log(LogStatus.PASS,  expectedResult);
			
		}
		else if (status.equalsIgnoreCase("Info")) {
			
			
			
			test.log(LogStatus.INFO,  "Test data :" +info);
			
		}
		 else if (status.equalsIgnoreCase("Info_withimage")) {
				
      	 
      	   test.log(LogStatus.INFO,test.addScreenCapture(filePath));
			
		}

		else {
			parameters.put("testcaseStatus", "FAIL");
			
			test.log(LogStatus.FAIL, expectedResult);
			test.log(LogStatus.INFO, "Actual Result is "+actualResult);
			
			if(!filePath.equals(""))
			{
			
			test.log(LogStatus.INFO,test.addScreenCapture(filePath));
			
			snapShotIndex=snapShotIndex+1;
			}
					
			extent.endTest(test);
			   
		 extent.flush();
		}
	}
	
	 public WiniumDriver setUpApplication(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException {
			
			
			
	    	DesktopOptions options = new DesktopOptions();
		    options.setApplicationPath(parameter.split("=")[1].toString());
	    	
		    String WiniumEXEpath = winium_driver_path;
		    File file = new File(WiniumEXEpath);
		    if (! file.exists()) {
		        throw new IllegalArgumentException("The file " + WiniumEXEpath + " does not exist");
		    }
		    Runtime.getRuntime().exec(file.getAbsolutePath());
		    try {
		        windriver = new WiniumDriver(new URL("http://localhost:9999"),options);
		    } catch (MalformedURLException e) {
		        e.printStackTrace();
		    }
		    System.out.println("winnnnnnn"+windriver);
		    return windriver;
	    }
	 public boolean createTextMessage(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException {
         String messageType="";
         String messageSubType="";
         String values="";
         try {
                
                
                
                
                
                //Excel
                messageType=parameter.split(";")[0].toString();
                
                //Sheet name
                messageSubType=parameter.split(";")[1].toString();
                values="";
                
                if(parameter.split(";").length>2)
                {
                      values=parameter.split(";")[2].toString();
                }
                
                
         //creating the text file
                
                String filePath=createFile(messageSubType,".txt");
                
                
                /**** EXCEL OPS***/
                InputStream inp = null;
                XSSFWorkbook wb = null;
        

          int rowIndex = 0;
        
          Row row =null;
        
          String value="";
                
          try {
                      
                
                      String path = message_format+messageType+".xlsx";
                      inp = new FileInputStream(path);
                } catch (FileNotFoundException e) {

                      e.printStackTrace();
                }
          try {
                      wb = new XSSFWorkbook(inp);
                } catch (IOException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
                }
                
          Sheet sheet = wb.getSheet(messageSubType);
          
       
                  Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()) {
                row = rows.next();


                for (Cell cell : row) {
                  row = sheet.getRow(rowIndex);
                  cell = row.getCell(0, Row.CREATE_NULL_AS_BLANK);
                   value=cell.toString();
                  
                   
                  
                   if(value.contains("<"))
                   {
                         
                          String valuee="";
                         
                          for(int j=0;j<value.length();j++)
                          {
                               String val="";
                               
                                if ( value.charAt(j) =='<')
                                {
                                       while(value.charAt(j+1) !='>')
                                       {
                                              val=val+value.charAt(j+1);
                                              j=j+1;
                                              
                                            
                                       }
                                       
                                     
                                       
                                       
                                       //Getting the awb value...
                                       
                                       for(int k=0;k<values.split(",").length;k++)
                                       {
                                              if(values.split(",")[k].toString().contains(val))
                                              {
                                                     val=values.split(",")[k].toString().split("=")[1].toString();
                                                     
                                                     if(val.contains("'"))
                                                     {
                                                            
                                                            val=val.split("'")[1].toString();
                                                            
                                                            if(val.equals("null"))
                                                            {
                                                                   val="";
                                                            }
                                                           
                                                     }
                                                     
                                                     else
                                                     {
                                                            val=getCellValue(dataSheet, dataSheetName,tcName, val);  
                                           
                                                     }
                                              }
                                       }
                                       
                                       
                                       valuee=valuee+val; 
                                      
                                }
                                
                                
                                else
                                {
                                       if(value.charAt(j)!='>')
                                       {
                                              valuee=valuee+value.charAt(j);
                                             
                                       }
                                       
                                       
                                     
                                }
                              
                          }
                          
                         
                          
                         value=valuee;
                   }
                   
                   
                   
                   
                   
                   
                   
                   
                   
                
                  frameMessage(filePath,value);
                  rowIndex++;
           
                       }
                
               
                 }
                
                  
                 
                       
               
        

                
         
                if(hmap.get("toReport").equals("Y"))
                {
                
                extentReports("Pass", "", "", "Message created for type '"+messageType+"' and the subtype '"+messageSubType+"'", "",tcName);
                }
                
                passFlag=true;
                
                 
                return true;
         }

         catch (Exception e) {
                System.out.println("Message is not created for Type : " + object);
                
         
                extentReports("Fail","", "", "Message created for type '"+messageType+"' and the subtype '"+messageSubType+"'", "",tcName);
                passFlag=false;
                return false;
         }
  }
  

	 public void frameMessage(String filePath,String msg)
     {
            String fileName = filePath;
                PrintWriter printWriter = null;
                File file = new File(fileName);
                try {
                  
                    printWriter = new PrintWriter(new FileOutputStream(fileName, true));
                    printWriter.write(msg+System.getProperty("line.separator"));
                } catch (IOException ioex) {
                    ioex.printStackTrace();
                } finally {
                    if (printWriter != null) {
                        printWriter.flush();
                        printWriter.close();
                    }
                }
            }
     
	 public String createFile(String messageType,String fileType) throws IOException
     {
            String filePath=message_files+messageType+fileType;
            File file = new File(filePath);
            
             if(file.exists())
            {
                   file.delete();
            }
            
             file.createNewFile();
            
             return filePath;
     }

	 public boolean setCustomReports(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException, ParseException {
         
         try
         {
                
         String status=parameter.split(",")[0].toString();
         String actualResult=parameter.split(",")[1].split("'")[1].toString();
         String dateFormat=createDateFormats("","","","dateFormat,ddMMMyyyyHHmmss,,day=0",tcName,hmap);
         
         
         
         if (status.equalsIgnoreCase("Pass")) {
                
         
                
                test.log(LogStatus.PASS,  actualResult);
                
         }
         else if (status.equalsIgnoreCase("Info")) {
                
                
                
                test.log(LogStatus.INFO,  "Test data :" +actualResult);
                
         }
         else if (status.equalsIgnoreCase("Info_withimage")) {
                      
                String filePath=captureScreenShot(tcName+"_"+dateFormat);
    test.log(LogStatus.INFO,test.addScreenCapture(filePath));
                
         }

         else {
             String filePath="";
             try
             {
             filePath=captureScreenShot(tcName+"_"+dateFormat);
             }
             
             catch(Exception e)
             {
                   
             }
             
             
             
             test.log(LogStatus.FAIL, actualResult);
             
             if(!filePath.equals(""))
             {
             test.log(LogStatus.INFO,test.addScreenCapture(filePath));
             }
             

                
         

         }
         passFlag=true;
         return true;
         
         
         }
         
         catch(Exception e)
         {
                passFlag=false;
                return false;
         }
  }     


}