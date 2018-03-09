package enumtype.unit;

public enum LengthUnit {
    MILLIMETER(true,1),CENTIMETER(true,10),METER(true,1000),YARD(false,914.40),FOOT(false,304.80),INCH(false,25.40);

    private final boolean IS_SI;

    private final double LENGTHINMILLIMETER;

    public boolean isIS_SI() {
        return IS_SI;
    }

    public double getLENGTHINMILLIMETER() {
        return LENGTHINMILLIMETER;
    }

    LengthUnit(boolean IS_SI, double LENGTHINMILLIMETER) {
        this.IS_SI = IS_SI;
        this.LENGTHINMILLIMETER = LENGTHINMILLIMETER;
    }
}
