package common;

/*****Author name: A-7290 A-7626 and A-7688
 * Description: Common methods for Web Elements
 Date of creation: 29-05-18******/

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import bsh.ParseException;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import controls.ExcelRead;

public class WebFunctions {
	public String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public int RANDOMSTRINGLENGTH = 10;
	public static WebDriver driver;
	ExcelReadWrite excelReadWrite;
	public String excelfilename = null;
	public ExcelReadWrite excelreadwrite;
	public ExcelRead excelRead;
	public static ExtentTest test;
	Object[][] retObjArr = null;
	// String currentTestName;
	public Actions action;
	boolean j = false;
	public CommonUtility commonUtility;
	public Xls_Read xls_Read;

	public int counter = 0;
	public Actions actions;
	public Alert alert;
	public String alertText;
	public WebElement ele;
	public boolean Status = true;
	static String windowHandle;
	static String referenceVar;
	public static String childWindow;
	public static String parentWindow;
	public static Map<Object, Object> map;
	public static CustomFunctions customFunction;
	public String projDir = System.getProperty("user.dir");
	String globalVarPath = "\\src\\resources\\GlobalVariable.properties";
	public Wait wait;

	public WebFunctions(WebDriver driver, ExcelReadWrite excelReadWrite, Xls_Read xls_Read2)

	// Initializing variables
	{

		this.driver = driver;
		this.excelreadwrite = excelReadWrite;
		commonUtility = new CommonUtility();
		this.xls_Read = xls_Read2;
		excelRead = new ExcelRead();
		excelfilename = this.getClass().getSimpleName();
		actions = new Actions(driver);
		customFunction = new CustomFunctions(driver, excelReadWrite, xls_Read2);
	}

	WebElement element;
	String testSteps, pageName, eleName;

	// Zero Parameter constructor
	public WebFunctions() {
	}

	public ExtentTest getExtentTestInstance() {
		return this.test;
	}

	public void setExtentTestInstance(ExtentTest test) {
		this.test = test;
	}

	/**
	 * Description... Takes Object Map keys, returns the value of key
	 * 
	 * @param keyName
	 * @return Map values
	 */
	/*
	 * Author: A-7626 Date Modified :17-05-2018
	 */
	public String data(String keyName) {
		
		try {
			
			if(keyName.contains("prop~"))
				
				
			{
			
				String keyVal=keyName.split("~")[1].toString();
				
				return(getPropertyValue(globalVarPath,keyVal));
				
				
			}
			
			else if(keyName.contains("val~"))
			{
				
				return(keyName.split("~")[1].toString());
			}
			else
			{
			return (String) map.get(keyName);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


	/*
	 * Author: A-7271 Date Modified :30-05-2018
	 */
	public enum applications {
		iCargo, BE, MESX, iMail, AVI
	}

	/**
	 * Description... Takes environment details and returns username, password
	 * and URL from Global Varialble properties file
	 * 
	 * @param keyName
	 * @return Map values
	 */
	public String[] getApplicationParams(String appln) {
		String[] params = new String[3];
		switch (applications.valueOf(appln)) {

		case iCargo:
			params[0] = getPropertyValue(globalVarPath, "iCargoURL");
			params[1] = getPropertyValue(globalVarPath, "iCargoUN");
			params[2] = getPropertyValue(globalVarPath, "iCargoPWD");
			return params;

		case BE:
			params[0] = getPropertyValue(globalVarPath, "BEURL");
			params[1] = getPropertyValue(globalVarPath, "BEUN");
			params[2] = getPropertyValue(globalVarPath, "BEPWD");
			return params;

		case MESX:
			params[0] = getPropertyValue(globalVarPath, "MESWEBURL");
			params[1] = getPropertyValue(globalVarPath, "MESWEBUN");
			params[2] = getPropertyValue(globalVarPath, "MESWEBPWD");
			return params;

		case iMail:
			params[0] = getPropertyValue(globalVarPath, "iMailURL");
			params[1] = getPropertyValue(globalVarPath, "iMailUN");
			params[2] = getPropertyValue(globalVarPath, "iMailPWD");
			return params;

		case AVI:
			params[0] = getPropertyValue(globalVarPath, "AVIURL");
			params[1] = getPropertyValue(globalVarPath, "AVIUN");
			params[2] = getPropertyValue(globalVarPath, "AVIPWD");

		}
		return params;

	}
	// for switch to default frame argument is "default"
	// for switch to a particular frame arguments are "frameLocator", sheetName
	// name
	// for switch to content frame arguments are "contentFrame" and ScreenId ex
	// "OPR016"

	/**
	 * Description... for switch to default frame argument is "default" for
	 * switch to a particular frame arguments are "frameLocator", sheetName name
	 * for switch to content frame arguments are "contentFrame" and ScreenId ex
	 * "OPR016"
	 * 
	 * @param frameName
	 *            as var args
	 */
	public void switchToFrame(String... frameName) {
		wait = new WebDriverWait(driver, 60);
		waitForSync(2);
		try {
			String fName;
			if (frameName[0].equalsIgnoreCase("frameLocator")) {
				fName = xls_Read.getCellValue(frameName[1], "frame_Screen;name");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(fName));
			} else if (frameName[0].equalsIgnoreCase("default"))
				driver.switchTo().defaultContent();
			else if (frameName[0].equalsIgnoreCase("contentFrame")) {
				fName = "iCargoContentFrame" + frameName[1];
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(fName));
			}

		} catch (Exception e) {
			System.out.println("Could not Switch To Frame " + frameName[0]);
			writeExtent("Could not Switch To Frame " + frameName[0], "FAIL");
			Assert.assertFalse(true, "Could not Switch To Frame " + frameName[0]);
		}

	}

	public enum alertOps {
		Accept, Dismiss, GetText, CompareText
	}

	/**
	 * Description... Accepts/Dismiss or return Alert Text
	 * 
	 * @param AlertOperations
	 *            Accept/Dismiss/GetText
	 * @param ScreenName
	 *            ScreenName from application
	 * @return Alert Text
	 * @throws IOException
	 */
	// handle javascript alerts and perform operations as Accept, Dismiss,Get
	// Text and store in property file
	public String switchToAlert(String alertOperations, String ScreenName) throws IOException {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		try {

			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
			switch (alertOps.valueOf(alertOperations)) {
			case Accept:

				alert.accept();
				writeExtent("Pass", "Accepted Alert on " + ScreenName + " Screen");
				return null;
			case Dismiss:
				alert.dismiss();
				writeExtent("Pass", "Dismissed Alert on " + ScreenName + " Screen");
				return null;

			case GetText:
				alertText = alert.getText();
				writeExtent("Pass", "Alert Text is " + alertText + " On " + ScreenName + " Screen");
				return alertText;

			}
		} catch (UnhandledAlertException e) {

			writeExtent("Pass", "Failed to handle Alert with text " + alertText + " On " + ScreenName + " Screen");

		}
		return alertText;
	}

	/**
	 * Description... Selects any option from the dropdown
	 * 
	 * @param sheetName
	 *            xpath sheetName
	 * @param locator
	 *            locator in xpath sheet
	 * @param option
	 *            option to be selected in dropdown
	 * @param eleName
	 *            element name for reporting
	 * @param selectBy
	 *            value/index/visible text
	 * @param index
	 *            index as integer 0/1/2...
	 */
	// select the option in a dropdown if it is not selected
	public void selectValueInDropdown(String sheetName, String locator, String option, String eleName,
			String selectBy) {
		try {
			String locname = locator.split(";")[1];
			if (locname.equals("name"))
				ele = driver.findElement(By.name(xls_Read.getCellValue(sheetName, locator)));
			else if (locname.equals("xpath"))
				ele = driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, locator)));
			else if (locname.equals("id"))
				ele = driver.findElement(By.id(xls_Read.getCellValue(sheetName, locator)));
			Select select = new Select(ele);
			switch (selectBy) {
			case "Value": {
				String actopt = select.getFirstSelectedOption().getText();
				if (!actopt.equalsIgnoreCase(option))
					select.selectByValue(option);

			}
				break;
			case "VisibleText": {
				String actopt = select.getFirstSelectedOption().getText();
				if (!actopt.equalsIgnoreCase(option))
					select.selectByVisibleText(option);

			}
				break;
			case "Index": {
				int index = Integer.parseInt(option);
				String actopt = select.getFirstSelectedOption().getText();
				if (!actopt.equalsIgnoreCase(option))
					select.selectByIndex(index);

			}
				break;

			}
			writeExtent("Pass", "Entered " + option + " as " + eleName + " on " + sheetName.split("_")[0] + " Screen");
			System.out.println("Entered " + option + " as " + eleName + " on " + sheetName.split("_")[0] + " Screen");

		} catch (Exception e) {
			System.out.println(
					"Could not enter " + option + " as " + eleName + " on " + sheetName.split("_")[0] + " Screen");
			writeExtent("Fail", "Could not enter " + " as " + eleName + " on " + sheetName.split("_")[0] + " Screen");
			Assert.assertFalse(true,
					"Could not enter " + " as " + eleName + " on " + sheetName.split("_")[0] + " Screen");

		}
	}

	/**
	 * Description... Defines case options for switchToAlert
	 * 
	 * @author A-7688
	 *
	 */

	/**
	 * Description... Sets Property value in the project path
	 * 
	 * @param Key
	 * @param Value
	 * @param s3
	 *            Relative path in the project
	 */
	/*
	 * Author : A-7688,A-7290,A-7626 Date Modified : 7/6/2017 Purpose : Set
	 * value for Key in any property file whose path is given as s3 under
	 * project folder
	 */
	public void setPropertyValue(String key, String value, String s3) {

		Properties prop = new Properties();
		String s2 = System.getProperty("user.dir");
		String path = s2 + s3;
		FileOutputStream output;
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(path);
			prop.load(fileIn);
			output = new FileOutputStream(path);
			prop.setProperty(key, value);
			prop.store(output, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * * Description... Gets the property value for the key from the property
	 * file
	 * 
	 * @param s3
	 * @param Key
	 * @return Value of the key
	 */
	/*
	 * Author : A-7688,A-7290,A-7626 Date Modified : 7/6/2017 Purpose :Takes
	 * value for Key from the file path in S3 and returns it as a string
	 */
	public static String getPropertyValue(String s3, String Key) {
		Properties prop = new Properties();
		String s2 = System.getProperty("user.dir");
		String path = s2 + s3;
		try {
			prop.load(new FileInputStream(path));
		} catch (Exception e) {

		}
		String value = prop.getProperty(Key);
		return value;
	}

	/**
	 * * Description... Explicitly waits for a WebElement for the wait time
	 * mentioned in GlobalVariable.properties
	 * 
	 * @param locator
	 */
	/*
	 * Author : A-7290 Date Modified : 7/6/2017 Purpose :Waits till the element
	 * is visible on page (Timeout is given in GlobalVariable.properties file as
	 * "waitTime") takes Locator as Argument
	 */

	public void waitTillOverlayDisappear(By locator) {
		int i = 0;

		String waitTime = Excel.getPropertyValue("waitTime");
		int waitint = Integer.parseInt(waitTime);
		while (i < waitint) {
			try {

				WebElement element = driver.findElement(locator);
				if (element != null) {

					System.out.println("waited for " + i);
					break;
				}
				waitForSync(1);
				i++;

			} catch (Exception e) {

				i++;
				System.out.println("waited for " + i);
			}
		}
	}

	/**
	 * Description... Explicitly waits for a WebElement for the wait time
	 * mentioned in GlobalVariable.properties
	 * 
	 * @param ele
	 *            WebElement
	 */
	/*
	 * Author : A-7688 Date Modified : 7/6/2017 Purpose : Waits till the element
	 * is visible on page (Timeout is given in GlobalVariable.properties file as
	 * "waitTime") takes WebElement as Argument
	 */

	public void waitTillOverlayDisappear(WebElement ele) {
		try {
			String waitTime = Excel.getPropertyValue("waitTime");
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(ele));

		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Description...Called by getRandomString for Generating random string of
	 * length 10
	 * 
	 * @return
	 */
	/*
	 * Author : Raghothma Date Modified : 7/6/2017 Purpose : returns random
	 * number as int data type
	 */

	public int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;

		}

	}

	/**
	 * Description...Generates a random String of length 10
	 * 
	 * @return
	 */
	/*
	 * Author : Raghothma Date Modified : 7/6/2017 Purpose : returns random
	 * string of length returned by getRandomNumber
	 */

	public String getRandomString() {
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOMSTRINGLENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();

	}

	/**
	 * Description... Closes all instances opened by Selenium
	 */
	/*
	 * Author : A-7626 Date Modified : 7/6/2017 Purpose :Close all open browser
	 * instances opened by Selenium and end the session
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			driver.quit();

		}
	}

	/**
	 * Description... Clicks links, button, radio button, check box
	 * 
	 * @param sheetName
	 *            Xpath Sheetname
	 * @param locator
	 *            Xpath Locator name
	 * @param eleName
	 *            used for reporting purpose. example OK Button
	 * @param ScreenName
	 *            used for reporting purpose. example Login Page
	 * @throws InterruptedException
	 */
	// click a webelement link, check box, button, radio button
	public void clickWebElement(String sheetName, String locator, String eleName, String ScreenName)
			throws InterruptedException {

		try {

			By element = getElement(sheetName, locator);
			javaScriptToclickElement(element, eleName, ScreenName);
		} catch (Exception e) {
			System.out.println("Could not click on " + eleName + " On " + ScreenName + " Page");
			writeExtent("Fail", "Could not click on " + eleName + " On " + ScreenName + " Page");
			Assert.assertFalse(true, "Could not click on " + eleName + " On " + ScreenName + " Page");
		}
	}

	public By getElement(String sheetName, String object) {

		try {

			By element = null;
			String locatorType = null;
			String locatorName = null;
			boolean deskTopAppln = false;

			locatorType = object.split(";")[1].toString();
			locatorName = xls_Read.getCellValue(sheetName, object);
			// Finding the element
			switch (locatorType) {
			case "xpath":
				element = By.xpath(locatorName);
				break;
			case "name":
				element = By.name(locatorName);
				break;
			case "id":
				element = By.id(locatorName);
				break;
			case "linkText":
				element = By.linkText(locatorName);
				break;
			case "partialLinkText":
				element = By.partialLinkText(locatorName);
				break;
			case "tagname":
				element = By.tagName(locatorName);
				break;
			case "cssSelector":
				element = By.cssSelector(locatorName);
				break;
			case "className":
				element = By.className(locatorName);
				break;
			}
			/***** waitTillOverlayDisappear(element, driver); ***/

			waitTillOverlayDisappear(element);
			return element;
		}

		catch (Exception e) {
			return null;
		}

	}

	/**
	 * Description...Multiplies SyncTime from GlobalVariable.properties to the
	 * number of seconds sent as argument
	 * 
	 * @param i
	 *            seconds to wait
	 */
	// wait for sync
	public void waitForSync(int i) {
		try {
			String path = customFunction.proppath;
			int syncTime = Integer.parseInt(getPropertyValue(path, "SyncTime"));
			int j = i * 1000 * syncTime;
			Thread.sleep(j);
			System.out.println("Waited for " + (i * syncTime) + " seconds...");
		} catch (Exception e) {

		}
	}

	/**
	 * Description...switch to parent/child window. Or stores the window
	 * depending on the argumnet passed
	 * 
	 * @param storeParent/child/getParent
	 */
	// stores/switch to a window depending on the argument passed
	public void switchToWindow(String window) throws Exception {
		waitForSync(2);
		if (window.equals("storeParent")) {
			String doubleWindow = driver.getWindowHandle();
			parentWindow = doubleWindow;
		}

		else if (window.equals("child")) {
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));

			Set<String> winHandle = driver.getWindowHandles();
			winHandle.remove(parentWindow);
			String winHandleNew = winHandle.toString();
			String winHandleFinal = winHandleNew.replaceAll("\\[", "").replaceAll("\\]", "");
			driver.switchTo().window(winHandleFinal);
			customFunction.clickCertificateError();

		} else if (window.equals("child_BE")) {

			Set<String> windowhandle = driver.getWindowHandles();
			Iterator it = windowhandle.iterator();
			String parentWindow = (String) it.next();
			driver.switchTo().window(parentWindow).close();
			String childWindow = (String) it.next();

			driver.switchTo().window(childWindow);

		} else if (window.equals("getParent"))
			driver.switchTo().window(parentWindow);

		else if (window.equals("closeParent"))
			driver.switchTo().window(parentWindow).close();

	}

	/**
	 * Description... Clicks the element if its available else doesn't break the
	 * flow
	 * 
	 * @param sheetName
	 *            Element Xpath sheetname
	 * @param locator
	 *            Element name in Xpath Sheet
	 * @throws Exception
	 */
	// click the element if it is displayed, doesn't through an exception
	public void clickIfDisplayed(String sheetName, String locator) throws Exception {
		try {

			driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, locator))).click();

		} catch (Exception e) {

			System.out.println("Not clicked on the object with locator " + locator + " in sheet " + sheetName);

		}
	}

	/**
	 * Description... enter text in a text box/ text area
	 * 
	 * @param sheetName
	 *            Xpath Sheetname
	 * @param locator
	 *            Xpath Locator name
	 * @param eleName
	 *            used for reporting purpose. example OK Button
	 * @param ScreenName
	 *            used for reporting purpose. example Login Page
	 * @throws InterruptedException
	 */
	/*
	 * Author : A-7688 Date Modified : 11/8/2017 Purpose : Enters Value in a
	 * WebElement, takes Xpath SheetName, Locator and element name as argument.
	 * Xpath must end with "_LocatorName"
	 */
	public void enterValueInTextbox(String sheetName, String locator, String value, String eleName, String ScreenName)
			throws InterruptedException {
     try {
           By element=getElement(sheetName,locator);           
           driver.findElement(element).clear();
           driver.findElement(element).sendKeys(value);		
			writeExtent("Pass", "Entered " + value + " as " + eleName + " on " + ScreenName + " Page");
			System.out.println("Entered " + value + " as " + eleName + " on " + ScreenName + " Page");

		} catch (Exception e) {
			System.out.println("Could not enter " + value + " as " + eleName + " on " + ScreenName + " Page");
			writeExtent("Fail", "Could not enter " + " as " + eleName + " on " + ScreenName + " Page");
			Assert.assertFalse(true, "Could not enter " + " as " + eleName + " on " + ScreenName + " Page");
		}

	}

	/**
	 * Description... Compares 2 boolean values and log the result in the
	 * report.
	 * 
	 * @param expValue
	 * @param actValue
	 * @param testSteps
	 * @param pageName
	 * @param ValueName
	 */
	/*
	 * Author : A-7688 Date Modified : 11/8/2017 Purpose : Verifies a text on a
	 * page . Argument needs to be sent from the Calling method are expValue,
	 * actValue, testSteps, pageName, ValueName
	 */

	public void verifyValueOnPage(boolean expValue, boolean actValue, String testSteps, String pageName,
			String ValueName) {

		if (actValue == expValue) {

			counter = counter + 1;
			excelreadwrite.insertData(DriverSetup.testName,

					commonUtility.getcurrentDateTime() + "_" + String.valueOf(counter),
					"Verify the Value " + ValueName + " On " + pageName + " Page ",
					"Expected Value is : " + expValue + "\nActual Value is : " + actValue, testSteps, true, "Yes",
					"Value " + ValueName + " on Page " + pageName + " Sucessfully Verified ",
					"Value" + ValueName + "On Page" + pageName + " Sucessfully Verified");
			writeExtent("Pass", "Value " + ValueName + " On " + pageName + "Page Sucessfully Verified");

		} else {

			Status = false;
			counter = counter + 1;
			excelreadwrite.insertFailedData(DriverSetup.testName,
					commonUtility.getcurrentDateTime() + "_" + String.valueOf(counter),
					"Verify the Value " + ValueName + " On " + pageName + " page ",
					"Expected Value is : " + expValue + " \nActual Value is : " + actValue, testSteps, false, "",
					"Failed to Verify " + ValueName + " On " + pageName + " Page ",
					"Value On " + pageName + "Page Sucessfully Verified");

			writeExtent("Fail", "Failed to Verify " + ValueName + " On " + pageName + " Page ");

		}

	}

	/**
	 * Description...Compares actValue and expValue using equals method and log
	 * the result
	 * 
	 * @param actValue
	 * @param expValue
	 * @param testSteps
	 * @param screenName
	 * @param functinalityName
	 * @throws InterruptedException
	 */
	/*
	 * Author : A-7688 Date Modified : 11/8/2017 Purpose : Verifies a text on a
	 * page . Argument needs to be sent from the Calling method are expValue,
	 * actValue, testSteps, pageName, functinalityName
	 */
	public void verifyValueOnPage(String actValue, String expValue, String testSteps, String screenName,
			String functinalityName) throws InterruptedException {
		waitForSync(2);
		System.out.println("expected is : " + expValue + "\nactual is : " + actValue);
		if (actValue.equals(expValue)) {
			customFunction.onPassUpdate(screenName, expValue, actValue, functinalityName, testSteps);

		} else {
			Status = false;
			customFunction.onFailUpdate(screenName, expValue, actValue, functinalityName, testSteps);
		}
	}

	

	/**
	 * Description... Click an element using javascript. This method is
	 * overloaded. Element has to be sent from the calling method
	 * 
	 * @param ele
	 * @param elename
	 * @param ScreenName
	 */
	// overloaded method to click an element using javascript
	public void javaScriptToclickElement(WebElement ele, String elename, String ScreenName) {

		try {
			waitForSync(2);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			writeExtent("Pass", "Clicked on " + eleName + " On " + ScreenName + " Page");
			System.out.println("Clicked on " + elename + " On " + ScreenName + " Page");

		} catch (Exception e) {
			System.out.println("Could not click on element " + elename);
			writeExtent("Fail", "Could not click on " + elename + " On " + ScreenName + " Page");
			Assert.assertFalse(true, "Could not click on " + elename + " On " + ScreenName + " Page");
		}

	}

	public void javaScriptToclickElement(By ele, String elename, String ScreenName) {
		WebElement element = driver.findElement(ele);
		waitTillOverlayDisappear(element);
		try {
			waitForSync(2);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			writeExtent("Pass", "Clicked on " + elename + " On " + ScreenName + " Page");
			System.out.println("Clicked on " + elename + " On " + ScreenName + " Page");

		} catch (Exception e) {
			System.out.println("Could not click on element " + elename);
			writeExtent("Fail", "Could not click on " + elename + " On " + ScreenName + " Page");
			Assert.assertFalse(true, "Could not click on " + elename + " On " + ScreenName + " Page");
		}

	}

	/**
	 * Description... Changes the date format from dd/MM/yy to dd-MMM-yyyy
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	// change the date format
	public String changeDateFormat(String date) throws ParseException, java.text.ParseException {
		String newDateString;
		SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		Date startDate;
		startDate = df.parse(date);
		newDateString = df1.format(startDate);
		return newDateString;

	}

	/**
	 * Description... This method is used to tell from which file and sheet Test
	 * data should be read. It is configured in test case file.
	 * 
	 * @param table
	 * @param sheet
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public String[] getTestDataFileDetails(String table, String sheet) throws IOException, InvalidFormatException {
		String tcFileName = System.getProperty("user.dir") + commonUtility.getPropertiesConfigValue("testCaseFilePath");
		int startNm = startRowNum(tcFileName, table, sheet);

		String fileName = Excel.getCellValue(tcFileName, sheet, startNm, 1);
		String sheetName = Excel.getCellValue(tcFileName, sheet, startNm, 2);
		String TagName = Excel.getCellValue(tcFileName, sheet, startNm, 3);
		String[] fileDetails = { fileName, sheetName, TagName };
		return fileDetails;
	}

	/**
	 * Description... Used by buildMapFromXls method for getting start row
	 * number for a test case from the datasheet
	 * 
	 * @param tcFileName
	 *            Test case file name
	 * @param str
	 *            Test case name
	 * @param sheetName
	 *            Data sheet name
	 * @return start row number
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static int startRowNum(String tcFileName, String str, String sheetName)
			throws IOException, InvalidFormatException {
		String path = tcFileName;
		FileInputStream fileInputStream = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fileInputStream);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> rows = sheet.rowIterator();

		int rowIndex = -1;

		Row row = null;

		ArrayList<Integer> rowNum = new ArrayList<Integer>();

		String rowNums = "";
		while (rows.hasNext()) {
			row = rows.next();
			for (Cell cell : row) {

				if (cell.getRichStringCellValue().toString().equals(str)) {

					rowIndex = row.getRowNum();
					rowNum.add(rowIndex);
				}
			}

		}

		// extracting

		rowNums = rowNum.get(0).toString();

		int startrow = Integer.parseInt(rowNums);

		return startrow;

	}

	/**
	 * Description... commonly used for reading xpaths from the xpath sheetname
	 * 
	 * @param cell
	 *            the cell value as object
	 * @return
	 */
	private static Object getCellValue(Cell cell) {
		HSSFCell hssfCell = (HSSFCell) cell;
		if (XSSFCell.CELL_TYPE_NUMERIC == hssfCell.getCellType()) {
			DecimalFormat df = new DecimalFormat("#.");
			String numeric = df.format(cell.getNumericCellValue());
			numeric = numeric + "";
			String[] strArray = (numeric.replace(".", "-")).split("-");
			if (strArray.length > 1) {
				if ((strArray[1].replace("0", "")).trim().length() == 0) {
					numeric = strArray[0];
				}
			}
			return numeric;

		} else if (XSSFCell.CELL_TYPE_STRING == hssfCell.getCellType()) {
			return hssfCell.getStringCellValue();
		} else if (XSSFCell.CELL_TYPE_NUMERIC == hssfCell.getCellType()) {
			return hssfCell.getNumericCellValue();
		} else if (XSSFCell.CELL_TYPE_BOOLEAN == hssfCell.getCellType()) {
			return hssfCell.getBooleanCellValue();
		} else if (XSSFCell.CELL_TYPE_BLANK == hssfCell.getCellType()) {
			return "";
		}
		return "";
	}

	/**
	 * Description... Checks whether an element is displayed and logs the result
	 * in custom report
	 * 
	 * @param sheetName
	 * @param eleXpath
	 * @param testSteps
	 * @param screenName
	 * @param eleName
	 * @throws InterruptedException
	 */
	/*
	 * Author : A-7290 Date Modified : 18/8/2017 Purpose : Common Method to
	 * Verify Element displayed in UI page or not
	 */
	public void verifyElementDisplayed(String sheetName, String eleXpath, String testSteps, String screenName,
			String eleName) throws InterruptedException {

		if (driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, eleXpath))).isDisplayed()) {
			customFunction.onPassUpdate(screenName, eleName + " is Displayed", eleName + " is Displayed",
					eleName + " is Displayed", testSteps);

		} else {
			Status = false;
			customFunction.onFailUpdate(screenName, eleName + " is Displayed", eleName + " is Not Displayed",
					eleName + " is Displayed", testSteps);
		}

	}

	/**
	 * Description... Collects the element text which is defined as innertext in
	 * HTML Tree
	 * 
	 * @param sheetName
	 * @param locator
	 * @param eleName
	 * @param pageName
	 * @return Text of an element
	 * @throws InterruptedException
	 */
	/*
	 * Author : A-7688 Date Modified : 29/08/2017 Purpose : Generic method to
	 * get text from a webelement
	 */
	public String getElementText(String sheetName, String locator, String eleName, String pageName)
			throws InterruptedException {

		waitForSync(2);
		try {
			waitTillOverlayDisappear(By.xpath(xls_Read.getCellValue(sheetName, locator)));
			String text = driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, locator))).getText();

			writeExtent("Pass", "Returned text of element " + eleName + " : " + text);
			return text;
		} catch (Exception e) {
			System.out.println("Could not return text from element " + eleName + " on " + pageName);
			writeExtent("Fail", "Could not return text from element " + eleName + " on " + pageName);
			return "";
		}

	}

	/**
	 * Description... Collects the element text using Javascript
	 * 
	 * @param sheetName
	 * @param locator
	 * @param eleName
	 * @param ScreenName
	 * @return Text of an element
	 */
	/*
	 * Author : A-7688 Date Modified : 29/08/2017 Purpose : Generic method to
	 * get text from a webelement using JavaScript
	 */
	public String getTextUsingJavascript(String sheetName, String locator, String eleName, String ScreenName) {
		String actValue = "";

		try {

			ele = driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, locator)));
			actValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", ele);

			System.out.println("Returned text of element " + eleName + " : " + actValue);
			writeExtent("Pass", "Returned text of element " + eleName + " : " + actValue);
			return actValue;
		}

		catch (Exception e) {

			e.printStackTrace();
			System.out.println("Could not get text of element " + eleName + " on " + ScreenName + "Screen");
			writeExtent("Fail", "Could not get text of element " + eleName + " on " + ScreenName + "Screen");
			return actValue;
		}

	}

	/**
	 * Description... Collects any attribute from a webelement and returns its
	 * value as String
	 * 
	 * @param sheetName
	 * @param locator
	 * @param eleName
	 * @param atrbName
	 *            Attribute Name whose value needs to be collected
	 * @param pageName
	 * @return Attribute Value
	 */
	/*
	 * Author : A-7688 Date Modified : 29/08/2017 Purpose : Generic method to
	 * get attribute from a webelement
	 */
	public String getAttributeWebElement(String sheetName, String locator, String eleName, String atrbName,
			String pageName) {
		try {

			if (atrbName.equals("title")) {
				String title = driver.getTitle();
				return title;
			} else {
				waitTillOverlayDisappear(By.xpath(xls_Read.getCellValue(sheetName, locator)));
				String text = driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, locator)))
						.getAttribute(atrbName);
				return text;
			}
		} catch (Exception e) {
			System.out.println("Could not return text from element " + eleName + " on " + pageName);
			writeExtent("Fail", "Could not return text from element " + eleName + " on " + pageName);
			return "";
		}

	}

	/**
	 * Description... Finds the element on the xpath sent from the calling
	 * method
	 * 
	 * @param xpath
	 * @param eleName
	 * @param ScreenName
	 * @return
	 */
	/*
	 * Author : A-7688 Date Modified : 6/09/2017 Purpose : Generic method to
	 * find element using dynamic xpath
	 */

	public WebElement findDynamicXpathElement(String xpath, String eleName, String ScreenName) {

		try {
			waitForSync(2);
			ele = driver.findElement(By.xpath(xpath));

			System.out.println("Returned " + eleName + " Sucessfully  On " + ScreenName + " Page");
			return ele;

		} catch (Exception e) {

			System.out.println("Failed to find element " + eleName + " On " + ScreenName + " Page");
			writeExtent("Fail", "Failed to find element " + eleName + " On " + ScreenName + " Page");
			return ele;
		}
	}

	/**
	 * Description... Finds the element on the xpath sent from the calling
	 * method
	 * 
	 * @param xpath
	 * @param eleName
	 * @param ScreenName
	 * @return
	 */
	public WebElement findDynamicXpathElement(String xpath, String sheetName, String eleName, String ScreenName) {

		try {
			waitForSync(2);
			ele = driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, xpath)));
			test.log(LogStatus.PASS, "Element returned sucessfully" + eleName + " On " + ScreenName + " Page");
			System.out.println("Element returned sucessfully " + eleName + " On " + ScreenName + " Page");
			return ele;

		} catch (Exception e) {

			System.out.println("Could not find element " + eleName + " On " + ScreenName + " Page");
			test.log(LogStatus.FAIL, "Could not find element " + eleName + " On " + ScreenName + " Page");
			Assert.assertFalse(true, "Could not find element " + eleName + " On " + ScreenName + " Page");
			return ele;
		}
	}

	/**
	 * Description... If an element xpath results in more than one
	 * element,collects the list of all such element and click the element which
	 * is displayed
	 * 
	 * @param sheetName
	 * @param locator
	 * @param eleName
	 * @param Screenname
	 * @throws InterruptedException
	 */
	/*
	 * Author : A-7626 Y Date Modified : 08/9/2017 Purpose : Clicks on a
	 * WebElement based on the availabity of the element(Is displayed), takes
	 * Xpath SheetName, Locator and element name as argument. Xpath must end
	 * with "_LocatorName"
	 */
	public void checkAndClickAvailablEle(String sheetName, String locator, String eleName, String Screenname)
			throws InterruptedException

	{

		try {
			waitForSync(2);
			String[] myLocator = locator.split(";");
			String templocator = myLocator[myLocator.length - 1];

			switch (templocator) {
			case "xpath":
				clickOnAvailableEle(driver.findElements(By.xpath(xls_Read.getCellValue(sheetName, locator))));
				break;
			case "id":
				clickOnAvailableEle(driver.findElements(By.id(xls_Read.getCellValue(sheetName, locator))));
				break;
			case "name":
				clickOnAvailableEle(driver.findElements(By.name(xls_Read.getCellValue(sheetName, locator))));
				break;
			case "linkText":
				clickOnAvailableEle(driver.findElements(By.linkText(xls_Read.getCellValue(sheetName, locator))));
				break;
			case "cssSelector":
				clickOnAvailableEle(driver.findElements(By.cssSelector(xls_Read.getCellValue(sheetName, locator))));
				break;
			case "tagName":
				clickOnAvailableEle(driver.findElements(By.tagName(xls_Read.getCellValue(sheetName, locator))));
				break;
			case "className":
				clickOnAvailableEle(driver.findElements(By.className(xls_Read.getCellValue(sheetName, locator))));
				break;
			case "partialLinkText":
				clickOnAvailableEle(driver.findElements(By.partialLinkText(xls_Read.getCellValue(sheetName, locator))));
				break;

			}
			writeExtent("Pass", "Clicked on element " + eleName);

		} catch (Exception e) {

			System.out.println("Could not click on element " + eleName);
			writeExtent("Fail", "Could not click on element " + eleName);
			Assert.assertFalse(true, "Could not click on element" + eleName);

		}
	}

	/**
	 * Description... called from checkAndClickAvailablEle method. clicks if the
	 * element is available
	 * 
	 * @param sheetName
	 * @param locator
	 * @param eleName
	 * @param Screenname
	 * @throws InterruptedException
	 */
	// called from checkAndClickAvailablEle method. clicks if the element is
	// available
	public void clickOnAvailableEle(List<WebElement> eles) {
		if (eles.size() > 0) {
			for (WebElement ele : eles) {

				if (ele.isDisplayed()) {
					ele.click();
					break;
				}
			}
		} else {
			writeExtent("Fail", "No Such element " + ele);
		}
	}

	/**
	 * Description... Checks whether an element is displayed and logs the result
	 * in custom report
	 * 
	 * @param sheetName
	 * @param eleXpath
	 * @param testSteps
	 * @param screenName
	 * @param eleName
	 * @throws InterruptedException
	 */
	// verify element is displayed overloaded method. takes
	// webelement,testSteps,screenName,eleName as argument
	public void verifyElementDisplayed(WebElement ele, String testSteps, String screenName, String eleName)
			throws InterruptedException {

		if (ele.isDisplayed()) {
			customFunction.onPassUpdate(screenName, eleName + " is Displayed", eleName + " is Displayed",
					eleName + " is Displayed", testSteps);
		} else {
			Status = false;
			customFunction.onFailUpdate(screenName, eleName + " is Displayed", eleName + " is Not Displayed",
					eleName + " is Displayed", testSteps);
		}

	}

	public void onPassUpdate(String screenName, String expText, String actText, String functinalityName,
			String testSteps) {
		try {
			counter = counter + 1;
			excelreadwrite.insertData(DriverSetup.testName,

					commonUtility.getcurrentDateTime() + "_" + String.valueOf(counter),
					"Verify the functionality " + functinalityName + " On " + screenName + " Screen", testSteps,
					"Expected Value is : " + expText + " \nActual value is : " + actText, true, "No", actText, expText);
			test.log(LogStatus.PASS, "Successfully Verified " + expText + "On" + screenName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFailUpdate(String screenName, String expText, String actText, String functinalityName,
			String testSteps) {
		counter = counter + 1;
		excelreadwrite.insertFailedData(DriverSetup.testName,
				commonUtility.getcurrentDateTime() + "_" + String.valueOf(counter),
				"Verify the functionality " + functinalityName + "On " + screenName + " Screen", testSteps,
				"Expected Value is : " + expText + " \nActual value is : " + actText, false, "", actText, expText);
		test.log(LogStatus.FAIL, "Failed to Verify " + expText);
		Assert.assertFalse(true, "Element is not found");

	}

	// click a webelement link, check box, button, radio button
	public void clickWebElement(WebElement ele, String eleName, String ScreenName) throws InterruptedException {
		waitForSync(1);
		waitTillOverlayDisappear(ele);
		try {
			ele.click();
			writeExtent("Pass", "Clicked on " + eleName + " On " + ScreenName + " Page");
			System.out.println("Clicked on " + eleName + " On " + ScreenName + " Page");

		} catch (Exception e) {
			System.out.println("Could not click on " + eleName + " On " + ScreenName + " Page");
			writeExtent("Fail", "Could not click on " + eleName + " On " + ScreenName + " Page");
			Assert.assertFalse(true, "Could not click on " + eleName + " On " + ScreenName + " Page");

		}
	}

	/**
	 * This method will set any parameter string to the system's clipboard.
	 * 
	 * @throws InterruptedException
	 */
	public void setClipboardData(String string) throws InterruptedException {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		waitForSync(2);
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public enum keyActions {
		TAB, ENTER, SCROLLDOWNMOUSE, DELETE, DOWN
	}

	/**
	 * Description...Performs any keyboard press key operations
	 * 
	 * @param key
	 *            as described in keyActions
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	// perform keyboard operations for pressing the keys
	public void keyPress(String key) throws AWTException, InterruptedException {
		waitForSync(1);
		String fieldValue = "";
		Robot robot = new Robot();

		switch (keyActions.valueOf(key)) {

		case TAB:
			robot.keyPress(KeyEvent.VK_TAB);
			System.out.println("pressed tab");
			break;
		case ENTER:
			robot.keyPress(KeyEvent.VK_ENTER);
			break;
		case DELETE:
			robot.keyPress(KeyEvent.VK_DELETE);
			break;
		case DOWN:
			robot.keyPress(KeyEvent.VK_DOWN);
			break;
		case SCROLLDOWNMOUSE:
			robot.mouseWheel(Integer.parseInt(fieldValue));
			break;
		}

	}

	/**
	 * Description...Perform keyboard operations for releasing the keys. Should
	 * be called after keyPress method
	 * 
	 * @param key
	 *            as described in keyActions
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	// perform keyboard operations for releasing the keys
	public void keyRelease(String key) throws AWTException, InterruptedException {
		waitForSync(1);
		String fieldValue = "";
		Robot robot = new Robot();

		switch (keyActions.valueOf(key)) {
		case TAB:
			robot.keyRelease(KeyEvent.VK_TAB);
			break;

		case ENTER:
			robot.keyRelease(KeyEvent.VK_ENTER);

			break;
		case DELETE:
			robot.keyRelease(KeyEvent.VK_DELETE);
			break;

		case DOWN:
			robot.keyRelease(KeyEvent.VK_DOWN);
			break;
		}

	}

	/**
	 * Description... Uploads the file. For Handling windows file upload pop up.
	 * 
	 * @param fileLocation
	 */
	// uploads file
	public void uploadFile(String fileLocation) {
		try {
			// Setting clipboard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			waitForSync(1);
			robot.keyPress(KeyEvent.VK_CONTROL);
			waitForSync(1);
			robot.keyPress(KeyEvent.VK_V);
			waitForSync(1);
			robot.keyRelease(KeyEvent.VK_V);
			waitForSync(1);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			waitForSync(1);
			robot.keyPress(KeyEvent.VK_ENTER);
			waitForSync(1);
			robot.keyRelease(KeyEvent.VK_ENTER);
			waitForSync(1);
		} catch (Exception exp) {
			System.out.println("Failed to Upload File " + fileLocation);
			writeExtent("Fail", "Failed to Upload File " + fileLocation);
			Assert.assertFalse(true, "Failed to Upload File " + fileLocation);
		}
	}

	/*
	 * Author : A-7688 Date Modified : 24/08/2017 * Purpose : Generic Method to
	 * check And Return Available Element
	 */
	public WebElement checkAndReturnAvailablEle(String sheetName, String locator, String eleName, String Screenname)
			throws InterruptedException

	{

		try {

			ele = returnAvailableEle(driver.findElements(By.xpath(xls_Read.getCellValue(sheetName, locator))));
			writeExtent("Pass", "returned element " + eleName);

		} catch (Exception e) {

			System.out.println("Could return element " + eleName);
			writeExtent("Fail", "Failed to return element " + eleName);
			Assert.assertFalse(true, "Failed to return element " + eleName);

		}
		return ele;
	}

	/*
	 * Author : A-7688 Date Modified : 24/08/2017 Flow : Open SetUP
	 * Page>>Login>>Go to B2BUI>>Load Profile>>Enter Flight and Passenger
	 * Details>>Click Search Button Purpose : Click Add to cart Button on Flight
	 * Search Page
	 */
	public WebElement returnAvailableEle(List<WebElement> eles) {
		if (eles.size() > 0) {
			for (WebElement ele : eles) {

				if (ele.isDisplayed()) {
					return ele;

				}
			}
		} else {
			writeExtent("Fail", "No Such element " + ele);
		}
		return null;
	}

	/**
	 * Description... Handles and Verifies the alert text
	 * 
	 * @param expAlertText
	 * @param testSteps
	 * @param pageName
	 * @param AlertText
	 * @throws InterruptedException
	 */
	/*
	 * Author : A-7688 Date Modified : 17/08/2017 Flow : Open URL>> Navigate as
	 * per test case flow>> if alert is present get Alert text and verify it
	 * Purpose : Generic Method to Verify Alert Text
	 */

	public void verifyAlertText(String expAlertText, String testSteps, String pageName, String AlertText,
			String currentTestName) throws InterruptedException {

		try {

			Alert alert = driver.switchTo().alert();
			String actAlertText = alert.getText();
			alert.accept();
			verifyValueOnPage(expAlertText, actAlertText, testSteps, pageName, AlertText);
		} catch (Exception e) {
			System.out.println("Could not find  " + expAlertText + " " + AlertText);
			writeExtent("Fail", "Could not find  " + expAlertText + " " + AlertText);
			Assert.assertFalse(true, "Could not find  " + expAlertText + " " + AlertText);
		}

	}

	/**
	 * Description... Verifies the file is downloaded successfully in the
	 * downloads folder
	 * 
	 * @param filePath
	 * @param fileName
	 * @param pageName
	 */
	/*
	 * Author : A-7688 Date Modified : 9/11/2017 flow : Download file on a Page,
	 * Verify file download purpose : Verify a file is downloaded
	 */
	public void verifyFileDownload(String filePath, String fileName, String pageName) {

		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		boolean fileFound = false;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				if (listOfFiles[i].toString().contains(fileName))
					fileFound = true;
				break;
			}
			if (fileFound == true)
				verifyValueOnPage(true, true, "1. Download file \n2. Verify file download", pageName, "File Download");
			else
				verifyValueOnPage(true, false, "1. Download file \n2. Verify file download", pageName, "File Download");

		}

	}

	/**
	 * Description...Delete file if present in a folder.
	 * 
	 * @param filePath
	 * @param fileName
	 * @author A-7688
	 */
	/*
	 * Author : A-7688 Date Modified : 9/11/2017 purpose : Delete file if
	 * present on a page
	 */
	public void deleteFileIfPresent(String filePath, String fileName) {
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {

				if (listOfFiles[i].toString().contains(fileName)) {
					writeExtent("Info", "Deleting file " + fileName + " from  " + filePath);
					System.out.println("Deleting file " + fileName + " from  " + filePath);
					listOfFiles[i].delete();
					break;
				}
			}
		}
	}

	/**
	 * Description... Performs mouse hover operation
	 * 
	 * @param sheetName
	 * @param xpath
	 */
	// to hover over an element
	public void hover(String sheetName, String xpath) {

		try {
			By element = By.xpath(xpath);
			waitTillOverlayDisappear(element);
			WebElement ele = driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, xpath)));
			(new Actions(driver)).moveToElement(ele).click().perform();
		}

		catch (Exception e) {
			System.out.println("Not hovered on the object with xpath : " + xpath);
		}
	}

	public enum Cookieops {
		Get, Add, Delete
	};

	/**
	 * Description... perform cookie related operations depending on parameter
	 * passed. All cookie operations should be given in Cookieops
	 * 
	 * @param parameter
	 *            Cookieops
	 * @throws InterruptedException
	 */
	// perform cookie related operations
	public void ManageCookies(String parameter) throws InterruptedException {
		Set<Cookie> cookies = driver.manage().getCookies();

		switch (Cookieops.valueOf(parameter)) {
		case Get:
			cookies = driver.manage().getCookies();
			setPropertyValue("Cookie", cookies.toString(), customFunction.proppath);
			break;
		case Add:
			for (Cookie a : cookies) {
				driver.manage().addCookie(a);
			}
			break;
		case Delete:
			driver.manage().deleteAllCookies();
			break;
		}

	}

	public enum Browserops {
		Refresh, Backwarkd, Forward, NavigateTo
	};

	/**
	 * Description... perfrom browser related operations depending on parameter
	 * passed. All browser operations should be given in Browserops
	 * 
	 * @param parameter
	 *            Browserops
	 * @throws InterruptedException
	 */
	// perfrom browser related operations
	public void browserOperations(String... parameter) throws InterruptedException {
		String url = parameter[1];
		switch (Browserops.valueOf(parameter[0])) {
		case Refresh:
			driver.navigate().refresh();
			break;
		case Backwarkd:
			driver.navigate().back();
			break;
		case Forward:
			driver.navigate().forward();
			break;
		case NavigateTo:
			driver.navigate().to(url);
			break;
		}
	}

	/**
	 * 
	 * Description... Checks for DetailedReport key in Global Variable
	 * properties. If DetailedReport=Yes then logs all the operations otherwise
	 * logs what is logged using test.log
	 * 
	 * @param Status
	 *            Pass/Fail
	 * @param Details
	 */
	public void writeExtent(String Status, String Details) {
		String reportDetails = getPropertyValue(customFunction.proppath, "DetailedReport");
		if (reportDetails.equalsIgnoreCase("Yes")) {
			if (Status.equals("Pass"))
				test.log(LogStatus.PASS, Details);
			else if (Status.equals("Fail"))
				test.log(LogStatus.FAIL, Details);
			else if (Status.equals("Info"))
				test.log(LogStatus.INFO, Details);
		}
	}

	public void selectTableRecord(String referenceVar, String locator, String sheetName, int loopCount) {

		try {

			String xpart1 = xls_Read.getCellValue("Generic_Elements", "table_selectEle;xpath") + referenceVar + "')]";
			String xpart2 = xls_Read.getCellValue(sheetName, locator);
			String dynXpath = xpart1 + xpart2;
			System.out.println(dynXpath);

			for (int i = 0; i < loopCount; i++) {
				try {
					new Robot().mouseWheel(2);
					driver.findElement(By.xpath(dynXpath)).click();
					break;
				}

				catch (ElementNotVisibleException e) {
					new Robot().mouseWheel(2);
					System.out.println("found at " + (i + 1) + "times");
					waitForSync(1);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Description... Selects the check box in a table in the required row where
	 * depending on the primary key.
	 * 
	 * @param referenceVar
	 * @param locator
	 * @param sheetName
	 * @param loopCount
	 */

	public void selectTableRecord(String referenceVar, String sheetName, String locator, String locatorEle,
			int loopCount) {

		try {
			boolean flag = false;
			int row = 0;
			List<WebElement> rows = driver.findElements(By.xpath(xls_Read.getCellValue(sheetName, locator)));
			locatorEle = xls_Read.getCellValue(sheetName, locatorEle);

			{
				for (int i = 0; i <= rows.size(); i++) {
					System.out.println("i= " + i);

					if (rows.get(i).getText().toLowerCase().replace(" ", "")
							.contains(referenceVar.toLowerCase().replace(" ", ""))) {

						flag = true;

					}

					if (flag) {
						row = i;
						break;
					}
				}

				String dynXpath = "(" + locatorEle + ")[" + row + "]";
				for (int i = 0; i < loopCount; i++) {
					try {
						new Robot().mouseWheel(2);
						driver.findElement(By.xpath(dynXpath)).click();
						break;
					}

					catch (ElementNotVisibleException e) {
						new Robot().mouseWheel(2);
						System.out.println("found at " + (i + 1) + "times");
						waitForSync(1);
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Description... Clears the text in textbox/ textarea
	 * 
	 * @param sheetName
	 * @param locator
	 * @param eleName
	 * @param ScreenName
	 */
	public void clearText(String sheetName, String locator, String eleName, String ScreenName) {
		try {
			String[] myLocator = locator.split(";");
			String templocator = myLocator[myLocator.length - 1];
			switch (templocator) {
			case "xpath":
				waitTillOverlayDisappear(By.xpath(xls_Read.getCellValue(sheetName, locator)));
				driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, locator))).clear();

				break;
			case "id":
				waitTillOverlayDisappear(By.id(xls_Read.getCellValue(sheetName, locator)));
				driver.findElement(By.id(xls_Read.getCellValue(sheetName, locator))).clear();

				break;
			case "name":
				waitTillOverlayDisappear(By.name(xls_Read.getCellValue(sheetName, locator)));
				driver.findElement(By.name(xls_Read.getCellValue(sheetName, locator))).clear();

				break;
			case "linkText":
				waitTillOverlayDisappear(By.linkText(xls_Read.getCellValue(sheetName, locator)));
				driver.findElement(By.linkText(xls_Read.getCellValue(sheetName, locator))).clear();

				break;
			case "cssSelector":
				waitTillOverlayDisappear(By.cssSelector(xls_Read.getCellValue(sheetName, locator)));
				driver.findElement(By.cssSelector(xls_Read.getCellValue(sheetName, locator))).clear();

				break;
			case "tagName":
				waitTillOverlayDisappear(By.tagName(xls_Read.getCellValue(sheetName, locator)));
				driver.findElement(By.tagName(xls_Read.getCellValue(sheetName, locator))).clear();

				break;
			case "className":
				waitTillOverlayDisappear(By.className(xls_Read.getCellValue(sheetName, locator)));
				driver.findElement(By.className(xls_Read.getCellValue(sheetName, locator))).clear();

				break;
			case "partialLinkText":
				waitTillOverlayDisappear(By.partialLinkText(xls_Read.getCellValue(sheetName, locator)));
				driver.findElement(By.partialLinkText(xls_Read.getCellValue(sheetName, locator))).clear();

				break;

			}
			waitForSync(1);
			writeExtent("Pass", "Cleared " + eleName + " on " + ScreenName + " Page");
			System.out.println("Cleared " + eleName + " on " + ScreenName + " Page");

		} catch (Exception e) {
			System.out.println("Could not clear " + eleName + " on " + ScreenName + " Page");
			writeExtent("Fail", "Could not clear " + eleName + " on " + ScreenName + " Page");
			Assert.assertFalse(true, "Could not enter " + " as " + eleName + " on " + ScreenName + " Page");
		}

	}

	/**
	 * Description... Check a check box/radio button if not checked
	 * 
	 * @param sheetName
	 * @param locator
	 * @param eleName
	 * @param ScreenName
	 */
	public void checkIfUnchecked(String sheetName, String locator, String eleName, String ScreenName) {
		try {
			String[] myLocator = locator.split(";");
			String templocator = myLocator[myLocator.length - 1];
			boolean checked = driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, locator))).isSelected();
			if (!checked)
				driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, locator))).click();
		} catch (Exception e) {
			System.out.println("Could not check " + eleName + " on " + ScreenName + " Page");
			writeExtent("Fail", "Could not check " + eleName + " on " + ScreenName + " Page");
			Assert.assertFalse(true, "Could not check " + " as " + eleName + " on " + ScreenName + " Page");
		}
	}

	/**
	 * Description... For selecting multiple options in a multiple select
	 * dropdown
	 * 
	 * @param multipleVals
	 * @param ele
	 * @param selectBy
	 * @param option
	 */
	public void selectMultipleValuesInDropdown(String multipleVals, WebElement ele, String selectBy, String option) {
		try {
			String multipleSel[] = multipleVals.split(",");
			switch (selectBy) {
			case "Value":
				for (String valueToBeSelected : multipleSel) {
					new Select(ele).selectByValue(valueToBeSelected);
				}
			case "VisibleText":
				for (String valueToBeSelected : multipleSel) {
					new Select(ele).selectByVisibleText(valueToBeSelected);
				}

			}
		} catch (Exception e) {
			System.out.println("Could not enter " + option);
			writeExtent("Fail", "Could not enter " + option);
			Assert.assertFalse(true, "Could not enter " + option);
		}
	}

	/**
	 * This Method return all of options available in DropDown Box
	 * 
	 */
	public String[] getAllOptions(WebElement ele) {
		List<String> listTemp = new ArrayList<String>();
		try {

			// List<WebElement> options =
			// dropDownListBox.findElements(By.tagName("option"));
			Select options = new Select(ele);
			for (WebElement option : options.getOptions()) {
				listTemp.add(option.getText());
			}
			String[] allOptions = listTemp.toArray(new String[0]);
			return allOptions;
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Description... Store the parent window handle, clicks on the Add Button
	 * and switches to the child window
	 * 
	 * @throws Exception
	 */
	public void clickButtonSwitchWindow(String sheetName, String locator, String screenName, String eleName)
			throws Exception {
		switchToWindow("storeParent");
		clickWebElement(sheetName, locator, eleName, screenName);
		switchToWindow("child");
	}

}
