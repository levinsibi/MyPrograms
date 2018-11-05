package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mailtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver", "")
		WebDriver driver=new FirefoxDriver();
		driver.get("https://imail.ibsplc.com/owa");
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("ibsplc.com\\A-6757");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("test138#*16");
		driver.findElement(By.xpath(".//*[@id='lgnDiv']/div[9]/div/span")).click();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='lvHighlightAllClass lvHighlightFromClass']")));
		//List<WebElement>list=driver.findElements(By.xpath(".//*[@class='lvHighlightAllClass lvHighlightFromClass']"));
		List<WebElement>list=driver.findElements(By.xpath(".//*[@class='lvHighlightAllClass lvHighlightSubjectClass']"));

		for(int i=0;i<list.size();i++)
		{

			if(list.get(i).isDisplayed()==true)
			{
				System.out.println(list.get(i).getText());
				if(list.get(i).getText().contains(("020-06689001 | Preliminary claim")))
				{
					list.get(i).click();
				}
			}
		}
		//driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[5]/div/div[1]/div/div[5]/div[3]/div/div[5]/div[1]/div/div/div[3]/div[2]/div[2]/div[5]/div[1]/div/div/div[1]/div[1]/div[3]/div[6]/div[3]/div[1]/div/div/div/center/table/tbody/tr/td/center[2]/div/table/tbody/tr/td/p[3]/a")).click();

		WebElement table=driver.findElement(By.xpath(".//*[@id='Item.MessageUniqueBody']/div/div/div/center/table/tbody/tr/td/center[2]/div/table"));
		//.//*[@id='Item.MessageUniqueBody']/div/div/div/center/table/tbody/tr/td/center[2]/div/table

		List<WebElement>trows=table.findElements(By.tagName("tr"));
		System.out.println("Total row count check is  --------"+trows.size());

		int row_num=1;
		int col_num=1;
		for(WebElement rowElement : trows)
		{
			List<WebElement> totalColumns=rowElement.findElements(By.xpath("td"));
			System.out.println("Total column count check is  --------"+totalColumns.size());

			for(WebElement columnElement : totalColumns)
			{
				System.out.println("row # "+row_num+", col # "+col_num+ "text="+columnElement.getText());
				/*if(columnElement.getText().contains(expectedResult)&col_num==cell_num)
			{
				System.out.println("Expected Info found on row # "+row_num+", col # "+col_num+ "text="+columnElement.getText());

				f=1;
				break;
			}*/
				col_num++;

			}

			row_num++;
		}
	}
}
