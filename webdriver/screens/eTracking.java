package screens;

import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class eTracking extends WebFunctions{
	public eTracking(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
	}

	public String sheetName="eTracking";
	public String ScreenName="eTracking";
	//public CustomFunctions comm;
	CustomFunctions comm=new CustomFunctions(driver, excelreadwrite, xls_Read);
	public void clickeServices() throws InterruptedException{
		clickWebElement(sheetName, "lnk_eServices;xpath", "eServices Link", ScreenName);
	}
	
	public void clickFlightStatusHelp() throws InterruptedException{
		clickWebElement(sheetName, "lnk_flghtStatusHelp;xpath", "Flght Status Help Link", ScreenName);
	}
	public void clickeTracking() throws InterruptedException{
		clickWebElement(sheetName, "lnk_eTracking;xpath", "eTracking Link", ScreenName);
	
	}
	
	public void clickGoToMyShipment() throws InterruptedException{
		clickWebElement(sheetName, "lnk_myShiment;xpath", "eTracking Link", ScreenName);
		
	}
	public void clickMyShipmentHelp() throws InterruptedException{
		clickWebElement(sheetName, "lnk_myShipmentHelp;xpath", "Go to my shipment link", ScreenName);
		
	}
	
	public void searchAWBNo(String awbNo) throws InterruptedException{
		enterValueInTextbox(sheetName, "inbx_awbNo;xpath", awbNo, "AWB No", ScreenName);
		clickWebElement(sheetName, "btn_search;xpath", "Search Button", ScreenName);
	}
	
	public void clickCompanyNotificationSetting()throws InterruptedException{
		
		clickWebElement(sheetName, "lnk_CompNotSetting;xpath", "Company Notification Setting Link", ScreenName);
		
	}
	
	public void enterPmyEmail(String pmyEmail) throws InterruptedException{
		enterValueInTextbox(sheetName, "inbx_email;xpath", pmyEmail, "Primary Email ID", ScreenName);
	}
	public void enterPmySMS(String pmySMS) throws InterruptedException{		
		enterValueInTextbox(sheetName, "inbx_sms;xpath", pmySMS, "Primary SMS", ScreenName);
	}
	public void enterPmyFAX(String pmyFAX) throws InterruptedException{
		enterValueInTextbox(sheetName, "inbx_fax;xpath", pmyFAX, "Primary FAX", ScreenName);
	}
	
	public void enterSecEmail(String secEmail) throws InterruptedException{
		enterValueInTextbox(sheetName, "inbx_secEmail;xpath", secEmail, "Secondary Email ID", ScreenName);
	}
	public void enterSecSMS(String secSMS) throws InterruptedException{
		enterValueInTextbox(sheetName, "inbx_secSMS;xpath", secSMS, "Secondary SMS", ScreenName);
	}
	public void enterSecFAX(String secFAX )throws InterruptedException{
		enterValueInTextbox(sheetName, "inbx_secFAX;xpath", secFAX, "Secondary FAX", ScreenName);
	}
	
	public void selectLang(String notLang){
		selectValueInDropdown(sheetName, "lst_notLang;xpath", notLang, "Notification Language", "Value");
				
	}
	public void checkTOAChange(){
		checkIfUnchecked(sheetName, "chk_TOAChange;xpath", "Select all event", ScreenName);				
	}
	
	public void enterEmailForTOA(String TOAEmail) throws InterruptedException{
		enterValueInTextbox(sheetName, "inbx_emailForTOA;xpath", TOAEmail, "Email for TOA", ScreenName);
	}
public void clickSaveChanges()throws InterruptedException{
		
		clickWebElement(sheetName, "btn_saveChanges;xpath", "Save Changes Button", ScreenName);
		
	}
public void clickInfoContinue()throws InterruptedException{
	
	clickWebElement(sheetName, "btn_continue;xpath", "Continue Button", ScreenName);
	
}

	
}
