package lab_13;

import org.apache.log4j.Logger;
import org.testng.*;

public class TestListeners implements ITestListener {
    private final Logger LOGGER = Logger.getLogger(this.getClass());
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        //System.out.println(result.getName()+"onTestStart");
        LOGGER.info(result.getName()+" onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        //System.out.println(result.getName()+"onTestSuccess");
        LOGGER.info(result.getName()+" onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        //System.out.println(result.getName()+"onTestFailure");
        LOGGER.info(result.getName()+" onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        //System.out.println(result.getName()+"onTestSkipped");
        LOGGER.info(result.getName()+" onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        //System.out.println(result.getName()+"onTestFailedButWithinSuccessPercentage");
        LOGGER.info(result.getName()+" onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        //System.out.println(result.getName()+"onTestFailedWithTimeout");
        LOGGER.info(result.getName()+" onTestFailedWithTimeout");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        //System.out.println(context.getName()+"onStart");
        LOGGER.info(context.getName()+" onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        //System.out.println(context.getName()+"onFinish");
        LOGGER.info(context.getName()+" onFinish");
    }
}
