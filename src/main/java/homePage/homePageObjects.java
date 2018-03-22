package homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.makeSettingsBrowser;

import static settings.waitFor.isElementPresent;

/**
 * Created by noise on 03.09.17.
 */
public class homePageObjects extends makeSettingsBrowser {

    static boolean homePage() {
        return driver.getCurrentUrl().equals("https://www.ryanair.com/ie/en/booking/home");
    }

    static WebElement closeIcon() {
        return driver.findElement(By.xpath("//core-icon[contains(@class,'register-login-bar-close')]"));
    }

    static WebElement totalCostPrice() {
        return driver.findElement(By.xpath("//div[@class='price-number notranslate short-price']"));
    }

    public static Double totalCostDouble() {
        return Double.parseDouble(totalCostPrice().getText().substring(2));
    }

    static WebElement passengers(String passengers) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + passengers + "')]"));
    }

    static WebElement totalCostT() {
        return driver.findElement(By.className("breakdown"));
    }

    static WebElement tolalCostList() {
        return driver.findElement(By.className("breakdown-list-container"));
    }

    static WebElement continueB() {
        return driver.findElement(By.xpath("//span[@translate='trips.summary.buttons.btn_continue']"));
    }

    static WebElement singUp() {
        return driver.findElement(By.xpath("//span[@translate='MYRYANAIR.LAYOUT.HEADER.MYRYANAIR_SIGNUP']"));
    }

    static WebElement logIn() {
        return driver.findElement(By.xpath("//span[@translate='MYRYANAIR.LAYOUT.HEADER.MYRYANAIR_LOGIN']"));
    }

    static String flightsTstring(String table) {
        return "//flight-list[@id='" + table + "']";
    }

    static String depatureTstring(String way) {
        return flightsTstring(way) + "//div[contains(@class, 'ranimate-flights-table flights-table__flight')]";
    }

    static String priceBstring(String way) {
        return depatureTstring(way) + "//div[@class='flight-header__min-price hide-mobile']//span[contains(@class,'flights-table-price__price')]";
    }

    static String selectStandartB(String way) {
        return flightsTstring(way) + "//button[@id='continue']";
    }

    static WebElement maxPriceB(String way) throws InterruptedException {
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

    public static String addToEndS(int numbers) {
        if (numbers > 1) return "s";
        else return "";
    }
}
