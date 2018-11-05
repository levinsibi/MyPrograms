package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jfree.io.FileUtilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestChromePOM1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		PageFactory.initElements(driver, ChromePOM1.class);
		ChromePOM1 pom=new ChromePOM1(driver);
		pom.Start();
		pom.verifyPageUrl();
		
		EventFiringWebDriver efw=new EventFiringWebDriver(driver);
		File src=efw.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\test.JpG"));
		
		
		
	}

}
