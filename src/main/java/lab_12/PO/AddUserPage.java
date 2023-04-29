package lab_12.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static lab_12.WebDriverSupplier.driver;

public class AddUserPage {

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "age")
    WebElement age;
    @FindBy(id = "salary")
    WebElement salary;

    @FindBy(id = "department")
    WebElement department;

    @FindBy(id = "submit")
    WebElement submit;

    public AddUserPage() {
        PageFactory.initElements(driver,this);
    }


    public boolean isOpen() {
        return driver.findElement(By.id("registration-form-modal")).isDisplayed();
    }

    public AddUserPage inputUsername(String username) {
        firstName.sendKeys(username);
         return this;
    }

    public AddUserPage inputLastname(String nadzhafov) {
        lastName.sendKeys("Nadzhafov");
        return this;
    }

    public AddUserPage inputMail(String s) {
        userEmail.sendKeys("tymur@gmail.com");
        return this;
    }

    public AddUserPage age(String s) {
        age.sendKeys("21");
        return this;
    }

    public AddUserPage salary(String s) {
        salary.sendKeys("5000");
        return this;
    }

    public AddUserPage departament(String s) {
        department.sendKeys("it-step");
        return this;
    }

    public AddUserPage submite() {
        submit.click();
        return this;
    }
}
