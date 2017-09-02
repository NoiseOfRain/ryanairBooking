package mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by noise on 31.08.17.
 */
public class makeSettingsBrowser {

    public static WebDriver driver;

    //private Profile profileBrowser = new FirefoxProfile();

    private String driverForBrowser = "webdriver.gecko.driver";
    private String wayToDriver = "src/main/resources/drivers/geckodriver";

    @BeforeTest(alwaysRun = true)
    public void selectBrowser() throws Exception {

        System.setProperty(driverForBrowser, wayToDriver);

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
