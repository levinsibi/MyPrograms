package common;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(common.TestNGListerner.class)	


public class WebFunctions extends Utility {


	CreateDynamicSuit cds=new CreateDynamicSuit();
	static Set<Cookie> cookies;


	@Test
	public boolean enterText(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException {

		try {



			logger=Logger.getLogger(tcName);

			//Finding the object

			String sheet=object.split(";")[0].split("=")[1].toString();
			String objectName=object.split(";")[1].toString().split("=")[1].toString();
			object=object.split(";")[1].toString().split("=")[1].toString();



			object=getCellValue(objectSheet, sheet,object, "Properties");



			/****By element = By.xpath(object);****/

			By element =getElement(object);






			//Finding the parameter

			if(!parameter.contains("value"))
			{
				try
				{
				parameter=getCellValue(dataSheet, dataSheetName,
						tcName, parameter);
				}
				catch(Exception e)
				{
					logger.error("Failed to Find Expected Column "+parameter+"in DataSheet");
					passFlag=false;
					Assert.fail("Exception Thrown");
				}
			}
			else if(parameter.contains("value"))
			{
				parameter=parameter.split("=")[1].toString();
			}


			clearText( object);
			driver.findElement(element).sendKeys(parameter);

			if(hmap.get("toReport").equals("Y"))
			{

				extentReports("Pass", "", "Text '"+parameter+"' entered for object '"+objectName+"'", "", "",tcName);
			}

			passFlag=true;

			logger.info("Entered text for object "+objectName +" with property "+object);
			return true;
		}

		catch (Exception e) {
			System.out.println("Text is not entered for object : " + object);


			String dest=captureScreenShot(tcName+"_"+snapShotIndex);
			extentReports("Fail",dest,  "Text '"+parameter+"' not entered for object '"+object+"'","", "",tcName);
			logger.error("Failed to Enter text for object "+object);
			passFlag=false;
			return false;
		}
	}

	public void switchToFrame(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws InterruptedException
	{



		String sheet=object.split(";")[0].split("=")[1].toString();
		object=object.split(";")[1].toString().split("=")[1].toString();



		object=getCellValue(objectSheet, sheet,object, "Properties");

		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		String currentFrame = (String) jsExecutor.executeScript("return self.name");

		Thread.sleep(5000);
		By element =getElement(object);
		driver.switchTo().frame(driver.findElement(element));
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor)driver;
		currentFrame = (String) jsExecutor1.executeScript("return self.name");
	}
	public enum Cookieops{Get,Add};
	public static void ManageCookies(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws InterruptedException
	{

		 
		switch(Cookieops.valueOf(parameter))
		{
		case Get:cookies=driver.manage().getCookies();break;
		case Add:
			for(Cookie a:cookies){  
            driver.manage().addCookie(a);}break;
        }
		
		
	}
	
		

	public enum Browserops{Refresh,Backwarkd};
	public void browserOperations(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws InterruptedException
	{
		//System.out.println("before  "+driver.getTitle());


		switch(Browserops.valueOf(parameter))
		{
		case Refresh:driver.navigate().refresh();break;
		case Backwarkd:driver.navigate().back();break;
		}


		



	}
	public boolean enterScreenId(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws AWTException, IOException
	{

		try
		{
			System.out.println("before  "+driver.getTitle());
			driver.close();
			for(String winHandle : driver.getWindowHandles()){
				this.driver=driver.switchTo().window(winHandle);
				System.out.println(winHandle);
			}



			//enterText(xpath,value); 
			enterText( object, onPass, onFail, parameter, tcName,hmap);
			//keyPress("ENTER");
			// passFlag=true;

			passFlag=false;
			return true;
		}

		catch(Exception e)
		{
			passFlag=false;
			return false;
		}
	}


	public boolean switchToFrame(String object) {

		try {
			By element =getElement(object);
			if(object.contains("default"))
			{
				driver.switchTo().defaultContent();
			}
			else
			{
				driver.switchTo().frame(driver.findElement(element));
			}
			passFlag=true;
			return true;

		}

		catch (Exception e) {

			passFlag=false;
			return false;
		}
	}
	/*public enum selectList {Value,Index}
	public void selectItem(String object, String text,String selectBy) {

		try {

			By element =getElement(object);

			Select s1=new Select(driver.findElement(element));
			switch(selectList.valueOf(selectBy))
			{
			case Value:s1.selectByValue(text);break;
			case Index:s1.selectByIndex(Integer.parseInt(text));break;
			}
			System.out.println("success");
		}

		catch (Exception e) {
			System.out.println("Text is not selected for xpath : " + object.split(";")[1].toString());
		}
	}*/

	public enum selectList {Value,Index,Text}
	public void selectItem(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) {

		try {
			logger=Logger.getLogger(tcName);

			String sheet=object.split(";")[0].split("=")[1].toString();
			String objectName=object.split(";")[1].toString().split("=")[1].toString();
			object=object.split(";")[1].toString().split("=")[1].toString();

			String dest;

			object=getCellValue(objectSheet, sheet,object, "Properties");

			By element =getElement(object);

			String selectBy=parameter.split(",")[1].toString();
			//Finding the parameter

			String p1=parameter.split(",")[0].toString();
			if(!p1.contains("value"))
			{
				try
				{
				parameter=getCellValue(dataSheet, dataSheetName,
						tcName, p1);
				}
				catch(Exception e)
				{
					logger.error("Failed to Find Expected Column "+p1+"in DataSheet");
					passFlag=false;
					Assert.fail("Exception Thrown");
				}
			}
			else if(p1.contains("value"))
			{
				parameter=p1.split("=")[1].toString();
			}

			Select s1=new Select(driver.findElement(element));
			switch(selectList.valueOf(selectBy))
			{
			case Value:s1.selectByValue(parameter);break;
			case Index:s1.selectByIndex(Integer.parseInt(parameter));break;
			case Text:s1.selectByVisibleText(parameter);;break;
			}
			System.out.println("success");
			logger.info("Selected element for object "+ objectName+" by"+selectBy);
			if(hmap.get("toReport").equals("Y"))
			{

				extentReports("Pass", "", "Selected '"+parameter+"'  for  '"+objectName+"'","",  "",tcName);
			}

			passFlag=true;
		}



		catch (Exception e) {
			System.out.println("Text is not selected for object : " + object.split(";")[1].toString());
			logger.error("Not able to Select element for object "+ object);
			Assert.fail("Exception Thrown");

		}
	}




	public void clearText(String object) {

		try {

			By element = getElement(object);


			driver.findElement(element).clear();
		}

		catch (Exception e) {

		}
	}
	public enum propertyLists {Enabled,Disabled, Text,Text2,TableCell,TableValues, SelectedItem, Value,Title, Existence,IsSelected, IsDisplayed}
	public void verifyObjProperty(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException {

		try {

			logger=Logger.getLogger(tcName);
			String sheet=object.split(";")[0].split("=")[1].toString();
			String objectName=object.split(";")[1].toString().split("=")[1].toString();
			object=object.split(";")[1].toString().split("=")[1].toString();
			boolean containsFlag=false;				
			object=getCellValue(objectSheet, sheet,object, "Properties");

			String info=parameter.split(",")[1].toString();
			String p1=parameter.split(",")[0].toString();
			boolean Result = false;
			String expectedResult="";
			String actualResult="";
			if(!info.contains("value"))
			{
				if(info.contains("<<"))
				{
					containsFlag=true;
					info=info.split("<<")[1].split(">>")[0]       .toString();
				}
				try
				{
				info=getCellValue(dataSheet, dataSheetName,
						tcName, info);
				}
				catch(Exception e)
				{
					logger.error("Failed to Find Expected Column "+info+"in DataSheet");
					passFlag=false;
					Assert.fail("Exception Thrown");
				}
			}
			else if(info.contains("value"))
			{

				info=info.split("=")[1].toString();
				if(info.contains("<<"))
				{
					containsFlag=true;
					info=info.split("<<")[1].split(">>")[0]       .toString();

				}
			}


			By element =getElement(object);
			waitTillOverlayDisappear(element, driver);
			switch (propertyLists.valueOf(p1))
			{

			case Enabled:
				expectedResult="The locator  with property "+element+" should be Enabled";

				boolean isEnabled=driver.findElement(element).isEnabled();

				if(isEnabled)
				{
					actualResult="The locator with  property"+element+" is Enabled";
					extentReports("Pass", "", expectedResult, actualResult, info,"tc");
					
				}
				else
				{
					String dest=captureScreenShot(info);
					actualResult="The locator with property "+element+" is not Enabled";
					//extentReports("Fail", "", "", "Text '"+parameter+"' entered for xpath '"+object+"'", "",tcName);
					extentReports("Fail", dest, expectedResult, actualResult, info,"tc");	
					
				}


				break;

			case Disabled:
				expectedResult="The locator with property "+element+" should be Disabled";

				boolean isDisabled=driver.findElement(element).isEnabled();

				if(!isDisabled)
				{
					actualResult="The locator with property "+element+" is Disabled";
					extentReports("Pass", "", expectedResult, actualResult, info,"tc");
				}
				else
				{
					String dest=captureScreenShot(info);
					actualResult="The locator with property "+element+" is not Disabled";
					extentReports("Fail", dest, expectedResult, actualResult, info,"tc");	
				}


				break;
			case IsSelected:
				expectedResult=info;
				try
				{
				Result=driver.findElement(element).isSelected();
				}
				catch(Exception e)
				{
					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail",dest, "Failed to Find object "+objectName,"" , "",tcName);
					logger.error("Failed to Find object :"+objectName);
					passFlag=false;
					Assert.fail("Exception Thrown");
					break;
				}
				if(Boolean.valueOf(expectedResult)==Result)
				{
					extentReports("Pass", "", "found '"+expectedResult+"'  for  '"+objectName+"'","" , "",tcName);
					logger.info("Succesfuly Verified property  IsSelected for "+ objectName+" with property "+object);
					logger.info("Expected Result is "+ expectedResult+" Actual Result is "+Result);
					passFlag=true;

				}
				else
				{
					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail", dest, "Not found '"+expectedResult+"'  for  '"+objectName+"'",actualResult, "",tcName);
					logger.error("Failed To Verify property  IsSelected for "+ objectName+" with property "+object);
					logger.error("Expected Result is "+ expectedResult+" Actual Result is "+Result);
					passFlag=false;

				}
				break;
			case IsDisplayed:
				expectedResult=info;
				try
				{
					Result=driver.findElement(element).isDisplayed();
				}
				catch(Exception e)
				{
					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail",dest, "Failed to Find object "+objectName,"" , "",tcName);
					logger.error("Failed to Find object :"+objectName);
					passFlag=false;
					Assert.fail("Exception Thrown");
					break;
				}
				if(Boolean.valueOf(expectedResult)==Result)
				{
					extentReports("Pass", "", "found '"+expectedResult+"'  for  '"+objectName+"'","" , "",tcName);
					logger.info("Succesfuly Verified property  IsDisplayed for "+ objectName+" with property "+object);
					logger.info("Expected Result is "+ expectedResult+" Actual Result is "+Result);
					passFlag=true;

				}
				else
				{
					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail", dest, "Not found '"+expectedResult+"'  for  '"+objectName+"'",actualResult, "",tcName);
					logger.error("Failed To Verify property  IsDisplayed for "+ objectName+" with property "+object);
					logger.error("Expected Result is "+ expectedResult+" Actual Result is "+Result);
					passFlag=false;

				}
				break;
			case TableValues:




				int msgDescriptionSize=driver.findElements(element).size();


				// verifyObjProperty(xpath, "TableValues",vp);


				if(msgDescriptionSize!=0)
				{
					String additionalMsg=info.split(";")[1].toString();
					String dest=captureScreenShot(info.split(";")[0].toString());
					actualResult=driver.findElement(element).getText();
					extentReports("Fail", dest, "", additionalMsg+actualResult, info,"tc");	
				}


				break;
			case Text:


				expectedResult=info;
				try
				{
					System.out.println("text is******"+driver.findElement(element).getText());
					System.out.println("value is******"+driver.findElement(element).getAttribute("value"));
					actualResult=driver.findElement(element).getText().toString().trim();
				}
				catch(Exception e)
				{
					System.out.println("Failed to Find object : " + objectName);


					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail",dest, "Failed to get Text property  for object :"+objectName+"'","object Not found", "",tcName);
					logger.error("Failed to get Text property  for object :"+objectName);
					passFlag=false;
					Assert.fail("Exception Thrown");
					break;

				}
				
				//actualResult=driver.findElement(element).getAttribute("value");

				if(containsFlag==true)
				{

					if(actualResult.trim().toUpperCase().contains(expectedResult.trim().toUpperCase())||actualResult.replaceAll("\\s+", "").toLowerCase().contains(expectedResult.replaceAll("\\s+", "").toLowerCase()))
					{


						//extentReports("Pass", "", "", expectedResult, "","tc");
						if(hmap.get("toReport").equals("Y"))
						{

							extentReports("Pass", "", "found '"+expectedResult+"'  for  '"+objectName+"'","" , "",tcName);
						}
						assertTrue(actualResult.replaceAll("\\s+","").toUpperCase().contains(expectedResult.replaceAll("\\s+","").toUpperCase()));
						logger.info("Succesfuly Verified property Text for "+ objectName+" with property "+object);
						logger.info("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
						passFlag=true;
						break;

					}
					else
					{


						String dest=captureScreenShot(tcName+"_"+snapShotIndex);



						if(hmap.get("toReport").equals("Y"))
						{

							extentReports("Fail", dest, "Not found '"+expectedResult+"'  for  '"+objectName+"'",actualResult, "",tcName);
						}

						logger.error("Failed Verification property Text for "+ objectName+" with property "+object);
						logger.error("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
						passFlag=false;
						assertTrue(actualResult.trim().toUpperCase().contains(expectedResult.trim().toUpperCase()));
						
						break;
					}
				}
				else{
					if(actualResult.equals(expectedResult))
					{
						if(hmap.get("toReport").equals("Y"))
						{

							extentReports("Pass", "", "found '"+expectedResult+"'  for  '"+objectName+"'","" , "",tcName);
						}
						assertTrue(actualResult.equals(expectedResult));
						logger.info("Succesfuly Verified property Text for "+ objectName+" with property "+object);
						logger.info("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
						passFlag=true;
						break;
					}
					else
					{


						String dest=captureScreenShot(tcName+"_"+snapShotIndex);



						if(hmap.get("toReport").equals("Y"))
						{

							extentReports("Fail", dest, "Not found '"+expectedResult+"'  for  '"+objectName+"'",actualResult, "",tcName);
						}

						logger.error("Failed Verification property Text for "+ objectName+" with property "+object);
						logger.error("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
						passFlag=false;
						assertTrue(actualResult.equals(expectedResult));

						break;
					}

				}
			
				
			case Value:
				expectedResult=info;
				try
				{
					actualResult=driver.findElement(element).getAttribute("value").toString().trim();
				}
				catch(Exception e)
				{
					System.out.println("Failed to get Value property  for object : " + objectName);


					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail",dest, "", "Failed to get Value property  for object :"+objectName+"'", "",tcName);
					logger.error("Failed to get Value property  for object :"+objectName);
					passFlag=false;
					Assert.fail("Exception Thrown");
					break;

				}
				
				if(containsFlag==true)
				{
					
					
					
						
					
					
					//actualResult=driver.findElement(element).getAttribute("value");

					if(actualResult.trim().toUpperCase().contains(expectedResult.trim().toUpperCase()))
					{


						//extentReports("Pass", "", "", expectedResult, "","tc");
						if(hmap.get("toReport").equals("Y"))
						{

							extentReports("Pass", "", "found '"+expectedResult+"'  for  '"+objectName+"'","" , "",tcName);
						}
						assertTrue(actualResult.trim().toUpperCase().contains(expectedResult.trim().toUpperCase()));
						logger.info("Succesfuly Verified property Text for "+ objectName+" with property "+object);
						logger.info("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
						passFlag=true;
						break;

					}
					else
					{


						String dest=captureScreenShot(tcName+"_"+snapShotIndex);



						if(hmap.get("toReport").equals("Y"))
						{

							extentReports("Fail", dest, "Not found '"+expectedResult+"'  for  '"+objectName+"'",actualResult, "",tcName);
						}

						logger.error("Failed Verification property Text for "+ objectName+" with property "+object);
						logger.error("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
						assertTrue(actualResult.trim().toUpperCase().contains(expectedResult.trim().toUpperCase()));

						break;
					}
				}
				else
				{
					expectedResult=info;

					

					//actualResult=driver.findElement(element).getAttribute("value");

					if(actualResult.equals(expectedResult))
					{


						//extentReports("Pass", "", "", expectedResult, "","tc");
						if(hmap.get("toReport").equals("Y"))
						{

							extentReports("Pass", "", "found '"+expectedResult+"'  for  '"+objectName+"'","" , "",tcName);
						}
						assertTrue(actualResult.equals(expectedResult));
						logger.info("Succesfuly Verified property Text for "+ objectName+" with property "+object);
						logger.info("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
						passFlag=true;
						break;

					}
					else
					{


						String dest=captureScreenShot(tcName+"_"+snapShotIndex);



						if(hmap.get("toReport").equals("Y"))
						{

							extentReports("Fail", dest, "Not found '"+expectedResult+"'  for  '"+objectName+"'",actualResult, "",tcName);
						}

						logger.error("Failed Verification property Text for "+ objectName+" with property "+object);
						logger.error("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
						assertTrue(actualResult.equals(expectedResult));

						break;
					}



				}
				

			case Title:


				
				try{
					expectedResult=info;
					actualResult=driver.getTitle().toString().trim();
				
				
				//actualResult=driver.findElement(element).getAttribute("value");

				if(actualResult.trim().toUpperCase().contains(expectedResult.trim().toUpperCase()))
				{


					//extentReports("Pass", "", "", expectedResult, "","tc");
					if(hmap.get("toReport").equals("Y"))
					{

						extentReports("Pass", "", "found title'"+expectedResult,"" , "",tcName);
					}
					assertTrue(actualResult.trim().toUpperCase().contains(expectedResult.trim().toUpperCase()));
					logger.info("Succesfuly Verified property Text for "+ objectName+" with property "+object);
					logger.info("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
					passFlag=true;
					break;

				}
				else
				{


					String dest=captureScreenShot(tcName+"_"+snapShotIndex);



					if(hmap.get("toReport").equals("Y"))
					{

						extentReports("Fail", dest, "Not found Title '"+expectedResult,actualResult, "",tcName);
					}

					logger.error("Failed Verification property Text for "+ objectName+" with property "+object);
					logger.error("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
					assertTrue(actualResult.trim().toUpperCase().contains(expectedResult.trim().toUpperCase()));

					break;
				}

				}
				catch(Exception e)
				{
					System.out.println("Failed to  Verify property " );


					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail",dest, "", "Failed to get Ttile property", "",tcName);
					logger.error("Failed to  Verify property");
					Assert.fail("Exception Thrown");
					passFlag=false;


				}



			case SelectedItem:


				//actualResult=driver.findElement(element).getText().toString().trim();
				
				Select s1=null;
				expectedResult=info;
				try
				
				{
					
					s1=new Select(driver.findElement(element));
				}
				catch(Exception e)
				{



					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail",dest, "Failed to Find object "+objectName,"", "",tcName);
					logger.error("Failed to Find object :"+objectName);
					passFlag=false;
					Assert.fail("Exception Thrown");
					break;

				}
				

				actualResult=s1.getFirstSelectedOption().getText();
				System.out.println("The current selected Option is"+s1.getAllSelectedOptions().toString());
				if(actualResult.trim().toUpperCase().contains(expectedResult.trim().toUpperCase()))
				{


					//extentReports("Pass", "", "", expectedResult, "","tc");
					if(hmap.get("toReport").equals("Y"))
					{

						extentReports("Pass", "", "found '"+expectedResult+"'  for  '"+objectName+"'","" , "",tcName);
					}
					assertTrue(actualResult.trim().toUpperCase().contains(expectedResult.trim().toUpperCase()));
					logger.info("Succesfuly Verified property Text for "+ objectName+" with property "+object);
					logger.info("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
					passFlag=true;
					break;

				}
				else
				{


					String dest=captureScreenShot(tcName+"_"+snapShotIndex);



					if(hmap.get("toReport").equals("Y"))
					{

						extentReports("Fail", dest, "Not found '"+expectedResult+"'  for  '"+object+"'",actualResult, "",tcName);
					}

					logger.error("Failed Verification property Text for "+ objectName+" with property "+object);
					logger.error("Expected Result is "+ expectedResult+" Actual Result is "+actualResult);
					assertTrue(actualResult.trim().toUpperCase().contains(expectedResult.trim().toUpperCase()));

					break;
				} 
				
			case TableCell:


				//String additionalMsg=info.split(";")[2].toString();
				int f=0;
				expectedResult=info;


				int cell_num=Integer.parseInt(parameter.split(",")[2].split("=")[1].toString());
				int row_num=1;
				int col_num=0;
				WebElement element1=null;
				try
				{
					element1=driver.findElement(element);
				}
				catch(Exception e)
				{
					System.out.println("Failed to get  Object property   " );


					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail",dest,  "Failed to Find object "+objectName, "","",tcName);
					logger.error("Failed to Find object :"+objectName);
					passFlag=false;
					break;

				}

				// actualResult=driver.findElement(element).getText().toString().trim();


				//System.out.println("actual result got for status history"+actualResult);
				System.out.println("expectede got "+expectedResult);


				List<WebElement> totalRows=element1.findElements(By.tagName("tr"));
				System.out.println("Total row count check is  --------"+totalRows.size());

				for(WebElement rowElement : totalRows)
				{
					List<WebElement> totalColumns=rowElement.findElements(By.xpath("td"));
					System.out.println("Total column count check is  --------"+totalColumns.size());
					col_num=1;
					for(WebElement columnElement : totalColumns)
					{
						System.out.println("row # "+row_num+", col # "+col_num+ "text="+columnElement.getText());
						if(columnElement.getText().contains(expectedResult)&col_num==cell_num)
						{
							System.out.println("Expected Info found on row # "+row_num+", col # "+col_num+ "text="+columnElement.getText());
							actualResult="Expected Info "+columnElement.getText()+" found on row # "+row_num+", col # "+col_num;
							f=1;
							break;
						}
						col_num++;
					}
					if(f==1)
					{
						//extentReports("Pass", "", "found '"+expectedResult+"'  for  '"+object+"'","" , "",tcName);

						extentReports("Pass", "", "found '"+expectedResult+"'  in Table column  '"+cell_num+"'","" , "",tcName);
						logger.info("Expected Result "+expectedResult+" is  found in Table column "+cell_num );
						break;
					}
					row_num++;
				} 
				if(f==0)
				{
					String dest=captureScreenShot(info);
					//actualResult=additionalMsg+"Not "+expectedResult;
					//extentReports("Fail", dest, expectedResult, actualResult, info,"tc");
					extentReports("Fail", dest, "Not found '"+expectedResult+"'  in Table column  '"+cell_num+"'","" , "",tcName);
					System.out.println("#####failed");
					logger.error("Expected Result "+expectedResult+" is Not found in Table column "+cell_num );
				}
				break;
				
				
			default:
				break;



			}
		}

		catch (Exception e) {

			System.out.println("Failed to Provide Expected Input For Object " + object);


			String dest=captureScreenShot(tcName+"_"+snapShotIndex);
			extentReports("Fail",dest,  "Failed to Provide Expected Input For Object "+object+"'", "","",tcName);
			logger.error("Failed to Provide Expected Input For Object "+object);
			passFlag=false;
			Assert.fail("Exception Thrown");
		

		}
	}

	public enum dateFormats {currentDate,nextDate}
	public void createDateFormats(String parameter) throws ParseException
	{


		String condition=parameter.split(",")[0].toString();
		String dateFormat=parameter.split(",")[1].toString();
		String excelColumn=parameter.split(",")[2].toString();
		//int rowVal=getRowIndex(String excelName,String sheetName,String rowValue)

		int rowVal=getRowIndex(dataSheet,dataSheetName , excelColumn);
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



	/*public void verifyObjProperty(String xpath, String property,String info) {

		try {

			By element = By.xpath(xpath);
			waitTillOverlayDisappear(element, driver);
			String expectedResult="";
			String actualResult="";

			switch (propertyLists.valueOf(property))
			{

			case Enabled:
				expectedResult="The locator with xpath "+xpath+" should be "+property;

				boolean isEnabled=driver.findElement(element).isEnabled();

				if(isEnabled)
				{
					actualResult="The locator with xpath "+xpath+" is Enabled";
					extentReports("Pass", "", expectedResult, actualResult, info,"tc");
				}
				else
				{
					String dest=captureScreenShot(info);
					actualResult="The locator with xpath "+xpath+" is not Enabled";
					extentReports("Fail", dest, expectedResult, actualResult, info,"tc");	
				}


				break;

			case Disabled:
				expectedResult="The locator with xpath "+xpath+" should be "+property;

				boolean isDisabled=driver.findElement(element).isEnabled();

				if(!isDisabled)
				{
					actualResult="The locator with xpath "+xpath+" is Disabled";
					extentReports("Pass", "", expectedResult, actualResult, info,"tc");
				}
				else
				{
					String dest=captureScreenShot(info);
					actualResult="The locator with xpath "+xpath+" is not Disabled";
					extentReports("Fail", dest, expectedResult, actualResult, info,"tc");	
				}


				break;

			case TableValues:




				 int msgDescriptionSize=driver.findElements(element).size();


				// verifyObjProperty(xpath, "TableValues",vp);


				if(msgDescriptionSize!=0)
				{
					String additionalMsg=info.split(";")[1].toString();
					String dest=captureScreenShot(info.split(";")[0].toString());
					actualResult=driver.findElement(element).getText();
					extentReports("Fail", dest, "", additionalMsg+actualResult, info,"tc");	
				}


				break;
			case Text:


                expectedResult=info;

                actualResult=driver.findElement(element).getText().toString().trim();


                 if(actualResult.toUpperCase().contains(expectedResult.trim().toUpperCase()))
                {


                     extentReports("Pass", "", "", expectedResult, "","tc");


                }
                else
                {

                      String dest=captureScreenShot(info);


                       extentReports("Fail", dest, "", actualResult, "","tc");

                }
                break;

	case Text2:


                expectedResult=info;

                actualResult=driver.findElement(element).getText().toString().trim();

                System.out.println("ssss"+actualResult);
                 if(expectedResult.toUpperCase().contains(actualResult.trim().toUpperCase()))
                {


                       extentReports("Pass", "", "", expectedResult, "","tc");

                }
                else
                {
                       String dest=captureScreenShot(info);


                       extentReports("Fail", dest, "", actualResult, "","tc");

                }
                break;


  case TableCell:


	String additionalMsg=info.split(";")[2].toString();
	int f=0;
	expectedResult=info.split(";")[0].toString();
	int cell_num=Integer.parseInt(info.split(";")[1].toString());
	int row_num=-1;
	int col_num=0;
	WebElement element1=driver.findElement(By.xpath(xpath));


	// actualResult=driver.findElement(element).getText().toString().trim();


	System.out.println("actual result got for status history"+actualResult);
	System.out.println("expectede got "+expectedResult);


	List<WebElement> totalRows=element1.findElements(By.tagName("tr"));
	System.out.println("Total row count check is  --------"+totalRows.size());

	for(WebElement rowElement : totalRows)
	{
		List<WebElement> totalColumns=rowElement.findElements(By.xpath("td"));
		System.out.println("Total column count check is  --------"+totalColumns.size());
		col_num=1;
		for(WebElement columnElement : totalColumns)
		{
			System.out.println("row # "+row_num+", col # "+col_num+ "text="+columnElement.getText());
			if(columnElement.getText().contains(expectedResult)&col_num==cell_num)
			{
				System.out.println("Expected Info found on row # "+row_num+", col # "+col_num+ "text="+columnElement.getText());
				actualResult="Expected Info "+columnElement.getText()+" found on row # "+row_num+", col # "+col_num;
				f=1;
				break;
			}
			col_num++;
		}
		if(f==1)
		{


			extentReports("Pass", "", "", additionalMsg+expectedResult, "","tc");
			break;
		}
		row_num++;
	} 
	if(f==0)
	{
		String dest=captureScreenShot(info);
		actualResult=additionalMsg+"Not "+expectedResult;
		extentReports("Fail", dest, expectedResult, actualResult, info,"tc");
		System.out.println("#####failed");
	}
	break;



			}
		}

		catch (Exception e) {

		}
	}
	 */

	public boolean click(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException {

		try {

			//Finding the object
			logger=Logger.getLogger(tcName);
			String sheet=object.split(";")[0].split("=")[1].toString();
			String objectName=object.split(";")[1].toString().split("=")[1].toString();
			object=object.split(";")[1].toString().split("=")[1].toString();



			object=getCellValue(objectSheet, sheet,object, "Properties");
			By element = getElement(object);

			driver.findElement(element).click();

			if(hmap.get("toReport").equals("Y"))
			{

				extentReports("Pass", "", "Clicked the button for the object '"+objectName+"'" ,"",  "",tcName);
			}

			logger.info("clicked on object "+objectName +" with property "+object);
			passFlag=true;
			return true;
		}

		catch (Exception e) {
			System.out.println("Not clicked on the object with property : "
					+ object);
			String dest=captureScreenShot(tcName+"_"+snapShotIndex);
			extentReports("Fail",dest,"Not Clicked the button with property '"+object+"'", "" , "",tcName);	
			passFlag=false;
			logger.error("Failed to click on object "+object);
			return false;
		}
	}


	//object,onPass,onFail,parameter,tcName
	public boolean launchBrowser(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws InterruptedException,
	IOException {

		String browser= cds.getTCPropertyValue("Parameters", "Sheet1", 1, 0);
		setUpBrowser(object, onPass, onFail, browser, tcName, hmap);

		String url=parameter;
		String pageTitle=getCellValue(dataSheet, dataSheetName,tcName, "PageTitle");

		if(!url.contains("value"))
		{
			try
			{
			url=getCellValue(dataSheet, dataSheetName,
					tcName, url);
			}

			catch(Exception e)
			{
				logger.error("Failed to Find Expected Column "+url+"in DataSheet");
				passFlag=false;
				Assert.fail("Exception Thrown");
			}
		}
		else
		{
			url=parameter.split("=")[1].toString();
		}


		try {


			driver.get(url);

			driver.manage().window().maximize();

			/*** String certificateXpath = getCellValue(objectSheet, "Utility",
			"lnk_certificate", "Properties");

     click(certificateXpath);***/
			/*try
			{
				while(driver.findElement(By.name("overridelink")).isDisplayed())
				{
					driver.findElement(By.name("overridelink")).click();
				}
					
				
			}
			catch(Exception ex)
			{
				
			}*/


			if(driver.getTitle().equals(pageTitle))
			{
				if(hmap.get("toReport").equals("Y"))
				{
					extentReports("Pass", "","WebPage '"+pageTitle+"'loaded successfully" ,"", "",tcName);		
				}
				passFlag=true;
				return true;
			}
			else
			{
				if(hmap.get("toReport").equals("Y"))
				{
					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail",dest, "", "WebPage '"+pageTitle+"'not loaded successfully", "",tcName);
				}
				passFlag=false;
				return false;
			}


		}

		catch (Exception e) {
			System.out.println("Browser not launched for  : " + url);
			extentReports("Fail", "MessageType_iCargo", "", "WebPage '"+pageTitle+"'not loaded successfully", "",tcName);			

			return false;
		}

	}

	public boolean verifyTitle(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException 
	{
		//String pageTitle=getCellValue(dataSheet, dataSheetName,tcName, "PageTitle");
		logger=Logger.getLogger(tcName);
		String info="";
		boolean containsFlag=false;
		if(parameter.contains("value="))
		{
			info=parameter.split("=")[1].toString();
			if(info.contains("<<"))
			{


				info=info.split("<<")[1].split(">>")[0]       .toString();
				containsFlag=true;
			}

		}
		else
		{
			if(parameter.contains("<<"))
			{
				info=info.split("<<")[1].split(">>")[0]       .toString();
				containsFlag=true;

			}
			try
			{
			info=getCellValue(dataSheet, dataSheetName,
					tcName, parameter);
			}
			catch(Exception e)
			{
				logger.error("Failed to Find Expected Column "+parameter+"in DataSheet");
				passFlag=false;
				Assert.fail("Exception Thrown");
			}
			
		}
		sleep(5000);
		for(String winHandle : driver.getWindowHandles()){
			driver=driver.switchTo().window(winHandle);
			System.out.println(winHandle);
		}
		System.out.println("after  "+driver.getTitle());

		String check=driver.getTitle();
		System.out.println("Current Title is"+check);
		//WebDriverWait wait=new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.titleContains(pageTitle));
		if(containsFlag==false)
		{
			if(driver.getTitle().equals(info))
			{
				if(hmap.get("toReport").equals("Y"))
				{
					extentReports("Pass", "","WebPage '"+info+"'loaded successfully" ,"", "",tcName);		
					logger.info("Found the expected Page Title: "+info);
				}
				passFlag=true;
				return true;
			}
			else
			{
				if(hmap.get("toReport").equals("Y"))
				{
					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail",dest, "Expected result is: "+info, "WebPage '"+info+"'not loaded successfully", "",tcName);
					logger.error("Failed to find Expected page tiltle "+info);
				}
				passFlag=false;
				return false;
			}

		}
		else
		{
			if(driver.getTitle().contains((info)))
			{
				if(hmap.get("toReport").equals("Y"))
				{
					extentReports("Pass", "","WebPage '"+info+"'loaded successfully" ,"", "",tcName);		
					logger.info("Found the expected Page Title: "+info);
				}
				passFlag=true;
				return true;
			}
			else
			{
				if(hmap.get("toReport").equals("Y"))
				{
					String dest=captureScreenShot(tcName+"_"+snapShotIndex);
					extentReports("Fail",dest, "Expected result is: "+info, "WebPage '"+info+"'not loaded successfully", "",tcName);
					logger.error("Failed to find Expected page tiltle "+info);
				}
				passFlag=false;
				return false;
			}
		}
	}

	public boolean closeBrowser(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) {

		try
		{
			//driver.quit();

			driver.close();
			passFlag=true;

			return true;
		}

		catch(Exception e)
		{
			passFlag=false;
			return false;
		}

	}

	
	public void hover(String xpath) {

		try {
			By element = By.xpath(xpath);
			waitTillOverlayDisappear(element, driver);

			sleep(10000);

			WebElement ele = driver.findElement(By.xpath(xpath));

			(new Actions(driver)).moveToElement(ele).click().perform();
		}

		catch (Exception e) {
			System.out.println("Not clicked on the object with xpath : "
					+ xpath);
		}
	}




	public boolean checkObjExistence(String xpath, String info)
			throws IOException {
		String expectedResult = "Webelement should be present with properties "
				+ xpath;
		String actualResult = "";
		By element = By.xpath(xpath);

		try {
			driver.findElement(element);
			actualResult = "Webelement  present with properties " + xpath;
			extentReports("Pass", "", expectedResult, actualResult, info,"tc");
			return true;

		}

		catch (Exception e)

		{
			String dest = captureScreenShot(info);
			actualResult = "Webelement not present with properties " + xpath;
			extentReports("Fail", dest, expectedResult, actualResult, info,"tc");
			return false;
		}
	}

	public boolean sample(String info,String testCase)
			throws IOException {
		String expectedResult = "Pass";

		String actualResult = "";


		if(info.equals("Pass"))
		{

			extentReports("Pass", "", expectedResult, actualResult, info,testCase);
			return true;
		}
		else
		{
			String dest = captureScreenShot(info);
			actualResult = "Fail";
			extentReports("Fail", dest, expectedResult, actualResult, info,testCase);
			return false;
		}
	}

	public enum keyActions {
		TAB, ENTER, SCROLLDOWNMOUSE
	}

	public void keyPress(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws AWTException {

		String fieldValue="";
		Robot robot=new Robot();
		if(parameter.contains(";"))
		{
			fieldValue=parameter.split(";")[1].toString();
			parameter=parameter.split(";")[0].toString();

		}
		switch (keyActions.valueOf(parameter)) {

		case TAB:

			robot.keyPress(KeyEvent.VK_TAB);
			System.out.println("pressed tab");
			break;

		case ENTER:
			robot.keyPress(KeyEvent.VK_ENTER);
			break;
		case SCROLLDOWNMOUSE:robot.mouseWheel(Integer.parseInt(fieldValue));
		break;
		}

	}

	public enum clickAtTableList {ReferenceObject}
	public boolean clickAtTableCell(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException {

		try {

			//Finding the object
			logger=Logger.getLogger(tcName);
			String sheet=object.split(";")[0].split("=")[1].toString();
			String objectName=object.split(";")[1].toString().split("=")[1].toString();
			object=object.split(";")[1].toString().split("=")[1].toString();
			String selection=parameter.split(",")[0].toString();
			String info=parameter.split(",")[1].toString();
			object=getCellValue(objectSheet, sheet,object, "Properties");
			By element = getElement(object);
			int cellToclick=Integer.parseInt(parameter.split(",")[3].toString());
			int rowFound=0;
			if(!info.contains("value"))
			{
				try
				{
				info=getCellValue(dataSheet, dataSheetName,
						tcName, info);
				}
				catch(Exception e)
				{
					logger.error("Failed to Find Expected Column "+info+"in DataSheet");
					passFlag=false;
					Assert.fail("Exception Thrown");
				}
			}
			else if(info.contains("value"))
			{

				info=info.split("=")[1].toString();

			}
			switch(clickAtTableList.valueOf(selection))
			{
			case ReferenceObject:

				String object2 = parameter.split(",")[2].toString();
				object2=getCellValue(objectSheet, sheet,object2, "Properties");

				WebElement table=driver.findElement(element);
				List<WebElement>trows=table.findElements(By.tagName("tr"));
				int row_num=0;
				int tr=0;
				for(WebElement rowElement : trows)
				{
					List<WebElement> totalColumns=rowElement.findElements(By.xpath("td"));
					System.out.println("Total column count check is  --------"+totalColumns.size());
					int col_num=1;
					for(WebElement columnElement : totalColumns)
					{
						System.out.println("row # "+row_num+", col # "+col_num+ "text="+columnElement.getText());
						if(columnElement.getText().toUpperCase().contains(info.toUpperCase()))
						{
							tr=row_num+1;
							rowFound=1;
							System.out.println("clicked");
							break;

						}
						col_num++;
					}
					if(rowFound==1)
						break;
					row_num++;
				}
				object2=object2+"/tr["+tr+"]/td["+cellToclick+"]/a[1]";
				By element2 = getElement(object2);
				//driver.findElement(By.xpath("//*[contains(@id,'yui_patched')]/tr["+tr+"]/td[6]/a[1]")).click();
				driver.findElement(element2).click();

				break;

			}
			if(hmap.get("toReport").equals("Y"))
			{

				extentReports("Pass", "", "Clicked the cell'"+cellToclick+" containing the Row element'"+info ,"",  "",tcName);
			}

			logger.info("Clicked the cell "+cellToclick+" containing the Row element"+info);
			passFlag=true;
			return true;



		}

		catch (Exception e) {
			logger.error("Failed to click on specified cell containing Row Info ");
			String dest=captureScreenShot(tcName+"_"+snapShotIndex);

			extentReports("Fail",dest, "", "Failed to click on specified cell containing Row Info", "",tcName);
			return false;

		}


	}
	public enum stringOperationsList {Concatenation}
	public String stringOperations(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException {

		try {

			//Finding the object
			logger=Logger.getLogger(tcName);

			String selection=parameter.split(";")[0].toString();

			String columnName=parameter.split(";")[1].toString().split("=")[1].toString();


			int n=parameter.split(";").length;
			String result="";
			int rowVal=getRowIndex(dataSheet,dataSheetName , tcName);
			switch(stringOperationsList.valueOf(selection))
			{
			case Concatenation:

				for(int i=2;i<n;i++)
				{
					String adder=parameter.split(";")[i].toString();
					if(adder.contains("value="))
					{
						adder=adder.split("=")[1].toString();
					}
					else
					{
						adder=getCellValue(dataSheet, dataSheetName,
								tcName, adder);
					}
					result=result+adder;
				}
				setCellValue(dataSheet,dataSheetName,rowVal, columnName,result);
				break;

			}
			if(hmap.get("toReport").equals("Y"))
			{

				extentReports("Pass", "", "concatenated string and result is: "+result ,"",  "",tcName);
			}

			logger.info("Concatenated String");
			passFlag=true;
			return result;



		}

		catch (Exception e) {
			logger.error("Failed to concatenate");
			String dest=captureScreenShot(tcName+"_"+snapShotIndex);

			extentReports("Fail",dest, "", "Failed to concatenate", "",tcName);
			return null;

		}


	}
	public enum iMailOperationsList {clickMail}
	public boolean MailOperations(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException {

		try {

			//Finding the object
			String selection;
			logger=Logger.getLogger(tcName);
			String sheet=object.split(";")[0].split("=")[1].toString();
			String objectName=object.split(";")[1].toString().split("=")[1].toString();
			object=object.split(";")[1].toString().split("=")[1].toString();

			boolean found=false;

			object=getCellValue(objectSheet, sheet,object, "Properties");
			By element = getElement(object);

			selection=parameter.split(";")[0].toString();
			parameter=parameter.split(";")[1].toString();
			if(!parameter.contains("value"))
			{
				parameter=getCellValue(dataSheet, dataSheetName,
						tcName, parameter);
			}
			else if(parameter.contains("value"))
			{
				parameter=parameter.split("=")[1].toString();
			}

			/*if(hmap.get("toReport").equals("Y"))
			{

				extentReports("Pass", "", "Clicked the button for the object '"+objectName+"'" ,"",  "",tcName);
			}

			logger.info("clicked on object "+objectName +" with property "+object);
			passFlag=true;
			return true;*/

			switch(iMailOperationsList.valueOf(selection))
			{

			case clickMail:List<WebElement>list=driver.findElements(element);
			for(int i=0;i<list.size();i++)
			{

				if(list.get(i).isDisplayed()==true)
				{
					System.out.println(list.get(i).getText());
					System.out.println(list.get(i).getText().replaceAll("\\s+","").toLowerCase());
					System.out.println(parameter.toLowerCase());
					if(list.get(i).getText().contains(parameter)||list.get(i).getText().replaceAll("\\s+","").toLowerCase().contains((parameter.toLowerCase().replaceAll("\\s+",""))))
					{
						list.get(i).click();
						System.out.println("Found in imail");
						if(hmap.get("toReport").equals("Y"))
						{

							extentReports("Pass", "", "Subject "+parameter+" Found in Mail" ,"",  "",tcName);
							found=true;
							break;
						}
					}
				}
			}

			break;
			}
			if(found==false)
			{
				logger.error("Failed to Find Subject :"+parameter);
				String dest=captureScreenShot(tcName+"_"+snapShotIndex);

				extentReports("Fail",dest, "", "Failed to find Subject: "+parameter, "",tcName);
				return false;

			}
			else
				return true;

		}

		catch (Exception e) {
			System.out.println("Not clicked on the object with property : "
					+ object);
			String dest=captureScreenShot(tcName+"_"+snapShotIndex);
			extentReports("Fail",dest,"Not Clicked the button with property '"+object+"'", "" , "",tcName);	
			passFlag=false;
			logger.error("Failed to click on object "+object);
			return false;
		}
	}


	public enum alertOps {Accept,Dismiss,GetText,CompareText}
	public boolean switchToAlert(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException
	{
		String alertOperations=parameter.split(";")[0].toString();
		String alertMsg="";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		try
		{

			Alert alert=driver.switchTo().alert();   
			alertMsg=alert.getText();
			switch (alertOps.valueOf(alertOperations))
			{
			case Accept:

				alert.accept();
				if(hmap.get("toReport").equals("Y"))
				{

					extentReports("Pass", "","Alert with text '"+alertMsg+"' is accepted" ,"",  "",tcName);

				}


				break;

			case Dismiss:
				alert.dismiss();
				if(hmap.get("toReport").equals("Y"))
				{

					extentReports("Pass", "", "Alert with text '"+alertMsg+"' is dismissed","",  "",tcName);
				}
				break;

			case GetText:

				String excelColumn=parameter.split(";")[1].split("=")[1].toString();
				setCellValue(dataSheet,dataSheetName,tcName, excelColumn,alertMsg);

				if(hmap.get("toReport").equals("Y"))
				{

					extentReports("Pass", "", "Alert with text '"+alert.getText()+"' is identified","","",tcName);
				}
				break;
			case CompareText:

				String toCompareString=parameter.split(";")[1].split("=")[1].toString();

				if(toCompareString.contains("'"))
				{
					toCompareString= toCompareString.split("'")[1].toString();
				}
				else
				{
					toCompareString=getCellValue(dataSheet, dataSheetName,
							tcName, toCompareString);
				}

				if(toCompareString.contains("<<"))
				{
					toCompareString=toCompareString.split("<<")[1].split(">>")[0].toString();



					if(alertMsg.contains(toCompareString))
					{
						if(hmap.get("toReport").equals("Y"))
						{

							extentReports("Pass", "", "", "Alert message matches with the expected value.Alert message is '"+alertMsg+"'", "",tcName);
						}

						passFlag=true;
						return true;
					}
					else
					{

						if(hmap.get("toReport").equals("Y"))
						{
							String dest=captureScreenShot(tcName+"_"+snapShotIndex);
							extentReports("Fail",dest, "", "Alert message not matches with the expected value.Alert message is '"+alertMsg+"'", "",tcName);
						}
						passFlag=false;
						return false;
					}
				}

				else
				{
					if(alertMsg.equals(toCompareString))
					{
						if(hmap.get("toReport").equals("Y"))
						{

							extentReports("Pass", "", "", "Alert message matches with the expected value.Alert message is '"+alertMsg+"'", "",tcName);
						}
						passFlag=true;
						return true;
					}
					else
					{
						if(hmap.get("toReport").equals("Y"))
						{
							String dest=captureScreenShot(tcName+"_"+snapShotIndex);
							extentReports("Fail",dest, "", "Alert message not matches with the expected value.Alert message is '"+alertMsg+"'", "",tcName);
						}
						passFlag=false;
						return false;
					}
				}



			}

			passFlag=true;
			return true;



		}

		catch(UnhandledAlertException e)
		{
			if(hmap.get("toReport").equals("Y"))
			{

				String dest=captureScreenShot(tcName+"_"+snapShotIndex);
				extentReports("Fail",dest, "", "Alert operation '"+alertOperations+"' not performed on the alert '"+alertMsg+"'", "",tcName);
			}
			passFlag=false;
			return false;

		}
	}


}
