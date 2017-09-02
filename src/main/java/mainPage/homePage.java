package mainPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by noise on 02.09.17.
 */
public class homePage extends makeSettingsBrowser {

    public void bookingHome() throws Exception {

        new waitFor(continueB(), 1);

        Assert.assertTrue(title() == "https://www.ryanair.com/ie/en/booking/home");

        Assert.assertTrue(passengersAdults().getText().contains("3"));
        Assert.assertTrue(passengersAdults().getText().contains("1"));

        priceB("outbound").click();
        new waitFor(flightsFromT(), 1);



        priceToB().click();
        new waitFor(flightsToT(), 1);

    }


    String title() {
        return driver.getTitle();
    }

    WebElement continueB() {
        return driver.findElement(By.xpath("//span[@translate='trips.summary.buttons.btn_continue']"));
    }

    WebElement passengersAdults() {
        return driver.findElement(By.xpath("//span[contains(text(),'Adults')]"));
    }

    WebElement passengersTeen() {
        return driver.findElement(By.xpath("//span[contains(text(),'Teen')]"));
    }

    WebElement priceB(String way) {
        return driver.findElement(By.xpath("//flight-list[@id='" + way + "']//div[@class='flight-header__min-price hide-mobile']"));
    }

    WebElement priceToB() {
        return driver.findElement(By.xpath("//flight-list[@id='inbound']//div[@class='flight-header__min-price hide-mobile']"));
    }

    WebElement flightsFromT() {
        return driver.findElement(By.xpath("//flight-list[@id='outbound']//div[@class='flights-table-fares']"));
    }
    WebElement flightsToT() {
        return driver.findElement(By.xpath("//flight-list[@id='inbound']//div[@class='flights-table-fares']"));
    }

    WebElement SelectB() {
        return driver.findElement(By.xpath("//div[@class='flights-table-fares__fare standard']//button[@id='continue']"));
    }


}
