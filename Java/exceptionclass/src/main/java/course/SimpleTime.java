package course;

public class SimpleTime {
    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        if(hour>23){throw new InvalidTimeException("Hour is invalid (0-23)");}
        else{this.hour = hour;}
        if(minute>59){throw new InvalidTimeException("Minute is invalid (0-59)");}
        this.minute = minute;

    }


    public SimpleTime(String timeStr){
        if(timeStr==null){throw new InvalidTimeException("Time is null");}
        if(!timeStr.contains(":")){throw new InvalidTimeException("Time is not hh:mm");}

        if(getHourString(timeStr)>23){throw new InvalidTimeException("Hour is invalid (0-23)");}
        else{this.hour = getHourString(timeStr);}
        if(getMinuteString(timeStr)>59){throw new InvalidTimeException("Minute is invalid (0-59)");}
        this.minute = getMinuteString(timeStr);


    }

    private int getHourString(String timeStr){
        String[] tempArr = timeStr.split(":");
        try {
            Integer.parseInt(tempArr[0]);
        }catch (NumberFormatException nfe){
            throw new InvalidTimeException("Time is not hh:mm");
        }
        return Integer.parseInt(tempArr[0]);
    }

    private int getMinuteString(String timeStr) {
        String[] tempArr = timeStr.split(":");
        try {
            Integer.parseInt(tempArr[1]);
        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        return Integer.parseInt(tempArr[1]);
    }



    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d",hour,minute);
    }



}
