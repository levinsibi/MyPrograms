package common;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import common.WebFunctions.propertyLists;

public class DesktopFunctions extends Utility {
	
	
	CreateDynamicSuit cds=new CreateDynamicSuit();
	
	
	public boolean enterTextForDesktop(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException {

		try {
			
			logger=Logger.getLogger(tcName);
			
			//Finding the object
			
			String sheet=object.split(";")[0].split("=")[1].toString();
			String objectName=object.split(";")[1].toString().split("=")[1].toString();
			object=object.split(";")[1].toString().split("=")[1].toString();
			
			
			
			object=getCellValue(objectSheet, sheet,object, "Properties");
					
		
			
			/****By element = By.xpath(object);****/
			
			By element =getElement(object);
			
		
			
			System.out.println("pppp"+parameter);
			
			
			//Finding the parameter
			
			if(!parameter.contains("value"))
			{
				parameter=getCellValue(dataSheet, dataSheetName,
						tcName, parameter);
			}
			else if(parameter.contains("value"))
			{
				parameter=parameter.split("=")[1].toString();
			}
			
			
				
			windriver.findElement(element).sendKeys(parameter);
			
			if(hmap.get("toReport").equals("Y"))
			{
			
				extentReports("Pass", "", "Text '"+parameter+"' entered for object '"+objectName+"'", "", "",tcName);
				
			}
			
			passFlag=true;
			logger.info("Entered text on object "+objectName +" with property "+object); 
			 
			return true;
		}

		catch (Exception e) {
			System.out.println("Text is not entered for object : " + object);

			String dest=captureScreenShot(tcName+"_"+snapShotIndex);
			extentReports("Fail",dest, "", "Text '"+parameter+"' not entered for object '"+object+"'", "",tcName);
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
	public enum selectList {Value,Index}
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
	}
	public void clearText(String object) {

		try {
			
			By element = getElement(object);
			

			driver.findElement(element).clear();
		}

		catch (Exception e) {
			
		}
	}
	

	public enum propertyListsDeskTop {Enabled,Disabled,Existence, Text}
	public boolean verifyObjPropertyForDesktop(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) {

		try {
			logger=Logger.getLogger(tcName);
			
			String expectedResult="";
			String actualResult="";
			
           //Finding the object
			
			String sheet=object.split(";")[0].split("=")[1].toString();
			object=object.split(";")[1].toString().split("=")[1].toString();
			
			
			
			object=getCellValue(objectSheet, sheet,object, "Properties");
					
		
			
			/****By element = By.xpath(object);****/
			
			By element =getElement(object);
			
			//Switch cases
			
			String switchCases=parameter.split(";")[0].toString();
			
			

			switch (propertyLists.valueOf(switchCases))
			{

			case Enabled:
				

				boolean isEnabled=windriver.findElement(element).isEnabled();

				if(isEnabled)
				{
					actualResult="The locator "+object+" is Enabled";
					
					if(hmap.get("toReport").equals("Y"))
					{
					extentReports("Pass", "", "", actualResult, "","tc");
					}
					passFlag=true;
					 
					 
					return true;
				}
				else
				{
					String dest=captureScreenShot(tcName+object+"Disabled");
					actualResult="The locator "+object+" is not Enabled";
					
					if(hmap.get("toReport").equals("Y"))
					{
					extentReports("Fail", dest, expectedResult, actualResult, "","tc");	
					}
					passFlag=false;
					 
					 
					return false;
				}


				

			case Disabled:
				

				boolean isDisabled=windriver.findElement(element).isEnabled();

				if(!isDisabled)
				{
					actualResult="The locator '"+object+ "'  is Disabled";
					
					if(hmap.get("toReport").equals("Y"))
					{
					extentReports("Pass", "", "", actualResult, "","tc");
					}
					passFlag=true;
					 
					 
					return true;
				}
				else
				{
					String dest=captureScreenShot(tcName+object+"Enabled");
					actualResult="The locator '"+object+ "' is not Disabled";
					if(hmap.get("toReport").equals("Y"))
					{
					extentReports("Fail", dest, "", actualResult, "","tc");	
					}
					passFlag=false;
					 
					 
					return false;
				}


         case Existence:
				
        	 boolean isExists=false;
        	 
                try
                {
				 isExists=windriver.findElement(element).isDisplayed();
                }
                
                catch(Exception e)
                {
                	
                }

				if(isExists)
				{
					actualResult="The locator '"+object+ "' is Displayed";
					if(hmap.get("toReport").equals("Y"))
					{
					extentReports("Pass", "", actualResult, "", "","tc");
					}
					passFlag=true;
					 
					logger.info("Succesfully "+actualResult);
					return true;
				}
				else
				{
					
					String dest=captureScreenShot(tcName+object+"Displayed");
					actualResult="The locator '"+object+ "' is not Displayed";
					if(hmap.get("toReport").equals("Y"))
					{
					extentReports("Fail", dest, expectedResult, actualResult, "","tc");	
					}
					passFlag=false;
					logger.error("Failed to Find Expected Result");
					 
					return false;
				}


			case Text:


				expectedResult=parameter.split(";")[1].toString();
				
				

				actualResult=windriver.findElement(element).getText().toString().trim();


				if(actualResult.equals(expectedResult))
				{

					if(hmap.get("toReport").equals("Y"))
					{
					extentReports("Pass", "", "", "Text verifictaion matches for '"+expectedResult+"'", "","tc");
					}
					passFlag=true;
					return true;
					 
					


				}
				else if(expectedResult.contains("<<"))
				{
					
					expectedResult=expectedResult.split("<<")[1].split(">>")[0]	.toString();
					
					if(actualResult.contains(expectedResult))
					{

						if(hmap.get("toReport").equals("Y"))
						{
					extentReports("Pass", "", "", "Text verifictaion matches for '"+expectedResult+"'", "","tc");
						}
					passFlag=true;
					return true;
					}
					
					else
					{
						String dest=captureScreenShot(tcName+object+"TextMismatch");

						if(hmap.get("toReport").equals("Y"))
						{
						extentReports("Fail", dest, "", "Text verifictaion not matches for '"+expectedResult+"' : Actual text is '"+actualResult+"'", "","tc");
						}
						passFlag=false;
						return false;	
					}
					 
					


				}
				else
				{

					String dest=captureScreenShot(tcName+object+"TextMismatch");

					if(hmap.get("toReport").equals("Y"))
					{
					extentReports("Fail", dest, "", "Text verifictaion not matches for '"+expectedResult+"' : Actual text is '"+actualResult+"'", "","tc");
					}
					passFlag=false;
					return false;

				}
				




			}
			
			passFlag=false;
			return false;
		}

		catch (Exception e) {
			
			passFlag=false;
			return false;

		}
	}

	
	public boolean clickDesktopAppln(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) throws IOException {

		try {
			
             //Finding the object
			logger=Logger.getLogger(tcName);
			
			String sheet=object.split(";")[0].split("=")[1].toString();
			String objectName=object.split(";")[1].toString().split("=")[1].toString();
			object=object.split(";")[1].toString().split("=")[1].toString();
			
			
			
			object=getCellValue(objectSheet, sheet,object, "Properties");
			By element = getElement(object);

			windriver.findElement(element).click();
			
			if(hmap.get("toReport").equals("Y"))
			{
			
				extentReports("Pass", "", "Clicked the button for the object '"+objectName+"'" ,"",  "",tcName);
			}
			
			logger.info("clicked on object "+objectName +" with property "+object);
        	 passFlag=true;
			return true;
		}

		catch (Exception e) {
			System.out.println("Not clicked on the object with xpath : "
					+ object);
			String dest=captureScreenShot(tcName+"_"+snapShotIndex);
			extentReports("Fail",dest,"Not Clicked the button '"+object+"'", "" , "",tcName);	
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
		url=getCellValue(dataSheet, dataSheetName,
					tcName, url);
		}
		

try {
    
	
	driver.get(url);

	driver.manage().window().maximize();

	/*** String certificateXpath = getCellValue(objectSheet, "Utility",
			"lnk_certificate", "Properties");

     click(certificateXpath);***/
	
		
	
	if(driver.getTitle().equals(pageTitle))
	{
		if(hmap.get("toReport").equals("Y"))
		{
			extentReports("Pass", "", "", "WebPage '"+pageTitle+"'loaded successfully", "",tcName);		
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

public boolean quitBrowser(String object,String onPass,String onFail,String parameter,String tcName,HashMap<String,String> hmap) {

try
{
driver.quit();


passFlag=true;

return true;
}

catch(Exception e)
{
	passFlag=false;
	return false;
}

}

public void closeBrowser() {


driver.close();

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
	TAB, ENTER
}

public void keyPress(String action) throws AWTException {
	
	Robot robot=new Robot();
	switch (keyActions.valueOf(action)) {

	case TAB:
		
		robot.keyPress(KeyEvent.VK_TAB);
		break;

	case ENTER:
		robot.keyPress(KeyEvent.VK_ENTER);
		break;

	}

}

}
