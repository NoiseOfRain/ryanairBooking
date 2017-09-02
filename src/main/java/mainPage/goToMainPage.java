package mainPage;

import org.junit.Assert;
import org.testng.annotations.Test;
import saveLogs.addScreenShot;
import settings.waitFor;

/**
 * Created by noise on 31.08.17.
 */
public class goToMainPage extends mainPageObjects {

    @Test
    public void goToMainPage() throws Exception {

        driver.get("https://www.ryanair.com/ie/en/");

        addScreenShot.screen("FirstScreen");

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

        inputLineTo().sendKeys("London Gatwick");

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
        Thread.sleep(500);
        passangersB().click();

        /**проверить что ссылка на правила видна и достапна*/
        Assert.assertTrue(agreeLink().isDisplayed() && agreeLink().isDisplayed());
        letsGoB().click();
    }
}
