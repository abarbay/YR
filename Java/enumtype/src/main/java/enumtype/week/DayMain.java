package enumtype.week;

import java.util.Arrays;

public class DayMain {
    public static void main(String[] args) {
        WorkdayCalculator wd = new WorkdayCalculator();

        System.out.println(Arrays.asList(wd.dayTypes(Day.FRIDAY,25)));

    }
}
