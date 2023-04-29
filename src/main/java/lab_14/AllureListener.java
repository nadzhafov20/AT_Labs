package lab_14;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static lab_12.WebDriverSupplier.driver;

public class AllureListener implements ITestListener {

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
        LOGGER.error(result.getName()+" onTestFailure");
        makeScreenShot();
    }
    @Attachment(value="Page screen", type="image/png")
    private byte[] makeScreenShot(){
        LOGGER.error("makeScreenShot");
        if(null!=driver){
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}
            return new byte[0];


    }



}
