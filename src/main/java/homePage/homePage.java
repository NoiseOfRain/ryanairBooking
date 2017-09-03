package homePage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import saveLogs.addScreenShot;
import settings.commonObjects;
import settings.waitFor;

import static settings.commonObjects.getTotalAdults;
import static settings.commonObjects.getTotalTeen;
import static settings.commonObjects.totalAdults;

/**
 * Created by noise on 02.09.17.
 */
public class homePage extends homePageObjects {

    @Test(priority = 9)
    public static void assertionsHomePage() throws Exception {

        Thread.sleep(5000);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.ryanair.com/ie/en/booking/home"));

        Assert.assertTrue(singUp().isEnabled());
        Assert.assertTrue(logIn().isEnabled());
        Assert.assertTrue(continueB().isEnabled());

        Assert.assertTrue(passengers("Adult").getText().equals(getTotalAdults() + " Adult" + addToEndS(getTotalAdults())));
        Assert.assertTrue(passengers("Teen").getText().equals(getTotalTeen() + " Teen" + addToEndS(getTotalTeen())));
    }


    @Test(priority = 10)
    public static void  selectFlyOut() throws Exception {
        assertionsHomePage();
        new waitFor(driver.findElement(By.xpath(flightsTstring("outbound"))));
        maxPriceB("outbound").click();

        closeIcon().click();
        new waitFor(By.xpath(selectStandartB("outbound")));
        driver.findElement(By.xpath(selectStandartB("outbound"))).click();
        Thread.sleep(1000);
    }

    @Test(priority = 11)
    public static void selectFlyTo() throws Exception {
        new waitFor(driver.findElement(By.xpath(flightsTstring("inbound"))));
        maxPriceB("inbound").click();
        new waitFor(By.xpath(selectStandartB("inbound")));
        driver.findElement(By.xpath(selectStandartB("inbound"))).click();
        Thread.sleep(1000);
    }

    @Test(priority = 12)
    public static void clickContinue() throws Exception {
        totalCostT().click();
        new waitFor(tolalCostList());
        addScreenShot.screen("TotalPlay");

        Thread.sleep(1000);

        commonObjects.setTotalCost(totalCostDouble());

        continueB().click();
    }
}
