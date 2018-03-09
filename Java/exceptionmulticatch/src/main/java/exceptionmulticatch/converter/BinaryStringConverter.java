package exceptionmulticatch.converter;


public class BinaryStringConverter {
    public boolean[] binaryStringToBooleanArray(String binaryString) {
        if (binaryString == "" || binaryString == null) {
            throw new NullPointerException();
        }
        String arr[] = binaryString.split("");
        boolean[] result = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("0")) {
                result[i] = false;
            } else if (arr[i].equals(("1"))) {
                result[i] = true;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                result += "1";
            } else {
                result += "0";
            }
        }
        return result;
    }
}
