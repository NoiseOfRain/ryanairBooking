import org.testng.annotations.Test;
import settings.makeSettingsBrowser;

import static extrasPage.extrasPage.goNext;
import static homePage.homePage.clickContinue;
import static homePage.homePage.selectFlyOut;
import static homePage.homePage.selectFlyTo;
import static mainPage.goToMainPage.*;
import static paymentPage.paymentPage.*;
import static saveLogs.saveExeption.saveExeption;

/**
 * Created by noise on 03.09.17.
 */
public class mainTest extends makeSettingsBrowser {

    @Test(priority = 1)
    public void mainPage() throws Exception {
        try {
            chooseAirport("London Gatwick");
            selectDate("31-03-2018)", "10-04-2018");
            addPassengers(3, 1);
            letsGo();
        } catch (Exception e) {
            System.out.println(e);
            saveExeption(e);
        }
    }

    @Test(priority = 2)
    public void homePage() throws Exception {
        try {
            selectFlyOut();
            selectFlyTo();
            clickContinue();
        } catch (Exception e) {
            saveExeption(e);
        }
    }

    @Test(priority = 3)
    public void extrasPage() throws Exception {
        try {
            goNext();
        } catch (Exception e) {
            saveExeption(e);
        }
    }

    @Test(priority = 4)
    public void paymentPage() throws Exception {
        try {
            paymentLogIn("noiseor@gmail.com", "8JvFQXev1");
            passengerFillAll();
            fillContactDetails("Russia", "9993659955");
            billingAddress("street", "tlt");
            fillPaymentMethod("5555555555555557",10,2020,368,"Vasilyi");
        } catch (Exception e) {
            saveExeption(e);
        }
    }
}
