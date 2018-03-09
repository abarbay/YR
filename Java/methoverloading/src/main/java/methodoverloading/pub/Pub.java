package methodoverloading.pub;

import methodoverloading.Time;

public class Pub {
    private String name;
    private Time open;


    public Pub(String name, int hours, int minutes) {
        this.name = name;
        this.open=new Time(hours,minutes);

    }

    public String getName() {
        return name;
    }



    public Time getOpenFrom(){
        return open;
    }

    @Override
    public String toString() {
        return name+ ";"+ open.getHours()+":"+open.getMinutes();
    }
}
