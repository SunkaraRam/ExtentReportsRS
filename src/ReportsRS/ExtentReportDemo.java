package ReportsRS;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDemo {
	
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	
	public void generatereport(){
	//define path for html report
	report=new ExtentReports("d://mystatus.html");	
	}
	@Test
	public void testcase1()
	{
	test=report.startTest("testcase1", "Testcase1 passed");
	test.log(LogStatus.PASS, "Testcase pass");
	}
	@Test(timeOut=5000)
	public void testcase2() throws InterruptedException
	{
	test=report.startTest("Testcase2", "testcase fail");
	test.log(LogStatus.FAIL, "Testcase Failed");
	Thread.sleep(6000);
	}
	@Test
	public void testcase3()
	{
		test=report.startTest("Testcase 3", "Skipping");
		test.log(LogStatus.SKIP, "Skipping testcase");
		throw new SkipException("skiping testcase");
	}
	@AfterTest
	public void close()
	{
		report.close();
	}
	@AfterMethod
	public void endreport()
	{
	report.flush();
	report.endTest(test);
	}


}
