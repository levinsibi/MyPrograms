package test;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class VerifyLinks {
 
	public static void main(String[] args) throws IOException 
	{
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://vmh-lcag-eport01-icapsit.lsy.fra.dlh.de:8012/");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println("Total links are "+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			
			WebElement ele= links.get(i);
			
			String url=ele.getAttribute("href");
			
			String resp=verifyLinkActive(new URL(url));
			System.out.println("The resultant url:"+i +"is"+url+" and response code is "+resp);
			
		}
		
	}
	
	public static String verifyLinkActive(URL url) throws IOException
	{
        /*try 
        {
        	
           URL url = new URL(linkUrl);
           
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(3000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {
           
        }*/
		
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		 
		try
 
		{
 
		    connection.connect();
 
		    String response = connection.getResponseMessage();	        
 
		    connection.disconnect();
 
		    return response;
 
		}
 
		catch(Exception exp)
 
		{
 
			return exp.getMessage();
 
		}				
		
    } 
	
	
	 
 
}