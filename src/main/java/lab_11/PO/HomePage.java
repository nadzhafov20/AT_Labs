package lab_11.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public static final String URL="https://demoqa.com/webtables";

    public HomePage(WebDriver driver) {
        this.driver=driver;

        if(!URL.equals(driver.getCurrentUrl()));
        driver.get(URL);
    }

    public AddUserPage adduser() {
        driver.findElement(By.id("addNewRecordButton")).click();
        return new AddUserPage(driver);
    }

    public SearchPage searchBox(String nadzhafov) {
        driver.findElement(By.id("searchBox")).sendKeys("Nadzhafov");
        return new SearchPage(driver);
    }
}
