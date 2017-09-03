import org.testng.annotations.Test;
import settings.makeSettingsBrowser;

import static extrasPage.extrasPage.goNext;
import static homePage.homePage.clickContinue;
import static homePage.homePage.selectFlyOut;
import static homePage.homePage.selectFlyTo;
import static mainPage.goToMainPage.*;
import static paymentPage.paymentPage.paymentLogIn;

/**
 * Created by noise on 03.09.17.
 */
public class mainTest extends makeSettingsBrowser {

    @Test(priority = 1)
    public void mainPage() throws Exception {
        chooseAirport("London Gatwick");
        selectDate("06-10-2017)", "31-10-2017");
        addPassengers(3, 1);
        letsGo();
    }

    @Test(priority = 2)
    public void homePage() throws Exception {
        selectFlyOut();
        selectFlyTo();
        clickContinue();
    }

    @Test(priority = 3)
    public void extrasPage() throws Exception {
        goNext();
    }

    @Test(priority = 4)
    public void paymentPage() throws Exception {
        paymentLogIn();
    }
}
