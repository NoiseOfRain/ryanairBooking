package extrasPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.makeSettingsBrowser;

/**
 * Created by noise on 03.09.17.
 */
public class extrasPageObjects extends makeSettingsBrowser {

    public String thisPage() {
        return driver.getCurrentUrl();
    }

    WebElement selectTourSeat() {
        return driver.findElement(By.xpath("//button[@translate='trips.extras.leaderboard.quick-card.SEATS.button.select']"));
    }

}
