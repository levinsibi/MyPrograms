package login;

import java.awt.AWTException;
import java.io.IOException;

import customFunctions.CustomFunctions;

public class SignIn extends CustomFunctions{

	public static void verifyTitle() throws IOException, AWTException
	{
		String value=getCellvalue(Utility.Dfilename, Utility.dataSheet, Utility.tcname, "Title");
		
		String Acttiltle=getTitle();
		
		createReport(value,Acttiltle,Utility.tcname);
	}
}
