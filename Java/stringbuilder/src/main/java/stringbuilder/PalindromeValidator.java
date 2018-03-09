package stringbuilder;

public class PalindromeValidator {
    public boolean isPalindrome(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }
        StringBuilder sb = new StringBuilder(word.trim().toLowerCase());
        return sb.toString().equals(sb.reverse().toString());
    }
}
