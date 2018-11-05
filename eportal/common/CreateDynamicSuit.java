package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class CreateDynamicSuit  {

	XSSFWorkbook suiteWorkBook, moduleWorkBook,tcWorkBook, workbook_ = null;
	XSSFSheet suiteSheet, moduleSheet,testCaseSheet, sheet_ = null;

	
	List<XmlTest> allTests;
	
	ExcelRead excelread=new ExcelRead();
	
	/*****Taking the excel paths
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException *****/
	
	

	
	public XmlSuite addAllTest(XmlSuite suite, Map<String,String> testngParams) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		/* All the suite level paraleters added.
		 * All the test with run status as Yes to suite */
		XmlSuite appendedSuite = new XmlSuite();
		
		
		//ArrayList<String> modulesToRun = getModule_List(moduleSheetName);
		String tcSheetName = "Sheet1";
	
		appendedSuite = addTestToSuite(suite,  tcSheetName,testngParams);
		return appendedSuite;
	}
	/*@SuppressWarnings("rawtypes")
    public XmlSuite addListeners(XmlSuite suite,TestNG myTestNG ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
    
             
           
           List<Class> listenerClasses = new ArrayList<Class>();
        listenerClasses.add(common.TestNGListerner.class);
        
        //Uncomment if immediate execution of failed cases required
        *//*****listenerClasses.add(retryexecution.RetryListener.class);****//*
      
        myTestNG.setUseDefaultListeners(true);
        myTestNG.setListenerClasses(listenerClasses);
        
        
           return suite;
       
    }*/


	@SuppressWarnings({ "rawtypes", "deprecation" })
	public XmlSuite addListeners(XmlSuite suite,TestNG myTestNG ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//TestListenerAdapter tla = new TestListenerAdapter();
		  
		
		List<Class<? extends ITestNGListener>> listenerClasses = new ArrayList<Class<? extends ITestNGListener>>();
	    listenerClasses.add(common.TestNGListerner.class);
	  //Uncomment if immediate execution of failed cases required
        //*****listenerClasses.add(retryexecution.RetryListener.class);****//*
	  
	    myTestNG.setUseDefaultListeners(true);
	    myTestNG.setListenerClasses(listenerClasses);
	    
		return suite;
		
		
		
		/*TestListenerAdapter tla = new TestListenerAdapter();
		List<Class> listenerClasses = new ArrayList<Class>();
		listenerClasses.add(common.TestNGListerner.class);
		myTestNG.setUseDefaultListeners(true);
		myTestNG.addListener(tla);
		return suite;*/
		
	   
	}
	
	public String getTCPropertyValue(String excelName,String sheetName, int tcCount, int property) {
		/*
		 * Since we are reading from the 7th row in the template, 7 is hard
		 * coded
		 */
		InputStream inp = null;
		XSSFWorkbook wb = null;
		
		try {
			String s2 = System.getProperty("user.dir");
	
			
			String path = s2 +"\\Excels\\"+ excelName+".xlsx";
			inp = new FileInputStream(path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	

		try {
			wb = new XSSFWorkbook(inp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		 
		
		 
		 
			Row row = sheet.getRow(tcCount);
			Cell cell = row.getCell(property);
		
		
		
		return cell.getStringCellValue();
	}
	
	public ArrayList<String> getModule_List(String moduleSheetName) {
		//Purpose : modules with runstatus as yes fetched from moduleSheetName.
		ArrayList<String> modulesToExecute = new ArrayList<String>();
		moduleSheet = moduleWorkBook.getSheet(moduleSheetName);

		int iteration = 1;
		String moduleName, runStatus;

		try {
			while (!moduleSheet.getRow(0 + iteration).getCell(0)
					.getStringCellValue().isEmpty()) {
				Cell paramCell = moduleSheet.getRow(0 + iteration).getCell(0);
				paramCell.setCellType(1);
				moduleName = paramCell.getStringCellValue();

				Cell paramStatus = moduleSheet.getRow(0 + iteration).getCell(1);
				paramStatus.setCellType(1);
				runStatus = paramStatus.getStringCellValue();

				if (runStatus.equalsIgnoreCase("yes")) {
					modulesToExecute.add(moduleName);
				}
				iteration++;
			}
		} catch (NullPointerException e) {
		}
		return modulesToExecute;
	}
	/*
	 * public int getAllTestsCount() { totalTestCount = allTests.size(); return
	 * totalTestCount; }
	 */

	private boolean checkTCModuleRunStatus(ArrayList<String> modulesToRun,
			String moduleName) {
		return modulesToRun.contains(moduleName);
	}
	/*
	 * SuiteConfig.properties is hard coded since, we are not planning the user
	 * to enter any value for the parameter Total test count
	 */
	public void writeTestCountToProperties(int count) {
		//Purpose : Used to store the total suite to execute in a properties file for future reference.
		Properties props = new Properties();
		props.setProperty("TotalTestCount", "" + count);
		OutputStream out = null;

		String userDir = System.getProperty("user.dir");
		String propertyPath = userDir
				+ "\\src\\resources\\Properties\\SuiteConfig.properties";
		try {
			File f = new File(propertyPath);
			out = new FileOutputStream(f);
		} catch (Exception e) {
			out = null;
		}
		try {
			props.store(out, "writing total count to properties file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private XmlSuite addTestToSuite(XmlSuite suite,
			 String tcSheetName,Map<String,String> testngParams) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
	
	
		int iterator = 1;
	    int tcCount=excelread.getRowCount("Testcases", "Sheet1");
	    
	   
	   
		
		allTests = new ArrayList<XmlTest>();
		
		 XmlTest test = new XmlTest(suite);
		 
		
		List<XmlClass> classes;
		classes = new ArrayList<XmlClass>();
		//Map<String, String> tcParamMap = new HashMap<String, String>();
		
		
		while (iterator<=tcCount) {
		
			
			
		
			
			
		if (getTCPropertyValue("Testcases","Sheet1", iterator, 1).equalsIgnoreCase("Y")) {
			
			
			String testName=getTCPropertyValue("Testcases","Sheet1",  iterator,
					0);
		
		
			
			//tcParamMap.put("testName",testName);
					
					
			test.setName(testngParams.get("module"));
			
			
		
			
			classes.add(new XmlClass(testName));
			
			test.setXmlClasses(classes);
			
			allTests.add(test);
			
		}
		
		iterator++;
		}
		
		
		return suite;
		
		
		/*List<String> testCaseToExecute = new ArrayList<String>();
		testCaseSheet = tcWorkBook.getSheet(tcSheetName);

		int iterator = 1;
		boolean moduleRunStatus, tcRunStatus;
		String moduleName;
		allTests = new ArrayList<XmlTest>();

		try {
			while (!testCaseSheet.getRow(1 + iterator).getCell(1)
					.getStringCellValue().isEmpty()) {
				
				 * code to check if the TC belong to modules with run status as
				 * yes
				 
				testCaseSheet.getSheetName();
				testCaseSheet.getRow(1 + iterator).getCell(0);
				Cell moduleCell = testCaseSheet.getRow(1 + iterator).getCell(7);
				moduleCell.setCellType(1);
				moduleName = moduleCell.getStringCellValue();

				moduleRunStatus = checkTCModuleRunStatus(modulesToRun,
						moduleName);
				List<XmlClass> classes;
				if (moduleRunStatus) {

					XmlTest test = new XmlTest(suite);
					Map<String, String> tcParamMap = new HashMap<String, String>();
					 checking whether tc run status is yes 
					if (getTCPropertyValue(testCaseSheet, 1 + iterator, 3)
							.equalsIgnoreCase("yes")) {
						tcParamMap.put(
								"testName",
								getTCPropertyValue(testCaseSheet, 1 + iterator,
										2));
						
						tcParamMap.put(
								"browser",
								getTCPropertyValue(testCaseSheet, 1 + iterator,
										4));
						tcParamMap.put(
								"browserversion",
								getTCPropertyValue(testCaseSheet, 1 + iterator,
										5));
						tcParamMap.put(
								"description",
								getTCPropertyValue(testCaseSheet, 1 + iterator,
										6));
						tcParamMap.put(
								"testURL",
								getTCPropertyValue(testCaseSheet, 1 + iterator,
										11));
						test.setParameters(tcParamMap);
						test.setName(getTCPropertyValue(testCaseSheet,
								1 + iterator, 2));
						classes = new ArrayList<XmlClass>();
						// classes.add(new
						// XmlClass(getTCPropertyValue(testCaseSheet,
						// 1 + iterator, 0)+".class"));
						classes.add(new XmlClass(getTCPropertyValue(
								testCaseSheet, 1 + iterator, 1)));
						test.setXmlClasses(classes);
						// suite.addTest(test);
						allTests.add(test);
						iterator++;
					} else
						iterator++;
				} else
					iterator++;

			}

			suite.setTests(allTests);
		} catch (NullPointerException e) {
		}
		writeTestCountToProperties(allTests.size());
		return suite;*/
	}

}