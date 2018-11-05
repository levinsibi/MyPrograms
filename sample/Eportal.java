package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Eportal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Select s1;
		WebElement e1;
		WebDriver driver=new FirefoxDriver();
		driver.get("https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='navigation']/ul[1]/li/a/span")));
		driver.findElement(By.xpath(".//*[@id='navigation']/ul[1]/li/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='_58_suxb__null__null']/span")).click();
		driver.findElement(By.xpath(".//*[@id='_58_companyname']")).sendKeys("LH");
		driver.findElement(By.xpath(".//*[@id='_58_street']")).sendKeys("adsd");
		driver.findElement(By.xpath(".//*[@id='_58_city']")).sendKeys("asdsdad");
		driver.findElement(By.xpath(".//*[@id='_58_state']")).sendKeys("asdsdad");
		
		driver.findElement(By.xpath(".//*[@id='_58_postalcode']")).sendKeys("658965");
		e1=driver.findElement(By.xpath(".//*[@id='_58_countryName']"));
		s1=new Select(e1);
		s1.selectByVisibleText("India");
		driver.findElement(By.xpath(".//*[@id='_58_groupcdb']")).sendKeys("100001670");
		e1=driver.findElement(By.xpath(".//*[@id='_58_prefixId']"));
		
		s1=new Select(e1);
		s1.selectByVisibleText("Mr.");
		driver.findElement(By.xpath(".//*[@id='_58_firstName']")).sendKeys("leergfsdvin");
		driver.findElement(By.xpath(".//*[@id='_58_lastName']")).sendKeys("leefgdgin");
		driver.findElement(By.xpath(".//*[@id='_58_emailAddress']")).sendKeys("abadsd@g.com");
		driver.findElement(By.xpath(".//*[@id='_58_phone']")).sendKeys("+495653451");
		driver.findElement(By.xpath(".//*[@id='_58_screenName']")).sendKeys("Lev15sd345");
		driver.findElement(By.xpath(".//*[@id='_58_screenName']")).sendKeys("Lev1dsdsf45");
		e1=driver.findElement(By.xpath(".//*[@id='_58_reminderQueryQuestion']"));
		
		s1=new Select(e1);
		s1.selectByVisibleText("What is your mother's maiden name?");
		
		driver.findElement(By.xpath(".//*[@id='eada_null_null_securityquestionanswer']")).sendKeys("Mary");
		
		driver.findElement(By.xpath(".//*[@id='_58_termsAndConditionCheckBoxCheckbox']")).click();
		driver.findElement(By.xpath(".//*[@id='_58_submitButton']")).click();
		
		String str=driver.findElement(By.xpath("//div[contains(@class,'alert margin')]")).getText();
		System.out.println(str);
		
	}

}
