package formatlocaleregexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpValidator {

    public boolean validateEmail(String email){
        boolean result=false;
        email=email.trim();
        if(email==null || email.isEmpty()){throw new IllegalArgumentException("Empty string");}
        Pattern pattern = Pattern.compile("^^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            result=true;
        }
        return result;
    }
    public boolean validateAcademicYear(String academicYear){
        boolean result=false;
        if(academicYear==null || academicYear==""){throw new IllegalArgumentException("Empty string");}
        Pattern pattern = Pattern.compile("(19|20)\\d{2}-(19|20)\\d{2}$");
        Matcher matcher = pattern.matcher(academicYear);
        if (matcher.matches()) {
            result=true;
        }
        return result;
    }
    public boolean validateYearString(String yearString){
        boolean result=false;
        if(yearString==null || yearString==""){throw new IllegalArgumentException("Empty string passed!");}
        Pattern pattern = Pattern.compile("^(19|20)\\d{2}$");
        Matcher matcher = pattern.matcher(yearString);
        if (matcher.matches()) {
            result=true;
    }
    return result;
    }
}
