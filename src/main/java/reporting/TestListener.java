package reporting;

import java.sql.DriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class TestListener implements ITestListener {
    private ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest t = extent.createTest(result.getMethod().getMethodName(),
                                         result.getMethod().getDescription());
        t.assignCategory(result.getTestContext().getName());
        ExtentTestManager.setTest(t);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest t = ExtentTestManager.getTest();
        t.log(Status.FAIL, result.getThrowable());
        String base64 = ((TakesScreenshot) DriverManager.getDrivers()).getScreenshotAs(OutputType.BASE64);
        t.fail("Screenshot on failure",
               MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}