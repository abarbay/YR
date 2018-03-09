package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements  FlyableRobot {
    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();
    public static final long ALTITUDE=5;

    public AstroBoy(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    public long getAltitude() {
        return this.position.getZ();
    }

    @Override
    public void liftTo(long altitude) {
        this.position.setZ(altitude);
        path.add(new Point(this.position.getX(),this.position.getY(),this.position.getZ()));

    }

    @Override
    public void moveTo(Point position) {
        this.position=position;
        path.add(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        this.liftTo(ALTITUDE);
        path.add(new Point(position.getX(),position.getY(),this.position.getZ()));
        this.position=position;
        path.add(position);
    }

    @Override
    public void rotate(int angle) {
        this.angle=angle;

    }

    @Override
    public List<Point> getPath() {
        return path;
    }
}
