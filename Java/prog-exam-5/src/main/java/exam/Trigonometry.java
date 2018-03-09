package exam;

public class Trigonometry {

    public static final int halfCircle = 180;

    public double calculateA(int c, int alfa) {
        if (alfa >= 90 || alfa <= 0) {
            throw new IllegalArgumentException();
        }
        double alfaRad = calculateRad(alfa);
        return Math.sin(alfaRad) * c;


    }

    public double calculateB(int c, int alfa) {
        if (alfa >= 90 || alfa <= 0) {
            throw new IllegalArgumentException();
        }
        double alfaRad = calculateRad(alfa);
        return Math.cos(alfaRad) * c;
    }

    private double calculateRad(int degree) {
        return degree * Math.PI / halfCircle;
    }
}
