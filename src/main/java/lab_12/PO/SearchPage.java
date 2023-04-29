package lab_12.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static lab_12.WebDriverSupplier.driver;

public class SearchPage {


//findElement(By.id("basic-addon2"))
    @FindBy(id = "basic-addon2")
    WebElement basicaddon2;
    //findElement(By.id("edit-record-4"))
    @FindBy(id = "edit-record-4")
    WebElement editrecord4;
    //findElement(By.id("firstName"))
    @FindBy(id = "firstName")
    WebElement firstName;
    //findElement(By.id("submit"))
    @FindBy(id = "submit")
    WebElement submit;


    public SearchPage() {
        PageFactory.initElements(driver,this);
    }

    public SearchPage searchUser() {
        basicaddon2.click();
        return this;
    }

    public SearchPage editButton() {
        editrecord4.click();
        return this;
    }

    public SearchPage editUser(String tymur) {
        firstName.sendKeys("Tymur");
        return this;
    }

    public SearchPage SaveUser() {
        submit.click();
        return this;
    }
}
