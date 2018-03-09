package zonedaylight;

import java.time.*;

public class WorkHoursCalculator {
    private ZonedDateTime startDateTime;
    public WorkHoursCalculator(int startYear, Month startMonth, int startDay, int startHour, ZoneId zone){
        LocalDateTime ldt= LocalDateTime.of(startYear,startMonth,startDay,startHour,0);
        startDateTime= ZonedDateTime.of(ldt,zone);
    }
    public long calculateHours(int year, Month month, int day, int hour){
        ZonedDateTime endDateTime=LocalDateTime.of(year,month,day,hour,0).atZone(startDateTime.getZone());
        return Duration.between(startDateTime,endDateTime).toHours();


    }

    public ZonedDateTime getStartDateTime(){
        return startDateTime;
    }

}
