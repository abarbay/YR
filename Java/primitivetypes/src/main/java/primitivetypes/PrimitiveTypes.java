package primitivetypes;

import java.util.Arrays;

public class PrimitiveTypes {

    public String toBinaryString(int n){
        int lngth=32;
        String s="";
        String s2="";

        while (n>0) {
            if (n % 2 == 1) {
                s+= "1";
            } else {
                s+="0";
            }
         n=n/2;
        }
        for(int i=lngth;0<i;i--){
            if(i>s.length()){
                s2+="0";
            }
            else{s2+=s.charAt(i-1);}
        }
        return s2;
    }

    public char flip(char c){
        char result=0;
        if (c=='1'){
            result='0';
        }
        else if (c=='0'){
            result='1';
        }
        return result;

    }

    public String  toTwoComplementer(String s){
        String result="";
        for(int i=0;i<s.length();i++){
          result+=flip(s.charAt(i));
        }
        return result.toString();
    }


//    public String addOne(String s){
//
//    }

}
