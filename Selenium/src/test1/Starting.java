package test1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Starting {
	int i=0;
  @Test
  public void f() {
	  try
	  {
	  WebDriver f  = new FirefoxDriver();
	  if(i==0)
	  {
	   f.get("http://mail.in.com");
	   
	  }
	  else
	  {
	   f.get("http://toolsqa.com/mobile-automation/appium/install-android-sdk-adb-on-windows/");
	  }
		f.manage().window().maximize();
		System.out.println("Tilte is"+f.getTitle());
		f.findElement(By.xpath(".//*[@id='primary-menu']/li[1]/a/span[1]/span/span")).click();
	   XmlSuite suite = new XmlSuite();
	   suite.setName("OMS");
	   XmlTest test1 = new XmlTest(suite);
	   test1.setName("TCase1");
	   List<XmlClass> classes = new ArrayList<XmlClass>();
	   classes.add(new XmlClass("test1.Starting"));
	   List<XmlSuite> suite_a = new ArrayList<XmlSuite>();
	   suite_a.add(suite);
	   TestNG tng = new TestNG();
	   tng.setXmlSuites(suite_a);
	   tng.run();
	  }
	  catch(Exception ex)
	  {
		   i=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter 1 or 0"));
		  if(i==1)
		  {
		  f();
		  }
	  }
  }
  
}
