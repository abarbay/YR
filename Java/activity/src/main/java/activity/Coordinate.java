package activity;
public class Coordinate {
    private  double longitude;
    private  double latitude;


    public Coordinate( double latitude, double longitude) {
        if(longitude<-180 || longitude>180){throw new IllegalArgumentException();}
        if(latitude<-90 || latitude>90){throw new IllegalArgumentException();}
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
