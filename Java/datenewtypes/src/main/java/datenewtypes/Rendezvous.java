package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Rendezvous {
    LocalTime time;

    public Rendezvous(int hour, int minute){
        this.time=LocalTime.of(hour,minute);
    }

    public Rendezvous(String from, String pattern){
        if(pattern==""){throw new IllegalArgumentException("Empty pattern string");}
        if(pattern=="hh:mm"){throw new IllegalArgumentException("Illegal time string");}
        if(from==""){throw new IllegalArgumentException("Illegal time string");}
    }

    public String toString(String pattern){
        if(pattern== null || pattern==""){throw new IllegalArgumentException("Empty pattern string");}

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return this.time.format(formatter);
    }

    public int countMinutesLeft(){
        int countMinutes= (int) ChronoUnit.MINUTES.between(LocalTime.now(), this.getTime());
        if(countMinutes<0){throw new MissedOpportunityException("Too late!");}
        return countMinutes;
    }

    public void pushLater(int hour, int minutes){
      this.time= this.time.plusMinutes(minutes);
    }

    public void pullEarlier(int hour, int minutes){
     this.time=this.time.minusHours(hour).minusMinutes(minutes);

    }

    public LocalTime getTime() {
        return time;
    }
}