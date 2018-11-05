package test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class TableCellMultipleCols {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver mdriver=new FirefoxDriver();
		//2,Name;6:1
		
			String parameter="1,DGR;2,DGR_BKG_11;3,04JAN18";
			TreeMap<String,String>tm=new TreeMap<String,String>();
			int n=parameter.split(";").length;
			int allpass=0;
			for(int i=0;i<n;i++)
			{
				tm.put(parameter.split(";")[i].toString().split(",")[0].toString().trim(), parameter.split(";")[i].toString().split(",")[1].toString().trim());
			}
			System.out.println(tm);
		
			mdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		    int rows_count = trows.size();
		    
		    
			System.out.println("Total row count check is  --------"+trows.size());
			
			int row_num=0;
			int tr=0;
			/*for(WebElement rowElement : trows)
			{
				List<WebElement> totalColumns=rowElement.findElements(By.xpath("td"));
				System.out.println("Total column count check is  --------"+totalColumns.size());
				int col_num=1;
				for(WebElement columnElement : totalColumns)
				{
					System.out.println("row # "+row_num+", col # "+col_num+ "text="+columnElement.getText());
					if(columnElement.getText().toUpperCase().contains("DGR_BKG_1"))
					{
						tr=row_num;
						System.out.println("clicked");
					}
					col_num++;
				}
				row_num++;
			} */
			//mdriver.findElement(By.xpath("//*[contains(@id,'yui_patched')]/tr["+tr+"]/td[6]/a[1]")).click();
		    
			
			
			/*for (int row = 0; row < rows_count; row++) 
			{
				List < WebElement > Columns_row = trows.get(row).findElements(By.tagName("td"));
				int columns_count = Columns_row.size();
				System.out.println("Number of cells In Row " + row + " are " + columns_count);
				for (int column = 0; column < columns_count; column++)
				{
					String celtext = Columns_row.get(column).getText();
					System.out.println("Row number#"+(row+1)+"ColumnNumber#"+(column+1)+" value is"+celtext);
				}
				
			}*/
		  
			int row;
		  
			for ( row = 1; row < rows_count; row++) 
			{
				allpass=0;
				List < WebElement > Columns_row = trows.get(row).findElements(By.tagName("td"));
				int columns_count = Columns_row.size();
				System.out.println("Number of cells In Row " + row + " are " + columns_count);
				for (int column = 0; column < columns_count; column++)
				{
					String celtext = Columns_row.get(column).getText();
					System.out.println("Row number#"+(row)+"ColumnNumber#"+(column+1)+" value is"+celtext);
					
					
				}
				

				for(String k:tm.keySet())
				{
					
					if(Columns_row.get(Integer.parseInt(k)-1).getText().contains((tm.get(k))))
					{
						allpass++;
						System.out.println("Value :"+tm.get(k)+" Found in "+Columns_row.get(Integer.parseInt(k)-1).getText());
						
						
					}
					
					
				
				}
				System.out.println("All pass count is-->"+allpass+"N value is For RowNumber:"+row);
				if(allpass==n)
				{
					System.out.println("************All values are matched*********************** ");
					break;
				}
				else
				{
					System.out.println("All values are Not matched for Row"+row);
				}
				
				
			}
			
			
	}

}

