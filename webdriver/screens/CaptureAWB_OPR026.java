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

public class CaptureAWB_OPR026 extends CustomFunctions {

	public CaptureAWB_OPR026(WebDriver driver, ExcelReadWrite excelReadWrite, Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
	}

	public String sheetName = "CaptureAWB_OPR026";
	public String screenName = "CaptureAWB";

	MaintainListCommodity_SHR015 shr015 = new MaintainListCommodity_SHR015(driver, excelreadwrite, xls_Read);

	public void selectSCI(String SCI) throws InterruptedException {
		Thread.sleep(2000);
		selectValueInDropdown(sheetName, "lst_SCI;xpath", data(SCI), "SCICode", "VisibleText");
		Thread.sleep(2000);
	}

	public void verifySCCCodes(String SCCCondition, String SCC) {
		waitForSync(6);
		switch (SCCCondition) {

		case "VerifySCCExists":
			ele = findDynamicXpathElement("inbx_SCC;xpath", sheetName, "SCC Codes", screenName);
			String actText = ele.getAttribute("value");
			String expText = SCC;
			verifyScreenText(sheetName, expText, actText, "Verify SCC codes", "Capture AWB");

			// verifyScreenText(SCC, expText, actText, "Verify SCC codes",
			// "Capture AWB");
			break;

		case "VerifySCCNotExists":
			ele = findDynamicXpathElement("inbx_SCC;xpath", sheetName, "SCC Codes", screenName);
			String actText1 = ele.getAttribute("value");
			String expText1 = SCC;
			verifyScreenTextNotExists(sheetName, expText1, actText1, "Verify SCC codes does not exists", "Capture AWB");
			break;
		}

	}

	public void provideShipperCode(String shipperCode) throws InterruptedException, AWTException {
		enterValueInTextbox(sheetName, "inbx_shipperCode;xpath", data(shipperCode), "ShipperCode", screenName);
		keyPress("TAB");
		keyRelease("TAB");
		Thread.sleep(2000);
	}

	/**
	 * Description Execute AVI Shipment
	 * 
	 * @throws Exception
	 */
	public void asIsExecuteAVI() throws Exception {
		switchToWindow("getParent");
		switchToFrame("contentFrame", "OPR026");
		switchToWindow("storeParent");
		clickWebElement(sheetName, "btn_AsIsExecute;xpath", "AsIsExecute Button", screenName);
		Thread.sleep(2000);
		switchToWindow("child");
		clickWebElement(sheetName, "btn_continue_AVI;name", "Continue Button", screenName);
		switchToWindow("getParent");
		switchToFrame("default");
		for (int i = 0; i < 3; i++)
			clickIfPopsUp();

		switchToFrame("contentFrame", "OPR026");
		waitForSync(6);
		/*
		 * WebElement ele1=findDynamicXpathElement("txt_executed;xpath",
		 * sheetName, "Text Executed", screenName);
		 */
		String actText = driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, "txt_executed;xpath"))).getText();
		String expText = "Executed";
		verifyScreenText(sheetName, expText, actText, "As is Execute", "Capture AWB");
		Thread.sleep(2000);
	}

	public void provideConsigneeCode(String consigneeCode) throws InterruptedException, AWTException {
		enterValueInTextbox(sheetName, "inbx_consigneeCode;xpath", data(consigneeCode), "ConsigneeCode", screenName);
		keyPress("TAB");
		keyRelease("TAB");
		Thread.sleep(2000);
	}

	public void clickChargesAcc() throws InterruptedException, AWTException {
		clickWebElement(sheetName, "btn_chargAndAcountg;xpath", "Rating Button", screenName);
		Thread.sleep(2000);
	}

	public void provideRatingDetails(String rateClass, String IATARate) throws InterruptedException, AWTException {
		selectValueInDropdown(sheetName, "lst_RateClass;xpath", data(rateClass), "RateClass", "VisibleText");
		enterValueInTextbox(sheetName, "inbx_IATARate;xpath", data(IATARate), "IATARate", screenName);
		keyPress("TAB");
		keyRelease("TAB");
		keyPress("TAB");
		keyRelease("TAB");
		Thread.sleep(2000);
	}

	public void saveAWB() throws InterruptedException, AWTException {
		clickWebElement(sheetName, "btn_Save;xpath", "Save Button", screenName);
		Thread.sleep(2000);
		switchToFrame("default");
		clickWebElement("Generic_Elements", "btn_yes;xpath", "Ok Button", screenName);
		Thread.sleep(2000);

	}

	public void securityAndScreeing(String SecSCC) throws Exception {
		switchToWindow("storeParent");
		clickWebElement(sheetName, "btn_SecurityAndScreening;id", "Sec&Screening Button", screenName);
		Thread.sleep(2000);
		switchToWindow("child");
		Thread.sleep(2000);
		switchToFrame("default");
		clickWebElement(sheetName, "btn_Yes;xpath", "Yes Button", screenName);
		Thread.sleep(2000);
		enterValueInTextbox(sheetName, "inbx_SCC;xpath", data(SecSCC), "SecSCC", screenName);
		Thread.sleep(1000);
		clickWebElement(sheetName, "chk_SecurityDataRcvd;xpath", "Security Checkbox", screenName);
		clickWebElement(sheetName, "btn_OK;id", "OK Button", screenName);
		Thread.sleep(2000);

	}

	// Below Methods for the dimention test cases

	public void clickReopen() throws InterruptedException {

		waitForSync(5);
		javaScriptToclickElement(sheetName, "button_Reopen;xpath", "Reopen Button", screenName);
		// clickWebElement(sheetName, "button_Reopen;name", "Reopen Button",
		// screenName);

	}

	public void updateStatedValues(String statedPieces, String statedWeight, String StatedVolume)
			throws InterruptedException, AWTException {
		waitForSync(3);
		keyPress("SCROLLDOWNMOUSE");
		waitForSync(2);
		enterValueInTextbox(sheetName, "inbx_stated_Pieces;xpath", data(statedPieces), "Stated pieces", screenName);
		enterValueInTextbox(sheetName, "inbx_stated_weight;name", data(statedWeight), "Stated pieces", screenName);
		enterValueInTextbox(sheetName, "inbx_stated_Volume;xpath", data(StatedVolume), "Stated pieces", screenName);
		waitForSync(2);
	}

	public void asIsExecuteDim1() throws Exception {
		waitForSync(2);
		switchToWindow("getParent");
		switchToFrame("contentFrame", "OPR026");
		clickWebElement(sheetName, "btn_AsIsExecute;xpath", "AsIsExecute Button", screenName);
		Thread.sleep(2000);
		switchToFrame("default");

		for (int i = 0; i < 4; i++) {
			try {
				ele = driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[1]"));
				ele.click();
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		}

		Thread.sleep(2000);
		switchToFrame("contentFrame", "OPR026");
	}

	public void asIsExecuteDim2() throws Exception {
		waitForSync(3);
		clickWebElement(sheetName, "btn_AsIsExecute;xpath", "AsIsExecute Button", screenName);
		Thread.sleep(2000);
		switchToFrame("default");

		for (int i = 0; i < 4; i++) {
			try {
				ele = driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[1]"));
				ele.click();
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		}

		Thread.sleep(2000);
		switchToFrame("contentFrame", "OPR026");
		ele = findDynamicXpathElement("txt_executed;name", sheetName, "Text Executed", screenName);
		String actText = ele.getText();
		String expText = "Executed";
		verifyScreenText(sheetName, expText, actText, "As is Execute", "Capture AWB");
		Thread.sleep(2000);

	}

	public void asIsExecute() throws Exception {
		switchToWindow("getParent");
		switchToFrame("contentFrame", "OPR026");
		clickWebElement(sheetName, "btn_AsIsExecute;xpath", "AsIsExecute Button", screenName);
		waitForSync(6);
		switchToFrame("default");

		/*
		 * for(int i=0;i<2;i++) clickIfPopsUp();
		 */

		try {
			Thread.sleep(6000);
			switchToFrame("default");

			while (driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[1]")).isDisplayed()) {
				clickWebElement("Generic_Elements", "btn_yes;xpath", "yes Button", screenName);
				Thread.sleep(6000);
			}
		} catch (Exception e) {
		}

		Thread.sleep(2000);
		switchToFrame("contentFrame", "OPR026");
		Thread.sleep(2000);
		String actText = driver.findElement(By.xpath(xls_Read.getCellValue(sheetName, "txt_executed;xpath"))).getText();
		String expText = "Executed";
		verifyScreenText(sheetName, expText, actText, "As is Execute", "Capture AWB");
		Thread.sleep(2000);

	}

	public void clickIfPopsUp() {

		try {
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[1]"));
			ele.click();

		} catch (Exception e) {
		}
	}

	public void verifyShipmentVolume() throws Exception {
		waitForSync(5);
		// Gross Volume
		By element = getElement(sheetName, "inbx_grossVol;xpath");
		String grossVolume = driver.findElement(element).getAttribute("value");
		System.out.println("Gross vol is--" + grossVolume);

		// stated volume
		By element2 = getElement(sheetName, "inbx_statedVol;xpath");
		String statedVolume = driver.findElement(element2).getAttribute("value");
		System.out.println("stated vol is--" + statedVolume);

		// gross weight
		By element3 = getElement(sheetName, "inbx_grossWeight;xpath");
		String grossWeight = driver.findElement(element3).getAttribute("value");
		System.out.println("gross Weight is--" + grossWeight);
		closeTab("OPR026", "CaptureAWB");

		waitForSync(4);
		searchScreen("SHR015", "Maintain and List Commodity");
		// list MISCELLANOUS commodity
		shr015.listCommodity("commodity");

		// Get its density factor
		String densityFactor = shr015.getDensityFactor();

		// Gross and Stated volume should be = Gross weight / density factor of
		// the commodity
		double result = Double.parseDouble(grossWeight) / Double.parseDouble(densityFactor);
		double roundOff = Math.round(result * 100.0) / 100.0;

		String expVol = String.valueOf(roundOff);
		System.out.println("expVol" + expVol);

		verifyValueOnPage(grossVolume, expVol, "Gross volume verification", sheetName, "Gross volume verification");
		verifyValueOnPage(statedVolume, expVol, "Stated volume verification", sheetName, "Stated volume verification");
	}

	public void verifyDefaultUnitChange() throws Exception {
		waitForSync(5);

		/*
		 * String cbfVolume = data("Volume"); String converionValueVolume =
		 * "0.0283168"; double cubicMetreVolume = Double.parseDouble(cbfVolume)
		 * * Double.parseDouble(converionValueVolume); cubicMetreVolume =
		 * Math.round(cubicMetreVolume * 100.0) / 100.0; String
		 * cubicMetreVolumeExp = String.valueOf(cubicMetreVolume);
		 */

		String cbfWeight = data("Weight");
		String converionValueWt = "0.453592";
		double cubicMetreWt = Double.parseDouble(cbfWeight) * Double.parseDouble(converionValueWt);
		cubicMetreWt = Math.round(cubicMetreWt * 100.0) / 100.0;
		String cubicMetreWtExp = String.valueOf(cubicMetreWt);

		// Gross Volume
		/*
		 * By element = getElement(sheetName, "inbx_grossVol;xpath"); String
		 * grossVolume = driver.findElement(element).getAttribute("value");
		 * System.out.println("Gross vol is--" + grossVolume);
		 * 
		 * // stated volume By element2 = getElement(sheetName,
		 * "inbx_statedVol;xpath"); String statedVolume =
		 * driver.findElement(element2).getAttribute("value");
		 * System.out.println("stated vol is--" + statedVolume);
		 */
		// gross weight
		By element3 = getElement(sheetName, "inbx_grossWeight;xpath");
		String grossWeight = driver.findElement(element3).getAttribute("value");
		System.out.println("gross Weight is--" + grossWeight);

		// Stated weight
		By element4 = getElement(sheetName, "inbx_stated_weight;name");
		String statedWeight = driver.findElement(element4).getAttribute("value");
		System.out.println("Stated Weight is--" + statedWeight);

		// verifyValueOnPage(grossVolume,cubicMetreVolumeExp,"Gross volume
		// default unit verification",sheetName, "Gross volume default unit
		// verification" );
		// verifyValueOnPage(statedVolume,cubicMetreVolumeExp,"Stated volume
		// default unit verification",sheetName, "Stated volume default unit
		// verification" );
		verifyValueOnPage(grossWeight, cubicMetreWtExp, "Gross Weight default unit verification", sheetName,
				"Gross Weight default unit verification");
		verifyValueOnPage(statedWeight, cubicMetreWtExp, "Stated Weight default unit verification", sheetName,
				"Stated Weight default unit verification");

	}

	public void verifyShipmentVolumewithDimension() throws Exception {
		waitForSync(5);
		switchToWindow("storeParent");
		waitForSync(2);

		clickWebElement(sheetName, "img_dimensionLOV;xpath", "Dimension LOV", screenName);
		waitForSync(12);
		switchToWindow("child");
		waitForSync(2);
		// Dimension Gross vol
		By element = getElement(sheetName, "inbx_volumeLOV;xpath");
		String dimVolume = driver.findElement(element).getAttribute("value");
		clickWebElement(sheetName, "btn_CloseLOV;name", "Dimension LOV", screenName);
		waitForSync(2);
		switchToWindow("getParent");
		switchToFrame("contentFrame", "OPR026");

		// Gross Vol
		By element2 = getElement(sheetName, "inbx_grossVol;xpath");
		String grossVolume = driver.findElement(element2).getAttribute("value");
		System.out.println("Gross vol is--" + grossVolume);

		// Stated Vol
		By element3 = getElement(sheetName, "inbx_statedVol;xpath");
		String statedVolume = driver.findElement(element3).getAttribute("value");

		// Verify gross, stated vol = gross volume in dimension LOV
		clickChargesAcc();
		By element4 = getElement(sheetName, "inbx_ratingVolume;xpath");
		String ratingVolume = driver.findElement(element4).getAttribute("value");

		verifyValueOnPage(ratingVolume, dimVolume, "Rating details volume verification", sheetName,
				"Rating details volume verification");
		verifyValueOnPage(grossVolume, dimVolume, "Gross volume verification", sheetName, "Gross volume verification");
		verifyValueOnPage(statedVolume, dimVolume, "Stated volume verification", sheetName,
				"Stated volume verification");

	}

	public void verifyULDLov() throws Exception {
		waitForSync(5);
		switchToWindow("storeParent");
		waitForSync(2);

		clickWebElement(sheetName, "img_uldLOV;xpath", "ULD LOV", screenName);
		waitForSync(8);
		switchToWindow("child");
		waitForSync(2);

		// Dimension Gross vol
		By element = getElement(sheetName, "inbx_uldNum1;xpath");
		String uldNum1 = driver.findElement(element).getAttribute("value");

		By element2 = getElement(sheetName, "inbx_uldNum2;xpath");
		String uldNum2 = driver.findElement(element2).getAttribute("value");

		By element3 = getElement(sheetName, "inbx_uldSlacPieces1;xpath");
		String uldSlacPieces1 = driver.findElement(element3).getAttribute("value");

		By element4 = getElement(sheetName, "inbx_uldSlacPieces2;xpath");
		String uldSlacPieces2 = driver.findElement(element4).getAttribute("value");

		clickWebElement(sheetName, "btn_CloseLOV;name", "Dimension LOV", screenName);
		waitForSync(2);
		switchToWindow("getParent");
		switchToFrame("contentFrame", "OPR026");

		verifyValueOnPage(uldNum1, data("ULD1"), "1st ULD name verification", sheetName, "1st ULD name verification");
		verifyValueOnPage(uldNum2, data("ULD2"), "2nd ULD name verification", sheetName, "2nd ULD name verification");

		verifyValueOnPage(uldSlacPieces1, data("ULDPieces1"), "ULD1 pieces verification", sheetName,
				"ULD1 pieces verification");
		verifyValueOnPage(uldSlacPieces2, data("ULDPieces2"), "ULD2 pieces verification", sheetName,
				"ULD2 pieces verification");

	}
	
	
	public void verifyShipperCode(String shipperCode) throws InterruptedException, AWTException {
		By element = getElement(sheetName, "inbx_shipperCode;xpath");
		
		String actShipperNo = driver.findElement(element).getAttribute("value");
		verifyValueOnPage(actShipperNo, data("shipperCode"), "Shipper Code verification", sheetName,
				"Shipper Code verification");
	}
	
	
	public void verifyConsigneeCode(String consigneeCode) throws InterruptedException, AWTException {
		
		By element = getElement(sheetName, "inbx_consigneeCode;xpath");
		String actConsigneeNo = driver.findElement(element).getAttribute("value");
		
		verifyValueOnPage(actConsigneeNo, data("consigneeCode"), "Consignee Code verification", sheetName,
				"Consignee Code verification");
		}

}
