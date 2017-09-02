package mainPage;

import org.openqa.selenium.By;
import saveLogs.addScreenShot;

/**
 * Created by noise on 31.08.17.
 */
public class nextPage extends makeSettingsBrowser {

    public void next() throws Exception {


        assert driver.getCurrentUrl() == "https://www.ryanair.com/ie/en/booking/home";
        addScreenShot.screen("Test3");


        driver.findElements(By.xpath("//button[@ng-click='goToPrev()']"));
        driver.findElements(By.xpath("//button[@ng-click='goToNext()']"));

        driver.findElement(By.className("flights-table-price__header"));

        driver.findElement(By.xpath("//span[@translate='trips.flight_list_table.from']")).
                findElement(By.xpath("//div[@class='flight-header__min-price hide-mobile']"));


        driver.findElement(By.className("plane-spinner")); //- самолетик О_о



        /**

*/

    }
}
