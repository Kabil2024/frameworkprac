package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
        test.log(Status.FAIL, result.getThrowable());

        // Capture Screenshot on Failure

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        // Get latest Extent Report Path
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";

        File reportFile = new File(reportPath);
        if (reportFile.exists()) {
            try {
                Desktop.getDesktop().browse(reportFile.toURI());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //EmailUtils.sendEmailWithReport(reportPath);
    }

}