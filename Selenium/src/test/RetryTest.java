package test;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {

	@Test(retryAnalyzer = test.RetryAnalyzer.class)
	public void Test1()
	{
		Assert.assertEquals(true, false);
	}

	@Test
	public void Test2()
	{
		Assert.assertEquals(false, true);
	}
}
