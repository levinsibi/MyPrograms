package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://vmh-lcag-eport01-sit.lsy.fra.dlh.de:8012/web/guest/dgr-booking?p_p_id=eportaldgr_WAR_eportaldgrportlet&p_p_lifecycle=0&_eportaldgr_WAR_eportaldgrportlet_jspPage=%2Fhtml%2Fdgr%2Fdgr_success.jsp&_eportaldgr_WAR_eportaldgrportlet_templateName=DGR-SUCCESS&_eportaldgr_WAR_eportaldgrportlet_timeForSuccessContent=29JUN18+22%3A00");
		String s=driver.findElement(By.xpath("//div[@class='alert marginTB20 alert-success']")).getText();
		
		System.out.println(s);

	}

}
