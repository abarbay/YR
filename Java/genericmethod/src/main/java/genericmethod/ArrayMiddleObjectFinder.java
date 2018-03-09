package genericmethod;


public class ArrayMiddleObjectFinder {

    public <T> T findMiddleObject(T... arr) throws IllegalArgumentException {
        if (arr == null) {
            throw new NullPointerException();
        }
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }
        if (arr.length % 2 == 0) {
            throw new IllegalArgumentException("Even number of elements");
        }
        return arr[(arr.length - 1) / 2];
    }
}
