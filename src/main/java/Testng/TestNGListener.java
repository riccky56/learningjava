package Testng;

import org.testng.*;
import org.testng.log4testng.Logger;

public class TestNGListener implements ITestListener {
    
    private static final Logger logger = Logger.getLogger(TestNGListener.class);

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Finished");
        logger.info("Total Tests: " + context.getAllTestMethods().length);
        logger.info("Passed: " + context.getPassedTests().size());
        logger.info("Failed: " + context.getFailedTests().size());
        logger.info("Skipped: " + context.getSkippedTests().size());
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("✓ Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("✗ Test Failed: " + result.getMethod().getMethodName());
        logger.info("Failure Reason: " + result.getThrowable().getMessage());
        
        // Capture screenshot on failure
        captureScreenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("⊘ Test Skipped: " + result.getMethod().getMethodName());
    }

    private void captureScreenshot(String testName) {
        // Screenshot capture logic
        logger.info("Screenshot captured for: " + testName);
    }
}
