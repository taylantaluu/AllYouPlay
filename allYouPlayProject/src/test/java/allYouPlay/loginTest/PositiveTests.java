package allYouPlay.loginTest;

import allYouPlay.base.BaseTest;

import allYouPlay.pages.HomePage;
import allYouPlay.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PositiveTests extends BaseTest {

    @Parameters({ "username", "password","expectedMessage"})
    @Test
    public void logInTest(String username, String password, String expectedMessage) {
        HomePage homePage = new HomePage(driver, log);
        LoginPage loginPage = new LoginPage(driver, log);
        homePage.openPage();
        homePage.closePopUp();
        homePage.moveUserLoginScreen();
        loginPage.userLoginProcess(username,password);
        Assert.assertTrue(homePage.isMyAccountButtonVisible(), "My account button is not visible");
        Assert.assertTrue(homePage.isLogoutButtonVisible(), "Logout button is not visible");
        homePage.myBasketControl();
        String actualMessage = homePage.messageFieldVisible();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "actualMessage does not contain expectedMessage");


    }
}
