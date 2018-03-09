package constructoroverloading.bus;

public class SimpleTime {
    private int hours;
    private int minutes;




    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this.hours = hours;
    }

    public SimpleTime(SimpleTime time){
        hours=time.getHours();
        minutes=time.getMinutes();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int difference(SimpleTime time){
       return (this.hours-time.getHours())*60+(this.minutes-time.getMinutes());

    }

    @Override
    public String toString() {
        return hours+":"+minutes;

    }


}
