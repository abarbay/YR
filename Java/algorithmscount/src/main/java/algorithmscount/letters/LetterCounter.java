package algorithmscount.letters;

public class LetterCounter {
    public int countLetters(String word, char letterToFind){
        int sum=0;
        for (int i = 0; i <word.length() ; i++) {
            if(word.charAt(i)==letterToFind){
                sum++;
            }
        }
        return sum;
    }
}
