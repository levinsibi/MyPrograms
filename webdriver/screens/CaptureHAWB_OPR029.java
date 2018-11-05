package screens;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import common.CustomFunctions;
import common.WebFunctions;
import common.ExcelReadWrite;
import common.Xls_Read;

public class CaptureHAWB_OPR029 extends CustomFunctions {

	public CaptureHAWB_OPR029(WebDriver driver, ExcelReadWrite excelReadWrite, Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
	}

	public String sheetName = "CaptureHAWB_OPR029";
	public String screenName = "CaptureHAWB";

	public void listHAWB(String awbNo,String ShipmentPrefix) throws InterruptedException {
		
		awbNo = getPropertyValue(proppath, "AWBNo");

		System.out.println("AWBnumber is ---" + awbNo);
		waitForSync(2);
		enterValueInTextbox(sheetName, "inbx_shipmentPrefix;name", data(ShipmentPrefix), "Shipment Prefix", screenName);
		enterValueInTextbox(sheetName, "inbx_AWBnumber;xpath", awbNo, "AWB No", screenName);
		clickWebElement(sheetName, "btn_list;name", "List Button", screenName);
		waitForSync(4);
		
	}
	
	public void verifyHAWBTbldetails(int verfCols[], String actVerfValues[]) throws InterruptedException {
		
		/*int verfCols[] = { 5, 6, 11, 12, 13, 15 };
		String actVerfValues[] = { data("Pieces"), data("Weight"), data("ShipmentDesc"), data("Origin"),
				data("Destination"), data("Remarks") };*/

		verify_tbl_records_multiple_cols(sheetName, "tbl_HAWBdetails;xpath", "//td", verfCols, data("HAWB"),
				actVerfValues);
	}

}
