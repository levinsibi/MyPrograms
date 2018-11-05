package screens;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.Xls_Read;

public class IQA_CSH036 extends CustomFunctions {
	String sheetName = "IQA_CHS036"; 
	public String screenName="IQA";
	
	public IQA_CSH036(WebDriver driver, ExcelReadWrite excelReadWrite, Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
		
	}
	
	/**
	 * Description... Overloaded - List an AWB No on Screen
	 * 
	 * @param awbNo
	 * @param ShipmentPrefix
	 * @param ScreenName
	 * @throws InterruptedException
	 */
	public void listAWB(String awbNo, String ShipmentPrefix, String ScreenName) throws InterruptedException {
		String sheetName = "Generic_Elements";

		awbNo = getPropertyValue(proppath, awbNo);

		System.out.println("AWBnumber is ---" + awbNo);
		enterValueInTextbox(sheetName, "inbx_shipmentPrefix_name", data(ShipmentPrefix), "Shipment Prefix", ScreenName);
		enterValueInTextbox("IQA_CHS036", "inbx_AWBnumber;xpath", awbNo, "AWB No", ScreenName);
		clickWebElement(sheetName, "btn_list;name", "List Button", ScreenName);

	}
	
	/**
	 * Description... Enter Destination Payer value
	 * 
	 * @param destPayer
	 * @throws InterruptedException, AWTException
	 */
	public void enterDestinationPayer(String destPayer) throws InterruptedException, AWTException  {
		waitForSync(1);
		enterValueInTextbox(sheetName, "inbx_destPayer;id", data(destPayer), "Destination Payer", screenName);
		keyPress("TAB");
	}
	
	
	/**
	 * Description... Enter Broker value
	 * 
	 * @param destPayer
	 * @throws InterruptedException, AWTException
	 */
	public void enterBroker(String broker) throws InterruptedException, AWTException  {
		waitForSync(1);
		enterValueInTextbox(sheetName, "inbx_broker;id", data(broker), "Broker", screenName);
		keyPress("TAB");
	}
	
	/**
	 * Description... Set IQA
	 * @throws InterruptedException
	 */
	public void setIQA() throws InterruptedException  {
		
		clickWebElement(sheetName, "btn_setIQA;name", "Set IQA Button", screenName);
		
	}
	
	/**
	 * Description... Set IQH
	 * @throws InterruptedException
	 */
	public void setIQH() throws InterruptedException  {
		
		clickWebElement(sheetName, "btn_setIQH;name", "Set IQH Button", screenName);
	}
	
	/**
	 * Description... Save IQA
	 * @throws InterruptedException
	 */
	public void save() throws InterruptedException  {
		
		clickWebElement(sheetName, "btn_save;name", "Save Button", screenName);
	}
	
	/**
	 * Description...Add new Charge code in IQA screen
	 * @param custType
	 * @param chargeCode
	 * @throws Exception 
	 */
	public void addChargeCode(String custType, String chargeCode) throws Exception  {
		waitForSync(1);
		switchToWindow("storeParent");
		clickWebElement(sheetName, "lnk_addChargeCode;id", "Add charge code Button", screenName);
		waitForSync(2);
		switchToWindow("child");
		enterValueInTextbox(sheetName, "lnk_addChargeCode;id", chargeCode, "Charge Code", screenName);
		clickWebElement(sheetName, "btn_listChildWindow;name", "List Button", screenName);
		selectValueInDropdown(sheetName,"lst_customerTypeAddCharge;name", data(custType),"Customer Type","VisibleText");
		clickWebElement(sheetName, "btn_calChargesAddCharge;name", "Calc charge Button", screenName);
		clickWebElement(sheetName, "btn_OKAddCharge;id", "OK Button", screenName);
		waitForSync(1);
		switchToWindow("getParent");
		switchToFrame("contentFrame", "CSH036");
		
	}
	
	/**
	 * Description...Overloaded Add new Charge code in IQA screen
	 * @param chargeCode
	 * @throws Exception 
	 */
	public void addChargeCode(String chargeCode) throws Exception  {
		waitForSync(1);
		switchToWindow("storeParent");
		clickWebElement(sheetName, "lnk_addChargeCode;id", "Add charge code Button", screenName);
		waitForSync(2);
		switchToWindow("child");
		enterValueInTextbox(sheetName, "inbx_chargeCode;name", data(chargeCode), "Charge Code", screenName);
		clickWebElement("Generic_Elements", "btn_listChildWindow;name", "List Button", screenName);
		
		clickWebElement(sheetName, "btn_calChargesAddCharge;name", "Calc charge Button", screenName);
		clickWebElement(sheetName, "btn_OKAddCharge;id", "OK Button", screenName);
		waitForSync(2);
		switchToWindow("getParent");
		switchToFrame("contentFrame", "CSH036");
		
	}
	
	/**
	 * Description... Click Calculate Charges button
	 * @throws InterruptedException
	 */
	public void calculateCharges() throws InterruptedException  {
		
		clickWebElement(sheetName, "btn_calcCharges;name", "calculate Charges Button", screenName);
		waitForSync(2);
	}
	
	/**
	 * Description... Select HAWB 
	 * @param HAWB
	 * @throws InterruptedException
	 */
	public void listHouses(String HAWB)throws InterruptedException  {
		selectValueInDropdown(sheetName,"lst_houses;name", data(HAWB),"Customer Type","VisibleText");
	}
	
	/**
	 * Description...verify IQA status
	 * @param Expected IQA Status
	 */
	public void verifyIQAStatus(String IQAStatus){
		
		// div_IQAStatus;xpath xpath needs to be captured
		ele=findDynamicXpathElement("div_IQAStatus;xpath", sheetName, "IQA status", screenName);			
		verifyScreenText(sheetName, IQAStatus, ele.getText(), "IQA Status verification","verify IQA Status");
		
	}
	
	/**
	 * Description...verify EQA status
	 * @param Expected EQA Status
	  */
	public void verifyEQAStatus(String EQAStatus){
		ele=findDynamicXpathElement("div_EQAStatus;xpath", sheetName, "EQA status", screenName);			
		verifyScreenText(sheetName, EQAStatus, ele.getText(),"EQA Status verification","verify EQA Status");
		
	}
	
	/**
	 * Description...Verify Freight Charges table details
	 * @param Expected EQA Status
	 */
	public void verifyFreightCharges(String expWt){
		ele=findDynamicXpathElement("table_freightCharges;xpath", sheetName, "Freight Charges weight", screenName);			
		verifyScreenText(sheetName, data(expWt), ele.getText(),"Freight Charges Table weight verification","verify Freight Charges Table weight");
		
	}
}
