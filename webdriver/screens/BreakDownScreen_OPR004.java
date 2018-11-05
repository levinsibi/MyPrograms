package screens;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class BreakDownScreen_OPR004 extends WebFunctions {

	private static final String TAB = null;
	private static final String Enter = null;
	public CustomFunctions customFuction;
	String sheetName="BreakDown_OPR004";
	String screenName="Import Manifest : OPR014 >> Breakdown : OPR004";


	public BreakDownScreen_OPR004(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
		customFuction=new CustomFunctions(driver, excelReadWrite, xls_Read2);

	}

	/*Enter the ULD number */
	public void enterULDnumber(String ULDBumber) throws InterruptedException, AWTException {

		enterValueInTextbox(sheetName, "uld_Number;xpath", data(ULDBumber), "ULD number", screenName);
		Thread.sleep(2000);

	}
	
	/*List the flight in the Import Manifest screen*/
	
	public void listFlight(String FlightNoStationCode, String FlightNumber, String FlightDate) throws InterruptedException, AWTException {

		enterValueInTextbox(sheetName, "inbx_carrierCode;name", data(FlightNoStationCode), "Flight carrierCode", screenName);
		enterValueInTextbox(sheetName, "inbx_flightNumber;name", data(FlightNumber), "Flight No", screenName);
		enterValueInTextbox(sheetName, "inbx_flightDate;name", data(FlightDate), "Flight Date", screenName);
		keyPress("TAB");
		clickWebElement(sheetName, "btn_list;xpath", "List", screenName);
		Thread.sleep(3000);		
	}
	
	/* Enter Location and pieces details*/
	//Use below logic when we are not navigating from Import Screen.
	
	public void enterBdnLocationDetails1(String BDNLocation) throws InterruptedException, AWTException {
		
		waitForSync(2);
		
		enterValueInTextbox(sheetName, "bdn_LocationDetails;xpath", data(BDNLocation), "BDN location", screenName);
		keyPress("ENTER");
		Thread.sleep(2000);
	}
	/* Enter Location and pieces details*/
	//Use below logic when we are navigating from Import Screen.
	
	public void enterBdnLocationDetails2(String BDNLocation) throws InterruptedException, AWTException {
		
		waitForSync(2);
		switchToFrame("frameLocator","ImportManifest_OPR014");
		enterValueInTextbox(sheetName, "bdn_LocationDetails;xpath", data(BDNLocation), "BDN location", screenName);
		keyPress("ENTER");
		Thread.sleep(2000);
	}

	/*click on the ULD check Box*/
	public void clickCheckBox(String value) throws InterruptedException {
		customFuction.selectTableRecord(value, "uld_CheckBox;xpath", sheetName, 3);
		Thread.sleep(2000);
	}

	/*click on the breakDown complete button*/
	public void clickBreakdownComplete() throws InterruptedException {

		clickWebElement(sheetName, "click_BreakDownComplete;xpath", "BreakDown Complete", screenName);
		Thread.sleep(3000);
		//customFuction.handleAlert("Accept", screenName);
		//customFuction.closeTab("OPR004", screenName);

	}
}




