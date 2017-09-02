package mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.makeSettingsBrowser;

/**
 * Created by noise on 02.09.17.
 */
public class mainPageObjects extends makeSettingsBrowser {

    WebElement signupMenuB() {
        return driver.findElement(By.id("myryanair-auth-signup"));
    }
    WebElement loginMenuB() {
        return driver.findElement(By.id("myryanair-auth-login"));
    }
    WebElement helpMenuB() {
        return driver.findElement(By.id("menu-links-right"));
    }
    WebElement lenguageMenuB() {
        return driver.findElement(By.id("markets"));
    }

    WebElement twoWaysTicketsCheck() {
        return driver.findElement(By.id("flight-search-type-option-return"));
    }
    WebElement oneWayTicketCheck() {
        return driver.findElement(By.id("flight-search-type-option-one-way"));
    }

    WebElement continueB() {
        return driver.findElement(By.xpath("//span[@translate='common.buttons.continue']"));
    }

    WebElement inputFlyOut(String parameter) {
        return driver.findElement(By.xpath("//input[@aria-label='Fly out: - " + parameter + "']"));
    }
    WebElement inputFlyBack(String parameter) {
        return driver.findElement(By.xpath("//input[@aria-label='Fly back: - " + parameter + "']"));
    }

    WebElement airportName() {
        return driver.findElement(By.xpath("//strong[contains(text(), 'London Gatwick')]"));
    }

    WebElement leftArrow() {
        return driver.findElement(By.xpath("//button[@class='arrow left']"));
    }
    WebElement rightArrow() {
        return driver.findElement(By.xpath("//button[@class='arrow right']"));
    }

    WebElement letsGoB() {
        return driver.findElement(By.xpath("//span[@translate='common.buttons.lets_go']"));
    }

    WebElement passangersB() {
        return driver.findElement(By.xpath("//div[@aria-label='Select number of passengers']"));
    }

    WebElement popupCalendar() {
        return driver.findElement(By.xpath("//div[@ng-transclude='contentSlot']"));
    }
    WebElement popupStartDate() {
        return driver.findElement(By.className("start-date"));
    }
    WebElement popupEndDate() {
        return driver.findElement(By.className("end-date"));
    }

    WebElement inputLineFrom() {
        return driver.findElement(By.xpath("//input[@placeholder='Departure airport']"));
    }
    WebElement inputLineTo() {
        return driver.findElement(By.xpath("//input[@placeholder='Destination airport']"));
    }

    WebElement popupInfant() {
        return driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_infant_popup.message']"));
    }

    WebElement buttonOkInfant() {
        return driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_infant_popup.ok']"));
    }

    WebElement popupAirports() {
        return driver.findElement(By.xpath("//popup-content[contains(@class, 'core-popup-content-searchbox')]"));
    }

    WebElement popubPassengers() {
        return driver.findElement(By.xpath("//popup-content[@role='listbox']"));
    }
    WebElement passengerPlusB(String passenger) {
        return driver.findElement(By.xpath("//div[@value='paxInput." + passenger + "']//core-icon[@icon-id='glyphs.plus-circle']"));
    }
    WebElement passengerPlusM(String passenger) {
        return driver.findElement(By.xpath("//div[@value='paxInput." + passenger + "']//core-icon[@icon-id='glyphs.minus-circle']"));
    }

    WebElement agreeLink() {
        return driver.findElement(By.linkText("Website Terms of Use"));
    }

    WebElement inputPassengersNumber(String passenger) {
        return driver.findElement(By.xpath("//div[@value='paxInput." + passenger + "']//input"));
    }

    WebElement monthNovember() {
        return driver.findElement(By.xpath("//h1[contains(text(), 'November 2017')]"));
    }
}
