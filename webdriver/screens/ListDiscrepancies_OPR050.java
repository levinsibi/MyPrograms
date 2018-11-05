package screens;

import org.openqa.selenium.WebDriver;

import common.CustomFunctions;
import common.ExcelReadWrite;
import common.WebFunctions;
import common.Xls_Read;

public class ListDiscrepancies_OPR050 extends WebFunctions  {

	private static final String TAB = null;
	private static final String Enter = null;
	public CustomFunctions customFuction;
	String sheetName="ListDiscrepancies_OPR050";
	String ScreenName="List Discrepancies";
	String screenId="OPR050";


	public ListDiscrepancies_OPR050(WebDriver driver, ExcelReadWrite excelReadWrite,
			Xls_Read xls_Read2) {
		super(driver, excelReadWrite, xls_Read2);
		customFuction=new CustomFunctions(driver, excelReadWrite, xls_Read2);

	}
	
	public void clickDamageTab() throws InterruptedException{
		clickWebElement(sheetName, "tab_damage;xpath", "Damage Tab", ScreenName);
	}
}