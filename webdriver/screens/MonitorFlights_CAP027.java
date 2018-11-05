package screens;



import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class MonitorFlights_CAP027 extends CustomFunctions {

	String sheetName="MonitorFlights_CAP027";
	String screenName="MonitorFlights : CAP027";

	public MonitorFlights_CAP027(WebDriver driver, ExcelReadWrite excelReadWrite,
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
	
	

	
	public void verifyCapacitySummaryRemainingSales(String REM_FS_Capacity_Sales_Wt,String REM_FS_Capacity_Sales_Vol,String REM_FS_Capacity_Sales_LDC,String REM_FS_Capacity_Sales_LDP,String REM_FS_Capacity_Sales_MDP)
	{
		waitForSync(4);
		int verfCols[]={2,3,4,5,6};
		String[] actVerfValues={data(REM_FS_Capacity_Sales_Wt),data(REM_FS_Capacity_Sales_Vol),data(REM_FS_Capacity_Sales_LDC),data(REM_FS_Capacity_Sales_LDP),data(REM_FS_Capacity_Sales_MDP)};
		verify_tbl_records_multiple_cols(sheetName, "tbl_capacitySummay;xpath", "//td", verfCols, "RemainingFS Capacity - Sales", actVerfValues);
	}
	public void verifyCapacitySummaryConsumedCapacity(String ConsumedCapacity_Wt,String ConsumedCapacity_Vol,String ConsumedCapacity_LDC,String ConsumedCapacity_LDP,String ConsumedCapacity_MDP)
	{
		waitForSync(4);
		int verfCols[]={2,3,4,5,6};
		String[] actVerfValues={data(ConsumedCapacity_Wt),data(ConsumedCapacity_Vol),data(ConsumedCapacity_LDC),data(ConsumedCapacity_LDP),data(ConsumedCapacity_MDP)};
		verify_tbl_records_multiple_cols(sheetName, "tbl_capacitySummay;xpath", "//td", verfCols, "Total Consumed Capacity", actVerfValues);
	}
	
	public void closeViewCapSummary() throws Exception
	{
		clickWebElement(sheetName, "btn_viewCapSummaryClose;id", "CloseButton", screenName);
		switchToWindow("getParent");
		switchToFrame("contentFrame", "CAP027");
	}
	
	
	public void viewCapSummary() throws Exception {
		waitForSync(4);
		clickButtonSwitchWindow(sheetName, "btn_viewCapSummary;id", "View Capacity Summary", screenName);

		
	}
}
