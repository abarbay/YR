public class Reverse {

    public String reverseString(String str){

        if(str==null){throw new IllegalStateException("String cannot be null");}
        else{
            String result="";
            for(int i= str.length();i>0;i--){
                result+=str.charAt(i-1);
            }
            return result;
        }

    }
}
