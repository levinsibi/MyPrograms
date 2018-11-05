package login;

import org.openqa.selenium.WebDriver;

public class Utility {

	
	public static WebDriver driver;
	public static String dataSheetName = "Sheet1";

	public static  String objectSheet = "Sheet1";
	public static String dataSheet = "Sheet1";
	public static  String Dfilename="D:\\DataSheet.xlsx";
	public static  String Ofilename="D:\\ObjectSheet.xlsx";
	public static String tcname;
	public static void SetTestName(String string) {
		// TODO Auto-generated constructor stub
		
		tcname=string;
	}
	
}
