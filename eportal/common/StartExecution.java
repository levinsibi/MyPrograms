
package common;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.XmlSuite;
//import org.apache.log4j.xml.DOMConfigurator;



public class StartExecution extends Utility {

	CreateDynamicSuit cds=new CreateDynamicSuit();
	
	
	
public void saveTestng( XmlSuite mySuite)

{
	 String s2 = System.getProperty("user.dir");
	 
	 System.out.println("workspace "+System.getProperty("user.dir"));
	    File file = new File(s2+"\\testng"+ ".xml");
		System.out.println("file" + file);
		FileWriter writer;
		try {
		    writer = new FileWriter(file);
		    writer.write(mySuite.toXml());
		    writer.close();
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    
}
public void runfailedCases(String filePath)

{

	File file = new File(filePath);
	
	if(file.exists())
	{
	
	TestNG testng = new TestNG();
	List<String> suites = Lists.newArrayList();
	suites.add(filePath);

	testng.setTestSuites(suites);
	testng.run();
	}
	
		
}
public void deleteXml(String filePath)
{
	File file = new File(filePath);
	
	if(file.exists())
	{
		System.out.println("enterrr deletee");
		file.delete();
	}
	
}
	public void runTestNGTest(Map<String,String> testngParams) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		//Create an instance on TestNG
		 TestNG myTestNG = new TestNG();
		 
		
		 		
		//Create an instance of XML Suite and assign a name for it.
		 XmlSuite mySuite = new XmlSuite();
		mySuite.setName(testngParams.get("suitName"));
		 	
		 
		//Create an instance of XmlTest and assign a name for it.
		/**** XmlTest myTest = new XmlTest(mySuite);
	     myTest.setName(testngParams.get("module"));****/
		 
		
		//Add any parameters that you want to set to the Test.
	
		mySuite.setParameters(testngParams);
		 
		 
		 
		 
		 
		 
		//Adding Listeners
		mySuite=cds.addListeners(mySuite,myTestNG);
		
		
		 
			//Create a list which can contain the classes that you want to run.
		 
		mySuite=cds.addAllTest(mySuite,testngParams);
		
	
		 
		//Add the suite to the list of suites.
		 List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		 mySuites.add(mySuite);
		 
		//Set the list of Suites to the testNG object you created earlier.
		 myTestNG.setXmlSuites(mySuites);
		 
		
	

		 
		
		 
		 //Store testng xml
		
		 saveTestng(mySuite);
		   
		//invoke run() - this will run your class.
		 myTestNG.run();
		 
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		System.out.println(System.getProperty("user.dir"));
		PropertyConfigurator.configure("Log4j.properties");
		
	//This Map can hold your testng Parameters.
		 Map<String,String> testngParams = new HashMap<String,String> ();
		 StartExecution createxml=new StartExecution();
		 
		
		 //Getting the parameters from the excel Parameters
		 
	     CreateDynamicSuit cds=new CreateDynamicSuit();
		 
		 //Browser
		String browser= cds.getTCPropertyValue("Parameters", "Sheet1", 1, 0);
		
		//Module
		String module=cds.getTCPropertyValue("Parameters", "Sheet1", 1, 1);
		
		//Suit Name
		String suitName=cds.getTCPropertyValue("Parameters", "Sheet1", 1, 2);
			
		//TestNG failed suit
		
		String testNGPath=System.getProperty("user.dir")+"//test-output//testng-failed.xml";
		//Assigning values to hashmap
		testngParams.put("browser", browser);
	    testngParams.put("module", module);
		testngParams.put("suitName", suitName);
		 
		createxml.runTestNGTest(testngParams);
		 
		//DOMConfigurator.configure("log4j.xml");
		
		if(retryExecutionFlag==true)
		 {
		 createxml.runfailedCases(testNGPath);
		 }
		
		

	}

}
