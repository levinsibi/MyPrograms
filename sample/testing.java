package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testing {

	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub

		
		//System.setProperty("webdriver.chrome.driver", "D:\\selenium\\Jars_SeleniumProject\\chromedriver.exe");
      /*  WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");*/
		
		
		
		/*Runtime run=Runtime.getRuntime();
		run.exec("notepad.exe");
		String str=System.getProperty("java.version");
		String name=System.getProperty("user.name");
		System.out.println(str);
		System.out.println(name);*/
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_S);  // VK_WINDOWS key still pressed
		r.keyRelease(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_ALT);
	}

}
