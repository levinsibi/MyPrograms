package screens;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class ListBookings_CAP142 extends CustomFunctions {
	
	String sheetName = "ListBookings_CAP142";
	String screenName = "List Bookings : CAP142";
	

	public ListBookings_CAP142(WebDriver driver, ExcelReadWrite excelReadWrite, Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
	}

	public void enterAwbNumber(String awbNumber) throws InterruptedException, AWTException {

		waitForSync(4);
		enterValueInTextbox(sheetName, "inbx_awbNumber;id", data(awbNumber), "awbNumber", screenName);
		waitForSync(1);
	}
	
	public void selectBKGStatus(String bkgStatus)
	{
		selectValueInDropdown(sheetName,"lst_bookingStatus;id",data(bkgStatus),"Booking Status","VisibleText");
		
	}
	public void listDetails() throws Exception {

		clickWebElement(sheetName, "btn_list;id", "List details", screenName);
		
		waitForSync(2);

	}
	public void expandShipmentDetails() throws Exception {

		clickWebElement(sheetName, "btn_expand;xpath", "Expand shipment details", screenName);
		
		waitForSync(2);

	}
	
	public void checkAWB() throws InterruptedException, AWTException {

	
		waitForSync(2);
		verifyElementDisplayed(sheetName, "chk_bookingData;name",
			"Booking Status", screenName,"Booking Data Check box");

	}

	
	public void verifyAwbDetails(int verfCols[],String actVerfValues[],String pmKey
			) throws InterruptedException {
		waitForSync(4);
		//int verfCols[]={4,5,6,10,11,12,13};
		//String[] actVerfValues={data("Date"),data("Origin"),data("Destination"),"FC",data("ShipmentPieces"),data("ShipmentWeight"),data("ShipmentVolume")};
		verify_tbl_records_multiple_cols(sheetName, "table_bookingDetails;xpath", "//td", verfCols, pmKey, actVerfValues);
	}

	public void listFlight(String FlightNumber, String flightDate) throws InterruptedException, AWTException {

		enterValueInTextbox(sheetName, "inbx_flightNumber;name", data(FlightNumber), "Flight No", screenName);
		enterValueInTextbox(sheetName, "inbx_flightFrom;xpath", data(flightDate), "From Flight Date", screenName);
		enterValueInTextbox(sheetName, "inbx_flightTo;xpath", data(flightDate), "To Flight Date", screenName);
		
		keyPress("TAB");
		clickWebElement("Generic_Elements", "btn_list2;name", "List", screenName);
		Thread.sleep(3000);		
	}
	public void verifyNoContent()
	{
		By element = getElement("Generic_Elements", "txt_errorText;xpath");
		String msg = driver.findElement(element).getText();
		
		
		
		if(msg.contains("No results found for the specified criteria."))
		{
		verifyScreenText(sheetName, "No content Present", "No content Present","ULD Booking Not displayed",screenName);
		
		}
		else
		{
			verifyScreenText(sheetName, "No content Present", "Content Present","ULD Booking displayed",screenName);
		}
	}
	public void verifyULDBkgID(String UldBkgID)
	{
		waitForSync(5);
		
		
		By element = getElement("ListBookings_CAP142", "lnk_uldBKGId;xpath");
		String msg=driver.findElement(element).getText().trim();
		
		if(msg.equals(data(UldBkgID)))
		{
		verifyScreenText(sheetName, data(UldBkgID), msg,"ULD Booking ID displayed",screenName);
		driver.findElement(element).click();
		}
		else
		{
			verifyScreenText(sheetName, data(UldBkgID), msg,"ULD Booking ID Not displayed",screenName);
		}
		waitForSync(5);
	}
				
	}




