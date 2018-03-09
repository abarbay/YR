package activity;
import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<TrackPoint> trackPoints= new ArrayList<>();


    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public  void addTrackPoint(TrackPoint trackPoint){
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate(){
        double maxLat=-90;
        double maxLon=-180;
        for(TrackPoint point:trackPoints){
            if(maxLat<point.getCoordinate().getLatitude()){
                maxLat=point.getCoordinate().getLatitude();
            }
            if(maxLon<point.getCoordinate().getLongitude()){
                maxLon=point.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLat,maxLon);

    }

    public Coordinate findMinimumCoordinate(){
        double minLat=90;
        double minLon=180;
        for(TrackPoint point:trackPoints){
            if(minLat>point.getCoordinate().getLatitude()){
                minLat=point.getCoordinate().getLatitude();
            }
            if(minLon>point.getCoordinate().getLongitude()){
                minLon=point.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLat,minLon);
    }

    public double getDistance(){
        double sumDistance=0.0;
        int i=0;
            while(i+1<trackPoints.size()){
                sumDistance+=trackPoints.get(i+1).getDistanceFrom(trackPoints.get(i));
                i++;
            }

        return sumDistance;
    }

    public double getFullDecrease(){
        double sumDecrease=0.0;
        int i=0;
            while(i+1<trackPoints.size()) {
                if (trackPoints.get(i + 1).getElevation()-trackPoints.get(i).getElevation()<0) {
                    sumDecrease += trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation();
                }
                i++;
            }
        return Math.abs(sumDecrease);
    }

    public double getFullElevation(){
        double sumElevation=0.0;
        int i=0;
        while(i+1<trackPoints.size()) {
            if (trackPoints.get(i + 1).getElevation()-trackPoints.get(i).getElevation()>0) {
                sumElevation += trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation();
            }
            i++;
        }
        return sumElevation;}

    public double getRectangleArea() {
        double a = findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude();
        double b = findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude();
        return a * b;
    }



}
