package lab_11.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUserPage {
    private WebDriver driver;
    public AddUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpen() {
        return driver.findElement(By.id("registration-form-modal")).isDisplayed();
    }

    public AddUserPage inputUsername(String username) {
        driver.findElement(By.id("firstName")).sendKeys(username);
         return this;
    }

    public AddUserPage inputLastname(String nadzhafov) {
        driver.findElement(By.id("lastName")).sendKeys("Nadzhafov");
        return this;
    }

    public AddUserPage inputMail(String s) {
        driver.findElement(By.id("userEmail")).sendKeys("tymur@gmail.com");
        return this;
    }

    public AddUserPage age(String s) {
        driver.findElement(By.id("age")).sendKeys("21");
        return this;
    }

    public AddUserPage salary(String s) {
        driver.findElement(By.id("salary")).sendKeys("5000");
        return this;
    }

    public AddUserPage departament(String s) {
        driver.findElement(By.id("department")).sendKeys("it-step");
        return this;
    }

    public AddUserPage submite() {
        driver.findElement(By.id("submit")).click();
        return this;
    }
}
