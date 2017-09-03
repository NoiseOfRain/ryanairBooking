package paymentPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.makeSettingsBrowser;

/**
 * Created by noise on 03.09.17.
 */
public class paymentPageObjects extends makeSettingsBrowser {

    String thisPage() {
        return driver.getCurrentUrl();
    }

    WebElement header() {
        return driver.findElement(By.className("header-section"));
    }

    WebElement signUp() {
        return driver.findElement(By.xpath("//button[@translate='MYRYANAIR.SIGN_UP']"));
    }

    WebElement logIn() {
        return driver.findElement(By.xpath("//button[@translate='trips.checkout.passengers.login']"));
    }
}
