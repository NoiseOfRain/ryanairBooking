package paymentPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import saveLogs.addScreenShot;
import settings.commonObjects;

/**
 * Created by noise on 03.09.17.
 */
public class paymentPage extends paymentPageObjects{

    @Test(priority = 30)
    public void paymentPageCheck() throws Exception {
        Thread.sleep(5000);

        Assert.assertTrue(thisPage().equals("https://www.ryanair.com/ie/en/booking/payment"));

        Assert.assertTrue(header().isDisplayed());
        Assert.assertTrue(signUpB().isDisplayed());
        Assert.assertTrue(logInB().isDisplayed());

        System.out.println(commonObjects.getTotalCost());
    }

    @Test(priority = 31)
    public void paymentLogIn() throws Exception {
        logInB().click();

        eMailInput().sendKeys("noiseor@gmail.com");
        ePassInput().sendKeys("8JvFQXev1");

        logInAuthorizationB().click();
    }

    @Test(priority = 32)
    public void paymentCheckTotal() throws Exception {
        Thread.sleep(1000);

        System.out.println(commonObjects.getTotalCost());
        System.out.println(overTotal().getText());
    }

    @Test(priority = 33)
    public void passengerFillAll() throws Exception {
        passengersFill();
    }

    @Test(priority = 34)
    public void contactDetails() throws Exception {
        selectCountry().click();
        phoneNomberI().sendKeys("9993659955");
    }

    @Test(priority = 35)
    public void billingAddress() throws Exception {
        billingAddressAddressLine1I().sendKeys("street");
        billingAddressCityI().sendKeys("tlt");
        acceptPolicyCheck().click();
    }

    @Test(priority = 36)
    public void paymentMethod() throws Exception {
        cardNomberI().sendKeys("5555555555555557");
        cardTypeSelect().click();
        expiryMonthSelect().click();
        expiryYearSelect().click();
        securityCodeI().sendKeys("335");
        cardHolderNameI().sendKeys("Vasya");
        Thread.sleep(500);
        payNow().click();
        Thread.sleep(5000);
    }

    @Test(priority = 37)
    public void errorPay() throws Exception {
        while (true) {
            paymentMethod();

            if (errorTitle().isDisplayed()) {
                addScreenShot.screen("End");
                break;
            }
        }
    }

    @Test(priority = 38)
    public void END() throws Exception {
        System.out.println("OK?");
    }
}
