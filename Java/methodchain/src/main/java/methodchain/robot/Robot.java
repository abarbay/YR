package methodchain.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private int distance;
    private int azimut;
    private List<NavigationPoint> navigationList= new ArrayList<>();


    public int getDistance() {
        return distance;
    }

    public Robot go(int distance) {
        this.distance += distance;
        return this;
    }

    public int getAzimut() {
        return azimut;
    }

    public Robot rotate(int azimut) {
        this.azimut += azimut;
        return this;
    }

    public Robot registerNavigationPoint(){
        navigationList.add(new NavigationPoint(distance,azimut));
        return this;

    }

    public List<NavigationPoint> getNavigationList() {
        return navigationList;
    }
}
