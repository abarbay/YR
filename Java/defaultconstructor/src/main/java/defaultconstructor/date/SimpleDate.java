package defaultconstructor.date;

import java.time.LocalDate;

public class SimpleDate {
    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
     if(isCorrect(year, month, day)){
        this.year = year;
        this.month = month;
        this.day = day;}
        else{throw new  IllegalArgumentException("One or more given parameter cannot be applied!");}
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


    private boolean isCorrect(int year, int month, int day){

        boolean result=false;
        if((calculateMonthLength(year,month)>0 && calculateMonthLength(year,month)>=day) && year>1899 &&(month>0 && month<12)){
            result=true;
        }
        else{throw new  IllegalArgumentException("One or more given parameter cannot be applied!");}
        return result;

    }
    private boolean isLeapYear(int year){
        if(((year%4==0) && (year%100!=0)) || (year%400==0)){
            return true;
        }
        else{throw new  IllegalArgumentException("One or more given parameter cannot be applied!");}

    }
    private int calculateMonthLength(int year, int month) {
        int result=0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                throw new  IllegalArgumentException("One or more given parameter cannot be applied!");
        }

    }
}
