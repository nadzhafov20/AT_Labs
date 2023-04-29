package lab_12;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import lab_12.BO.DemoblazeBO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddNewUserTest {


    @BeforeTest
    void setup() {
        WebDriverSupplier.setupDriver();




    }
    @Test

    void endToEndTest(){
        //1 open page
        //2 add new user
        //3 check/search user
        //4 edit/delete new user


        //step1 and 2
        DemoblazeBO demoblazeBO=new DemoblazeBO();
        //step 3 and 4
        demoblazeBO.checkAddNewUser().checkEditNewUser();


    }


}
