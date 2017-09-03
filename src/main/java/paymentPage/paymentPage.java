package paymentPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import settings.commonObjects;

/**
 * Created by noise on 03.09.17.
 */
public class paymentPage extends paymentPageObjects{

    @Test(priority = 20)
    public void paymentPageCheck() throws Exception {
        Thread.sleep(5000);

        Assert.assertTrue(thisPage().equals("https://www.ryanair.com/ie/en/booking/payment"));

        Assert.assertTrue(header().isDisplayed());
        Assert.assertTrue(signUp().isDisplayed());
        Assert.assertTrue(logIn().isDisplayed());


        System.out.println(commonObjects.getTotalCost());
    }
}
