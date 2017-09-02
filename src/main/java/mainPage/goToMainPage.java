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

        driver.findElement(By.xpath("//div[@class='homepageheroloader-wrapper']//span")).isDisplayed();

        addScreenShot.screen("FerstScreen");


        new waitFor(continueB());

        //new waitFor(By.className("homepageheroloader-wrapper")); - чет не работает доделать ожидание



        assert driver.getTitle().equals("Official Ryanair website | Cheap flights from Ireland | Ryanair");

        oneWayTicketCheck();
        twoWaysTicketsCheck();

        Assert.assertTrue(twoWaysTicketsCheck().isEnabled());
        Assert.assertTrue (oneWayTicketCheck().isEnabled());

        /*
        oneWayTicketCheck.click();
        addScreenShot.screen("Test2");
        */

        /**
         * поля ввода аэропорта
         * driver.findElement(By.xpath("//input[@placeholder='Departure airport']")).sendKeys("Hamburg");
         * driver.findElement(By.xpath("//input[@placeholder='Destination airport']")).sendKeys("Katowice");
*/
        Assert.assertTrue (inputLineFrom().isDisplayed());
        Assert.assertTrue (inputLineTo().isDisplayed());

        inputLineTo().sendKeys("Katowice");

        /**попап аэропортов*/
        popupContent().isEnabled();

        Thread.sleep(1500);
        airportName().click();

        /**кнопка Летс Го*/
        new waitFor(letsGoB());

        /**строки календаря*/
        inputFlyOut("DD").clear();
        inputFlyOut("DD").sendKeys("02");
        Thread.sleep(500);
        inputFlyOut("MM").clear();
        inputFlyOut("MM").sendKeys("09");
        inputFlyOut("YYYY").clear();
        inputFlyOut("YYYY").sendKeys("2017");


        /**попап календаря*/
        WebElement popupCalendar = driver.findElement(By.xpath("//div[@ng-transclude='contentSlot']"));
        new waitFor(popupCalendar);
        WebElement popupStartDate = driver.findElement(By.className("start-date"));

        /**проверка стрелок*/
        System.out.println("strelka left " + leftArrow().isEnabled());
        System.out.println("strelka right " + leftArrow().isEnabled());

        rightArrow().click();
        Thread.sleep(1000);
        leftArrow().click();
        Thread.sleep(1000);

        /**просмотр нерабочих дней*/
        WebElement unavailableDate = driver.findElement(By.className("unavailable"));

        //<li class="unavailable" ng-if="!range" data-id="03-09-2017"
        //<li ng-if="!range" data-id="04-09-2017"


        inputFlyBack("DD").clear();
        inputFlyBack("DD").sendKeys("03");
        Thread.sleep(500);
        inputFlyBack("MM").clear();
        inputFlyBack("MM").sendKeys("10");
        inputFlyBack("YYYY").clear();
        inputFlyBack("YYYY").sendKeys("2017");

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

        /**предупреждение по детям*/
        new waitFor(popupInfant());
        buttonOkInfant().click();


        Thread.sleep(1000);

        /**кнопки удаления пассажиров*/

        passengerPlusM("adults").click();
        passengerPlusM("teens").click();
        passengerPlusM("children").click();
        passengerPlusM("infants").click();
//




        letsGoB().click();




         System.out.println("");





        /**ошибки при вводе даты*/
        WebElement flightsAvailableMist = driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.no_flights_available_for_this_date']"));
        WebElement validDateMist = driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.valid_date_required']"));
        WebElement startDateMist =  driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.start_date_required']"));
        WebElement validDateFormatMist = driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.valid_date_format_required']"));


        //максимум 25 пассажиров
        /**
        <div class="info-box" ng-class="{'shown': paxInput.showMaxPassengersAlert}" role="alert">The maximum number of passengers is 25. If there are more than 25 passengers please use our group booking form.</div>
        <div class="info-box" ng-class="{'shown': paxInput.showMaxTeensAndChildrenAlert}" role="alert">The maximum number of teens & children is 24.</div>
        <div class="info-box" ng-class="{'shown': paxInput.showMaxInfantsAlert}" role="alert">The maximum number of infants is 18.</div>
        <div class="info-box" ng-class="{'shown': paxInput.showInfantsAlert}" role="alert">You can't travel with more infants than adults</div>
        */

        /**шапка выбора языка
        driver.findElement(By.xpath("//a[@ui-sref='header.markets']"));
        driver.findElement(By.id("largeMenu"));
        a class="core-link-inline selected" - выделенный язык
        */


        /**регистрация
        driver.findElement(By.id("myryanair-auth-signup")) - кнопка меню
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

    WebElement popupEndDate() {
        return driver.findElement(By.className("end-date"));
    }

    WebElement popubPassengers() {
        return driver.findElement(By.xpath("//popup-content[@role='listbox']"));
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

    WebElement popupContent() {
        return driver.findElement(By.xpath("//popup-content[contains(@class, 'core-popup-content-searchbox')]"));
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
}
