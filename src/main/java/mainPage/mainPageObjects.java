package mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.makeSettingsBrowser;

/**
 * Created by noise on 02.09.17.
 */
public class mainPageObjects extends makeSettingsBrowser {

    static WebElement coociesPolicy() {
        return driver.findElement(By.className("close-icon"));
    }

    static WebElement signupMenuB() {
        return driver.findElement(By.id("myryanair-auth-signup"));
    }
    static WebElement loginMenuB() {
        return driver.findElement(By.id("myryanair-auth-login"));
    }
    static WebElement helpMenuB() {
        return driver.findElement(By.id("menu-links-right"));
    }
    static WebElement lenguageMenuB() {
        return driver.findElement(By.id("markets"));
    }

    static WebElement twoWaysTicketsCheck() {
        return driver.findElement(By.id("flight-search-type-option-return"));
    }
    static WebElement oneWayTicketCheck() {
        return driver.findElement(By.id("flight-search-type-option-one-way"));
    }

    static WebElement continueB() {
        return driver.findElement(By.xpath("//span[@translate='common.buttons.continue']"));
    }

    static WebElement inputFlyOut(String parameter) {
        return driver.findElement(By.xpath("//input[@aria-label='Fly out: - " + parameter + "']"));
    }
    static WebElement inputFlyBack(String parameter) {
        return driver.findElement(By.xpath("//input[@aria-label='Fly back: - " + parameter + "']"));
    }

    static WebElement airportName(String name) {
        return driver.findElement(By.xpath("//strong[contains(text(), '" + name + "')]"));
    }

    static WebElement leftArrow() {
        return driver.findElement(By.xpath("//button[@class='arrow left']"));
    }
    static WebElement rightArrow() {
        return driver.findElement(By.xpath("//button[@class='arrow right']"));
    }

    static WebElement letsGoB() {
        return driver.findElement(By.xpath("//span[@translate='common.buttons.lets_go']"));
    }

    static WebElement passangersB() {
        return driver.findElement(By.xpath("//div[@aria-label='Select number of passengers']"));
    }

    static WebElement popupCalendar() {
        return driver.findElement(By.xpath("//div[@ng-transclude='contentSlot']"));
    }
    static WebElement popupStartDate() {
        return driver.findElement(By.className("start-date"));
    }
    static WebElement popupEndDate() {
        return driver.findElement(By.className("end-date"));
    }

    static WebElement inputLineFrom() {
        return driver.findElement(By.xpath("//input[@placeholder='Departure airport']"));
    }
    static WebElement inputLineTo() {
        return driver.findElement(By.xpath("//input[@placeholder='Destination airport']"));
    }

    static WebElement popupInfant() {
        return driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_infant_popup.message']"));
    }

    static WebElement buttonOkInfant() {
        return driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_infant_popup.ok']"));
    }

    static WebElement popupAirports() {
        return driver.findElement(By.xpath("//popup-content[contains(@class, 'core-popup-content-searchbox')]"));
    }

    static WebElement popubPassengers() {
        return driver.findElement(By.xpath("//popup-content[@role='listbox']"));
    }
    static WebElement passengerPlusB(String passenger) {
        return driver.findElement(By.xpath("//div[@value='paxInput." + passenger + "']//core-icon[@icon-id='glyphs.plus-circle']"));
    }
    static WebElement passengerPlusM(String passenger) {
        return driver.findElement(By.xpath("//div[@value='paxInput." + passenger + "']//core-icon[@icon-id='glyphs.minus-circle']"));
    }

    static WebElement agreeLink() {
        return driver.findElement(By.linkText("Website Terms of Use"));
    }

    static WebElement inputPassengersNumber(String passenger) {
        return driver.findElement(By.xpath("//div[@value='paxInput." + passenger + "']//input"));
    }

    static WebElement monthNovember() {
        return driver.findElement(By.xpath("//h1[contains(text(), 'November 2017')]"));
    }
}
