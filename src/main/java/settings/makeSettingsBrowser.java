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

    public static String wayToFile = "src/main/resources/logs/";
    // public static String wayToFile = "src\\main\\resources\\logs\\";
    private String driverForBrowser = "webdriver.gecko.driver";

    private String wayToDriver = "src/main/resources/drivers/geckodriverLinux";
    //private String wayToDriver = "src\\main\\resources\\drivers\\geckodriver.exe";
    //private String wayToDriver = "src/main/resources/drivers/geckodriverMac";

    @BeforeTest(alwaysRun = true)
    public void selectBrowser() {

        System.setProperty(driverForBrowser, wayToDriver);


        driver = new FirefoxDriver();


        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://www.ryanair.com/ie/en/");
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }





}
