package common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListerner implements ITestListener{

	
	@Override
	public void onTestStart(ITestResult result) {
	
		System.out.println("Testcases started and details are "+result.getTestClass());
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcases passed and details are "+result.getTestClass());
		
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Failed Method is "+result.getMethod());
		System.out.println("Failed Test Name is "+result.getName());
		
		System.out.println("Testcases failed and details are "+result.getTestClass());
		
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcases skipped and details are "+result.getTestClass());
		
	}

	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Testcases partially passed and details are "+result.getTestClass());
		
	}

	@Override
	public void onStart(ITestContext context) {
		//System.out.println("Execution started and details are "+context.getPassedTests());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//System.out.println("Execution finished and details are "+context.getPassedTests());
		
	}

}
