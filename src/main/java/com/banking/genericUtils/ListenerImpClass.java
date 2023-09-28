package com.banking.genericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener{
ExtentReports report;
ExtentTest test;

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./Extentreport/report.html");
		htmlreport.config().setDocumentTitle("Banking");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Online Banking System");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "windows 10");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Banking_System/");
		report.setSystemInfo("Reporter name", "Afshan");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		/*TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dtn = new File("./Screenshot/Failedscript.png");
		try {
			FileUtils.copyFile(src, dtn);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		String methodName = result.getMethod().getMethodName();
		try {
		WebDriverUtility wu = new WebDriverUtility();
		 String failedScript = wu.takeScreenShot(BaseClass.sdriver, methodName);
		 test.addScreenCaptureFromPath(failedScript);
	} catch(Throwable e)
		{
		e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, methodName+"====Failed");
		Reporter.log(methodName+"====> Failed");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, methodName+"---- skipped");
		Reporter.log(methodName+"-------> skipped");
 	}

	@Override
	public void onTestStart(ITestResult result) {
		//actual testscripts execution starts from here
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"---> Execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"----Passed");
		Reporter.log(methodName+"----Testscript executed successfully");
	}

}
