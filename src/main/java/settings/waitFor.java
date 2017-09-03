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

    public waitFor() throws InterruptedException {

        firstLocator = By.name(driver.getTitle());

        for (int second = 0; ;second ++) {
            if (second >= 60) {
                fail("Timeout to find:");
            }
            try {
                if (true) break;
            }
            catch (NoSuchElementException e) {}
            Thread.sleep(1000);
        }
    }

    public waitFor(By firstLocator) throws InterruptedException {

        this.firstLocator = firstLocator;

        for (int second = 0; ;second ++) {
            if (second >= 60) {
                fail("Timeout to find:");
            }
            try {
                if (driver.findElement(firstLocator).isDisplayed()) break;
            }
            catch (NoSuchElementException e) {}
            Thread.sleep(1000);
        }
    }

    public waitFor(WebElement webElement) throws InterruptedException {

        this.webElement = webElement;

        for (int second = 0; ;second ++) {
            if (second >= 60) {
                fail("Timeout to find:");
            }
            try {
                if (webElement.isDisplayed()) break;
            }
            catch (NoSuchElementException e) {}
            Thread.sleep(1000);
        }
    }

    public waitFor (String waitForURl) throws InterruptedException {

        this.waitForURl = waitForURl;

        for (int second = 0; ;second ++) {
            if (second >= 60) {
                fail("Timeout to find:");
            }
            try {
                if (driver.getCurrentUrl().equals(waitForURl)) break;
            }
            catch (NoSuchElementException e) {}
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

    public static boolean isElementPresent(WebElement webElement) throws InterruptedException{
        try {
            webElement.isEnabled();
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
}
