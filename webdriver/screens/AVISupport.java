package screens;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;


public class AVISupport extends CustomFunctions {
	String sheetName = "AVIOperations"; 
	
	
	public String screenName="AVI";
	String actText="";
	String expText="";
	float f1;
	
	
	public AVISupport(WebDriver driver, ExcelReadWrite excelReadWrite, Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
		
		

	}

	public void listAWB(String awbNumber) throws Exception {
		waitForSync(3);
		
		
		
		enterValueInTextbox(sheetName, "inbx_AWBNo;xpath", data(awbNumber),
				"FullAWBNo", screenName);
		clickWebElement(sheetName,"btn_Search;xpath","Serach AWB button",screenName);
		waitForSync(3);
	}
	/*public void verifyGeneralData() throws Exception {
		Thread.sleep(3000);
		
		ele=findDynamicXpathElement("txt_AWBNo;xpath", sheetName, "AWBNo", screenName);
		actText= ele.getAttribute("value");
		expText = data("FullAWBNo");
		comm.verifyScreenText(sheetName, expText, actText,"AWBNo Verification",screenName);
		
		
		ele=findDynamicXpathElement("txt_pieces;xpath", sheetName, "ShipmentPieces", screenName);
		actText= ele.getAttribute("value");
		expText = data("ShipmentPieces");
		comm.verifyScreenText(sheetName, expText, actText,"ShipmentPieces Verification",screenName);
		
		
		ele=findDynamicXpathElement("txt_weight;xpath", sheetName, "ShipmentWeight", screenName);
		actText= ele.getAttribute("value");
		f1= Math.round(Integer.parseInt(data("ShipmentWeight")));
		comm.verifyScreenText(sheetName, String.valueOf(f1), actText,"ShipmentWeight Verification",screenName);
		
		ele=findDynamicXpathElement("txt_volume;xpath", sheetName, "ShipmentVolume", screenName);
		actText= ele.getAttribute("value");
		f1 = Math.round(Integer.parseInt(data("ShipmentVolume")));
		comm.verifyScreenText(sheetName, String.valueOf(f1), actText,"ShipmentVolume Verification",screenName);
		
		ele=findDynamicXpathElement("txt_origin;xpath", sheetName, "ShipmentOrigin", screenName);
		actText= ele.getAttribute("value");
		expText = data("Origin");
		comm.verifyScreenText(sheetName, expText, actText,"ShipmentOrigin Verification",screenName);
		
		ele=findDynamicXpathElement("txt_destination;xpath", sheetName, "ShipmentDestination", screenName);
		actText= ele.getAttribute("value");
		expText = data("Destination");
		comm.verifyScreenText(sheetName, expText, actText,"ShipmentDestination Verification",screenName);
		
		ele=findDynamicXpathElement("txt_prodCode;xpath", sheetName, "Product code", screenName);
		actText= ele.getAttribute("value");
		expText = data("PRODCode");
		comm.verifyScreenText(sheetName, expText, actText,"Product code Verification",screenName);
		
		ele=findDynamicXpathElement("txt_SPL;xpath", sheetName, "SPL Code", screenName);
		actText= ele.getAttribute("value");
		expText = data("SPL");
		comm.verifyScreenText(sheetName, expText, actText,"SPL Code Verification",screenName);
				

		ele=findDynamicXpathElement("txt_content;xpath", sheetName, "Content Code", screenName);
		actText= ele.getAttribute("value");
		expText = data("Content");
		comm.verifyScreenText(sheetName, expText, actText,"Content Code Verification",screenName);
		
	}
	*/
	public void verifyAWBNo() throws Exception {
		Thread.sleep(3000);
		ele=findDynamicXpathElement("txt_AWBNo;xpath", sheetName, "AWBNo", screenName);
		actText= ele.getAttribute("value");
		expText = data("FullAWBNo");
		verifyScreenText(sheetName, expText, actText,"AWBNo Verification",screenName);
		
	}
	public void verifyPieces() throws Exception {

		ele=findDynamicXpathElement("txt_pieces;xpath", sheetName, "ShipmentPieces", screenName);
		actText= ele.getAttribute("value");
		expText = data("ShipmentPieces");
		verifyScreenText(sheetName, expText, actText,"ShipmentPieces Verification",screenName);
		
	}
	public void verifyWeight() throws Exception {

		ele=findDynamicXpathElement("txt_weight;xpath", sheetName, "ShipmentWeight", screenName);
		actText= ele.getAttribute("value");
		f1= Math.round(Integer.parseInt(data("ShipmentWeight")));
		verifyScreenText(sheetName, String.valueOf(f1), actText,"ShipmentWeight Verification",screenName);
		
	}
	public void verifyVolume() throws Exception {
	ele=findDynamicXpathElement("txt_volume;xpath", sheetName, "ShipmentVolume", screenName);
	actText= ele.getAttribute("value");
	f1 = Math.round(Integer.parseInt(data("ShipmentVolume")));
	verifyScreenText(sheetName, String.valueOf(f1), actText,"ShipmentVolume Verification",screenName);
	
	}
	public void verifyOrigin() throws Exception {
	ele=findDynamicXpathElement("txt_origin;xpath", sheetName, "ShipmentOrigin", screenName);
	actText= ele.getAttribute("value");
	expText = data("Origin");
	verifyScreenText(sheetName, expText, actText,"ShipmentOrigin Verification",screenName);
	
	ele=findDynamicXpathElement("txt_destination;xpath", sheetName, "ShipmentDestination", screenName);
	
	}
	
	public void verifyDestination() throws Exception {
	ele=findDynamicXpathElement("txt_destination;xpath", sheetName, "ShipmentDestination", screenName);
	actText= ele.getAttribute("value");
	expText = data("Destination");
	verifyScreenText(sheetName, expText, actText,"ShipmentDestination Verification",screenName);
	
	}
	
	public void verifyProductCode() throws Exception {
	ele=findDynamicXpathElement("txt_prodCode;xpath", sheetName, "Product code", screenName);
	actText= ele.getAttribute("value");
	expText = data("PRODCode");
	verifyScreenText(sheetName, expText, actText,"Product code Verification",screenName);
	
	}
	
	
	public void verifySPLCode() throws Exception {
	ele=findDynamicXpathElement("txt_SPL;xpath", sheetName, "SPL Code", screenName);
	actText= ele.getAttribute("value");
	expText = data("SPL");
	verifyScreenText(sheetName, expText, actText,"SPL Code Verification",screenName);
	
	}
	public void verifycontentCode() throws Exception {
		
	ele=findDynamicXpathElement("txt_content;xpath", sheetName, "Content Code", screenName);
	actText= ele.getAttribute("value");
	expText = data("Content");
	verifyScreenText(sheetName, expText, actText,"Content Code Verification",screenName);
	}
	public void clickFlightPlanning() throws Exception {
		
		waitForSync(3);
		clickWebElement(sheetName,"lnk_flightPlanning;id","Flight planning button",screenName);
		waitForSync(3);
		}
public void enterFlightDetails(String fromDate,String toDate) throws Exception {
		
		waitForSync(3);
		enterValueInTextbox(sheetName, "inbx_flightStartDate;id", data(fromDate),
				"flightStartDate", screenName);
		enterValueInTextbox(sheetName, "inbx_flightEndDate;id", data(toDate),
				"flightENdDate", screenName);
		enterValueInTextbox(sheetName, "inbx_flightStartTime;id", data("val~00:00"),
				"flightStartDate", screenName);
		enterValueInTextbox(sheetName, "inbx_flightEndTime;id", data("val~23:59"),
				"flightENdDate", screenName);
		clickWebElement(sheetName,"btn_searchFlight;id","Search button",screenName);
		waitForSync(3);
		}
	
	public void verifySegmentContent(int verfCols[],String actVerfValues[],String pmKey
			) throws InterruptedException {
		waitForSync(4);
		//int verfCols[]={4,5,6,10,11,12,13};
		//String[] actVerfValues={data("Date"),data("Origin"),data("Destination"),"FC",data("ShipmentPieces"),data("ShipmentWeight"),data("ShipmentVolume")};
		verify_tbl_records_multiple_cols_AVI(sheetName, "table_segmentcontent;xpath", "//input", verfCols, pmKey, actVerfValues);
	}
	
	public void verifyFlightDetails(int verfCols[],String actVerfValues[],String pmKey
			) throws InterruptedException {
		waitForSync(4);
		//int verfCols[]={4,5,6,10,11,12,13};
		//String[] actVerfValues={data("Date"),data("Origin"),data("Destination"),"FC",data("ShipmentPieces"),data("ShipmentWeight"),data("ShipmentVolume")};
		verify_tbl_records_multiple_cols(sheetName, "table_flightPlanning;xpath", "//td", verfCols, pmKey, actVerfValues);
	}

	
}


