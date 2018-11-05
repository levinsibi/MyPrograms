package test;




import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;











import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SampleLinkTest {
 
	static WebDriver driver;
	static String title;
	static FileInputStream fis;
	static XSSFSheet sheet;
	static XSSFWorkbook workbook;
	static Hyperlink hp=null;
	static HttpURLConnection huc = null;
	static int respCode;
	public static void main(String[] args) throws IOException, AWTException 
	{
		File file=new File("D:\\LinkCheck\\linkcheck.xlsx");
		fis=new FileInputStream(file);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);
		sheet.getRow(0).getCell(0).setCellValue("URL Name reference ");
		sheet.getRow(0).getCell(1).setCellValue("Link");
		sheet.getRow(0).getCell(2).setCellValue("Title");
		TreeSet<String>list=new TreeSet<String>();
		int j=0;
		driver=new FirefoxDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/");
		//driver.get("http://newtours.demoaut.com/");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		
		
		System.out.println("Total links are "+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			
			WebElement ele= links.get(i);
			
			String url=ele.getAttribute("href");
			
			System.out.println(url);
			if(url!=null)
			list.add(url);
			
			
			
		}
			
		
			for(String m:list)
			{
				
				try
				{
				verifyLinkActive(j,m);
				
				}
				catch(Exception ex)
				{
					continue;
				}
				j++;
			}
			FileOutputStream fos=new FileOutputStream(new File("D:\\LinkCheck\\linkcheck.xlsx"));
			workbook.write(fos);
			fos.close();
			driver.quit();
			
		}
		
	
	
	public static void verifyLinkActive(int i,String url) throws IOException, AWTException
	{
		driver.get(url);
		
		title=driver.getTitle();
		
		
		
		/*
		huc = (HttpURLConnection)(new URL(url).openConnection());
		huc.setRequestMethod("HEAD");
        
        huc.connect();
        
        respCode = huc.getResponseCode();*/
		
		
        /*URL url1 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)url1.openConnection();
        connection.setRequestMethod("READ");
        connection.connect();

        int code = connection.getResponseCode();*/
		
		
		
		XSSFCreationHelper helper= workbook.getCreationHelper();
		XSSFHyperlink url_link=helper.createHyperlink(Hyperlink.LINK_URL);
        url_link.setAddress(url);
		sheet.getRow(i+1).getCell(0).setCellValue("URL"+i);
		sheet.getRow(i+1).getCell(1).setHyperlink(url_link);
		sheet.getRow(i+1).getCell(1).setCellValue(url);
		sheet.getRow(i+1).getCell(2).setCellValue(title);
		
		System.out.println("The resultant url:"+i +"is"+url+" and tiltle is "+title);
		
		
		Robot robot = new Robot();
        String format = "jpg";
        String fileName = "D:\\LinkCheck\\"+"URL"+i+"."+format;
         
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
        ImageIO.write(screenFullImage, format, new File(fileName));
        
        driver.navigate().back();
        
	
	 
 
}
}