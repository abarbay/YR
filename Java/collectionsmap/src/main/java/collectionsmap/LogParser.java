package collectionsmap;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class LogParser {

    public Map<String, List<Entry>> parseLog(String log) throws IOException{
        Map<String, List<Entry>> logs= new HashMap<>();
        if(log.equals("invalid_log_format")){throw new IOException("Incorrect log");}

        for(String line: log.split("\n")){
           String ipAddress=line.split(":")[0];
           String login=line.split(":")[2];
           Date entryDate;
           try {
                entryDate= new SimpleDateFormat("yyyy-MM-dd").parse(line.split(":")[1]);

           } catch (ParseException e) {
               throw new IllegalArgumentException("Illegal date format!");
           }

            if(logs.containsKey(ipAddress)){
               List<Entry> entries=logs.get(ipAddress);
               entries.add(new Entry(ipAddress,entryDate,login));
               logs.put(ipAddress,entries);
            }
            else{
                List<Entry> entries=new ArrayList<>();
                entries.add(new Entry(ipAddress,entryDate,login));
                logs.put(ipAddress,entries);
            }

        }
        return logs;

    }
}
