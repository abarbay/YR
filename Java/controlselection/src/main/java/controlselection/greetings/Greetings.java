package controlselection.greetings;

public class Greetings {
    public String greet(int hour , int minutes){
        String result="";
        // az óra és a perc az időszakokban külön,külön nem összehasonlítható ezért közös értékre kell hozni öket
        if(hour*60+minutes<=5*60){result="jó éjt";}  //0:00-5:00
        else if(hour*60+minutes<=9*60){result="jó reggelt";} //5:01-9:00
        else if(hour*60+minutes<=(18*60)+30){result="jó napot";} //9:01-18:30
        else if(hour*60+minutes<=20*60){result="jó estét";} //18:31-20:00
        else{result="jó éjt";} //20:01-0:00

        return result;
    }
}
