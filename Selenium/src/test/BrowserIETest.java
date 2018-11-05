package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class BrowserIETest {

	@Test(invocationCount=4,threadPoolSize = 4)
	public static void sample() {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.ie.driver",
				"D:\\selenium\\Jars_SeleniumProject\\IEDriverServer.exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

		ieCapabilities.setCapability("nativeEvents", false);    
		ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
		ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
		ieCapabilities.setCapability("disable-popup-blocking", true);
		ieCapabilities.setCapability("enablePersistentHover", true);

		WebDriver driver= new InternetExplorerDriver(ieCapabilities);
		driver.get("http://toolsqa.com/selenium-webdriver/fire-ie-selenium-tool-ie-browser/");
		
	}

}
