import java.text.DateFormat;
import java.util.Date;

import static mainPage.goToMainPage.chooseAirport;
import static mainPage.goToMainPage.selectDate;

/**
 * Created by noise on 03.09.17.
 */
public class mainTest {

    public void go() throws Exception {
        chooseAirport("London Gatwick");
        selectDate(DateFormat()(06-10-2016), 31-10-2016);
    }
}
