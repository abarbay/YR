package duration;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class WorkHoursCalculator {
    private List<Duration> workHours = new ArrayList<>();


    public void addWorkTime(Duration duration) {
        workHours.add(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        Duration d = Duration.parse("P" + days + "DT" + hours + "H" + minutes + "M");
        workHours.add(d);
    }

    public void addWorkTime(String durationString) {
        try {
            if (isEmpty(durationString)) {
                throw new IllegalArgumentException("Parameter must not be empty!");
            }
            workHours.add(Duration.parse(durationString));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found:" + durationString);
        }

    }

    public int calculateWorkHours() {
        int result = 0;
        for (Duration duration : workHours) {
            result += duration.toHours();
        }
        return result;
    }

    public Duration getWorkDuration() {
        Duration sum = Duration.ofDays(0);
        for (Duration duration : workHours) {
            sum = sum.plus(duration);
        }
        return sum;
    }


    private boolean isEmpty(String s) {
        return (s == null || s.isEmpty());
    }

    @Override
    public String toString() {
        Duration dur = getWorkDuration();
        return "Days: " + dur.toDays() +
                ", hours: " + dur.toHours() % 24 +
                ", minutes: " + dur.toMinutes() % 60;
    }
}
