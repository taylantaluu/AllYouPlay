package allYouPlay.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class BaseTest {


    protected WebDriver driver;
    protected Logger log;
    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;


    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        BrowserBase factory = new BrowserBase(browser, log);
        driver = factory.createDriver();

        driver.manage().window().maximize();

        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        driver.quit();
    }


}
