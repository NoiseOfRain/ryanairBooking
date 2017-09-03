package extrasPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import settings.commonObjects;

/**
 * Created by noise on 03.09.17.
 */
public class extrasPage extends extrasPageObjects {

    @Test(priority = 20)
    public void extrasPageCheck() throws Exception {
        Thread.sleep(5000);

        Assert.assertTrue(thisPage().equals("https://www.ryanair.com/ie/en/booking/extras"));

        System.out.println(commonObjects.getTotalCost());


    }
}
