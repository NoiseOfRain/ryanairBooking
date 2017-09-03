package homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import saveLogs.addScreenShot;
import settings.makeSettingsBrowser;
import settings.waitFor;

import static settings.waitFor.isElementPresent;

/**
 * Created by noise on 02.09.17.
 */
public class homePage extends makeSettingsBrowser {

    WebElement passengers(String passengers) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + passengers + "')]"));
    }

    WebElement totalCostT() {
        return driver.findElement(By.className("breakdown"));
    }

    WebElement tolalCostList() {
        return driver.findElement(By.className("breakdown-list-container"));
    }

    WebElement continueB() {
        return driver.findElement(By.xpath("//span[@translate='trips.summary.buttons.btn_continue']"));
    }

    WebElement singUp() {
        return driver.findElement(By.xpath("//span[@translate='MYRYANAIR.LAYOUT.HEADER.MYRYANAIR_SIGNUP']"));
    }

    WebElement logIn() {
        return driver.findElement(By.xpath("//span[@translate='MYRYANAIR.LAYOUT.HEADER.MYRYANAIR_LOGIN']"));
    }

    String flightsTstring(String table) {
        return "//flight-list[@id='" + table + "']";
    }

    String depatureTstring(String way) {
        return flightsTstring(way) + "//div[contains(@class, 'ranimate-flights-table flights-table__flight')]";
    }

    String priceBstring(String way) {
        return depatureTstring(way) + "//div[@class='flight-header__min-price hide-mobile']//span[contains(@class,'flights-table-price__price')]";
    }

    String selectStandartB(String way) {
        return flightsTstring(way) + "//button[@id='continue']";
    }

    WebElement maxPriceB(String way) throws InterruptedException {
        int numberFlights = driver.findElements(By.xpath(depatureTstring(way))).size();

        double maxPrice = 0;
        int number = 0;


        for (int i = 0; i < numberFlights; i++) {
            if (isElementPresent(By.xpath(priceBstring(way)))) {
                String text = driver.findElements(By.xpath(priceBstring(way))).get(i).getText();
                int Euro = 0;
                double value = 0;

                for (int j = 0; j < text.length(); j++) {
                    if (text.charAt(j) == '€') {
                        Euro = j;
                        value = Double.parseDouble(driver.findElements(By.xpath(priceBstring(way))).get(i).getText().substring(Euro + 2));
                    }
                }

                if (maxPrice < value) {
                    maxPrice = value;
                    number = i;
                }
            }
        }
        return driver.findElements(By.xpath(priceBstring(way))).get(number);
    }

    @Test(priority = 9)
    public void assertionsHomePage() throws Exception {
        Thread.sleep(4000);

        Assert.assertTrue(driver.getCurrentUrl() == "https://www.ryanair.com/ie/en/booking/home");
        Assert.assertTrue(singUp().isDisplayed());
        Assert.assertTrue(logIn().isDisplayed());
        Assert.assertTrue(continueB().isDisplayed());

        Assert.assertTrue(passengers("Adults").getText() == "3 Adults");
        Assert.assertTrue(passengers("Teen").getText() == "1 Teen");

    }


    @Test(priority = 10)
    public void flyOut() throws Exception {
        new waitFor(driver.findElement(By.xpath(flightsTstring("outbound"))), 1);
        maxPriceB("outbound").click();
        new waitFor(By.xpath(selectStandartB("outbound")));
        driver.findElement(By.xpath(selectStandartB("outbound"))).click();
        Thread.sleep(1000);
    }

    @Test(priority = 11)
    public void flyTo() throws Exception {
        new waitFor(driver.findElement(By.xpath(flightsTstring("inbound"))), 1);
        maxPriceB("inbound").click();
        new waitFor(By.xpath(selectStandartB("inbound")));
        driver.findElement(By.xpath(selectStandartB("inbound"))).click();
        Thread.sleep(1000);
    }

    @Test(priority = 12)
    public void continueTest() throws Exception {
        totalCostT().click();
        new waitFor(tolalCostList(), 1);
        addScreenShot.screen("TotalPlay");
        continueB().click();
    }
}
