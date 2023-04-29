package lab_10v1;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumStart {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nadzh\\IdeaProjects\\task10\\src\\driver\\chromedriver.exe");


        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/webtables");
//        //1
//        WebElement webtables = driver.findElement(By.id("item-3"));
//        webtables.click();

        WebElement webtables1 = driver.findElement(By.id("delete-record-1"));
        webtables1.click();
        System.out.println("click" + webtables1);

        WebElement webtables2 = driver.findElement(By.id("delete-record-2"));
        webtables2.click();
        System.out.println("click" + webtables2);

        WebElement webtables3 = driver.findElement(By.id("delete-record-3"));
        webtables3.click();
        System.out.println("click" + webtables3);

        //2
        WebElement webtables4 = driver.findElement(By.id("addNewRecordButton"));
        webtables4.click();
        System.out.println("click" + webtables4);




    }
}
