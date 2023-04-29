package lab_11;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import lab_11.BO.DemoblazeBO;
import lab_11.PO.AddUserPage;
import lab_11.PO.HomePage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

public class EndToEndTest {

    private WebDriver driver;
    @BeforeTest
    void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nadzh\\IdeaProjects\\task10\\src\\driver\\chromedriver.exe");

        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


    }
    @Test

    void endToEndTest(){
        //1 open page
        //2 add new user
        //3 check/search user
        //4 edit/delete new user


        //step1 and 2
        DemoblazeBO demoblazeBO=new DemoblazeBO(driver);
        //step 3 and 4
        demoblazeBO.checkAddNewUser().checkEditNewUser();


    }


}
