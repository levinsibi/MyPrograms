package common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.IReporter;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class StartTest {
	
	

    static CreateDynamicSuite cds;
    
    

    /* Starting point of automated testing */
    
    public static void main(String[] args) {
	Reporter.log("##############Starting test #################");
	cds = new CreateDynamicSuite();
	int suiteCount = cds.getSuite_Count();

	for (int suite_index = 1; suite_index <= suiteCount; suite_index++) {
	    /* checking whether suite run status is Yes */
	    if (cds.getSuitePropertyValue(suite_index, 3).equalsIgnoreCase(
		    "yes")) {
		XmlSuite suite = new XmlSuite();
		suite.setName(cds.getSuitePropertyValue(suite_index, 1));
		suite.setThreadCount(4);		
		suite.setParameters(cds.getSuiteParameters(suite_index));
		suite = cds.addAllTest(suite, suite_index);

		File file = new File("TestNG_" + suite_index + ".xml");
		System.out.println("file" + file);
		
		FileWriter writer;
		try {
		    writer = new FileWriter(file);
		    writer.write(suite.toXml());
		    
		    
		    writer.close();
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG testng = new TestNG();
		// For Custom report generation
		TestListenerAdapter tla = new controls.CustomTestReport();
		testng.addListener(tla);
		// Added for extent reports
		IReporter extent = new controls.ExtentReporterNG();
		testng.addListener(extent);
		testng.setXmlSuites(suites);
		testng.setVerbose(1);		
		testng.run();
		
	    }
	 }
    }

}
