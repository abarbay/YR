package formatlocalemessage;

import java.text.MessageFormat;
import java.util.Date;

public class MessageGenerator {

    public String generateForecastText(String weather, int degree, String place){
        return MessageFormat.format("Tomorrow expect {0} with {1} \u00B0C temperature in {2}.", weather,Integer.toString(degree),place);

    }
    public String generateLotteryAnnouncement(String name){
        return MessageFormat.format("Yesterday {0} won a staggering sum of 500 M", name);
    }
}
