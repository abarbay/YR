package datenewtypes;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {
    LocalDate date;

    public DateOfBirth(int year,int month, int day){

        this.date=LocalDate.of(year, month, day);
    }

    public DateOfBirth(String dateString, String pattern) {
        if(dateString==""){throw new IllegalArgumentException("Empty date string");}
        if(pattern==""){throw new IllegalArgumentException("Empty pattern string");}
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        this.date = LocalDate.parse(dateString,formatter);
    }

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        if(dateString==""){throw new IllegalArgumentException("Empty date string");}
        if(locale==null){throw new NullPointerException("Locale must not be null");}
        if(pattern==""){throw new IllegalArgumentException("Empty pattern string");}
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern).withLocale(locale);
        this.date = LocalDate.parse(dateString,formatter);
    }

    public String findDayOfWeekForBirthDate(Locale locale){
        if(locale==null){throw new NullPointerException("Locale must not be null!");}
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("EEEE",locale);
        String s = formatter.format(date);
        return s;
    }

    public int countDaysSinceBirth(){
        if(this.getDateOfBirth().isAfter(LocalDate.now())){throw new IllegalStateException("Birthdate is in the future");}
        return (int) ChronoUnit.DAYS.between(this.getDateOfBirth(), LocalDate.now());
    }

    public int countDaysBetween(DateOfBirth date){
        return (int) ChronoUnit.DAYS.between(this.getDateOfBirth(), date.getDateOfBirth());
    }

    public String toString(String pattern){
        if(pattern==null || pattern==""){throw new IllegalArgumentException("Empty pattern string");}
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return this.date.format(formatter);
    }

    public LocalDate getDateOfBirth() {
        return date;
    }
}
