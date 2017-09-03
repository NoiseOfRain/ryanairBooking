package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.testng.FileAssert.fail;

/**
 * Created by noise on 01.09.17.
 */
public class waitFor extends makeSettingsBrowser{
    By firstLocator;
    String waitForURl;
    WebElement webElement;

    public waitFor() throws Exception {

        firstLocator = By.name(driver.getTitle());

        for (int second = 0; ;second ++) {
            if (second >= 60) {
                fail("Timeout to find:");
            }
            try {
                if (!driver.findElement(By.id("loader-dummy")).isDisplayed() && !driver.findElement(By.className("loader-timer")).isDisplayed()) break;
            }
            catch (Exception e) {}
            Thread.sleep(1000);
        }
    }

    public waitFor(By firstLocator) throws Exception {

        this.firstLocator = firstLocator;

        for (int second = 0; ;second ++) {
            if (second >= 60) {
                fail("Timeout to find:");
            }
            try {
                if (driver.findElement(firstLocator).isDisplayed() && driver.findElement(firstLocator).isEnabled()) break;
            }
            catch (Exception e) {}
            Thread.sleep(1000);
        }
    }

    public waitFor(WebElement webElement) throws Exception {

        this.webElement = webElement;

        for (int second = 0; ;second ++) {
            if (second >= 60) {
                fail("Timeout to find:");
            }
            try {
                if (webElement.isEnabled()) break;
            }
            catch (Exception e) {}
            Thread.sleep(1000);
        }
    }

    public waitFor(WebElement webElement, int status) throws Exception {

        this.webElement = webElement;

            for (int second = 0; ;second ++) {
                if (second >= 60) {
                    fail("Timeout to find:");
                }
                try {
                    if (webElement.isDisplayed()) break;
                }
                catch (Exception e) {}
                Thread.sleep(1000);
            }
    }

    public waitFor (String waitForURl) throws Exception {

        this.waitForURl = waitForURl;

        for (int second = 0; ;second ++) {
            if (second >= 60) {
                fail("Timeout to find:");
            }
            try {
                if (driver.getCurrentUrl().equals(waitForURl)) break;
            }
            catch (Exception e) {}
            Thread.sleep(1000);
        }
    }


    public static boolean isElementPresent(By by) throws InterruptedException{
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementNotPresent(By by) throws InterruptedException{
        try {
            driver.findElement(by);
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public boolean waitForVi() {
        return true;
    }
}
