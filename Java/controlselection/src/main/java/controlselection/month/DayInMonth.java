package controlselection.month;

public class DayInMonth {

    public int numberOfDays(int year,String month){

        switch (month.toLowerCase()) {
            case "január":
            case "március":
            case "május":
            case "július":
            case "augusztus":
            case "október":
            case "december":
                return 31;
            case "április":
            case "június":
            case "szeptember":
            case "november":
                return 30;
            case "február": return leapyear(year) ? 29:28;

            default:
                throw new IllegalArgumentException("Invalid month: " + month);

        }
    }

    private boolean leapyear(int year){
        return((year%4==0) && (year%100!=0)) || (year%400==0);
    }
}
