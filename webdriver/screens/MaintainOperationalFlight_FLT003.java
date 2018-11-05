package screens;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;

import com.sun.glass.events.KeyEvent;

import common.WebFunctions;
import common.ExcelReadWrite;
import common.Xls_Read;

public class MaintainOperationalFlight_FLT003 extends WebFunctions {

	String sheetName="MaintainOperationFlight_FLT003";
	String screenName="Maintain Operational Flight : FLT003";

	public MaintainOperationalFlight_FLT003(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
	} 

	public void listFlight(String fltNumber,String fltDate) throws InterruptedException, AWTException {

		enterValueInTextbox(sheetName, "inbx_flightNumber;id", data(fltNumber), "Flight No", screenName);
		enterValueInTextbox(sheetName, "inbx_flightDate;id", data(fltDate), "Flight Date", screenName);
		keyPress("TAB");
		clickWebElement(sheetName, "btn_listFlight;id", "List", screenName);
		Thread.sleep(3000);		
	}

	public void changeControlOffice() throws InterruptedException {
		
		enterValueInTextbox(sheetName, "controlStation_field;xpath", data("controlStation"), "Station", screenName);	
		enterValueInTextbox(sheetName, "controlOffice_Field;xpath", data("controlOffice"), "Office", screenName);	
		Thread.sleep(3000);		
	}
	public void clickLegCapacity() throws Exception {
        waitForSync(2);
		switchToWindow("storeParent");
		clickWebElement(sheetName, "btn_legCapacity;id", "Leg Capacity", screenName);
		
		
	}
	
	public void updateAircraftType(String aircraftType) throws Exception
	{
		  waitForSync(1);
		  switchToWindow("child");
		  waitForSync(1);
		  enterValueInTextbox(sheetName, "inbx_aircraftType;id", data(aircraftType), "Aircraft Type", screenName);
		  clickWebElement(sheetName, "btn_legDetailsOK;id", "Leg Details OK", screenName);
		  waitForSync(1);
		  new Robot().keyPress(KeyEvent.VK_ENTER);
		  waitForSync(3);
		  switchToWindow("getParent");
		  switchToFrame("default");
		  switchToFrame("contentFrame","FLT003");
		 
		  
	}

	public void clickSave() throws InterruptedException {
		 waitForSync(1);
		clickWebElement(sheetName, "btn_Save;id", "Save", screenName);
		
	}

}
