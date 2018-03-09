public class LetterCounter {
    public int cnt(String s) {
        if (s == null || s == "") {
            throw new IllegalArgumentException();
        }
        int actualLength = 1;
        int longest = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                actualLength++;
                if (actualLength > longest) {
                    longest = actualLength;
                }
            } else {

                actualLength = 1;
            }

        }
        return longest;

    }
}
