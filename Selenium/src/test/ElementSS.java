package test;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.asprise.ocr.Ocr;

public class ElementSS {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		try
		{
		 driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://portal2.bsnl.in/myportal/quickrecharge.do");
		WebElement element = driver.findElement(By.xpath("//img[@id='captcha_image']"));
		
		EventFiringWebDriver efw=new EventFiringWebDriver(driver);
		// Get entire page screenshot
		File screenshot = efw.getScreenshotAs(OutputType.FILE);
		
		//BufferedImage  fullImg = ImageIO.read(screenshot);
		BufferedImage  fullImg = ImageIO.read(screenshot);
		// Get the location of element on the page
		Point point = element.getLocation();

		// Get width and height of the element
		int elementWidth = element.getSize().getWidth();
		int elementHeight = element.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage elementScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
				elementWidth, elementHeight);
		ImageIO.write(elementScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocation = new File("D:\\AutImages\\img2.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
		Ocr.setUp(); // one time setup
    	Ocr ocr = new Ocr(); // create a new OCR engine
    	ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
    	System.out.println("entered");
    	String s = ocr.recognize(new File[] {new File("D:\\AutImages\\img2.png")},
    	  Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT); // PLAINTEXT | XML | PDF | RTF
    	System.out.println("Result: " + s);
    	WebElement e1=driver.findElement(By.id("captcha"));
    	WebDriverWait wait=new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("captcha")));
    	e1.sendKeys(s.trim());
    	ocr.stopEngine();
		}
		catch(Exception ex)
		{
			
		}
		finally
		{

			String str=JOptionPane.showInputDialog(" retry????...........");
			System.out.println("result is "+str);
			
			if(str.equals("yes"))
			{
				
				driver.get("https://portal2.bsnl.in/myportal/quickrecharge.do");
				
			}
		}
	}

}
