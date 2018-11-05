package screens;

import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class FlightLoadPlan_OPR015 extends WebFunctions  {

	private static final String TAB = null;
	private static final String Enter = null;
	public CustomFunctions customFuction;
	String sheetName="FlightLoadPlan_OPR015";
	String ScreenName="Flight Load Plan";
	String screenId="OPR015";


	public FlightLoadPlan_OPR015(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
		customFuction=new CustomFunctions(driver, excelReadWrite, xls_Read2);

	}
	public void clickULDTab() throws InterruptedException{
		clickWebElement(sheetName, "btn_uld;xpath", "ULD Tab", ScreenName);
	}
	public void checkULD(String uldNo, String locator, String locatorEle) throws InterruptedException{
		customFuction.selectTableRecord(uldNo, sheetName, locator, locatorEle, 5);
		
		
	}
	public void selectULDType(String option){
	selectValueInDropdown(sheetName, "lst_uld;name", option, "ULD Type", "Value");
	}
	
	public void  clickAssignAWB() throws InterruptedException{
		clickWebElement(sheetName, "btn_assignAwb;name", "Assign AWB Button", ScreenName);
	
	}
	public void  clickMorePanel() throws InterruptedException{
		clickWebElement(sheetName, "lnk_panelLink;xpath", "More Panel Link", ScreenName);
	
	}
	
	public void  clickAutoAssign() throws InterruptedException{
		clickWebElement(sheetName, "btn_autoAssign;name", "Auto Assign Button", ScreenName);
	
	}
	public void  clickSaveButton() throws InterruptedException{
		clickWebElement(sheetName, "btn_save;name", "Save Button", ScreenName);
	waitForSync(5);
	}
	


}