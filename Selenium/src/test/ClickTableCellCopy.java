package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickTableCellCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver mdriver=new FirefoxDriver();
		//2,Name;6:1
		
			String input="2,DGR_BKG_1;3,02JAN18";
			int count=input.split(";").length;
			System.out.println(count);
			String str[]=new String[count];
			for(int i=0;i<count;i++)
			{
				 //str[i]=input.split(";").toString().split(",")[1].toString();
				
				str[i]=input.split(";")[i].toString();
				i++;
			}
			System.out.println(str[0]);
			
			
			/*mdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			mdriver.get("https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/web/guest/home");
			mdriver.manage().window().maximize();
		 	mdriver.findElement(By.xpath(".//*[@id='navigation']/ul[1]/li/a/span")).click();
		    mdriver.findElement(By.xpath(".//*[@id='_58_login']")).sendKeys("testfactory1.ibs");
		    mdriver.findElement(By.xpath(".//*[@id='_58_password']")).sendKeys("Ibs4321!");
		    mdriver.findElement(By.xpath(".//*[@id='_58_fm']/fieldset/div[1]/button")).click();
		    mdriver.findElement(By.xpath(".//*[@id='trigger1']/span")).click();
		    mdriver.findElement(By.xpath(".//*[@id='dropdown1']/ul/li/ul/li[1]/ul/li[3]/div/a")).click();
		    mdriver.findElement(By.xpath(".//*[@id='_eportaldgr_WAR_eportaldgrportlet_loadTemplateBtn']")).click();
		    
		    WebElement table=mdriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div/div/div/div[1]/div/div/div/table"));
		    List<WebElement>trows=table.findElements(By.tagName("tr"));
		    
		    
		    
			System.out.println("Total row count check is  --------"+trows.size());
			
			int row_num=0;
			int tr=0;
			for(WebElement rowElement : trows)
			{
				List<WebElement> totalColumns=rowElement.findElements(By.xpath("td"));
				System.out.println("Total column count check is  --------"+totalColumns.size());
				int col_num=1;
				for(WebElement columnElement : totalColumns)
				{
					System.out.println("row # "+row_num+", col # "+col_num+ "text="+columnElement.getText());
					if(columnElement.getText().toUpperCase().contains("DGR_BKG_1"))
					{
						pcount=pcount+1;
						tr=row_num;
						System.out.println("clicked");
						while(pcount<count+1)
						{
							 col_num=1;
							 if(columnElement.getText().toUpperCase().contains("DGR_BKG_1"))
							 {
								 
							 }
							
						}
						
					}
					col_num++;
				}
				row_num++;
			} 
			mdriver.findElement(By.xpath("//*[contains(@id,'yui_patched')]/tr["+tr+"]/td[6]/a[1]")).click();*/
	}

}
