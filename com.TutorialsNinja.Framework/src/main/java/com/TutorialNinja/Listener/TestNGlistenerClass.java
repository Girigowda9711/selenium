package com.TutorialNinja.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TutorialNinja.BaseTest.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestNGlistenerClass implements ITestListener {
	protected  ExtentSparkReporter spark;
	protected ExtentReports report;
	protected ExtentTest test;


	

	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,"TESTCASE IS FAILED"+result.getName());
			test.log(Status.FAIL,"TESTCASE IS FAILED"+result.getThrowable());
		String screenshot = BaseClass.getScreenshotAs(result.getName());
		test.addScreenCaptureFromPath(screenshot);
			
			
			
			
			
		}
		
	}

	public void onTestSuccess(ITestResult result) {


	}

	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()==ITestResult.SKIP){
	   test.log(Status.SKIP,"TESTCASE IS SKIPPED"+result.getName());
   }

	}

	public void onStart(ITestContext context) {
		spark=new ExtentSparkReporter("./extent/report.html");
		spark.config().setDocumentTitle("ExtentReport");
		spark.config().setReportName("Girigowda");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS ","Windows 10");
		report.setSystemInfo("Browser","Chrome");
		report.setSystemInfo("Browser version","108");
		report.setSystemInfo("QA","Girigowda");





	}

	public void onFinish(ITestContext context) {
		report.flush();


	}



}
