package extrasPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import settings.commonObjects;

/**
 * Created by noise on 03.09.17.
 */
public class extrasPage extends extrasPageObjects {

    @Test(priority = 20)
    public static void extrasPageCheck() throws Exception {
        Thread.sleep(5000);

        Assert.assertTrue(thisPage().equals("https://www.ryanair.com/ie/en/booking/extras"));
        Assert.assertTrue(selectTourSeat().isDisplayed());
        Assert.assertTrue(addYourBag().isDisplayed());
        Assert.assertTrue(addPriorityBoarding().isDisplayed());
        Assert.assertTrue(bookACar().isDisplayed());
        Assert.assertTrue(bookAHotel().isDisplayed());

        System.out.println(commonObjects.getTotalCost());
    }

    @Test(priority = 21)
    public static void goNext() throws Exception {
        extrasPageCheck();
        checkOutB().click();

        Thread.sleep(1000);
        Assert.assertTrue(seatPromptPopup().isDisplayed());

        okThanksB().click();
    }
}
