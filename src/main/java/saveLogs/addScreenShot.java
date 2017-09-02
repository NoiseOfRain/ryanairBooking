package saveLogs;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import static mainPage.makeSettingsBrowser.driver;

/**
 * Created by noise on 31.08.17.
 */
public class addScreenShot {

    static String screenshotsWay = "src/main/resources/logs/";

    public static void screen(String method) throws Exception {
//создание скриншота
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File(screenshotsWay +
                method + ".png"));
    }
}
