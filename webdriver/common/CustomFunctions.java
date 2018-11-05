package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.apache.log4j.Logger;

import com.gargoylesoftware.htmlunit.javascript.host.Map;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IExtentTestClass;
import com.relevantcodes.extentreports.LogStatus;

import common.WebFunctions.alertOps;
import controls.ExcelRead;

public class CustomFunctions extends WebFunctions {
	public static String message_format = System.getProperty("user.dir") + "\\src\\resources\\messages\\formats\\";
	public static HashMap<String, String> parameters = new HashMap<String, String>();
	public static String message_files = System.getProperty("user.dir") + "\\src\\resources\\messages\\files\\";
	public static String proppath = "\\src\\resources\\GlobalVariable.properties";
	public String testrunner_path = "D:\\Applns\\SoapUI-5.2.1\\bin\\testrunner.bat";
	int j, k = 0;

	public CustomFunctions(WebDriver driver, ExcelReadWrite excelReadWrite, Xls_Read xls_Read2) {


		this.driver = driver;
		this.excelreadwrite = excelReadWrite;
		commonUtility = new CommonUtility();
		this.xls_Read = xls_Read2;
		excelRead = new ExcelRead();
		excelfilename = this.getClass().getSimpleName();
		actions = new Actions(driver);

	}
	public void clickExpandButton(String sheetName, String locator,
			String eleName, String screenName) throws InterruptedException {
		clickWebElement(sheetName, locator, eleName, screenName);
	}
	public void searchAWB(String awbNo) throws InterruptedException {
		enterValueInTextbox("AVI", "inbx_awbNo;xpath", awbNo, "AWB No", "AVI");
		clickWebElement("AVI", "btn_search;xpath", "Search Button", "AVI");
		waitForSync(4);
	}

	public void verify_tbl_records_multiple_cols_AVI(String sheetName, String locator, String tableTag, int verfCols[],
			String pmyKey, String actVerfValues[]) {
		boolean flag = false;
		int row = 0;
		String ScreenName = sheetName.split("_")[0];
		// get the required row
		String tableBody = xls_Read.getCellValue(sheetName, locator);

		switch (tableTag) {
		case "//input":

			String dynXpath = tableBody + tableTag;
			List<WebElement> rows = driver.findElements(By.xpath(dynXpath));

		{
			for (int i = 0; i <= rows.size(); i++) {
				System.out.println("i= " + i);

				if (rows.get(i).getAttribute("value").toLowerCase().replace(" ", "")
						.contains(pmyKey.toLowerCase().replace(" ", ""))) {

					flag = true;

				}

				if (flag) {
					row = i + 1;
					break;
				}
			}

			System.out.println("row = " + row);
			for (int i = 0; i < verfCols.length; i++) {
				tableTag = "//td[" + verfCols[i] + "]//input";
				dynXpath = "(" + tableBody + ")[" + row + "]" + tableTag;
				WebElement ele = null;

				ele = driver.findElement(By.xpath(dynXpath));
				if (ele.getAttribute("value").toLowerCase().replace(" ", "")
						.contains(actVerfValues[i].replace(" ", "").toLowerCase())) {
					System.out.println("found true for " + actVerfValues[i]);
					test.log(LogStatus.PASS, "Verified " + actVerfValues[i] + " On " + ScreenName + " Screen");

				} else {

					test.log(LogStatus.FAIL, "Could not Verify " + actVerfValues[i] + " On " + ScreenName + " Screen");
				}
			}
		}
		}
	}

	public void loginAVI(String username, String password) throws InterruptedException {
		waitForSync(6);
		enterValueInTextbox("AVI", "inbx_username;name", username, "Username", "AVI");

		enterValueInTextbox("AVI", "inbx_password;name", password, "Password", "AVI");
		clickWebElement("AVI", "btn_login;name", "Click Button", "AVI");

	}


	/**
	 * Description... Performs the following mail operations in Outlook.
	 * findMail
	 * /clickMail/countMailTrigger/dataCaptureLink/clickHereLink/checkContent
	 * 
	 * @param expectedMailTriggerCount
	 * @param expSubject
	 * @param expText
	 * @param title
	 * @param IssueFoundText
	 * @param RecActionText
	 * @param imailOps
	 * @return
	 * @throws Exception
	 */
	public void imailOps(int expectedMailTriggerCount, String expSubject, String expText, String title,
			String IssueFoundText, String RecActionText) throws Exception {
		List<WebElement> subList = driver.findElements(By.xpath("txt_subList;xpath"));
		int j = 0, k = 0;
		for (int i = 0; i < subList.size(); i++)
			if (subList.get(i).getText().equals(expSubject)) {
				System.out.println("index = " + i + " " + subList.get(i).getText());
				j++;
				k = i;

			}

		System.out.println(j);
		subList.get(k).click();
		waitForSync(3);
		String identifiedIssue = getElementText("iMail", "txt_identifiedIssue;xpath", "Identified Issues", "iMail");

		if (expText.equalsIgnoreCase(identifiedIssue))
			onPassUpdate("iMail", expText, identifiedIssue, "Identified Issues Text", "");
		else
			onFailUpdate("iMail", expText, identifiedIssue, "Identified Issues Text", "");

		String sentMultipleTimes = getElementText("iMail", "txt_sentMulTimes;xpath", "Sent multiple times", "iMail");

		if (IssueFoundText.equalsIgnoreCase(sentMultipleTimes))
			onPassUpdate("iMail", IssueFoundText, sentMultipleTimes, "Sent multiple times Text", "");
		else
			onFailUpdate("iMail", IssueFoundText, sentMultipleTimes, "Sent multiple times Text", "");

		String actRecActionText = getElementText("iMail", "txt_msgRejection;xpath", "Recommended Action Text", "iMail");

		if (RecActionText.equalsIgnoreCase(actRecActionText))
			onPassUpdate("iMail", RecActionText, actRecActionText, "Recommended Action Text", "");
		else
			onFailUpdate("iMail", RecActionText, actRecActionText, "Recommended Action Text", "");

		switchToWindow("storeParent");
		//javaScriptToclickElement("iMail", "lnk_dataCapture;xpath", "Data Capture Link", "iMail");

		waitForSync(3);
		switchToWindow("child");
		String LufTitle = driver.getTitle();

		waitForSync(3);

		verifyScreenText("Lufthansa Login", data("lufthansaTitle"), LufTitle, "Lufthansa Login Title", "");

		enterValueInTextbox("iMail", "inbx_LufUsername;xpath", "UserName", "UserName", "iMailLogin");

		// driver.close();
		switchToWindow("getParent");
		//javaScriptToclickElement("iMail", "lnk_clickHere;xpath", "Click here Link", "iMail");

		String expAWBTitle = data("expAWBTitle");
		String actAWBTitle = driver.getTitle();
		verifyScreenText(actAWBTitle, expAWBTitle, actAWBTitle, "AWB", "");

		driver.close();
		switchToWindow("getParent");
	}

/**
	* Description : Kill the processes
	  * @param process: Should specify the required process to be killed
	  * 
	  *@Sample format:(CMD)
	  * @author A-7271
	  */

	public enum processes {
	  CMD
	}
	public void killProcesses(String process) throws IOException
	{
		Runtime runtime = Runtime.getRuntime();
		
		switch (processes.valueOf(process)) {
		
		   case CMD:
		runtime.exec("taskkill /f /im cmd.exe") ;   
		
			break;
	}
	}
	
	/**
	* Description : Invoke the SOAP Suit
	  * 
	  * 
	  */
	public void triggerSOAPSuit(String project, String testSuit, String testCase)
			throws IOException, InterruptedException {

		String sOAPPath = getPropertyValue(proppath, "SoapPath");
		Runtime runtime = Runtime.getRuntime();
				
		runtime.exec("cmd /c start " + sOAPPath +" -s\"" + testSuit + "\" -c\"" + testCase
					+ "\" -r -A -a -j -S -f \"D:\\SoapUIResults\" \"" + projDir + "\\" + project + ".xml" + "\""+ " -P TCName="+DriverSetup.testName);
		
		waitForSync(2);
	}

	

	/**
	 * Description : Create the required date format and stores to propertyFile
	 * 
	 * @param dateFormat:
	 *            Should specify the required format
	 * @param value
	 *            : provide the value of day/month/year to be added or
	 *            substracted
	 * @param formats:
	 *            Specify DAY , MONTH or YEAR
	 * @param propsKey:Specify
	 *            the property file key whether the data to be saved
	 * @Sample format:(ddMMMYY,1,DAY,startDate)
	 * @author A-7271
	 */

	public enum format {
		CURRENT, DAY, MONTH, YEAR
	}

	public String createDateFormat(String dateFormat, int value, String formats, String propsKey) throws Exception {

		try {
			Date date = new Date();

			Calendar c = Calendar.getInstance();
			c.setTime(date);

			switch (format.valueOf(formats)) {

			case DAY:
				c.add(Calendar.DATE, value);
				break;

			case MONTH:
				c.add(Calendar.MONTH, value);
				break;

			case YEAR:
				c.add(Calendar.YEAR, value);
				break;

			case CURRENT:

				break;
			}

			date = c.getTime();

			DateFormat fmt = new SimpleDateFormat(dateFormat);
			String fromattedDate = fmt.format(date);

			if (!propsKey.equals("")) {
				setPropertyValue(propsKey, fromattedDate, proppath);
			}

			return fromattedDate;

		}

		catch (Exception e) {
			return "";
		}
	}

	/**
	 * Description... Clicks the certificate error which comes in Internet
	 * Explorer browser.
	 * 
	 * @throws Exception
	 */
	public void clickCertificateError() throws Exception {
		try {

			driver.findElement(By.linkText(xls_Read.getCellValue("Login", "lnk_certificateError;linkText"))).click();
			waitForSync(3);

		} catch (Exception e) {
			System.out.println("Not clicked on the object: certificate Error");

		}
	}

	/**
	 * Description... Searches the Screen with the screen ID
	 * 
	 * @param ScreenID
	 * @param ScreenName
	 * @throws InterruptedException
	 */

	public void searchScreen(String ScreenID, String ScreenName) throws InterruptedException {
		try {
			waitForSync(1);
			String sheetName = "Login";
			clickWebElement(sheetName, "inbx_searchScreen;xpath",
					"Screen Search Field", ScreenID);			
			enterValueInTextbox(sheetName, "inbx_searchScreen;xpath", ScreenID,
					ScreenID, ScreenName);
			waitForSync(1);
			new Robot().keyPress(KeyEvent.VK_DOWN);
			
			waitForSync(5);
			new Robot().keyPress(KeyEvent.VK_ENTER);
			
			waitForSync(5);

			String frameName = "iCargoContentFrame" + ScreenID;			
			driver.switchTo().frame(frameName);
			test.log(LogStatus.PASS, "Entered " + ScreenID + " and invoked " + ScreenName + " Screen");		
			System.out.println("Entered " + ScreenID + " and invoked " + ScreenName + " Scr"
					+ "een");
		}

		catch (Exception e) {
			System.out.println("Could not enter " + ScreenID + " and invoke " + ScreenName + " Screen");
			test.log(LogStatus.FAIL, "Could not enter " + ScreenID + " and invoke " + ScreenName + " Screen");
			Assert.assertFalse(true, "Could not enter " + ScreenID + " and invoke " + ScreenName + " Screen");

		}
	}
	

	/**
	 * Description... Web Login to outlook
	 * 
	 * @param UserName
	 * @param Password
	 * @throws Exception
	 */
	public void loginImail(String UserName, String Password) throws Exception {
		
		waitForSync(4);
		enterValueInTextbox("IMail", "inbx_username;name", UserName, "Username", "IMail");
		enterValueInTextbox("IMail", "inbx_password;name", Password, "Password", "IMail");
		clickWebElement("IMail", "btn_login;xpath", "Click Button", "IMail");
	}

	/**
	 * Description... Login to iCargo
	 * 
	 * @param UserName
	 * @param Password
	 * @throws Exception
	 */
	public void loginICargo(String UserName, String Password) throws Exception {
		waitForSync(3);
		enterValueInTextbox("Login", "inbx_userName;xpath", UserName,
				"Username", "Login");
		enterValueInTextbox("Login", "inbx_password;xpath", Password,
				"Password", "Login");
		clickWebElement("Login", "btn_login;xpath", "Click Button", "Login");
		waitForSync(1);
		Set<String> windowhandle = driver.getWindowHandles();
		Iterator it = windowhandle.iterator();
		waitForSync(1);
		String parentWindow = (String) it.next();
		String childWindow = (String) it.next();
		waitForSync(1);
		driver.switchTo().window(parentWindow).close();
		waitForSync(1);
		driver.switchTo().window(childWindow);
	}
	
	/*public void loginICargo(String UserName, String Password) throws Exception {
		waitForSync(3);
		clickCertificateError();
		enterValueInTextbox("Login", "inbx_userName;xpath", UserName,
				"Username", "Login");
		enterValueInTextbox("Login", "inbx_password;xpath", Password,
				"Password", "Login");
		clickWebElement("Login", "btn_login;xpath", "Click Button", "Login");
		waitForSync(5);
		switchToAlert("Accept", "Login");
		switchToWindow("child");
		waitForSync(3);
	}*/
	/**
	 * Description... Login to MESWEB
	 * 
	 * @param UserName
	 * @param Password
	 *
	 */

	public void loginMESWEB(String username, String password) throws InterruptedException{

		String SheetName="Mesx_Screen";
		waitForSync(3);
		enterValueInTextbox(SheetName, "inbx_userName;name", username, "Username", "Login");
		enterValueInTextbox(SheetName, "inbx_password;name", password, "Password", "Login");
		clickWebElement(SheetName, "Login_button;xpath", "Click Button", "Login");
		waitForSync(3);	
	}
	
	
	
	/** Description... Entering the Telexaddress in the MESWEB screen
	 * 
	 * @param Address
	 * 
	 *
	 */
	
	public void enterTelexAddress(String address) throws InterruptedException, IOException {

		String SheetName="Mesx_Screen";
		waitForSync(3);
		clickWebElement(SheetName, "link_CPYC1LH;xpath", "CPYC1LH (3453)", "Mesx_Screen");
		clickWebElement(SheetName, "btn_writeNewMsg;xpath", "NEW", "Mesx_Screen");
		waitForSync(3);
		enterValueInTextbox(SheetName, "inbx_telexAddr;name", data(address), "Username", "Mesx_Screen");

	}
	 
	 /**
	 * Description... Sending the message in the MESWEB screen
	 * 
	 */
	public void sendMessage() throws InterruptedException{
		String SheetName="Mesx_Screen";
		
		enterValueInTextbox(SheetName, "txtarea_msg;name", parameters.get("messageLine"), "Message", "Mesx_Screen");
		clickWebElement(SheetName, "btn_sendMsg;xpath", "Send Button", "Mesx_Screen");  
		waitForSync(3);
		ele=findDynamicXpathElement("txt_sentMsgSuccess;xpath", SheetName, "Message sent", "Lufthansa Systems");
		try{
			String actText = ele.getText();
			
			String expText = " Message sent";
				
			verifyScreenText("Lufthansa Systems",actText,expText," Message sent"," Message sent");
			
			
		}
		catch (Exception e){
			System.out.println("Not verified");
			
		}
		
	}

	
	

	/**
	 * Description... Create an AWB No depending on the stock_range_from in
	 * Global Variable properties file
	 * 
	 * @param AWBNo
	 */
	public void createAWB(String AWBNo) {

		try {
			String propValue = "stock_range_from";

			// loading the property file
			String value = getPropertyValue(proppath, propValue);

			// loading the property file

			int val = Integer.parseInt(value);
			int modValue = val % 7;

			String awbNumber = Integer.toString(val) + Integer.toString(modValue);

			if (awbNumber.length() < 8) {
				awbNumber = "0" + awbNumber;
			}
			String valToStore = Integer.toString(val + 1);

			if (valToStore.length() < 7) {
				valToStore = "0" + valToStore;
			}
			setPropertyValue(propValue, valToStore, proppath);
			setPropertyValue(AWBNo, awbNumber, proppath);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Description... List an AWB No on any Screen
	 * 
	 * @param awbNo
	 * @param ShipmentPrefix
	 * @param ScreenName
	 * @throws InterruptedException
	 */
	public void listAWB(String awbNo,String ShipmentPrefix, String ScreenName) throws InterruptedException {
		String sheetName = "Generic_Elements";
		awbNo = getPropertyValue(proppath, "AWBNo");

		System.out.println("AWBnumber is ---" + awbNo);
		waitForSync(2);
		enterValueInTextbox(sheetName, "inbx_shipmentPrefix;name", data(ShipmentPrefix), "Shipment Prefix", ScreenName);
		enterValueInTextbox(sheetName, "inbx_AWBnumber;xpath", awbNo, "AWB No", ScreenName);
		clickWebElement(sheetName, "btn_list;name", "List Button", ScreenName);
		waitForSync(4);
		
	}


	/**
	 * Description... Verifies the Screen Text and logs the result in the Extent
	 * Report
	 * 
	 * @param screenName
	 * @param expText
	 * @param actText
	 * @param functinalityName
	 * @param testSteps
	 */
	public void verifyScreenText(String screenName, String expText, String actText, String functinalityName,
			String testSteps) {

		if (actText.contains(expText))
			onPassUpdate(screenName, expText, actText, functinalityName, testSteps);
		else
			onFailUpdate(screenName, expText, actText, functinalityName, testSteps);
	}

	public void verifyScreenTextNotExists(String screenName, String expText, String actText, String functinalityName,
			String testSteps) {

		if (!actText.contains(expText))
			onPassUpdate(screenName, expText, actText, functinalityName, testSteps);
		else
			onFailUpdate(screenName, expText, actText, functinalityName, testSteps);
	}
	/*
	 * Author: A-7271 Date Modified :30-05-2018
	 */
	public enum applications {
		iCargo, BE, MESX, iMail
	}

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

		}
		return params;

	}

	/********** TRIGGERING SOAP TEST CASE FROM SELENIUM *******/
	public boolean invokeSoapSuite(String testCaseId, String soapProjectPath) throws InterruptedException, IOException {

		try {
			Runtime runtime = Runtime.getRuntime();

			// invokes testRunner.bat command
			String testrunnerPath = "cmd /c start ".concat(testrunner_path).concat(" ");

			// appends -P argument for project custom properties, to get current
			// TC id which is running
			String testcaseName = " -P TCName=" + testCaseId;

			// Final command to be invoked
			String message = testrunnerPath.concat(data(soapProjectPath)).concat(testcaseName);

			runtime.exec(message);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Description... To generate ULD no in format - AKE10569LH *
	 * 
	 * @return ULD Number
	 */
	// To generate ULD no in format - AKE10569LH
	/*public String create_uld_number(String uldtype, String FltNumStationCode) {

		String randStr = "";

		try {

			String randomNum_length = "5";
			int digit = Integer.parseInt(randomNum_length);
			long value1 = 1;
			long value2 = 9;

			for (int i = 1; i < digit; i++) {
				value1 = value1 * 10;
				value2 = value2 * 10;
			}

			Long randomlong = (long) (value1 + Math.random() * value2);

			randStr = randomlong.toString();

			randStr = data(uldtype) + randStr + data(FltNumStationCode);

			writeExtent("Pass", "ULD number is generated " + randStr);
			System.out.println("ULD number is generated " + randStr);

		}

		catch (Exception e) {
			System.out.println("ULD number could not be generated");
			writeExtent("Fail", "ULD number could not be generated");

		}
		return randStr;
	}*/

	/**
	 * Description... Takes the message format from the Message Excel sheet,
	 * replaces all the parameters and stores the message in the text file named
	 * same as that of Excel sheet name
	 * 
	 * @param MessageExcelAndSheet
	 * @param MessageParam
	 * @return
	 * @throws IOException
	 */
	public boolean createTextMessage(String MessageExcelAndSheet, String MessageParam) throws IOException {

		String messageLine = "";
		String messageType = "";
		String messageSubType = "";
		String values = "";
		try {

			// Excel name
			messageType = data(MessageExcelAndSheet).split(",")[0];

			// Sheet name
			messageSubType = data(MessageExcelAndSheet).split(",")[1];
			values = data(MessageParam);

			// creating the text file

			String filePath = createFile(messageSubType, ".txt");

			/**** EXCEL OPS ***/
			InputStream inp = null;
			XSSFWorkbook wb = null;

			int rowIndex = 0;

			Row row = null;

			String value = "";

			try {

				String path = message_format + messageType + ".xlsx";
				inp = new FileInputStream(path);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				wb = new XSSFWorkbook(inp);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Sheet sheet = wb.getSheet(messageSubType);

			Iterator<Row> rows = sheet.rowIterator();
			while (rows.hasNext()) {
				row = rows.next();

				for (Cell cell : row) {
					row = sheet.getRow(rowIndex);
					cell = row.getCell(0, Row.CREATE_NULL_AS_BLANK);
					value = cell.toString();

					if (value.contains("<")) {

						String valuee = "";

						for (int j = 0; j < value.length(); j++) {
							String val = "";

							if (value.charAt(j) == '<') {
								while (value.charAt(j + 1) != '>') {
									val = val + value.charAt(j + 1);
									j = j + 1;

								}

								// Getting the awb value...

								for (int k = 0; k < values.split(",").length; k++) {
									if (values.split(",")[k].toString().contains(val)) {
										val = values.split(",")[k].toString().split("=")[1].toString();
										if (val.toLowerCase().contains("date"))
											val = data(val).toUpperCase();
										else
											val = data(val);
											break;

									}
								}

								valuee = valuee + val;

							}

							else {
								if (value.charAt(j) != '>') {
									valuee = valuee + value.charAt(j);

								}

							}

						}

						value = valuee;
					}

					frameMessage(filePath, value);
					rowIndex++;

				}
				messageLine = messageLine + value + "\n";
			}
			
						
			parameters.put("messageLine", messageLine);
			

			return true;
		}

		catch (Exception e) {
			System.out.println("Message is not created for Type : " + messageType);
			e.printStackTrace();
			return false;
		}
	}

	public String createFile(String messageType, String fileType) throws IOException {
		String filePath = message_files + messageType + fileType;
		File file = new File(filePath);

		if (file.exists()) {
			file.delete();
		}

		file.createNewFile();

		return filePath;
	}

	/**
	 * Description... Creates the message line by line
	 * 
	 * @param filePath
	 * @param msg
	 */
	public void frameMessage(String filePath, String msg) {
		String fileName = filePath;
		PrintWriter printWriter = null;
		File file = new File(fileName);
		try {

			printWriter = new PrintWriter(new FileOutputStream(fileName, true));
			printWriter.write(msg + System.getProperty("line.separator"));
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}
	}

	/**
	 * Description... Switches to the default frame and Close any Screen Tab.
	 * 
	 * @param ScreenID
	 * @param ScreenName
	 * @throws InterruptedException
	 */
	/*
	 * Author : A-7688 Date Modified : 29/05/2018 Purpose : Close the Screen tab
	 * in iCapsit, creates xpath dynamically
	 */
	public void closeTab(String ScreenID, String ScreenName) throws InterruptedException {
		switchToFrame("default");
		String xpath = xls_Read.getCellValue("Generic_Elements", "btn_closeTab;xpath").replace("ScreenID", ScreenID);
		ele = findDynamicXpathElement(xpath, "Close Button", ScreenID);
		javaScriptToclickElement(ele, ScreenID, ScreenName);

		try {
			xpath = xls_Read.getCellValue("Generic_Elements", "btn_yes;xpath");
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {

		}

	}

	/**
	 * Description... Switch to the required Station
	 * 
	 * @param Office
	 * @param RoleGroup
	 * @param stationCode
	 * @throws InterruptedException
	 * @throws AWTException 
	 */

	public void switchRole(String stationCode, String Office, String RoleGroup) throws InterruptedException, AWTException {

		waitForSync(2);
		clickWebElement("SwitchRole", "btn_more;xpath", "More Button", "Switch Role");
		clickWebElement("SwitchRole", "btn_switchRole;xpath", "switch Role Button", "Switch Role");
		waitForSync(2);
		switchToFrame("frameLocator", "SwitchRole");
		waitForSync(4);
		selectValueInDropdown("SwitchRole", "lst_fromStation;name", data(stationCode), "StationCode", "VisibleText");
		keyPress("TAB");
		keyRelease("TAB");		
		selectValueInDropdown("SwitchRole", "lst_office;name", data(Office), "Office", "VisibleText");
		selectValueInDropdown("SwitchRole", "lst_roleGroup;name", data(RoleGroup), "RoleGroup", "VisibleText");
		clickWebElement("SwitchRole", "btn_ok;xpath", "OK Button", "Switch Role");
		waitForSync(3);
		switchToFrame("default");
	}

	/**
	 * Description... List Flight
	 * 
	 * @param ScreenID
	 * @throws InterruptedException
	 */
	public void listFlight(String ScreenID, String carrierCode,
			String flightNumber, String flightDate, String sheetName) throws InterruptedException, AWTException {
		enterValueInTextbox("Generic_Elements", "inbx_carrierCode;xpath",
				data(carrierCode), "Carrier Code", ScreenID);
		enterValueInTextbox(sheetName, "inbx_flightNumber;xpath",
				data(flightNumber), "Flight Number", ScreenID);
		enterValueInTextbox("Generic_Elements", "inbx_flightDate;xpath",
				data(flightDate), "Flight Date", ScreenID);
		waitForSync(2);
		keyPress("TAB");
		keyRelease("TAB");
		clickWebElement("Generic_Elements", "btn_list;name", "List Button",	ScreenID);
		waitForSync(2);

	}

	/**
	 * Description... Verfies any number of column data in a table
	 * 
	 * @param sheetName
	 *            xpath sheet name
	 * @param locator
	 *            xpath locator
	 * @param tableTag
	 *            tagname of the element whose value is to be verified
	 * @param verfCols
	 *            array of column numbers
	 * @param pmyKey
	 *            unique number for selecting a row
	 * @param actVerfValues
	 *            values to be verified
	 */

	public void verify_tbl_records_multiple_cols(String sheetName, String locator, String tableTag, int verfCols[],
			String pmyKey, String actVerfValues[]) {
		try {
			boolean flag = false;
			int row = 0;
			String ScreenName = sheetName.split("_")[0];
			// get the required row
			String tableBody = xls_Read.getCellValue(sheetName, locator);
			List<WebElement> rows = driver.findElements(By.xpath(xls_Read.getCellValue(sheetName, locator)));
			String dynXpath = xls_Read.getCellValue(sheetName, locator) + tableTag;

			System.out.println("row size  " + rows.size());
			switch (tableTag) {
			case "//input": {
				for (int i = 0; i < rows.size(); i++) {

					List<WebElement> cols = driver.findElements(By.xpath(dynXpath));

					for (int j = 0; j < cols.size(); j++) {

						System.out.println("col text = " + cols.get(j).getAttribute("value"));
						if (cols.get(j).getAttribute("value").contains(pmyKey)) {
							break;
						}
					}
					if (flag) {
						row = i + 1;
						break;
					}
				}
				for (int i = 0; i < verfCols.length; i++) {
					dynXpath = "(" + tableBody + ")[" + row + "]" + tableTag + "[" + verfCols[i] + "]";
					WebElement ele = null;
					dynXpath = "(" + tableBody + ")[" + row + "]" + "//td[" + verfCols[i] + "]//input";
					ele = driver.findElement(By.xpath(dynXpath));
					if (ele.getAttribute("value").toLowerCase().replace(" ", "")
							.contains(actVerfValues[i].replace(" ", "").toLowerCase())) {
						System.out.println("found true for " + actVerfValues[i]);
						test.log(LogStatus.PASS, "Verified " + actVerfValues[i] + " On " + ScreenName + " Screen");

					} else {
						test.log(LogStatus.FAIL,
								"Could not Verify " + actVerfValues[i] + " On " + ScreenName + " Screen");

					}
				}
			}
				break;
			case "//td":

			{

				rows = driver.findElements(By.xpath(tableBody));
				dynXpath = tableBody + tableTag;
				{
					for (int i = 0; i <= rows.size(); i++) {
						System.out.println("i= " + i);

						if (rows.get(i).getText().toLowerCase().replace(" ", "")
								.contains(pmyKey.toLowerCase().replace(" ", ""))) {

							flag = true;

						}

						if (flag) {
							row = i + 1;
							break;
						}
					}

					System.out.println("row = " + row);
					for (int i = 0; i <=verfCols.length; i++) {

						dynXpath = "(" + tableBody + ")[" + row + "]" + tableTag + "[" + verfCols[i] + "]";
						WebElement ele = null;

						ele = driver.findElement(By.xpath(dynXpath));
						if (ele.getText().toLowerCase().replace(" ", "")
								.equals(actVerfValues[i].replace(" ", "").toLowerCase())) {
							System.out.println("found true for " + actVerfValues[i]);
							test.log(LogStatus.PASS, "Verified " + actVerfValues[i] + " On " + ScreenName + " Screen");

						} else {
							test.log(LogStatus.FAIL,
									"Could not Verify " + actVerfValues[i] + " On " + ScreenName + " Screen");

						}
					}

				}
			}
				break;
			case "//div":

			{
				for (int i = 0; i <= rows.size(); i++) {
					System.out.println("i= " + i);

					if (rows.get(i).getText().toLowerCase().replace(" ", "")
							.contains(pmyKey.toLowerCase().replace(" ", ""))) {

						flag = true;

					}

					if (flag) {
						row = i + 1;
						break;
					}
				}
			}
				System.out.println("row = " + row);
				for (int i = 0; i < verfCols.length; i++) {

					dynXpath = "(" + tableBody + ")[" + row + "]" + tableTag + "[" + verfCols[i] + "]";
					WebElement ele = null;

					ele = driver.findElement(By.xpath(dynXpath));
					if (ele.getText().toLowerCase().replace(" ", "")
							.contains(actVerfValues[i].replace(" ", "").toLowerCase())) {
						System.out.println("found true for " + actVerfValues[i]);
						test.log(LogStatus.PASS, "Verified " + actVerfValues[i] + " On " + ScreenName + " Screen");

					} else {
						test.log(LogStatus.FAIL,
								"Could not Verify " + actVerfValues[i] + " On " + ScreenName + " Screen");

					}

					break;
				}
			}

		} catch (Exception e) {

		}
	}

	/**
	 * Description... defines flight type for createFlight method
	 * 
	 * @author A-7688
	 *
	 */
	public enum flightTypes {
		FullFlightNumber, FlightNumber, FlightNo, FullFlightNumber2
	}

	/**
	 * Description... Creates the new flight
	 * 
	 * @param flightType
	 * @throws InterruptedException
	 */
	public void createFlight(String flightType) throws InterruptedException {
		String propValue = "flight_range_from";
		// loading the property file
		String value = getPropertyValue(proppath, propValue);
		String flightCode = getPropertyValue(proppath, "flight_code");
		String valToStore = "";
		int val = Integer.parseInt(value) + 1;
		Random r = new Random();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Character base = alphabet.charAt(r.nextInt(alphabet.length()));

		valToStore = Integer.valueOf(val).toString();
		switch (flightTypes.valueOf(flightType)) {

		case FullFlightNumber: {
			value = flightCode + value + Character.toString(base);
			setPropertyValue("flightNumber", value, proppath);
			break;

		}
		case FullFlightNumber2: {
			value = flightCode + value + Character.toString(base);
			setPropertyValue("flightNumber2", value, proppath);
			break;
		}
		case FlightNo:
			break;
		default:
			break;

		}
		valToStore = Integer.valueOf(Integer.parseInt(valToStore) + 1).toString();
		setPropertyValue(propValue, valToStore, proppath);

	}

	/**
	 * Description... Handles an alert with options getText/Accept/Dismiss/Close
	 * 
	 * @param alertOps
	 * @param ScreenName
	 */
	public void handleAlert(String alertOps, String ScreenName) {
		switchToFrame("default");
		String AlertText = driver
				.findElement(By.xpath(xls_Read.getCellValue("Generic_Elements", "txt_AlertText;xpath"))).getText();

		try {
			switch (alertOps.valueOf(alertOps)) {
			case "getText":
				setPropertyValue("AlertText", AlertText, proppath);
				break;

			case "Accept":
				driver.findElement(By.xpath(xls_Read.getCellValue("Generic_Elements", "btn_yes;xpath"))).click();
				writeExtent("Pass", "Accepted Alert with text " + AlertText + " on " + ScreenName + " Screen");

				break;
			case "Dismiss":
				driver.findElement(By.xpath(xls_Read.getCellValue("Generic_Elements", "btn_no;xpath"))).click();
				writeExtent("Pass", "Dismissed Alert with text " + AlertText + " on " + ScreenName + " Screen");
				break;
			case "Close":
				driver.findElement(By.xpath(xls_Read.getCellValue("Generic_Elements", "btn_close;xpath"))).click();
				writeExtent("Pass", "Closed Alert with text " + AlertText + " on " + ScreenName + " Screen");
				break;
			}

		} catch (Exception e) {
			writeExtent("Pass", "Failed to handle Alert with text " + AlertText + " On " + ScreenName + " Screen");

		}
	}

	/**
	 * Description... defines options for imail_operations
	 * @author A-7688
	 *
	 */
	public enum imailOperations {
		countMailTrigger, clickMail,findMail,checkFMAContent,checkFNAContent
	}

	/**
	 * Description... Performs the following mail operations in Outlook.
	 * findMail
	 * /clickMail/countMailTrigger/dataCaptureLink/clickHereLink/checkContent
	 * 
	 * @param expectedMailTriggerCount
	 * @param expSubject
	 * @param expText
	 * @param IssueFoundText
	 * @param RecActionText
	 * @param imailOps
	 * @return
	 * @throws Exception
	 */

	public boolean imail_operations(int expectedMailTriggerCount, String expSubject, String expText,
			String IssueFoundText, String RecActionText, String imailOps) throws Exception {
		List<WebElement> subList = driver
				.findElements(By.xpath(xls_Read.getCellValue("IMail", "txt_subList;xpath")));

		switch (imailOperations.valueOf(imailOps)) {
		case findMail:
			
			for (int i = 0; i < subList.size(); i++) {
				if (subList.get(i).getText().replaceAll(" ", "").contains(expSubject)) {
					System.out.println("index = " + i + " " + subList.get(i).getText());
					j++;
					k = i;
					break;
				}
			}
			break;
		case clickMail:
			waitForSync(1);
			String xpath = "(" + xls_Read.getCellValue("IMail", "txt_subList;xpath") + ")[" + (k + 1) + "]";
			ele = driver.findElement(By.xpath(xpath));
			javaScriptToclickElement(ele, "mail", "iMail");

			waitForSync(1);
			switchToWindow("storeParent");
			break;
			
		case countMailTrigger:
			int actualMC=0;
			for (int i = 0; i < subList.size(); i++) {
				
				if(subList.get(i).getText().replaceAll(" ", "").contains(expSubject))
                {
					actualMC=actualMC+1;

                }
				
			}
				if (actualMC == expectedMailTriggerCount)
				{	
					onPassUpdate("Imail","Exp MailtriggerCountis "+expectedMailTriggerCount,"ACT MailtriggerCountis "+j,"Mail count Matches","");
					System.out.println("Mail trigger Count matches");
				}
				else
				{
					onFailUpdate("Imail","Exp MailtriggerCountis "+expectedMailTriggerCount,"ACT MailtriggerCountis "+j,"Mail count does not Matches","");
				}
			
				break;
				
		
		case checkFMAContent:

			waitForSync(1);
			
			String mailContent = getElementText("iMail", "txt_mailContent;xpath", "Verify Mail Content", "iMail").replaceAll(" ", "");
			
			if (mailContent.contains(expText))
			{
				onPassUpdate("iMail", expText, mailContent, "Verify Mail Content", "");
				System.out.println("mail content verified");
			}
			else
				onFailUpdate("iMail", expText, mailContent, "Verify Mail Content", "");
			
			break;
			
		case checkFNAContent:
			
			waitForSync(1);
			String issueMailContent = getElementText("iMail", "txt_mailContent;xpath", "Verify Mail Content", "iMail").replaceAll(" ", "");
			
			if (issueMailContent.contains(expText))
			{
				onPassUpdate("iMail", expText, issueMailContent, "Verify Mail Content", "");
				System.out.println("mail content verified");
			}
			else
				onFailUpdate("iMail", expText, issueMailContent, "Verify Mail Content", "");
			
			String actIssueText = getElementText("iMail", "txt_issueFound;xpath", "Verify Issue Text", "iMail").replaceAll(" ", "");

			if (actIssueText.contains(IssueFoundText))
			{				
				onPassUpdate("iMail", IssueFoundText, actIssueText, "Verify Issue Text", "");
				System.out.println("Issue found text verified");
			}
			else
				onFailUpdate("iMail", IssueFoundText, actIssueText, "Verify Issue Text", "");

			String actRecActionText = getElementText("iMail", "txt_recommendedAction;xpath", "Recommended Action Text","iMail").replaceAll(" ", "");

			if (actRecActionText.contains(RecActionText))
			{				
				onPassUpdate("iMail", RecActionText, actRecActionText, "Verify Recommended Action Text", "");
				System.out.println("Recommended action text verified");
			}
			else
				onFailUpdate("iMail", RecActionText, actRecActionText, "Verify Recommended Action Text", "");
			break;
			
		}
		return Status;
		
	}

	/**
	 * Description... write the text message stored in the messageLine variable
	 * by createTextMessage method
	 * 
	 * @param sheetName
	 * @param locator
	 * @param eleName
	 * @param screenName
	 * @throws IOException
	 */
	public void writeTextMsg(String sheetName, String locator, String eleName, String screenName) throws IOException {

		clearText(sheetName, locator, eleName, screenName);
		String messageLine = parameters.get("messageLine");
		driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, locator))).sendKeys(messageLine);

	}
		
	/**
	 * Description... To generate ULD no in format - AKE10569LH *
	 * 
	 * @return ULD Number
	 */
	// To generate ULD no in format - AKE10569LH
	public String create_uld_number(String uldtype, String FltNumStationCode) {

		String randStr = "";

		try {

			String randomNum_length = "5";
			int digit = Integer.parseInt(randomNum_length);
			long value1 = 1;
			long value2 = 9;

			for (int i = 1; i < digit; i++) {
				value1 = value1 * 10;
				value2 = value2 * 10;
			}

			Long randomlong = (long) (value1 + Math.random() * value2);

			randStr = randomlong.toString();

			randStr = uldtype + randStr + FltNumStationCode;

			writeExtent("Pass", "ULD number is generated " + randStr);
			System.out.println("ULD number is generated " + randStr);

		}

		catch (Exception e) {
			System.out.println("ULD number could not be generated");
			writeExtent("Fail", "ULD number could not be generated");

		}
		return randStr;
	}
		
}