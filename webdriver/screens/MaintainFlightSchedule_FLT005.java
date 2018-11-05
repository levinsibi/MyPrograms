package screens;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class MaintainFlightSchedule_FLT005 extends CustomFunctions {

	String sheetName="MaintainFlightSchedule_FLT005";
	String screenName="MaintainFlightSchedule : FLT005";

	public MaintainFlightSchedule_FLT005(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);

	}
	public void listFlight(String FlightNumber, String flightStartDate,String flightEndDate ) throws InterruptedException, AWTException {

		enterValueInTextbox(sheetName, "inbx_flightNumber;xpath", data(FlightNumber), "Flight No", screenName);
		enterValueInTextbox(sheetName, "inbx_flightStartDate;xpath", flightStartDate, "Flight StartDate", screenName);
		keyPress("TAB");
		enterValueInTextbox(sheetName, "inbx_flightEndDate;xpath", flightEndDate, "Flight EndDate", screenName);
		keyPress("TAB");
		clickWebElement(sheetName, "btn_flightListButton;xpath", "List", screenName);
		Thread.sleep(3000);	
		handleAlert("Accept", screenName);
	}
	
	

	public void enterFlightDetails(String route,String schduleType,String FCTLStation,String FCTLOffice,String flightType) throws Exception {

		
		switchToFrame("contentFrame", "FLT005");
		enterValueInTextbox(sheetName, "inbx_flightRoute;xpath", data(route), "Flight route", screenName);
		checkIfUnchecked(sheetName, "chk_flightFrequency;xpath",  "Flight Frequency", screenName);
		selectValueInDropdown(sheetName, "lst_flightScheduleType;xpath", data(schduleType), "schduleType", "VisibleText");
		enterValueInTextbox(sheetName, "inbx_controlStation;xpath", data(FCTLStation), "FCTL Station", screenName);
		enterValueInTextbox(sheetName, "inbx_controlOffice;xpath", data(FCTLOffice), "FCTL office", screenName);
		selectValueInDropdown(sheetName, "lst_flightType;xpath", data(flightType), "Flight Type", "VisibleText");
		enterValueInTextbox(sheetName, "inbx_flightEffectiveDate;xpath", ".", "Effective Date", screenName);
		Thread.sleep(2000);
		clickButtonSwitchWindow(sheetName, "lnk_flightUpdateCapacity;xpath", "Update Capacity", screenName);


	}
	public void enterLegCapacityDetails(String departureTime,String arrivalTime,String aircraftType,String capacityConfig) throws InterruptedException {

		
		enterValueInTextbox(sheetName, "inbx_flightDepartureTime;xpath", data(departureTime), "Departure Time", screenName);
		enterValueInTextbox(sheetName, "inbx_flightArrivalTime;xpath", data(arrivalTime), "Arrival Time", screenName);
		enterValueInTextbox(sheetName, "inbx_aircraftType;xpath", data(aircraftType), "Aircraft type", screenName);
		clickWebElement(sheetName, "btn_viewCapacity;xpath", "view capcity", screenName);
		waitForSync(2);
		selectValueInDropdown(sheetName, "lst_capacityConfig;xpath", data(capacityConfig), "capacity Config", "Value");
	}
	public void legCapacityOkButton() throws Exception {

		clickWebElement("Generic_Elements", "btn_ok2;name", "leg capcity ok btn", screenName);
		
		switchToWindow("getParent");
		switchToFrame("contentFrame", "FLT005");
		waitForSync(4);
	}
	public void save() throws Exception {

		clickWebElement(sheetName, "btn_save;xpath", "Save button", screenName);
		waitForSync(2);
		switchToFrame("default");
		handleAlert("Accept", screenName);
		waitForSync(2);
		handleAlert("Accept", screenName);
		waitForSync(2);
		keyPress("ENTER");
	}
	
	
	
}
