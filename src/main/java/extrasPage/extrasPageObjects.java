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

    WebElement addYourBag() {
        return driver.findElement(By.xpath("//button[@translate='trips.extras.leaderboard.quick-card.BAGS.button.select']"));
    }

    WebElement addPriorityBoarding() {
        return driver.findElement(By.xpath("//button[@translate='trips.extras.leaderboard.quick-card.PRIOBRDNG.button.select']"));
    }

    WebElement bookACar() {
        return driver.findElement(By.xpath("//button[@translate='trips.extras.leaderboard.quick-card.CARHIRE.button.select']"));
    }

    WebElement bookAHotel() {
        return driver.findElement(By.xpath("//button[@translate='trips.extras.leaderboard.quick-card.ACCOMMODATION.button.select']"));
    }

    WebElement checkOutB() {
        return driver.findElement(By.xpath("//button[@translate='trips.summary.buttons.btn_checkout']"));
    }

    WebElement seatPromptPopup() {
        return driver.findElement(By.className("seat-prompt-popup"));
    }

    WebElement okThanksB() {
        return driver.findElement(By.xpath("//button[@translate='trips.summary.seat.prompt.popup.reject']"));
    }


}
