package screens;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class ImportManifest_OPR014 extends WebFunctions {

	public CustomFunctions customFuction;
	String sheetName="ImportManifest_OPR014";
	String screenName="Import Manifest : OPR014";
	

	public ImportManifest_OPR014(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
		customFuction=new CustomFunctions(driver, excelReadWrite, xls_Read2);

	}

	/*List the flight in the Import Manifest screen*/

	/*public void listFlight() throws InterruptedException, AWTException {

		enterValueInTextbox(sheetName, "inbx_carrierCode;name", data("carrierCode"), "Flight carrierCode", screenName);
		enterValueInTextbox(sheetName, "inbx_flightNumber;name", data("flightNum"), "Flight No", screenName);
		enterValueInTextbox(sheetName, "inbx_flightDate;name", data("flightDate"), "Flight Date", screenName);
		keyPress("TAB");
		clickWebElement(sheetName, "btn_list;name", "List", screenName);
		Thread.sleep(3000);		
	}*/
	
	
	/*click the ULD check Box*/
	public void clickULDCheckBox(String pmyKey) throws InterruptedException {
		customFuction.selectTableRecord(pmyKey, "chk_select;xpath", sheetName, 3);
		Thread.sleep(2000);
	}
	

	
	/*click on the BreakDown*/
	public void clickBreakDown() throws InterruptedException {
	
		clickWebElement(sheetName, "btn_breakdown;name", "Break Down", screenName);
		Thread.sleep(2000);
		/*try{		 
			Thread.sleep(2000);
			switchToFrame("default");
			clickWebElement("Generic_Elements", "btn_yes;xpath", "yes Button", screenName);
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			System.out.println("Not clicked");
			
		}*/
		
		customFuction.handleAlert("Accept", screenName);
		
		
		
	}
}

	
	
	
	
