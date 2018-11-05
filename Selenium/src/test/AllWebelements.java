package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllWebelements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver mdriver=new FirefoxDriver();
		//2,Name;6:1
		
		
			mdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			mdriver.get("https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/web/guest/home");
			mdriver.manage().window().maximize();
		 	//mdriver.findElement(By.xpath(".//*[@id='navigation']/ul[1]/li/a/span")).click();
			List<WebElement> el = mdriver.findElements(By.xpath("//*"));
            int count=0;
            for ( WebElement e : el ) {
             System.out.println( e.getTagName()+"    "+e.getText());

             count++;

            }
          System.out.println(count );
	}

}
