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

        driver.get("https://demoqa.com/elements");
        //1
        WebElement webtables = driver.findElement(By.id("item-3"));
        webtables.click();
        //2
        WebElement webtables2 = driver.findElement(By.id("addNewRecordButton"));
        webtables2.click();
        //3
        WebElement webtables3 = driver.findElement(By.id("firstName"));
        webtables3.click();
        //4
        WebElement webtables4 = driver.findElement(By.id("lastName"));
        webtables4.click();
        //5
        WebElement webtables5 = driver.findElement(By.id("submit"));
        webtables5.click();



    }
}
