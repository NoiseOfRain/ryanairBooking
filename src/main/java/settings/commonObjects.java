package settings;

/**
 * Created by noise on 03.09.17.
 */
public class commonObjects {

    public static Double totalCost;
    public static void setTotalCost(Double price) {
        totalCost = price;
    }
    public static Double getTotalCost() {
        return totalCost;
    }

    public static int totalAdults;
    public static void setTotalAdults(int adults) {
        totalAdults = adults;
    }
    public static int getTotalAdults() {
        return totalAdults;
    }

    public static int totalTeen;
    public static void setTotalTeen(int teen) {
        totalTeen = teen;
    }
    public static int getTotalTeen() {
        return totalTeen;
    }
}
