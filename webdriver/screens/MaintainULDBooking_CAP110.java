package screens;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class MaintainULDBooking_CAP110 extends CustomFunctions  {

	private static final String TAB = null;
	private static final String Enter = null;
	public CustomFunctions customFuction;
	String sheetName="MaintainULDBooking_CAP110";
	String ScreenName="Maintain ULD Booking";
	String screenId="CAP110";


	public MaintainULDBooking_CAP110(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
		customFuction=new CustomFunctions(driver, excelReadWrite, xls_Read2);

	}
	public void selectULDBookingType(String uldBookingType ){
		switchToFrame("contentFrame", "CAP110");
		selectValueInDropdown(sheetName, "lst_uldBookingType;name", data(uldBookingType), "Uld Booking Type", "Value");
	
	}
	public void clickListButton() throws InterruptedException{
		clickWebElement("Generic_Elements", "btn_list2;name", "List Button", ScreenName);
		waitForSync(3);
		customFuction.handleAlert("Accept", ScreenName);
	}
	
	public void listULDBooking(String uldbkgid) throws InterruptedException{
		enterValueInTextbox(sheetName, "txt_uldBookingID;id",data(uldbkgid), "ULD BookingId", ScreenName);
		clickWebElement("Generic_Elements", "btn_list2;name", "List Button", ScreenName);
		waitForSync(4);
	}
	public void clickAddLink() throws InterruptedException{
		clickWebElement(sheetName, "lnk_add;xpath", "Add Link", ScreenName);
	}
	
	public void addULDDetails1(String uldType, String noOfULD,String countour ) throws Exception{
		
		
		//enterValueInTextbox(sheetName, "inbx_origin;name", origin, "Origin", ScreenName);
		//enterValueInTextbox(sheetName, "inbx_destination;name", destination, "Destination", ScreenName);	
		switchToWindow("getParent");
		switchToFrame("contentFrame", "CAP110");
		clickWebElement("Generic_Elements", "lnk_add;id", "Add ULD details button", ScreenName);
		enterValueInTextbox(sheetName, "inbx_uldType;name", data(uldType), "Uld Type", ScreenName);
		enterValueInTextbox(sheetName, "inbx_numberOfULD;name",data(noOfULD), "No Of ULDs", ScreenName);
		keyPress("TAB");
		selectValueInDropdown(sheetName, "lst_contour;id", data(countour), "contour", "Value");
		
		
		
	}
	
	
	public void clickGetShipmentDetails(String awbNo) throws Exception{
		
		clickButtonSwitchWindow(sheetName, "btn_getShipment;name", "Get Shipment Button", ScreenName);
		enterValueInTextbox(sheetName, "inbx_awbNumber;name", data(awbNo), "Uld Type", ScreenName);
		clickWebElement(sheetName, "btn_list;name", "List Button", ScreenName);		
		waitForSync(3);
		//checkIfUnchecked(sheetName, "chk_listBooking;name", "Booking list Check Box", ScreenName);
		clickWebElement(sheetName, "chk_listBooking;name", "Booking list Check Box", ScreenName);
		clickWebElement(sheetName, "btn_ok;name", "Ok Button", ScreenName);
	
	}
	public void validateULD() throws InterruptedException{
		clickWebElement(sheetName, "btn_validate;name", "Validate Button", ScreenName);
		waitForSync(4);
		
		
		
	}
	public void cancelULDBooking() throws InterruptedException{
		clickWebElement(sheetName, "btn_cancel;id", "Cancel Button", ScreenName);
		waitForSync(4);
		customFuction.handleAlert("Accept", ScreenName);
		
		
	}
	public void save() throws InterruptedException{
		clickWebElement(sheetName, "btn_save;id", "Save Button", ScreenName);
		waitForSync(4);
	}
	public void closeButton() throws InterruptedException{
		clickWebElement(sheetName, "btn_closeScreen;xpath", "Close Button", ScreenName);
		waitForSync(4);
	}
	public void storeULDBoookingId() throws InterruptedException{
		By element = getElement(sheetName, "txt_uldBookingID;id");
		String uldBkgID = driver.findElement(element).getAttribute("value");
		map.put("ULD_BKG_ID", uldBkgID);
		
		
		
	}
	public void verifyULDBkgStatusConfirmed() throws InterruptedException{
		By element = getElement(sheetName, "txt_uldBookingStatus;id");
		String status = driver.findElement(element).getAttribute("value");
		map.put("ULD_BKG_Status", status);
		
		
		if(status.equals("Confirmed"))
		{
		verifyScreenText(sheetName, "Confirmed", "Confirmed","ULD Booking status is conirmed","MaintainULDBooking");
		
		}
		else
		{
			verifyScreenText(sheetName, "Confirmed", status,"ULD Booking status is Nonconirmed","MaintainULDBooking");
		}
		
	}
	public void verifyULDBkgID(String ULDBkgId) throws InterruptedException{
		By element = getElement(sheetName, "txt_uldBookingID;id");
		String uldBkgID = driver.findElement(element).getAttribute("value");
		
		
		
		if(uldBkgID.equals(data(ULDBkgId)))
		{
		verifyScreenText(sheetName, data(ULDBkgId), uldBkgID,"ULD Booking Id is present","MaintainULDBooking");
		
		}
		else
		{
			verifyScreenText(sheetName, data(ULDBkgId), uldBkgID,"ULD Booking Id is Not present","MaintainULDBooking");
		}
		
	}
	public void verifyULDBkgStatusCancelled() throws InterruptedException{
		switchToFrame("contentFrame", "CAP110");
		waitForSync(5);
		By element = getElement(sheetName, "txt_uldBookingStatus;id");
		String status = driver.findElement(element).getAttribute("value");
		map.put("ULD_BKG_Status", status);
		
		
		if(status.equals("Cancelled"))
		{
		verifyScreenText(sheetName, "Cancelled", "Cancelled","ULD Booking status is conirmed","MaintainULDBooking");
		
		}
		else
		{
			verifyScreenText(sheetName, "Cancelled", status,"ULD Booking status is Nonconirmed","MaintainULDBooking");
		}
		
	}
	
	
	public void enterOriginDest(String origin, String destination) throws InterruptedException{
		
		enterValueInTextbox(sheetName, "inbx_origin;name", data(origin), "origin", ScreenName);
		enterValueInTextbox(sheetName, "inbx_destination;name", data(destination), "destination", ScreenName);
		
		

	}
public void enterOwnWtVol() throws InterruptedException{
		
		enterValueInTextbox(sheetName, "inbx_ownWeight;name", data("OwnWt"), "Own Weight", ScreenName);
		enterValueInTextbox(sheetName, "inbx_ownVolume;name", data("OwnVol"), "Own Volume", ScreenName);
		
		

	}
public void allowFillUp() throws InterruptedException{
	clickWebElement(sheetName, "rad_FillupYes;xpath", "FillupYes Button", ScreenName);
	waitForSync(2);
	
	
	
}
public void bookingFreeSale() throws InterruptedException{
	clickWebElement(sheetName, "rad_FreeSale;xpath", "FreeSale Button", ScreenName);
	waitForSync(2);
	
	
	
}
public void selectFlight() throws Exception{
	clickButtonSwitchWindow(sheetName, "btn_selectFlight;xpath", "Select Flight Button", ScreenName);
	waitForSync(10);
	
	
	
}
public void addLink()throws Exception{
	clickWebElement("Generic_Elements", "lnk_add;id", "Add ULD details button", ScreenName);
}
public void enterFlight1Details(String Origin,String Destination,String FlightNo,String FlightDate) throws InterruptedException, AWTException{
	
	enterValueInTextbox(sheetName, "inbx_selectedFlightOrigin;xpath", data(Origin), "Origin", ScreenName);
	enterValueInTextbox(sheetName, "inbx_selectedFlightDestination;xpath", data("Destination"), "Destination", ScreenName);
	
	enterValueInTextbox(sheetName, "inbx_selectedFlightNumber;xpath", data(FlightNo), "FullFlightNo", ScreenName);
	enterValueInTextbox(sheetName, "inbx_selectedFlightDate;xpath", data(FlightDate), "FlightDate", ScreenName);
	keyPress("TAB");
}
public void SelectFlightOkBtn()throws Exception{
	Thread.sleep(4000);
	clickWebElement("Generic_Elements", "btn_ok2;name", "ok button", ScreenName);
	waitForSync(5);
	
	
}
}