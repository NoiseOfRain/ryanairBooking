package paymentPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.makeSettingsBrowser;

import java.util.List;

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

    WebElement signUpB() {
        return driver.findElement(By.xpath("//span[@translate='MYRYANAIR.SIGN_UP']"));
    }

    WebElement logInB() {
        return driver.findElement(By.xpath("//span[@translate='trips.checkout.passengers.login']"));
    }

    WebElement eMailInput() {
        return driver.findElement(By.xpath("//input[@placeholder='Email address']"));
    }

    WebElement ePassInput() {
        return driver.findElement(By.xpath("//input[@placeholder='Password']"));
    }

    WebElement logInAuthorizationB() {
        return driver.findElement(By.xpath("//button-spinner[@button-text='MYRYANAIR.AUTHORIZATION.LOGIN.LOGIN_AUTHORIZATION']"));
    }

    WebElement overTotal() {
        return driver.findElement(By.className("overall-total"));
    }

    Double total(WebElement overTotal) {
        int priceFrom = 0;
        for (int i = 0 ; i < overTotal.getText().length() ; i++) {
            if (overTotal.getText().charAt(i) == '€') {
                priceFrom = i;
            }
        }
        return Double.parseDouble(overTotal.getText().substring(priceFrom + 2));
    }

    /**заполняем пользователей*/

    String passengerInputS() {
        return "//passenger-input-group";
    }

    String passengerS(String name) {
        return "//select[@ng-model='passenger.name." + name + "']";
    }

    String passengerI(String name) {
        return "//input[@ng-model='passenger.name." + name + "']";
    }

    public void passengersFill() {
        List<WebElement> passengers = driver.findElements(By.xpath(passengerInputS()));
        for (int i = 0 ; i < passengers.size() ; i++) {
            driver.findElements(By.xpath(passengerInputS()+passengerS("title")+"//option[@label='Mr']")).get(i).click();
            for (int j = 0 ; j < i + 1 ; j++){
                driver.findElements(By.xpath(passengerInputS()+passengerI("first"))).get(i).sendKeys("Iv");
                driver.findElements(By.xpath(passengerInputS()+passengerI("last"))).get(i).sendKeys("De");
            }
        }
    }

    WebElement selectCountry() {
        return driver.findElement(By.xpath("//option[@label='Russia']"));
    }

    WebElement phoneNomberI() {
        return driver.findElement(By.xpath("//input[@name='phoneNumber']"));
    }

    WebElement cardNomberI() {
        return driver.findElement(By.xpath("//input[@name='cardNumber']"));
    }

    WebElement cardTypeSelect() {
        return driver.findElement(By.xpath("//option[@label='MasterCard Debit']"));
    }

    WebElement expiryMonthSelect() {
        return driver.findElement(By.xpath("//select[@name='expiryMonth']//option[@label='10']"));
    }

    WebElement expiryYearSelect() {
        return driver.findElement(By.xpath("//select[@name='expiryYear']//option[@label='2018']"));
    }

    WebElement securityCodeI() {
        return driver.findElement(By.xpath("//input[@name='securityCode']"));
    }

    WebElement cardHolderNameI() {
        return driver.findElement(By.xpath("//input[@name='cardHolderName']"));
    }

    WebElement billingAddressAddressLine1I() {
        return driver.findElement(By.xpath("//input[@name='billingAddressAddressLine1']"));
    }

    WebElement billingAddressCityI() {
        return driver.findElement(By.xpath("//input[@name='billingAddressCity']"));
    }

    WebElement acceptPolicyCheck() {
        return driver.findElement(By.xpath("//input[@name='acceptPolicy']"));
    }

    WebElement payNow() {
        return driver.findElement(By.xpath("//button[@translate='common.components.payment_forms.pay_now']"));
    }

    WebElement errorMessage() {
        return driver.findElement(By.xpath("//div[@translate='common.components.payment_forms.error_title']"));
    }

    WebElement errorTitle() {
        return driver.findElement(By.xpath("//h4[@translate='common.components.failed-payment.title']"));
    }

}