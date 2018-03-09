package abstractclass.gamecharacter;

public final class Point {
    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long distance(Point newPoint){
        return (long) Math.sqrt(Math.pow((this.x-newPoint.x),2)+Math.pow((this.y-newPoint.y),2));
    }
}
