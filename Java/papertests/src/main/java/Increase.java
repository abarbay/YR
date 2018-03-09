public class Increase {

    public boolean incdec(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array is Null");
        }
        int p = 0;
        int n = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                n = 1;
            } else if (arr[i] < arr[i + 1]) {
                p = 1;
            } else if (arr[i] == arr[i + 1]) {
                p = 0;
                n = 0;
                break;
            }
        }
        return ((p + n) == 1);
    }
}
