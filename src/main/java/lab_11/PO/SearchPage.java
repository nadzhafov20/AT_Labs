package lab_11.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }





    public SearchPage searchUser() {
        driver.findElement(By.id("basic-addon2")).click();
        return this;
    }

    public SearchPage editButton() {
        driver.findElement(By.id("edit-record-4")).click();
        return this;
    }

    public SearchPage editUser(String tymur) {
        driver.findElement(By.id("firstName")).sendKeys("Tymur");
        return this;
    }

    public SearchPage SaveUser() {
        driver.findElement(By.id("submit")).click();
        return this;
    }
}
