package dateoldtypes;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateOfBirth {
    Date date;

    public DateOfBirth(int year, int month, int day){
      setDateOfBirth(year+"-"+month+"-"+day,new SimpleDateFormat("yyyy-MM-dd"));
    }
    public DateOfBirth(String dateString, String pattern, Locale locale){
        if(locale==null){throw new NullPointerException("Locale must not be null!");}

        setDateOfBirth(dateString,new SimpleDateFormat(pattern,locale));
    }
    public DateOfBirth(String dateString, String pattern){
        if(pattern==null || pattern==""){throw new IllegalArgumentException("Illegal pattern string");}
        setDateOfBirth(dateString,new SimpleDateFormat(pattern));
    }

    public String findDayOfWeekForBirthDate(Locale locale){
        if(locale==null){throw new NullPointerException("Locale must not be null!");}
        Format formatter = new SimpleDateFormat("EEEE",locale);
        String s = formatter.format(date);
        return s;

    }
    public String toString(String pattern){
        if(pattern==null || pattern==""){throw new IllegalArgumentException("Illegal pattern string");}

        return new SimpleDateFormat(pattern).format(date);
    }

    public boolean isWeekDay(){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if(c.get(Calendar.DAY_OF_WEEK)<=5){
            return true;
        }
        return false;
    }

    private void setDateOfBirth(String dateString, DateFormat dateFormat){
        dateFormat.setLenient(false);
        try{
            Date date = dateFormat.parse(dateString);
            this.date=date;

        }catch(ParseException e){
            throw new IllegalArgumentException("Illegal date string");
        }

    }

}
