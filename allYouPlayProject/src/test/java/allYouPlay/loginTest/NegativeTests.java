package allYouPlay.loginTest;

import allYouPlay.base.BaseTest;
import allYouPlay.pages.HomePage;
import allYouPlay.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTests  extends BaseTest {

    @Parameters({ "username", "password" ,"expectedMessage"})
    @Test
    public void logInTest(String username, String password, String expectedMessage) {
        HomePage homePage = new HomePage(driver, log);
        LoginPage loginPage = new LoginPage(driver, log);
        homePage.openPage();
        homePage.closePopUp();
        homePage.moveUserLoginScreen();
        loginPage.userLoginProcess(username,password);
        String actualMessage = loginPage.errorMessageFieldVisible();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "actualMessage does not contain expectedMessage");

    }
}

