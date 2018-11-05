package screens;

import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class DeliveryDocumentation_OPR293 extends WebFunctions{
	public DeliveryDocumentation_OPR293(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
	}

	public String sheetName="DeliveryDocumentation_OPR293";
	public String ScreenName="DeliveryDocumentation";
	//public CustomFunctions comm;
	CustomFunctions comm=new CustomFunctions(driver, excelreadwrite, xls_Read);
	
	public void enterCustName() throws InterruptedException{
		enterValueInTextbox(sheetName, "inbx_custCode;name", data("CustomerCode"), "Customer Code", ScreenName);
		
		

	}
	
	public void clickDeliveryID() throws InterruptedException{
		clickWebElement(sheetName, "btn_genDelivery;name", "Delivery ID Button", ScreenName);
		
	}
}
