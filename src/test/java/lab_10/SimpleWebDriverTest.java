package lab_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleWebDriverTest {
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
    void simpleWDTest() {


        //step 1
        driver.get("https://demoqa.com/webtables");

        WebElement webtables1 = driver.findElement(By.id("delete-record-1"));
        Assert.assertTrue(webtables1.isDisplayed());

        WebElement webtables2 = driver.findElement(By.id("delete-record-2"));
        Assert.assertTrue(webtables2.isDisplayed());

        WebElement webtables3 = driver.findElement(By.id("delete-record-3"));
        Assert.assertTrue(webtables3.isDisplayed());

        WebElement webtables4 = driver.findElement(By.id("addNewRecordButton"));
        Assert.assertTrue(webtables4.isDisplayed());



    }
    @AfterTest
    void CloseBrowser(){
        driver.close();
        driver.quit();
    }
}

