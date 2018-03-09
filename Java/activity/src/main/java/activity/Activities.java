package activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Activities {
    private List<Activity> activities= new ArrayList<>();

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }



    public void addActivity(Activity activity){
        activities.add(activity);
    }

    public List<Report> distancesByTypes(){
        double bikingDistance=0;
        double hikingDistance=0;
        double runningDistance=0;
        double basketballDistance=0;
        for(Activity activity:activities){
            switch (activity.getType()){
                case RUNNING:
                    runningDistance+=activity.getDistance();
                    break;
                case BIKING:
                    bikingDistance+=activity.getDistance();
                    break;
                case HIKING:
                    hikingDistance+=activity.getDistance();
                    break;
                case BASKETBALL:
                    basketballDistance+=activity.getDistance();
            }
        }
         Report basketballReport=new Report(ActivityType.BASKETBALL,basketballDistance);
         Report bikeReport=new Report(ActivityType.BIKING,bikingDistance);
         Report hikingReport=new Report(ActivityType.HIKING,hikingDistance);
         Report runningReport=new Report(ActivityType.RUNNING,runningDistance);
         return new ArrayList<>(Arrays.asList(basketballReport,bikeReport,hikingReport,runningReport));

    }

    public int numberOfTrackActivities(){
        int sum=0;
        for(Activity activity:activities){
            if(activity instanceof ActivityWithTrack){
                sum++;
            }
        }
        return sum;
    }

    public int numberOfWithoutTrackActivities(){
        int sum=0;
        for(Activity activity:activities){
            if(activity instanceof ActivityWithoutTrack){
                sum++;
            }
        }
        return sum;
    }

}
