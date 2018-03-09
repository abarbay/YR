package methodoverloading;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time){
        hours=time.getHours();
        minutes=time.getMinutes();
        seconds=time.getSeconds();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isEqual(Time time){
        boolean result=false;
        if(hours==time.getHours() && time.getMinutes()==minutes && time.getSeconds()==seconds){
            result=true;
        }
        return result;
    }

    public boolean isEqual(int hours, int minutes, int seconds){
        boolean result=false;
        if(hours==this.getHours() && this.getMinutes()==minutes && this.getSeconds()==seconds){
            result=true;
        }
        return result;

    }
    public boolean isEarlier(Time time){
        boolean result=false;
        if(time.getHours()>hours){
            result=true;
        }

        if(time.getHours()==hours && time.getMinutes()>minutes){
            result=true;
        }

        if(time.getMinutes()==hours && time.getMinutes()==minutes && time.getSeconds()>seconds){
            result=true;
        }
        return result;
    }
    public boolean isEarlier(int hours, int minutes, int seconds){
        return isEarlier(new Time(hours,minutes,seconds));
    }



}
