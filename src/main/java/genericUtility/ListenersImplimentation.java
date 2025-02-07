package genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentation implements ITestListener{
	JavaUtility jutil=new JavaUtility();
	String dateTimeStamp=jutil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Listeners test started");
		Reporter.log(methodName+"Listeners test started");
		
		
		//Adding test method to reports
		test=report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Listeners test passed");
		Reporter.log(methodName+"Listeners test passed");
		
		test.log(Status.PASS, methodName+"test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Listeners test Failure");
		Reporter.log(methodName+"Listeners test Failure");
		test.log(Status.FAIL, methodName+"test failed");
		test.log(Status.INFO, result.getThrowable());
		SeleniumUtility sutil=new SeleniumUtility();
		try {
			String path=sutil.getWebpageScreenshot(BaseClass.sdriver, dateTimeStamp);
			//attaching screenshot to the report
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Listeners test skipped");
		Reporter.log(methodName+"Listeners test skipped");
		
		test.log(Status.SKIP, methodName+"test skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Listeners suite started");
		Reporter.log("Listeners suite started");
		//configuration of extent report
		ExtentSparkReporter repoter=new ExtentSparkReporter(".\\ExtentReport\\report-"+dateTimeStamp+".html");
		repoter.config().setDocumentTitle("Vtiger report");
		repoter.config().setReportName("Vtiger execution report");
		repoter.config().setTheme(Theme.STANDARD);
		
		//Generation of extent report 
		report=new ExtentReports();
		report.attachReporter(repoter);
		report.setSystemInfo("Base platform","Windows");
		report.setSystemInfo("Base Browser","Chrome");
		report.setSystemInfo("Base Engineer","Ram");
		report.setSystemInfo("Base Application","Vtiger");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("Listeners suite finished");
		Reporter.log("Listeners suite finished");
		
		//Flush out the report to create a report
		report.flush();
		
	}  
	

}
