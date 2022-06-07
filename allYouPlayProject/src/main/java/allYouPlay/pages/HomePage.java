package allYouPlay.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {

    private By homePageLoginButtonLocator=By.xpath("//div[contains(@class,'is-flex')]//a[contains(@href,'login')]");
    private By closePopUpLocator=By.xpath("//a[contains(@class,'image-close')]");
    private By myAccountButtonLocator=By.xpath("//ul[2]//a[contains(@href,'order/history')]");
    private By logoutButtonLocator=By.xpath("//ul[2]//a[contains(@href,'en/logout')]");
    private By myBasketButton=By.xpath(" //ul[2]//i[contains(@class,'cart')]");
    private By meesageField = By.xpath("//div[contains(@class,'is-text-small')]");
    private String pageUrl = "https://www.allyouplay.com/en/";




    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage() {
        try{
            log.info("Opening home page: " + pageUrl);
            openUrl(pageUrl);
            log.info("Home page opened!"); }
        catch  (Exception e)
        { log.info("Home page not opened"); }
    }

    public void closePopUp()
    {
        try{
            find(closePopUpLocator).isDisplayed();
            click(closePopUpLocator);
            log.info("pop-up closed.");  }
        catch (Exception e)
        { log.info("pop-up alredy closed."); }
    }

    public void moveUserLoginScreen()   {

        try {
            Thread.sleep(2000);
            click(homePageLoginButtonLocator);
            log.info("User will be login.");
        }catch (Exception e){
            log.info("User was previously login.");
        }
    }

    public void myBasketControl()   {

        try {
            find(myBasketButton);
            click(myBasketButton);
            log.info("My basket is opened");
        }catch (Exception e){
            log.info("My basket is not opened.");
        }
    }
    public boolean isMyAccountButtonVisible() {
        return find(myAccountButtonLocator).isDisplayed();
    }

    public boolean isLogoutButtonVisible() {
        return find(logoutButtonLocator).isDisplayed();
    }

    public String messageFieldVisible() {
        return find(meesageField).getText();

    }
}
