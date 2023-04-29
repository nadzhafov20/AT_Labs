package lab_12.BO;

import lab_12.PO.AddUserPage;
import lab_12.PO.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.UUID;

public class DemoblazeBO {

    private HomePage homePage;
    private AddUserPage addUserPage;
    private String username;




    public DemoblazeBO checkAddNewUser() {

        homePage = new HomePage();
        addUserPage = homePage.adduser();

        Assert.assertTrue(addUserPage.isOpen());

        username = randomString();

        addUserPage.inputUsername(username)
                .inputLastname("Nadzhafov")
                .inputMail("tymur@gmail.com")
                .age("21")
                .salary("5000")
                .departament("it-step")
                .submite();
        return this;
    }
    private String randomString() {
        return UUID.randomUUID().toString().substring(0,10).replace("-", "");
    }

    public void checkEditNewUser() {

        homePage.searchBox("Nadzhafov")
                .searchUser()
                .editButton()
                .editUser("Tymur")
                .SaveUser();
    }


    public void failTest() {
        Assert.fail();
    }
}
