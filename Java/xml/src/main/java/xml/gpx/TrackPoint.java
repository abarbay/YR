package xml.gpx;


import java.time.ZonedDateTime;

public class TrackPoint {
    private double lat;
    private double lon;
    private int elevation;
    private ZonedDateTime time;

    public TrackPoint(double lat, double lon, int elevation, ZonedDateTime time) {
        this.lat = lat;
        this.lon = lon;
        this.elevation = elevation;
        this.time = time;
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

    public ZonedDateTime getTime() {
        return time;
    }
}
