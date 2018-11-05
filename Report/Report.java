package report;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;





import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Report {


	public static String report_path="D:\\ExecutionReport\\";
	public static String html_report_path=report_path+"HtmlReport\\ExecutionReport.html";
	public static ExtentReports extent=new ExtentReports(html_report_path,true);
	
	
	public static ExtentTest test;
	/**
	 * @param args
	 * @throws AWTException 
	 */
	public static void getCellvalue() throws IOException, AWTException
	{
		
		FileInputStream fis=new FileInputStream(new File("D:\\ExecutionResult.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		//XSSFSheet sheet=workbook.getSheet("ExecutionResult");
	/*	Iterator<Row>rows=sheet.rowIterator();
		while(rows.hasNext())
		{
			Row row=rows.next();
			String Module=sheet.getRow(row.getRowNum()).getCell(0).toString();
			String Result=sheet.getRow(row.getRowNum()).getCell(1).toString();
			
			createReport(Module,Result);
		}*/
		Iterator<XSSFSheet>sheets=workbook.iterator();
		while(sheets.hasNext())
		{
			String SheetName=sheets.next().getSheetName();
			System.out.println(SheetName);
			XSSFSheet sheet1=(XSSFSheet) workbook.getSheet(SheetName);
			Iterator<Row>rows=sheet1.rowIterator();
			test=extent.startTest(SheetName, "Results");
			while(rows.hasNext())
			{
				Row row=rows.next();
				String TestCase=sheet1.getRow(row.getRowNum()).getCell(0).toString();
				String Result=sheet1.getRow(row.getRowNum()).getCell(1).toString();
				String Tester=sheet1.getRow(row.getRowNum()).getCell(2).toString();
				String issues=sheet1.getRow(row.getRowNum()).getCell(3).toString();
				createReport(SheetName,TestCase,Result,Tester,issues);
			}
			 
			
		}
		
		
		
		
		
		
	}
	public static void createReport(String SheetName,String Testcase,String Result,String Tester,String IssuesLogged) throws AWTException, IOException
	{
		 
		  
		  
		 
		
		
		 
		test.log(LogStatus.INFO,"Issues Logged :"+IssuesLogged );
		 test.log(LogStatus.INFO,"Tester :"+Tester );
		if(Result.equalsIgnoreCase("pass")) {
			
	        
	         test.log(LogStatus.PASS, "Module Executed Case : "+Testcase);
		}
		else{
			
			 test.log(LogStatus.INFO,SheetName );
		        
	         test.log(LogStatus.FAIL, "Module Executed Case is : "+Testcase);
	         
	         
		}
		 
	}
	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub

		getCellvalue();
		extent.endTest(test);
		extent.flush();
	}

}

