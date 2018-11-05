package screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class MaintainCustomer_CMT008 extends WebFunctions  {

	private static final String TAB = null;
	private static final String Enter = null;
	public CustomFunctions customFuction;
	String sheetName="MaintainCustomer_CMT008";
	String ScreenName="Maintain Customer";
	String screenId="CMT008";


	public MaintainCustomer_CMT008(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
		customFuction=new CustomFunctions(driver, excelReadWrite, xls_Read2);

	}
	
	public void clickListButton() throws InterruptedException{
		clickWebElement(sheetName, "inbx_list;name", "List Button", ScreenName);
		waitForSync(10);
	}
	public void enterCustCode(String custCode) throws InterruptedException{
		waitForSync(8);
		enterValueInTextbox(sheetName, "inbx_customerCode;name", custCode, "Customer Code", ScreenName);
	}
	
	public void verifyRows(){
		By b=getElement(sheetName, "lst_custDetails;xpath");
		List <WebElement> list=driver.findElements(b);
		
		for(WebElement ele:list){			
			Select select=new Select(ele);
			String option=select.getFirstSelectedOption().getText();
			if(option.equalsIgnoreCase("eTracking"))
				verifyValueOnPage(true, true, "1. Verify Row for eTracking is Displayed in CMT008", "Maintain Customer", "eTracking Row in Customer Details");
			if(option.equalsIgnoreCase("eTrackingTOA"))
				verifyValueOnPage(true, true, "1. Verify Row for eTrackingTOA is Displayed in CMT008", "Maintain Customer", "eTrackingTOA Row in Customer Details");
		
		
		}
	}

	public void verifyNotfctnLang(String lang) throws InterruptedException{
		By b=getElement(sheetName, "lst_LangCode;name");
		Select select=new Select(driver.findElement(b));
		String option=select.getFirstSelectedOption().getText();
		verifyValueOnPage(option, lang, "Verify Notification Language in Notification Preference Pop up", "Notification Preference Pop up", "Notification Language");
		
	}
	
}