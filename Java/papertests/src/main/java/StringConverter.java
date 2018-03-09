public class StringConverter {

    public String converter(String str){
        String result="";

        for (int i = 0; i <str.length() ; i++) {
            result+=str.charAt(i);
            result+=i;
        }
        return result;
    }

}
