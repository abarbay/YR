package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {
    public List<DayType> dayTypes(Day firstDay, int numberOfDays){
        List<DayType> days=new ArrayList<>();
        Day nday=firstDay;
        days.add(firstDay.getValue());
        for (int i = 0; i <numberOfDays-1 ; i++) {
            days.add(nextDay(nday).getValue());
            nday=nextDay(nday);
        }
        return days;
    }

    public Day nextDay(Day day){
        Day result;
        if(day.ordinal()==6){
            result=Day.MONDAY;
        }
        else{result=Day.values()[day.ordinal()+1];}
        return result;
    }
}
