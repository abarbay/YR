package methodchain.robot;


public class NavigationPoint {
    private final int distance;
    private final int azimut;



    public NavigationPoint(int distance, int azimut) {
        this.distance = distance;
        this.azimut = azimut;
    }

    @Override
    public String toString() {
        return "distance: " + distance +
                " azimut: " + azimut;
    }
}
