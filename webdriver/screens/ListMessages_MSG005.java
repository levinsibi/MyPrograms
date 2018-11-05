package screens;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import common.CustomFunctions;
import common.DriverSetup;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class ListMessages_MSG005 extends CustomFunctions {
	public CustomFunctions customFuction;
	String sheetName = "ListMessages_MSG005";
	String screenName = "List Messages : MSG005";
	String screenId="MSG005";
	int msgCounter = 0;
	//CustomFunctions comm=new CustomFunctions(driver, excelreadwrite, xls_Read);

	public ListMessages_MSG005(WebDriver driver, ExcelReadWrite excelReadWrite, Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
	}
	public void clickClearButton() throws InterruptedException{
		clickWebElement("Generic_Elements", "btn_clear;name", "Clear Button", screenName);
	
	}
	public void enterMsgType(String MessageType) throws InterruptedException, AWTException {

		enterValueInTextbox(sheetName, "MSGtype_field;xpath", MessageType, "Message Type", screenName);
		keyPress("TAB");
		keyRelease("TAB");
		waitForSync(2);

	}
	
	public void selectMsgSubType(String MessageSubType) throws InterruptedException {

		selectValueInDropdown(sheetName, "lst_MsgSubType;xpath", MessageSubType, "Message SubType", "VisibleText");
		waitForSync(2);

	}
	
	public void clickReference() throws InterruptedException {
		clickWebElement(sheetName, "Reference_But;xpath", "View", screenName);
		waitForSync(2);

	}


	public void enterReferenceValue(String messageType, String FlightNo,String AWBNo) throws InterruptedException {

		switch (messageType) {

		case "FFM":
			enterValueInTextbox(sheetName, "FLTnum_text;xpath", data(FlightNo),"FLTNUM", screenName);
			break;

		case "SSM":
			enterValueInTextbox(sheetName, "SSMNum_text;xpath", data(FlightNo),"NUM", screenName);
			break;

		case "FWB":
			enterValueInTextbox(sheetName, "AWBscr_text;xpath", data(AWBNo),"AWBSCR", screenName);
			break;

		case "FHL":
			enterValueInTextbox(sheetName, "HAWBscr_text;xpath",data(AWBNo),"HAWBSCR", screenName);
			break;
			
				
		case "ASM" :
		
			enterValueInTextbox(sheetName, "AWBscr_text;xpath", data(FlightNo),"ASMSCR", screenName);
			break;
			
		case "FLTOPRAVI":
			enterValueInTextbox(sheetName, "inbx_refFLTOPRAVI;xpath", data(FlightNo),"FLTNUM", screenName);
			break;
			
			
		case "MYD":
			enterValueInTextbox(sheetName, "inbx_refMYD;xpath", data(FlightNo),"FLTNUM", screenName);
			break;

		}

		waitForSync(2);
	}
	
	public void clickViewButton() throws Exception {
		switchToWindow("storeParent");
		clickWebElement("Generic_Elements", "btn_view;name", "View Button",
				screenName);
	}
	
	
	public void clickMsg() throws InterruptedException {
		clickWebElement("Generic_Elements", "chk_msg;name",
				"Message check Box", screenName);

	}


	public String  getMessageContent() throws Exception{
		switchToWindow("storeParent");
		switchToWindow("child");
		switchToFrame("default");
		ele = findDynamicXpathElement("txtarea_RawMsg;xpath", sheetName,
				"Message Content", screenName);
		String text=ele.getText();		
		clickWebElement("Generic_Elements", "butn_close;name", "Close Button", "Message View Button Pop up");
		switchToWindow("getParent");
		switchToFrame("contentFrame",screenId);
		return  text;
		
	}

	public void verifyErrorMIPDescription(String expText) throws Exception{
		switchToWindow("storeParent");
		switchToWindow("child");
		switchToFrame("default");
		ele = findDynamicXpathElement("table_ErrorDesc;xpath", sheetName,
				"MIP Error Description", screenName);
		String actText=ele.getText();	
		verifyScreenText(sheetName, data(expText), actText,"Error Description Verification",screenName);
		clickWebElement("Generic_Elements", "butn_close;name", "Close Button", "Message View Button Pop up");
		switchToWindow("getParent");
		switchToFrame("contentFrame",screenId);
		
	}

/**
	 * Description... Enters the to and from date in message screen
	 * 
	 * @param fromDate
	 * @param toDate
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void enterToFromDate(String fromDate, String toDate)
			throws InterruptedException, AWTException {

		enterValueInTextbox(sheetName, "FromDate_field;xpath", fromDate,
				"From Date", screenName);
		enterValueInTextbox(sheetName, "ToDate_Field;xpath", toDate, "To Date",
				screenName);
		keyPress("TAB");
		keyRelease("TAB");

	}
	
	public void selectStatus(String messageStatus) throws InterruptedException {
		
		switch (messageStatus) {
		case "ProcessedWithWarnings":
			selectValueInDropdown(sheetName,"lst_MsgStatus;xpath","Processed With Warnings","Message Status","VisibleText");
			break;

		case "ProcessedSuccessfully":
			selectValueInDropdown(sheetName,"lst_MsgStatus;xpath","Processed Successfully","Message Status","VisibleText");
			break;
			
		case "ProcessedWithErrors":
			selectValueInDropdown(sheetName,"lst_MsgStatus;xpath","Processed With Errors","Message Status","VisibleText");
			break;

		case "Sent":
			selectValueInDropdown(sheetName,"lst_MsgStatus;xpath","Sent","Message Status","VisibleText");
			break;
			
	}
		waitForSync(2);
	}
	
	public void clickList() throws InterruptedException {
		clickWebElement(sheetName, "List_Msg;xpath", "List", screenName);
		waitForSync(2);
	}
	
     public void clickClear() throws InterruptedException {
		clickWebElement(sheetName, "btn_Clear;name", "Clear", screenName);
		waitForSync(2);
	}
	public void clickCheckBox(String pmyKey) throws InterruptedException {

		selectTableRecord(data(pmyKey), "chk_selectAWB;xpath", sheetName, 3);
		waitForSync(2);

	}
	public void verifyMessageDetails(int verfCols[],String actVerfValues[],String pmKey
			) throws InterruptedException {
		waitForSync(4);
		//int verfCols[]={4,5,6,10,11,12,13};
		//String[] actVerfValues={data("Date"),data("Origin"),data("Destination"),"FC",data("ShipmentPieces"),data("ShipmentWeight"),data("ShipmentVolume")};
		verify_tbl_records_multiple_cols(sheetName, "table_listMessage;xpath", "//td", verfCols, pmKey, actVerfValues);
	}
	
	public void clickprocess1() throws InterruptedException {
		clickWebElement(sheetName, "click_Process;xpath", "Process", screenName);
		waitForSync(5);
		
		switchToFrame("default");
		
		try
		{

        String msgStatus=getElementText("Generic_Elements", "htmlDiv_msgStatus;xpath",
			"Message Status", screenName);
        
        if(msgStatus.contains("processed successfully."))
        {
        	writeExtent("Pass", "Message processed successfully");
        }
        else
        {
        	writeExtent("Fail", "Message not processed successfully.Msg status is "+msgStatus);	
        }
        
        clickWebElement("Generic_Elements", "btn_ok;xpath", "OK button", screenName);
        switchToFrame("contentFrame","MSG005");
        
		}
		
		catch(Exception e)
		{
			
		}
        
		 
		
	}

	public void clickViewlogs(String pmyKey) throws InterruptedException {
		
		clickWebElement(sheetName, "lnk_Viewlogs;xpath", "Click Viewlogs", screenName);
		waitForSync(3);

	}
	
	public void VerifyHandlingCode(String HandlingCode) throws Exception {
		waitForSync(2);
		switchToWindow("storeParent");
		switchToWindow("child");		
		switchToFrame("default");
		waitForSync(2);
		try
		{
		ele=findDynamicXpathElement("tbl_Viewlogs_HandlingProfile;xpath", sheetName, "Handling code", screenName);
		waitForSync(1);
		String actText = ele.getText();
		waitForSync(1);
		String expText = data(HandlingCode);
		verifyScreenText(sheetName, expText, actText,"Message Verification",screenName);
	
		}
		catch(Exception e)
		{
			System.out.println("Handling code is not verified");
		}

	}
	
	public void closeViewlogs() throws Exception {

		clickWebElement(sheetName, "btn_CloseViewlogs;xpath", "Close Viewlogs", screenName);
		waitForSync(2);
		switchToWindow("getParent");
		switchToFrame("contentFrame","MSG005");	
	}
	
		
	public void clickView() throws InterruptedException {
		clickWebElement(sheetName, "click_View;xpath", "View", screenName);
		waitForSync(2);

	}

	public void verifyMessageContent(String MessageContent) throws Exception {
		switchToWindow("storeParent");
		switchToWindow("child");
		switchToFrame("default");
		waitForSync(3);
		ele=findDynamicXpathElement("txtarea_RawMsg;xpath", sheetName, "Message Content", screenName);
		String actText = ele.getText();		
		String expText = data(MessageContent);
		verifyScreenText(sheetName, expText, actText,"Message Verification",screenName);
		waitForSync(2);
	}
	
	public void verifyMessageContent(List<String> MessageContent) throws Exception {
		switchToWindow("storeParent");
		switchToWindow("child");
		switchToFrame("default");
		waitForSync(3);
		ele=findDynamicXpathElement("txtarea_RawMsg;xpath", sheetName, "Message Content", screenName);
		String actText = ele.getText();	
		
		Iterator<String> itr = MessageContent.iterator();
        while(itr.hasNext()){
        	System.out.println("Actual val is---" + itr.next());
        	verifyScreenText(sheetName, data(itr.next()), actText,"Message Verification",screenName);
        }
        
		waitForSync(2);
	}

	public void verifyMessageContentLine(String actText,String Line,String functinalityName,
			int arrayLen) throws Exception {
		
		String expText = Line;
		if (actText.trim().contains(expText.trim()))
			msgCounter++;
		else {
			test.log(LogStatus.FAIL, "Failed to Verify " + expText);
			Assert.assertFalse(true, "Element is not found");
		}

		if(arrayLen==msgCounter)
		{
			counter = counter + 1;
			
		excelreadwrite.insertData(DriverSetup.testName,

				commonUtility.getcurrentDateTime() + "_" + String.valueOf(counter),
				"Verify the functionality " + functinalityName + " On " + screenName + " Screen", functinalityName,
				functinalityName, true, "No", functinalityName, functinalityName);
			test.log(LogStatus.PASS, "Verified "+functinalityName+" Message Content");
		}
		
	}


	public void closeView() throws Exception {
		clickWebElement(sheetName, "click_CloseView;xpath", "Close View", screenName);
		waitForSync(2);
		switchToWindow("getParent");
		switchToFrame("contentFrame","MSG005");	
	}

	public void clickprocess() throws InterruptedException {
		clickWebElement(sheetName, "click_Process;xpath", "View", screenName);
		waitForSync(2);
	}
	
	public void expandSearchCriteria() throws InterruptedException {
		clickWebElement(sheetName, "btn_ExpandSearch;xpath", "ExpandSearch", screenName);
		waitForSync(2);
		clickWebElement(sheetName, "btn_ExpandSearch;xpath", "ExpandSearch", screenName);
		waitForSync(2);
	}
	

}
