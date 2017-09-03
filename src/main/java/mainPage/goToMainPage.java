package mainPage;

import org.junit.Assert;
import org.testng.annotations.Test;
import saveLogs.addScreenShot;
import settings.waitFor;

import java.text.DateFormat;
import java.util.Date;

import static settings.commonObjects.setTotalAdults;
import static settings.commonObjects.setTotalTeen;
import static settings.commonObjects.totalAdults;

/**
 * Created by noise on 31.08.17.
 */
public class goToMainPage extends mainPageObjects {

    @Test
    public static void MainPageCheckElements() throws Exception {
        driver.get("https://www.ryanair.com/ie/en/");

        addScreenShot.screen("FirstScreen");

        new waitFor(continueB());
        Thread.sleep(1000);

        /**проверка наличия кнопок меню*/
        Assert.assertTrue(signupMenuB().isDisplayed());
        Assert.assertTrue(loginMenuB().isDisplayed());
        Assert.assertTrue(helpMenuB().isDisplayed());
        Assert.assertTrue(lenguageMenuB().isDisplayed());

        assert driver.getTitle().equals("Official Ryanair website | Cheap flights from Ireland | Ryanair");

        Assert.assertTrue(twoWaysTicketsCheck().isEnabled());
        Assert.assertTrue(oneWayTicketCheck().isEnabled());

        /**поля ввода аэропорта*/
        Assert.assertTrue(inputLineFrom().isDisplayed());
        Assert.assertTrue(inputLineTo().isDisplayed());
    }

    @Test(priority = 1)
    public static void chooseAirport(String aiport) throws Exception {

        MainPageCheckElements();
        inputLineTo().sendKeys(aiport);

        /**попап аэропортов*/
        popupAirports().isEnabled();

        Thread.sleep(1500);
        airportName().click();

        /**кнопка Летс Го*/
        new waitFor(letsGoB());
    }

    @Test(priority = 2)
    public static void selectDate(String outDate, String backDate) throws Exception {
        /**проверка на закрытие обратного полета*/
        oneWayTicketCheck().click();

        Assert.assertTrue(!inputFlyBack("DD").isDisplayed());
        Thread.sleep(500);
        twoWaysTicketsCheck().click();


        System.out.println(outDate.substring(0, 2));
        System.out.println(outDate.substring(3, 5));
        System.out.println(outDate.substring(6, 10));
        /**строки календаря*/
        inputFlyOut("DD").click();
        inputFlyOut("DD").sendKeys(outDate.substring(0, 2));
        Thread.sleep(500);
        inputFlyOut("MM").clear();
        inputFlyOut("MM").sendKeys(outDate.substring(3, 5));
        inputFlyOut("YYYY").clear();
        inputFlyOut("YYYY").sendKeys(outDate.substring(6, 10));


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
        inputFlyBack("DD").sendKeys(backDate.substring(0, 2));
        Thread.sleep(500);
        inputFlyBack("MM").clear();
        inputFlyBack("MM").sendKeys(backDate.substring(3, 5));
        inputFlyBack("YYYY").clear();
        inputFlyBack("YYYY").sendKeys(backDate.substring(6, 10));

        new waitFor(popupCalendar());
        Assert.assertTrue(popupEndDate().isDisplayed());
    }

    @Test(priority = 3)
    public static void addPassengers(int adults, int teen) throws Exception {

        setTotalAdults(adults);
        setTotalTeen(teen);

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

        /**ваставить необходимое число людей*/
        inputPassengersNumber("adults").click();
        inputPassengersNumber("adults").sendKeys(String.valueOf(adults));
        inputPassengersNumber("teens").click();
        inputPassengersNumber("teens").sendKeys(String.valueOf(teen));
        Thread.sleep(1000);
        passangersB().click();

    }

    @Test(priority = 4)
    public static void letsGo() {
        /**проверить что ссылка на правила видна и доступна*/
        Assert.assertTrue(agreeLink().isDisplayed() && agreeLink().isDisplayed());
        letsGoB().click();
    }
}
