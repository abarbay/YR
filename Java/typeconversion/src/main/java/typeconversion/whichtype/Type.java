package typeconversion.whichtype;

public enum Type {
    BYTE(Byte.MIN_VALUE, Byte.MAX_VALUE), SHORT(Short.MIN_VALUE, Short.MAX_VALUE), INT(Integer.MIN_VALUE, Integer.MAX_VALUE);

    private final long min;
    private final long max;

    Type(long min, long max) {
        this.min = min;
        this.max = max;
    }

    boolean isBetween(long n) {
        return n <= max && n >= min;
    }
}
