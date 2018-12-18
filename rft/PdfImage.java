package testcase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfImage {

	static WebDriver driver;
	static Document document;

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\jars\\chromedriver.exe");
		document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("C:\\img\\Report.pdf"));
		document.open();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		WebElement e1 = driver.findElement(By.name("q"));
		JavascriptExecutor jse = (JavascriptExecutor) (driver);
		jse.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", e1);
		takeScreenShot("Before entering");
		e1.sendKeys("sachin");
		takeScreenShot("After Entering");
		document.close();

		System.out.println("Done");
	}

	public static void takeScreenShot(String step) throws IOException, DocumentException {

		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		File src = efw.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\img\\1.PNG"));
		Image img = Image.getInstance("C:\\img\\1.PNG");
		img.scaleToFit(500f, 500f);
		document.add(new Paragraph(step));
		document.add(img);
	}

}
