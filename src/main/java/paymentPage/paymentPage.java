package paymentPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import saveLogs.addScreenShot;
import settings.commonObjects;
import settings.waitFor;

import static settings.waitFor.isElementPresent;

/**
 * Created by noise on 03.09.17.
 */
public class paymentPage extends paymentPageObjects{

    @Test(priority = 30)
    public static void paymentPageCheck() throws Exception {
        Thread.sleep(3000);

        Assert.assertTrue(thisPage().equals("https://www.ryanair.com/ie/en/booking/payment"));

        Assert.assertTrue(header().isDisplayed());
        Assert.assertTrue(signUpB().isDisplayed());
        Assert.assertTrue(logInB().isDisplayed());

        System.out.println(commonObjects.getTotalCost());
    }

    @Test(priority = 31)
    public static void paymentLogIn(String login, String password) throws Exception {
        paymentPageCheck();

        logInB().click();

        eMailInput().sendKeys(login);
        ePassInput().sendKeys(password);

        logInAuthorizationB().click();
    }

    @Test(priority = 33)
    public static void passengerFillAll() throws Exception {
        passengersFill();
    }

    @Test(priority = 34)
    public static void fillContactDetails(String country, String phoneNumber) throws Exception {
        selectCountry(country).click();
        phoneNomberI().sendKeys(phoneNumber);
    }

    @Test(priority = 35)
    public static void billingAddress(String address, String city) throws Exception {
        billingAddressAddressLine1I().sendKeys(address);
        billingAddressCityI().sendKeys(city);
        acceptPolicyCheck().click();
    }

    @Test(priority = 36)
    public static void fillPaymentMethod(String cardNumber, int monthCard, int yearCard, int securityCode,
                                         String holderName) throws Exception {
        Assert.assertTrue(commonObjects.getTotalCost().equals(total(overTotal())));

        //for (int i = 0 ; i < 3 ; i++){
        while (true) {
            cardNomberI().sendKeys(cardNumber);
            cardTypeSelect().click();
            expiryMonthSelect(monthCard).click();
            expiryYearSelect(yearCard).click();
            securityCodeI().sendKeys(securityCode + "");
            cardHolderNameI().sendKeys(holderName);
            Thread.sleep(500);
            payNow().click();

            //new waitFor(errorMessage());

            if (isElementPresent(errorTitle())) {
                break;
            }
        }

        Assert.assertTrue(driver.findElement(errorTitle()).isDisplayed());
        addScreenShot.screen("End");
    }
}
