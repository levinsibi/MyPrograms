package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class sampleTestWinium {
    public static void main(String[] args) throws InterruptedException, IOException {
    	
    	
    	/*Runtime.getRuntime().exec(
				   "cmd /c taskkill /F /IM Winium.Desktop.Driver.exe");*/
    	Runtime run=Runtime.getRuntime();
    	run.exec("D:\\Winium\\Winium\\Winium.Desktop.Driver.exe");
        WiniumDriver driver = null;
        String appPath = "C:/windows/system32/calc.exe";
        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(appPath);
        option.setDebugConnectToRunningApp(false);
        // true means application starting steps are skipped.by default its false
        option.setLaunchDelay(2);
        driver = new WiniumDriver(new URL("http://localhost:9999"),option);
        Thread.sleep(1000);
        
       /* /C      				Carries out the command specified by string and then terminates
        
        /T                    	Terminates the specified process and any
        						child processes which were started by it.
        /F                     	Specifies to forcefully terminate the process(es).
        
        /IM   					imagename        Specifies the image name of the process
        						to be terminated. Wildcard '*' can be used
        						to specify all tasks or image names.*/

  	  
       // WebElement window =  driver.findElementByClassName("CalcFrame");
       // WebElement menuItem = window.findElement(By.id("MenuBar")).findElement(By.name("View"));
       // menuItem.click();
        driver.findElementByName("View").click();
        driver.findElementByName("Scientific").click();

        /*window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
        driver.findElementByName("History").click();

        window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
        driver.findElementByName("History").click();

        window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
        driver.findElementByName("Standard").click();*/

        driver.findElementByName("4").click();
        driver.findElementByName("Add").click();
        driver.findElementByName("5").click();
        driver.findElementByName("Equals").click();
        driver.close();
        Runtime.getRuntime().exec(
				   "cmd /c taskkill /F /IM Winium.Desktop.Driver.exe");
        
        
        System.gc();
        
    }
}
