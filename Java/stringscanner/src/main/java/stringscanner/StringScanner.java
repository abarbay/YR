package stringscanner;

import java.util.Scanner;

public class StringScanner {
    public int readAndSumValues(String intString, String delimiter){
        Scanner sc=new Scanner(intString).useDelimiter(delimiter);
        int sum=0;
        while(sc.hasNext()){
            if (sc.hasNext() && !sc.hasNextInt()) {
                throw new IllegalArgumentException("Incorrect");
            } else {
                sum += sc.nextInt();
            }
        }
        return sum;
    }
    public int readAndSumValues(String intString){
        Scanner sc=new Scanner(intString);
        int sum=0;
        while(sc.hasNext()){
            sum+=sc.nextInt();
        }
        return sum;

    }
public String filterLinesWithWordOccurrences(String text, String word){
        Scanner sc= new Scanner(text);
       StringBuilder output= new StringBuilder();
        while(sc.hasNextLine()){
            String result=sc.nextLine();
            if(result.contains(word) && sc.hasNextLine()){
                output.append(result);
                output.append("\n");
            }else if(result.contains(word)){output.append(result);}

        }
        return output.toString();
}

}
