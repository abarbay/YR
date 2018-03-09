package exceptionresource.accesscontrol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AccessLog {
    private String fileName;

    public AccessLog(String fileName) {
        this.fileName = fileName;
    }


    public List<String> inAtTime(LocalDateTime time) {
        List<String> result = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            while ((line = reader.readLine()) != null) {
                String arr[];
                arr = line.split(",");

                if ((timeFormatter(arr[0])).isBefore(time) && arr[2].toString().equals(AccessType.IN.toString())) {
                    result.add(arr[1]);
                } else if ((timeFormatter(arr[0])).isBefore(time) && arr[2].toString().equals(AccessType.OUT.toString())) {
                    result.remove(arr[1]);
                }
            }

        } catch (IOException ioe) {
            throw new LogException();
        }
        return result;
    }

    public List<LocalDateTime> loginsById(String personId) {
        List<LocalDateTime> result = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            while ((line = reader.readLine()) != null) {
                String arr[];
                arr = line.split(",");
                if (arr[1].toString().equals(personId) && arr[2].toString().equals(AccessType.IN.toString())) {
                    result.add(timeFormatter(arr[0]));
                }

            }
        } catch (IOException ioe) {
            throw new LogException();
        }
        return result;
    }

    private LocalDateTime timeFormatter(String inTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(inTime, formatter);
        return time;
    }

}


