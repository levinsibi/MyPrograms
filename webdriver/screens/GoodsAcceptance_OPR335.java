package screens;





import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;







import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;
public class GoodsAcceptance_OPR335 extends WebFunctions {
	public GoodsAcceptance_OPR335(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
	}

	public String sheetName="GoodsAcceptance_OPR335";
	public String screenName="GoodsAcceptance";
	CustomFunctions comm=new CustomFunctions(driver, excelreadwrite, xls_Read);	
		public void looseShipmentDetails(String ShipmentAcceptanceLocation, String ShipmentPieces,String ShipmentWeight) throws Exception {
			Thread.sleep(3000);
			
			clickWebElement(sheetName,"div_LooseAcceptance;xpath","Loose acceptance tab open",screenName);
			
			enterValueInTextbox(sheetName, "inbx_LooseShipmentLoc;name", data(ShipmentAcceptanceLocation),
					"ShipmentLocation", screenName);
			enterValueInTextbox(sheetName, "inbx_LooseShipmentPcs;name", data(ShipmentPieces),
					"ShipmentLocation", screenName);
			enterValueInTextbox(sheetName, "inbx_LooseShipmentWt;name", data(ShipmentWeight),
					"ShipmentWeight", screenName);
		}
		
	
		public void allPartsRecieved(
				) throws InterruptedException {
			
			clickWebElement("GoodsAcceptance_OPR335","chk_AllPartsRcvd;name","AllParts recieved Checkbox","GoodsAcceptance_OPR335");
		}
		public void saveAcceptance(
				) throws InterruptedException {
			Thread.sleep(6000);
			clickWebElement(sheetName,"btn_Save;name","AcceptanceSaveButton",screenName);
			try{		 
				Thread.sleep(4000);
				switchToFrame("default");
				clickWebElement("Generic_Elements", "btn_yes;xpath", "yes Button", screenName);
				Thread.sleep(4000);
		}
			catch(Exception e)
			{
			}
			switchToFrame("contentFrame","OPR335");
			
			String actText = driver.findElement(By.xpath(".//*[@id='messagePane']/label[2]")).getText();
			
			System.out.println("Actual text is--"+actText);
			String expText = "Acceptance finalised";	
			if(actText.equals(expText))
			{
			comm.verifyScreenText(sheetName, "Finalized", "Finalized","AcceptanceFinalized",screenName);
			
			}
			else
			{
				comm.verifyScreenText(sheetName, "Acceptance Finalized", "Acceptance Not Finalized","AcceptanceFinalized",screenName);
			}
			Thread.sleep(2000);
		}
		public void addULDDetails(
				) throws InterruptedException {
			
			clickWebElement(sheetName,"lnk_AddULD;xpath","Add ULD Details Button",screenName);
		}
		public void uld1Details(String ULDNumber1, String Contour1,String Location,String Pieces,String Weight) throws Exception {
			Thread.sleep(3000);
			
			
			/*enterValueInTextbox(String sheetName, String locator,
					String value, String eleName, String ScreenName)*/
			enterValueInTextbox(sheetName, "inbx_ULD1Name;xpath", ULDNumber1,
					"ULDNumber1", screenName);
		/*	enterValueInTextbox("GoodsAcceptance_OPR335", "lst_ULD1Contour;xpath", Contour1,
					"Contour1", "GoodsAcceptance_OPR335");*/
			enterValueInTextbox(sheetName, "inbx_ULD1Location;xpath", Location,
					"Location", screenName);
			enterValueInTextbox(sheetName, "inbx_ULD1Pieces;xpath", Location,
					"Pieces", screenName);
			enterValueInTextbox(sheetName, "inbx_ULD1ShipmentWeight;xpath", Location,
					"Weight", screenName);
		}
	}




