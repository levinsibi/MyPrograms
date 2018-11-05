package test;

import login.Login;
import login.SignIn;
import login.Utility;

import org.openqa.selenium.WebDriver;

import customFunctions.CustomFunctions;

public class TC1 {

	private static WebDriver driver=null;
	
	public static void main(String[]args) throws Exception
	{
		Utility.SetTestName("TC2");
		CustomFunctions.setup();
		CustomFunctions.launch();
		Login.enterUname();
		Login.enterPassword();
		Login.signIn();
		SignIn.verifyTitle();
		CustomFunctions.afterTest();
	}
}
