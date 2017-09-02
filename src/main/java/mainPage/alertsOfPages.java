package mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.makeSettingsBrowser;

/**
 * Created by noise on 01.09.17.
 */
public class alertsOfPages extends makeSettingsBrowser {

    public void mainPage() throws Exception {
        /**ошибки при вводе даты
         driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.no_flights_available_for_this_date']")).isDisplayed();
         driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.valid_date_required']"));
         driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.start_date_required']"));
         driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.valid_date_format_required']"));
         */

        WebElement flightsAvailableMist = driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.no_flights_available_for_this_date']"));
        WebElement validDateMist = driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.valid_date_required']"));
        WebElement startDateMist =  driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.start_date_required']"));
        WebElement validDateFormatMist = driver.findElement(By.xpath("//span[@translate='foh.home.flight_search_errors.valid_date_format_required']"));



/*
        if (true) {
            return true;
        }
        flightsAvailableMis.isDisplayed();


        return false;*/
    }

}
