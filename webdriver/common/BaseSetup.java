package common;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public abstract class BaseSetup extends DriverSetup {
	protected ExtentReports extent;
	protected ExtentTest test;
	
	Calendar calendar = Calendar.getInstance();
	Date date = calendar.getTime();
	DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__HH_mm_ss");
	final String filePath = ".\\reports\\html\\ExtentReport_"+ dateFormat.format(date)+".html";
	
	protected String globalVarPath="\\src\\resources\\GlobalVariable.properties";
	
	@AfterMethod
	protected void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed");
		}
		ExtentManager.getReporterInstance().endTest(test);
		ExtentManager.getReporterInstance().flush();
	}

	@BeforeMethod
	public void startExtent(Method method) {
		test = ExtentManager.getReporterInstance().startTest(method.getDeclaringClass().getSimpleName());
	}

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.getReporter(filePath);
	}

	@AfterSuite
	protected void afterSuite() {
		extent.close();
	}

}