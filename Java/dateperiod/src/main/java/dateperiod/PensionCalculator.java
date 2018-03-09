package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class PensionCalculator {
    private List<Period> periods = new ArrayList<>();

    public void addEmploymentPeriod(Period period) {
        periods.add(fullyNormalized(period));

    }

    public Period sumEmploymentPeriods() {
        Period result = Period.of(0, 0, 0);
        for (Period period : periods) {
            result = result.plus(fullyNormalized(period));
        }
        return result;
    }

    public Period modifyByDays(Period period, int days) {

        return period.plusDays(days);
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) {
            throw new NullPointerException("Null parameters are not allowed!");
        }

        return fullyNormalized(Period.between(fromDate, toDate));
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        if (fromDate.isEmpty()) {
            throw new IllegalArgumentException("Empty from date string, cannot use");
        }
        if (toDate.isEmpty()) {
            throw new IllegalArgumentException("Empty to date string, cannot use");
        }
        if (fromDate == null || toDate == null) {
            throw new NullPointerException("Null parameters are not allowed!");
        }

        if (pattern.isEmpty()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use");
        }
        LocalDate from = LocalDate.parse(String.format(fromDate, pattern));
        LocalDate to = LocalDate.parse(String.format(toDate, pattern));
        return fullyNormalized(Period.between(from, to));
    }

    public int calculateTotalDays(Period period) {
        return period.getYears() * 365 + period.getMonths() * 30 + period.getDays();

    }

    private Period fullyNormalized(Period period) {
        int days = period.getDays();
        int monthToIncrease = 0;
        int remainingDays = days;

        if (days > 30) {
            monthToIncrease = days / 30;
            remainingDays = days % 30;
        }
        return Period.of(period.getYears(), period.getMonths() + monthToIncrease, remainingDays).normalized();

    }

    private boolean isEmpty(String str) {
        return (str == null || str.isEmpty());
    }

}
