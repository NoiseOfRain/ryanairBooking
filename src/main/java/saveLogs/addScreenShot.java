package saveLogs;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import static settings.makeSettingsBrowser.driver;
import static settings.makeSettingsBrowser.wayToFile;

/**
 * Created by noise on 31.08.17.
 */
public class addScreenShot {

    public static void screen(String method) throws Exception {
//создание скриншота
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File(wayToFile +
                method + ".png"));
    }
}
