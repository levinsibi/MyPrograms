package test;



import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class First  {
	
	//public WebDriver driver;
	public static String report_path="D:\\Selenium_Reports\\";
	public static String html_report_path=report_path+"HtmlReport\\ExtentReport.html";
	public static String snap_shot_path=report_path+"Snapshots\\TC1.PNG";

	public static ExtentReports extent=  new ExtentReports(html_report_path, true);
    
    public static ExtentTest test = extent.startTest("Test_Step", "TestCase");
    
    
	 public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		 WebDriver driver ;
		 driver = new FirefoxDriver();
		 String baseUrl = "http://www.google.com";
		 driver.get(baseUrl);
		 Thread.sleep(9000);
	
	driver.manage().window().maximize();
	
	String actualResult = driver.getTitle();
	String expResult = "googles";
	
	if(actualResult.equalsIgnoreCase(expResult)) {
		 test.log(LogStatus.INFO, "Test Step ");
         test.log(LogStatus.INFO, "Expected Result : "+expResult);
         test.log(LogStatus.PASS, "Actual Result : "+actualResult);
	}
	else{
		
		 Robot robot=new Robot();
		 Rectangle rectangle=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		 BufferedImage BI=robot.createScreenCapture(rectangle);
		 ImageIO.write(BI, "PNG", new File("D:\\Selenium_Reports\\Snapshots\\TC1.PNG"));
		 test.log(LogStatus.INFO, "Test Step ");
         test.log(LogStatus.INFO, "Expected Result : "+expResult);
         test.log(LogStatus.FAIL, "Actual Result : "+actualResult);
         test.log(LogStatus.INFO, "Failure Snapshot : " +                test.addScreenCapture(snap_shot_path));
	}
	extent.endTest(test);
	extent.flush();
	driver.close();
	driver.quit();
	
	}
	

}
