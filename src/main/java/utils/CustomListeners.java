package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;
import com.relevantcodes.extentreports.ExtentTest;

public class CustomListeners  implements ITestListener, ISuiteListener {

    public ExtentReports rep = ExtentManager.getInstance();
    public static ExtentTest test;
    public String messageBody;

    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestFailure(ITestResult arg0) {

        test.log(LogStatus.FAIL, arg0.getName().toUpperCase() + " FAIL");
        rep.endTest(test);
        rep.flush();

    }

    public void onTestSkipped(ITestResult arg0) {


        test.log(LogStatus.SKIP, arg0.getName().toUpperCase() + " Skipped the test as the Run mode is NO");
        rep.endTest(test);
        rep.flush();

    }


    public void onTestStart(ITestResult arg0) {

        test = rep.startTest(arg0.getName().toUpperCase());

    }

    public void onTestSuccess(ITestResult arg0) {


        test.log(LogStatus.PASS, arg0.getName().toUpperCase() + " PASS");
        rep.endTest(test);
        rep.flush();

    }

    public void onFinish(ISuite arg0) {


    }

    public void onStart(ISuite arg0) {
        // TODO Auto-generated method stub

    }
}