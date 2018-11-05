package screens;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class MarkFlightMovements_FLT006 extends WebFunctions {

	String sheetName="MarkFlightMovements_FLT006";
	String screenName="Mark Flight Movements : FLT006";

	public MarkFlightMovements_FLT006(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);

	}
	public void listFlight(String FlightNumber, String flightDate) throws InterruptedException, AWTException {

		enterValueInTextbox(sheetName, "inbx_flightNumber;name", data(FlightNumber), "Flight No", screenName);
		enterValueInTextbox(sheetName, "inbx_flightDate;name", data(flightDate), "Flight Date", screenName);
		keyPress("TAB");
		clickWebElement(sheetName, "btn_list;name", "List", screenName);
		Thread.sleep(3000);		
	}
	
	

	public void enterFlightMovementDepartureDetails() throws InterruptedException {

		//enterValueInTextbox(sheetName, "inbx_ETDDate;xpath", data("etdDate"), "ETD date", screenName);
		//enterValueInTextbox(sheetName, "inbx_ETDTime;xpath", data("etdTime"), "ETD time", screenName);
		enterValueInTextbox(sheetName, "inbx_ATDDate;name", data("atdDate"), "ATD date", screenName);
		enterValueInTextbox(sheetName, "inbx_ATDTime;name", data("atdTime"), "ATD time", screenName);
		Thread.sleep(2000);


	}
	public void enterFlightMovementArrivalDetails() throws InterruptedException {

		//enterValueInTextbox(sheetName, "inbx_ETAData;xpath", data("etaDate"), "ETA date", screenName);
		//enterValueInTextbox(sheetName, "inbx_ETATime;xpath", data("etaTime"), "ETA time", screenName);
		enterValueInTextbox(sheetName, "inbx_ATADate;xpath", data("ataDate"), "ATA date", screenName);
		enterValueInTextbox(sheetName, "inbx_ATATime;xpath", data("ataTime"), "ATA time", screenName);
		Thread.sleep(2000);
	}
	
	
	public void enterFlightMovementDepartureDetails(String flightTime) throws InterruptedException {

		//enterValueInTextbox(sheetName, "inbx_ETDDate;xpath", data(etdDate), "ETD date", screenName);
		//enterValueInTextbox(sheetName, "inbx_ETDTime;xpath", data(etdTime), "ETD time", screenName);
		enterValueInTextbox(sheetName, "inbx_ATDDate;name", "-1", "Flight Date", "Mark Flight Movements : FLT006");
		enterValueInTextbox(sheetName, "inbx_ATDTime;name", flightTime, "Flight Time", "Mark Flight Movements : FLT006");
		/*enterValueInTextbox(sheetName, "inbx_ATDDate;name", data(atdDate), "ATD date", screenName);
		enterValueInTextbox(sheetName, "inbx_ATDTime;name", data(atdTime), "ATD time", screenName);*/
		Thread.sleep(2000);
	}
	public void enterFlightMovementArrivalDetails(String flightTime) throws InterruptedException {

		//enterValueInTextbox(sheetName, "inbx_ETAData;xpath", data(etaDate), "ETA date", screenName);
		//enterValueInTextbox(sheetName, "inbx_ETATime;xpath", data(etaTime), "ETA time", screenName);
		enterValueInTextbox(sheetName, "inbx_ATADate;xpath", "-1", "Flight Date", screenName);
		enterValueInTextbox(sheetName, "inbx_ATATime;xpath", flightTime, "Flight Time", screenName);
		/*enterValueInTextbox(sheetName, "inbx_ATADate;xpath", data(ataDate), "ATA date", screenName);
		enterValueInTextbox(sheetName, "inbx_ATATime;xpath", data(ataTime), "ATA time", screenName);*/
		Thread.sleep(2000);
		}
	public void clickSave() throws InterruptedException {
		clickWebElement(sheetName, "btn_save;name", "Save", screenName);

	}
}
