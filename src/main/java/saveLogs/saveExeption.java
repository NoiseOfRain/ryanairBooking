package saveLogs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static settings.makeSettingsBrowser.wayToFile;

/**
 * Created by Noise on 03.09.2017.
 */
public class saveExeption {

    public static void saveExeption(Exception e) throws IOException {
        FileWriter fw = new FileWriter (wayToFile + "exception.txt", true);
        PrintWriter pw = new PrintWriter (fw);
        e.printStackTrace (pw);
        pw.close();
        fw.close();
    }

}
