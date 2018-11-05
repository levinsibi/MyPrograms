package screens;


import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class ImportFlightProgress_OPR263 extends CustomFunctions {
	private static final String TAB = null;
	private static final String Enter = null;
	public CustomFunctions customFuction;
	String sheetName = "ImportFlightProgress_OPR263";
	String screenName = "Import Flight Progress";
	String screenId="OPR263";

	public ImportFlightProgress_OPR263(WebDriver driver,
			ExcelReadWrite excelReadWrite, Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
		customFuction = new CustomFunctions(driver, excelReadWrite, xls_Read2);

	}
	
	public void clickFlightEnquiry() throws InterruptedException{
		clickWebElement(sheetName, "chk_Flight;name", "Flight Check Box", screenName);
		clickWebElement(sheetName, "btn_flightEnquiry;name", "Flight Enquiry Button", screenName);
		
	}
}
