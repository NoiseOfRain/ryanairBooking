package paymentPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.makeSettingsBrowser;

import java.util.List;

/**
 * Created by noise on 03.09.17.
 */
public class paymentPageObjects extends makeSettingsBrowser {

    static String thisPage() {
        return driver.getCurrentUrl();
    }

    static WebElement header() {
        return driver.findElement(By.className("header-section"));
    }

    static WebElement signUpB() {
        return driver.findElement(By.xpath("//span[@translate='MYRYANAIR.SIGN_UP']"));
    }

    static WebElement logInB() {
        return driver.findElement(By.xpath("//span[@translate='trips.checkout.passengers.login']"));
    }

    static WebElement eMailInput() {
        return driver.findElement(By.xpath("//input[@placeholder='Email address']"));
    }

    static WebElement ePassInput() {
        return driver.findElement(By.xpath("//input[@placeholder='Password']"));
    }

    static WebElement logInAuthorizationB() {
        return driver.findElement(By.xpath("//button-spinner[@button-text='MYRYANAIR.AUTHORIZATION.LOGIN.LOGIN_AUTHORIZATION']"));
    }

    static WebElement overTotal() {
        return driver.findElement(By.className("overall-total"));
    }

    static Double total(WebElement overTotal) {
        int priceFrom = 0;
        for (int i = 0 ; i < overTotal.getText().length() ; i++) {
            if (overTotal.getText().charAt(i) == '€') {
                priceFrom = i;
            }
        }
        return Double.parseDouble(overTotal.getText().substring(priceFrom + 2));
    }

    /**заполняем пользователей*/

    static String passengerInputS() {
        return "//passenger-input-group";
    }

    static String passengerS(String name) {
        return "//select[@ng-model='passenger.name." + name + "']";
    }

    static String passengerI(String name) {
        return "//input[@ng-model='passenger.name." + name + "']";
    }



    public static void passengersFill() {
        List<WebElement> passengers = driver.findElements(By.xpath(passengerInputS()));
        for (int i = 0 ; i < passengers.size() ; i++) {
            driver.findElements(By.xpath(passengerInputS()+passengerS("title")+"//option[@label='Mr']")).get(i).click();
            for (int j = 0 ; j < i + 1 ; j++){
                driver.findElements(By.xpath(passengerInputS()+passengerI("first"))).get(i).sendKeys("Iv");
                driver.findElements(By.xpath(passengerInputS()+passengerI("last"))).get(i).sendKeys("De");
            }
        }
    }

    static WebElement selectCountry(String country) {
        return driver.findElement(By.xpath("//option[@label='" + country + "']"));
    }

    static WebElement phoneNomberI() {
        return driver.findElement(By.xpath("//input[@name='phoneNumber']"));
    }

    static WebElement cardNomberI() {
        return driver.findElement(By.xpath("//input[@name='cardNumber']"));
    }

    static WebElement cardTypeSelect() {
        return driver.findElement(By.xpath("//option[@label='MasterCard Debit']"));
    }

    static WebElement expiryMonthSelect(int month) {
        return driver.findElement(By.xpath("//select[@name='expiryMonth']//option[@label='" + month + "']"));
    }

    static WebElement expiryYearSelect(int year) {
        return driver.findElement(By.xpath("//select[@name='expiryYear']//option[@label='" + year + "']"));
    }

    static WebElement securityCodeI() {
        return driver.findElement(By.xpath("//input[@name='securityCode']"));
    }

    static WebElement cardHolderNameI() {
        return driver.findElement(By.xpath("//input[@name='cardHolderName']"));
    }

    static WebElement billingAddressAddressLine1I() {
        return driver.findElement(By.xpath("//input[@name='billingAddressAddressLine1']"));
    }

    static WebElement billingAddressCityI() {
        return driver.findElement(By.xpath("//input[@name='billingAddressCity']"));
    }

    static WebElement acceptPolicyCheck() {
        return driver.findElement(By.xpath("//input[@name='acceptPolicy']"));
    }

    static WebElement payNow() {
        return driver.findElement(By.xpath("//button[@translate='common.components.payment_forms.pay_now']"));
    }

    static By errorMessage() {
        return By.xpath("//div[@translate='common.components.payment_forms.error_title']");
    }

    static By errorTitle() {
        return By.xpath("//h4[@translate='common.components.failed-payment.title']");
    }

}