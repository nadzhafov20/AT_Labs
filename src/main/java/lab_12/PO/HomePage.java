package lab_12.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static lab_12.WebDriverSupplier.driver;

public class HomePage {
    @FindBy(id = "addNewRecordButton")
    WebElement addNewRecordButton;
    @FindBy(id = "searchBox")
    WebElement searchBox;
    public static final String URL="https://demoqa.com/webtables";

    public HomePage() {
        if(!URL.equals(driver.getCurrentUrl()));
        driver.get(URL);

        PageFactory.initElements(driver,this);
    }

    public AddUserPage adduser() {
        addNewRecordButton.click();
        return new AddUserPage();
    }

    public SearchPage searchBox(String nadzhafov) {
        searchBox.sendKeys("Nadzhafov");
        return new SearchPage();
    }
}
