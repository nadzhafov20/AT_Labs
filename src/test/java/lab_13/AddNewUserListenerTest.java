package lab_13;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import lab_12.BO.DemoblazeBO;
import lab_12.WebDriverSupplier;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteListeners.class, TestListeners.class, UniversalVideoListener.class})
public class AddNewUserListenerTest {


    @BeforeTest
    void setup() {
        WebDriverSupplier.setupDriver();




    }
    @Video
    @Test
    void endToEndTest(){
        //1 open page
        //2 add new user
        //3 check/search user
        //4 edit/delete new user


        //step1 and 2
        DemoblazeBO demoblazeBO=new DemoblazeBO();
        //step 3 and 4
        demoblazeBO.checkAddNewUser().checkEditNewUser();


    }
    @Video
    @Test
    void endToEndFailTest(){
        //1 open page
        //2 add new user
        //3 check/search user
        //4 edit/delete new user


        //step1 and 2
        DemoblazeBO demoblazeBO=new DemoblazeBO();
        //step 3 and 4
        demoblazeBO.checkAddNewUser().failTest();



    }






}
