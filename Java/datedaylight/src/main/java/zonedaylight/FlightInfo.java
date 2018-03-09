package zonedaylight;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FlightInfo {
    private ZonedDateTime departureTime;

    public FlightInfo(String dateString, String pattern, Locale locale, ZoneId zone){
        if(isEmpty(dateString)){throw new IllegalArgumentException("Empty date string parameter!");}
        if(isEmpty(pattern)){throw new IllegalArgumentException("Empty pattern string parameter!");}
        if(isValidObject(locale)){throw new NullPointerException("Locale must not be null!");}
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern(pattern,locale);
        LocalDateTime ldt=LocalDateTime.parse(dateString,dtf);
        departureTime= ZonedDateTime.of(ldt,zone);

    }
    public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes){
        Duration flightDuration=Duration.ofMinutes(flightHours*60+flightMinutes);
        ZonedDateTime arrivalTime=departureTime.plus(flightDuration);
        return arrivalTime.withZoneSameInstant(zone);

    }
    public ZonedDateTime getDepartureDateTime(){
        return departureTime;
    }

    private boolean isEmpty(String str){
        return(str==null|| str.isEmpty());
    }

    private boolean isValidObject(Object o){
        return(o==null);
    }
}
