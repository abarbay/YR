package exam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TrackPoint {

    private LocalDateTime time;
    private double lat;
    private double lon;
    private int elevation;
    private String comment;


    public TrackPoint(String string) {
        String[] arr;
        arr = string.split(",");
        if (arr.length != 6) {
            throw new IllegalArgumentException("Invalid field number");
        }
        this.time = LocalDateTime.of(LocalDate.parse(arr[0]), LocalTime.parse(arr[1]));
        this.lat = Double.parseDouble(arr[2]);
        this.lon = Double.parseDouble(arr[3]);
        this.elevation = Integer.parseInt(arr[4]);
        this.comment = arr[5];
    }

    public TrackPoint(LocalDateTime time, double lat, double lon, int elevation, String comment) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
        this.elevation = elevation;
        this.comment = comment;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public int getElevation() {
        return elevation;
    }

    public String getComment() {
        return comment;
    }
}
