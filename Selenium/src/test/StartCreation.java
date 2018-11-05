package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class StartCreation {

	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*XmlSuite suite = new XmlSuite();
		suite.setName("TmpSuite");

		XmlTest test = new XmlTest(suite);
		test.setName("TmpTest");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("test.SeleniumTest"));
		test.setXmlClasses(classes) ;


		//And then you can pass this XmlSuite to TestNG:

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();*/
		
		
		
		
			WebDriver f  = new FirefoxDriver();
		   f.get("http://mail.in.com");
		   f.get("http://toolsqa.com/mobile-automation/appium/install-android-sdk-adb-on-windows/");
			f.manage().window().maximize();
			System.out.println("Tilte is"+f.getTitle());
			
		   XmlSuite suite = new XmlSuite();
		   suite.setName("OMS");
		   XmlTest test1 = new XmlTest(suite);
		   test1.setName("TCase1");
		   List<XmlClass> classes = new ArrayList<XmlClass>();
		   classes.add(new XmlClass("test.StartCreation"));
		   List<XmlSuite> suite_a = new ArrayList<XmlSuite>();
		   suite_a.add(suite);
		   TestNG tng = new TestNG();
		   tng.setXmlSuites(suite_a);
		   tng.run();

	}

}
