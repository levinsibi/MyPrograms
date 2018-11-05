package test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class FileUpload {



public static void main(String[]args) throws IOException, InterruptedException{
	
	WiniumDriver wind;
	 String WiniumEXEpath="D:\\Winium\\Winium\\Winium.Desktop.Driver.exe";
	System.setProperty("webdriver.winium.desktop.driver", WiniumEXEpath);
    DesktopOptions options = new DesktopOptions();
    WebDriver mdriver=new FirefoxDriver();
    options.setApplicationPath("C:\\Windows\\System32\\openfiles.exe");
    mdriver.get("https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/web/guest/home");//use your own code to launch browser
   
   // wind.findElement(By.id("file-upload")).click();

    wind = new WiniumDriver(new URL("http://localhost:9999"),options);
   mdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   
   /* File file = new File(WiniumEXEpath);
    if (! file.exists()) {
        throw new IllegalArgumentException("The file " + WiniumEXEpath + " does not exist");
    }*/
        
    mdriver.manage().window().maximize();
    mdriver.findElement(By.xpath(".//*[@id='navigation']/ul[1]/li/a/span")).click();
    mdriver.findElement(By.xpath(".//*[@id='_58_login']")).sendKeys("testfactory1.ibs");
    mdriver.findElement(By.xpath(".//*[@id='_58_password']")).sendKeys("Ibs4321!");
    mdriver.findElement(By.xpath(".//*[@id='_58_fm']/fieldset/div[1]/button")).click();
    mdriver.findElement(By.xpath(".//*[@id='trigger1']/span")).click();
    mdriver.findElement(By.xpath(".//*[@id='dropdown1']/ul/li/ul/li[1]/ul/li[3]/div/a")).click();
    
    mdriver.findElement(By.xpath(".//*[@id='_eportaldgr_WAR_eportaldgrportlet_shipperDeclarationCheckbox']")).click();
    mdriver.findElement(By.xpath(".//*[@id='_eportaldgr_WAR_eportaldgrportlet_copyUpload']")).click();
    wind.findElementByName("File name:").sendKeys("C:\\Users\\Public\\Videos\\Sample Videos\\Wildlife.wmv");
    //Open
    wind.findElementByName("Open").click();
    Thread.sleep(10000);
    String result=wind.findElementByName("File can not be uploaded. The maximum total upload size is 10MB.").getAttribute("Name");
    
    System.out.println("This is my rsult-------->"+result);
    
    
}
 
}