package allYouPlay.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {


    private By usernameLocator = By.id("Email");
    private By passwordLocator = By.id("Password");
    private By logInButtonLocator = By.xpath("//button[contains(@class,'btn btn-primary is')]");
    private By errorMessageLocator = By.xpath("//div[contains(@class,'validation-summary-errors')]//li");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void userLoginProcess(String username,String password)   {

        try {
            fill(username,usernameLocator);
            fill(password,passwordLocator);
            click(logInButtonLocator);
            log.info("User logged in.");

        }catch (Exception e){
            log.error("User login failed.");
        }
    }


    public String errorMessageFieldVisible() {
        return find(errorMessageLocator).getText();

    }


}
