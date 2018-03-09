package genericclass;

public class ArraySearch {


    public DataPair<String> getFirstAndLastWord(String[] words){
        if(words==null){throw new NullPointerException();}
        if(words.length==0){throw new IllegalArgumentException();}
        else if(words.length==1){
          return new DataPair<>(words[0],words[0]);
        }
        else{
            return new DataPair<>(words[0],words[words.length-1]);
        }


    }


}
