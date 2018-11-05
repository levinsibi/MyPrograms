package screens;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;


public class ExportManifest_OPR016 extends WebFunctions {
	String sheetName = "ExportManifest_OPR016"; 
	public CustomFunctions customFuction;
	String screenID="OPR016";
	public String screenName="ExportManifest";
	
	public ExportManifest_OPR016(WebDriver driver, ExcelReadWrite excelReadWrite, Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
		customFuction = new CustomFunctions(driver, excelreadwrite, xls_Read);
		

	}

	// Click AWB tab after listing flight
	public void clickAWBButton() throws InterruptedException {
		waitForSync(2);
		clickWebElement(sheetName, "button_AWB;xpath", "AWB Button", "ExportManifest");
	}

	// Select AWB in table. Usage : Here pmyKey is AWBNo in table to be selected
	public void selectAWBNo(String pmyKey, String sheetName,String locatorTableRow,String locatorEle, int loopCount ) throws InterruptedException {
		customFuction.selectTableRecord( pmyKey,  sheetName, locatorTableRow, locatorEle,  loopCount);
		waitForSync(2);
			
	}
	/**
	 * Description... Enters SCC, POU, enters bulk and uld comment
	 * @param optionSCC
	 * @param optionPOU
	 * @param bulkComment
	 * @param uldComment
	 * @throws Exception
	 */
		public void preAdvice(String optionSCC,String optionPOU , String bulkComment, String uldComment) throws Exception{
			switchToWindow("storeParent");
			clickWebElement(sheetName, "btn_preAdvice;name", "PreAdvice Button", "PreAdvice Popup Export Manifest");
			switchToWindow("child");
			selectValueInDropdown(sheetName, "lst_preAdvice_scc;name", optionSCC, "Preadvice SCC", "Value");
			selectValueInDropdown(sheetName, "lst_pointOfUnlading_scc;name", optionPOU, "Preadvice SCC", "Value");
			clickWebElement("Generic_Elements", "btn_list;name", "List Button", "PreAdvice Popup Export Manifest");
			
			clickWebElement(sheetName, "rad_pointOfUnlading_msgTypeFFM;name", "Message Type Radio Button", "PreAdvice Popup Export Manifest");
			enterValueInTextbox(sheetName, "txtar_pointOfUnlading_remarks1;name", bulkComment, "Bulk Comment", "PreAdvice Popup Export Manifest");
			enterValueInTextbox(sheetName, "txtar_pointOfUnlading_remarks2;name", uldComment, "ULD Comment", "PreAdvice Popup Export Manifest");
			clickWebElement(sheetName, "btn_send;name", "Send Button", "PreAdvice Popup Export Manifest");
			
			customFuction.handleAlert("Accept","PreAdvice Popup Export Manifest");
			switchToFrame("contentFrame",screenID);
			clickWebElement("Generic_Elements", "btn_close;name", "Close Button", "PreAdvice Popup Export Manifest");
			
			switchToWindow("getParent");
		}

	/**
	 * Description... Clicks the SplitsAssign Button and assigns the required pieces to any ULD 
	 * @param Bulk
	 * @param SplitPieces
	 * @param SplitWeight
	 * @throws Exception
	 */
		public void splitAssign(String Bulk,String SplitPieces,String SplitWeight) throws Exception {

			selectValueInDropdown(sheetName, "lst_BULK;name", Bulk, "Select ULD", "Value");
			waitForSync(2);
			switchToWindow("storeParent");
			clickWebElement(sheetName, "btn_splitAssign;name", "Split Assign Button", "Export Manifest");		
			switchToWindow("child");
			enterValueInTextbox(sheetName, "inbx_splitPieces;name", data(SplitPieces), "Split Pieces", "Export Manifest");
			enterValueInTextbox(sheetName, "inbx_splitWeight;name", data(SplitWeight), "Split Weight", "Export Manifest");
			map.put("SplitVol", getAttributeWebElement(sheetName, "txt_splitAssign_vol;xpath", "value","vol", "Export Manifest"));
			clickWebElement("Generic_Elements", "btn_ok;name", "Ok Button", "Export Manifest");		
			switchToWindow("getParent");
		}
	
	//Assign AWB to ULD
	public void assignULD(String uldno, String POU, String contour, String Pieces,String Weight,String AWBNo) throws Exception {

		 switchToWindow("storeParent");
		 clickWebElement(sheetName, "btn_AssignULD;name", "Assign ULD Button", "ExportManifest");
		 waitForSync(5);
		 switchToWindow("child");
		 enterValueInTextbox(sheetName, "inbx_uldNo;id", uldno, "ULD Number", "Export Manifest");
		 selectValueInDropdown(sheetName, "lst_POU;id", POU, "Select POU", "Value");
		 
		 clickWebElement(sheetName, "btn_btnListULD;name", "List ULD Button", "ExportManifest");
		 
		 selectValueInDropdown(sheetName, "lst_contour;name", data(contour), "Select Contour", "Value");
		// enterValueInTextbox(sheetName, "inbx_awbPrefix;id", data("carrierCode"), "Carrier Code", "Export Manifest");
		 
		 enterValueInTextbox(sheetName, "inbx_awbNo;id",AWBNo, "AWB No", "Export Manifest");
		 clickWebElement(sheetName, "btn_btnListAWB;name", "List AWB Button", "ExportManifest");
		 
		 enterValueInTextbox(sheetName, "inbx_shipmentPieces;id", data(Pieces), "Pieces", "Export Manifest");
		 enterValueInTextbox(sheetName, "inbx_AssignULD_wt;name", data(Weight), "Weight", "Export Manifest");
		 map.put("Vol", getAttributeWebElement(sheetName, "txt_vol;xpath", "value","vol", "Export Manifest"));
		 
		
		 keyPress("TAB");
		 waitForSync(2);
		 keyRelease("TAB");
		 clickWebElement(sheetName, "btn_ULDok;id", "OK Button", "ExportManifest");
		 
		 switchToWindow("getParent");
	}

	
	//Assign AWB to Bulk, here ULD value can be 'BULK / MUC' based on the routing
	public void assignToBulk(String Bulk) throws Exception {

		selectValueInDropdown(sheetName, "lst_BULK;name", data(Bulk), "Select ULD", "Value");
		waitForSync(2);
		clickWebElement(sheetName, "btn_AssigntoULD;name", "Assign to ULD Button", "ExportManifest");
		
	}

	
	// Save Option
	public void save() throws InterruptedException {

		clickWebElement(sheetName, "btn_Save;name", "Save Button", "ExportManifest");
	}

	
	// Print Manifest
	public void printManifest() throws Exception {

		switchToWindow("storeParent");
		clickWebElement(sheetName, "btn_PrintMft;name", "Print Manifest Button", "ExportManifest");
		waitForSync(3);
		switchToWindow("child");

		// clickWebElement(sheetName, "rad_Mawb;name", "MAWB radio",
		// "ExportManifest");

		clickWebElement(sheetName, "btn_Close;name", "Close Print Manifest Button", "ExportManifest");
		switchToWindow("getParent");
		switchToFrame("contentFrame", "OPR016");

	}

	
	// Finalize Flight
	public void finalizeFlight(String flightTime) throws Exception {
		
		switchToWindow("storeParent");
		clickWebElement(sheetName, "btn_FinalizeFlight;name", "Finalize Flight Button", "ExportManifest");
		
		waitForSync(2);
		switchToFrame("default");
		clickWebElement("Generic_Elements", "btn_Yes;xpath", "Yes Button", "Export Manifest");
		waitForSync(2);
		switchToWindow("child");
		
		enterValueInTextbox(sheetName, "inbx_FlightTime;name", flightTime, "Flight Time", "Export Manifest");
		enterValueInTextbox(sheetName, "inbx_Date;xpath", "-1", "Flight Date", "Export Manifest");
		
		waitForSync(2);

		clickWebElement(sheetName, "btn_SaveFinalizeFlt;name", "Save Finalize Flight Button", "Export Manifest");
		waitForSync(2);
		switchToWindow("getParent");
		switchToFrame("default");
		clickWebElement(sheetName, "btn_Yes;xpath", "Yes Button", "Export Manifest");
		switchToFrame("contentFrame","OPR016");
		
		// Verify Flight status got finalized
		ele=findDynamicXpathElement("txt_Finalized;xpath", sheetName, "Text Finalized", screenName);			
		String actText = ele.getText();
		customFuction.verifyScreenText(sheetName,"Finalized",actText,"Flight Finalization","Finalize Flight");
		waitForSync(1);

	}

}