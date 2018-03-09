public class Adder {
    public int add(int value) {


        String s = "";
        s = s + value;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }
}
