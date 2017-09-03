package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by noise on 31.08.17.
 */
public class makeSettingsBrowser {

    public static WebDriver driver;

    private String driverForBrowser = "webdriver.gecko.driver";
    //private String wayToDriver = "src/main/resources/drivers/geckodriver";
    private String wayToDriver = "src\\main\\resources\\drivers\\geckodriver.exe";

    @BeforeTest(alwaysRun = true)
    public void selectBrowser() throws Exception {

        System.setProperty(driverForBrowser, wayToDriver);

        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
