package homePage;

import settings.makeSettingsBrowser;
import settings.waitFor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by noise on 02.09.17.
 */
public class homePage extends makeSettingsBrowser {

    public void bookingHome() throws Exception {

        new waitFor(continueB(), 1);

        Assert.assertTrue(title() == "https://www.ryanair.com/ie/en/booking/home");

        Assert.assertTrue(passengers("Adults").getText().contains("3"));
        Assert.assertTrue(passengers("Teen").getText().contains("1"));

        priceB("outbound").click();
        new waitFor(flightsT("outbound"), 1);



        priceB("inbound").click();
        new waitFor(flightsT("inbound"), 1);

    }


    String title() {
        return driver.getTitle();
    }

    WebElement continueB() {
        return driver.findElement(By.xpath("//span[@translate='trips.summary.buttons.btn_continue']"));
    }

    WebElement passengers(String passengers) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + passengers + "')]"));
    }

    WebElement flightsT(String table) {
        return driver.findElement(By.xpath("//flight-list[@id='" + table + "']" +
                "//div[@class='flights-table-fares']"));
    }

    WebElement priceB(String way) {
        return driver.findElement(By.xpath("//flight-list[@id='" + way + "']" +
                "//div[@class='flight-header__min-price hide-mobile']"));
    }

    WebElement selectStandartB(String way) {
        return driver.findElement(By.xpath("//flight-list[@id='" + way + "']" +
                "//div[@class='flights-table-fares__fare standard']" +
                "//button[@id='continue']"));
    }

    By wayToDeparture(String way) {
        return By.xpath("//flight-list[@id='" + way + "']" +
                "//div[@class='ranimate-flights-table flights-table__flight");
    }

    WebElement maxPriceB(String way) {
        int numberFlights = driver.findElements(wayToDeparture(way)).size();

        double maxPrice = 0;
        int number = 0;

        for (int i = 1 ; i < numberFlights + 1 ; i ++) {
            double value = Double.parseDouble(driver.findElement(By.xpath("//flight-list[@id='" + way + "']" +
                    "//div[contains(@class, 'ranimate-flights-table flights-table__flight')][" + numberFlights + "]" +
                    "//div[@class='flight-header__min-price hide-mobile']" +
                    "//span[contains(@class, 'flights-table-price__price')]")).getText().substring(2));

            if (maxPrice < value) {
                maxPrice = value;
                number = i;
            }
        }

        return driver.findElement(By.xpath("//flight-list[@id='" + way + "']" +
                "//div[contains(@class, 'ranimate-flights-table flights-table__flight')][" + number + "]" +
                "//div[@class='flight-header__min-price hide-mobile']" +
                "//span[contains(@class, 'flights-table-price__price')]"));
    }

    @Test
    public void test() throws Exception {

        maxPriceB("outbound").click();


    }



}
