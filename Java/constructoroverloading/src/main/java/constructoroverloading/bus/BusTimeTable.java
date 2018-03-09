package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime>timeTable= new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute){
        int size=1+lastHour-firstHour;

        for (int i = 0; i <size ; i++) {
            timeTable.add(new SimpleTime(firstHour+i,everyMinute));
        }


    }



    public List<SimpleTime> getTimeTable(){
        return timeTable;

    }
    public SimpleTime nextBus(SimpleTime actual){
        SimpleTime nextBusTime= new SimpleTime(actual.getHours()+1,actual.getMinutes());
        SimpleTime lastBusTime=new SimpleTime(timeTable.indexOf(timeTable.size()-1));

        if(nextBusTime.difference(lastBusTime)>0){
            return nextBusTime;
        }
        else{
            throw new IllegalStateException("No more buses today!");
        }

    }

}
