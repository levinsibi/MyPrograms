package login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bsh.UtilTargetError;
import customFunctions.CustomFunctions;

public class Login extends CustomFunctions{

	private static WebElement element;
	
	
	public  static void enterUname() throws Exception
	{
		
		String object=getCellvalue(Utility.Ofilename, Utility.objectSheet, "uname", "properties");
		By locator =getLocator(object);
		String value=getCellvalue(Utility.Dfilename, Utility.dataSheet, Utility.tcname, "uname");
		
		enterText(locator,value);
		
	}
	public static void enterPassword() throws Exception
	{
		
		String object=getCellvalue(Utility.Ofilename, Utility.objectSheet, "pword", "properties");
		By locator =getLocator(object);
		String value=getCellvalue(Utility.Dfilename, Utility.dataSheet, Utility.tcname, "pword");
		
		enterText(locator,value);
	}
	public static void signIn() throws Exception
	{
		String object=getCellvalue(Utility.Ofilename, Utility.objectSheet, "login", "properties");
		By locator =getLocator(object);
		click(locator);
	}
}
