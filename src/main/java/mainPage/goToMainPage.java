package mainPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import saveLogs.addScreenShot;

/**
 * Created by noise on 31.08.17.
 */
public class goToMainPage extends makeSettingsBrowser {

    @Test
    public void goToMainPage() throws Exception {

        driver.get("https://www.ryanair.com/ie/en/");

        addScreenShot.screen("FerstScreen");

        new waitFor(continueB());

        /**проверка наличия кнопок меню*/
        Assert.assertTrue(signupMenuB().isDisplayed());
        Assert.assertTrue(loginMenuB().isDisplayed());
        Assert.assertTrue(helpMenuB().isDisplayed());
        Assert.assertTrue(lenguageMenuB().isDisplayed());

        assert driver.getTitle().equals("Official Ryanair website | Cheap flights from Ireland | Ryanair");


        Assert.assertTrue(twoWaysTicketsCheck().isEnabled());
        Assert.assertTrue (oneWayTicketCheck().isEnabled());

        /**поля ввода аэропорта*/
        Assert.assertTrue (inputLineFrom().isDisplayed());
        Assert.assertTrue (inputLineTo().isDisplayed());

        inputLineTo().sendKeys("Katowice");

        /**попап аэропортов*/
        popupAirports().isEnabled();

        Thread.sleep(1500);
        airportName().click();

        /**кнопка Летс Го*/
        new waitFor(letsGoB());

        /**проверка на закрытие обратного полета*/
        oneWayTicketCheck().click();

        Assert.assertTrue(!inputFlyBack("DD").isDisplayed());
        Thread.sleep(500);
        twoWaysTicketsCheck().click();


        /**строки календаря*/
        inputFlyOut("DD").click();
        inputFlyOut("DD").sendKeys("02");
        Thread.sleep(500);
        inputFlyOut("MM").clear();
        inputFlyOut("MM").sendKeys("09");
        inputFlyOut("YYYY").clear();
        inputFlyOut("YYYY").sendKeys("2017");


        /**попап календаря*/
        new waitFor(popupCalendar());
        Assert.assertTrue(popupStartDate().isDisplayed());

        /**проверка стрелок*/
        Assert.assertTrue(leftArrow().isEnabled());
        Assert.assertTrue(leftArrow().isEnabled());

        rightArrow().click();
        Thread.sleep(1000);
        Assert.assertTrue(monthNovember().isDisplayed());

        leftArrow().click();
        Thread.sleep(1000);

        inputFlyBack("DD").click();
        inputFlyBack("DD").sendKeys("03");
        Thread.sleep(500);
        inputFlyBack("MM").clear();
        inputFlyBack("MM").sendKeys("10");
        inputFlyBack("YYYY").clear();
        inputFlyBack("YYYY").sendKeys("2017");

        new waitFor(popupCalendar());
        Assert.assertTrue(popupEndDate().isDisplayed());

        /**добавляем пассажиров*/
        passangersB().click();

        Thread.sleep(500);

        /**попап пассажиров*/
        Assert.assertTrue(popubPassengers().isDisplayed());

        /**кнопки добавления пассажиров*/

        passengerPlusB("adults").click();
        passengerPlusB("teens").click();
        passengerPlusB("children").click();
        passengerPlusB("infants").click();

        Assert.assertEquals(inputPassengersNumber("adults").getAttribute("value"), "2");
        Assert.assertEquals(inputPassengersNumber("teens").getAttribute("value"), "1");
        Assert.assertEquals(inputPassengersNumber("children").getAttribute("value"), "1");
        Assert.assertEquals(inputPassengersNumber("infants").getAttribute("value"), "1");

        /**предупреждение по детям*/
        new waitFor(popupInfant());
        buttonOkInfant().click();



        Thread.sleep(1000);

        /**кнопки удаления пассажиров*/

        passengerPlusM("adults").click();
        passengerPlusM("teens").click();
        passengerPlusM("children").click();
        passengerPlusM("infants").click();

        Assert.assertEquals(inputPassengersNumber("adults").getAttribute("value"), "1");
        Assert.assertEquals(inputPassengersNumber("teens").getAttribute("value"), "0");
        Assert.assertEquals(inputPassengersNumber("children").getAttribute("value"), "0");
        Assert.assertEquals(inputPassengersNumber("infants").getAttribute("value"), "0");

        inputPassengersNumber("adults").click();
        inputPassengersNumber("adults").sendKeys("3");
        inputPassengersNumber("teens").click();
        inputPassengersNumber("teens").sendKeys("1");
        passangersB().click();

        /**проверить что ссылка на правила видна и достапна*/
        Assert.assertTrue(agreeLink().isDisplayed() && agreeLink().isDisplayed());
        letsGoB().click();






        /**ошибки при вводе даты*/
        WebElement flightsAvailableMist = driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.no_flights_available_for_this_date']"));
        WebElement validDateMist = driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.valid_date_required']"));
        WebElement startDateMist =  driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.start_date_required']"));
        WebElement validDateFormatMist = driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.valid_date_format_required']"));



        /**шапка выбора языка
        driver.findElement(By.xpath("//a[@ui-sref='header.markets']"));
        driver.findElement(By.id("largeMenu"));
        a class="core-link-inline selected" - выделенный язык
        */


        /**регистрация
        driver.findElement(By.id("myryanair-auth-signup")) - кнопка меню
        driver.findElement(By.id("myryanair-auth-login")) - кнопка меню
        driver.findElement(By.id("myryanair-auth-right")) - кнопка меню
        driver.findElement(By.id("markets")) - кнопка меню
        driver.findElement(By.className("modal-form-container")) - контейнер регистрации
        driver.findElements(By.xpath("//translate[@translate='myryanair.authorization.dialog.continue.as.guest']")); - кнопра продолжить как гость

        driver.findElements(By.xpath("//input[contains(@id,'email')]")) - поле емаил, надо юрать елемент из контейнера регистрации
        driver.findElements(By.xpath("//input[contains(@id,'password')]")) - поле емаил, надо юрать елемент из контейнера регистрации
        driver.findElements(By.xpath("//translate[@translate='MYRYANAIR.SIGN_UP']"));- кнопка отправить
        */

        /**логин
        driver.findElements(By.xpath("//translate[@translate='MYRYANAIR.AUTHORIZATION.LOGIN.LOGIN_AUTHORIZATION']"));//- кнопка log-in
        */

    }

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

    WebElement airportName() throws Exception {
        return driver.findElement(By.xpath("//strong[contains(text(), 'Katowice')]"));
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
