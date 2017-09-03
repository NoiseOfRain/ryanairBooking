package extrasPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.makeSettingsBrowser;

/**
 * Created by noise on 03.09.17.
 */
public class extrasPageObjects extends makeSettingsBrowser {

    public static String thisPage() {
        return driver.getCurrentUrl();
    }

    static WebElement selectTourSeat() {
        return driver.findElement(By.xpath("//button[@translate='trips.extras.leaderboard.quick-card.SEATS.button.select']"));
    }

    static WebElement addYourBag() {
        return driver.findElement(By.xpath("//button[@translate='trips.extras.leaderboard.quick-card.BAGS.button.select']"));
    }

    static WebElement addPriorityBoarding() {
        return driver.findElement(By.xpath("//button[@translate='trips.extras.leaderboard.quick-card.PRIOBRDNG.button.select']"));
    }

    static WebElement bookACar() {
        return driver.findElement(By.xpath("//button[@translate='trips.extras.leaderboard.quick-card.CARHIRE.button.select']"));
    }

    static WebElement bookAHotel() {
        return driver.findElement(By.xpath("//button[@translate='trips.extras.leaderboard.quick-card.ACCOMMODATION.button.select']"));
    }

    static WebElement checkOutB() {
        return driver.findElement(By.xpath("//button[@translate='trips.summary.buttons.btn_checkout']"));
    }

    static WebElement seatPromptPopup() {
        return driver.findElement(By.className("seat-prompt-popup"));
    }

    static WebElement okThanksB() {
        return driver.findElement(By.xpath("//button[@translate='trips.summary.seat.prompt.popup.reject']"));
    }


}
