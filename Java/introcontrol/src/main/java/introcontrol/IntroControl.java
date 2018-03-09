package introcontrol;

import com.sun.org.apache.xpath.internal.SourceTree;

public class IntroControl {

    public int substractTenIfGreaterThanTen(int n){
        int result=n;
        if(n>10){
            result=n-10;
        }
        return result;
    }

    public String describeNumber(int n){
        String s="Not zero";
        if(n==0){
            s="Zero";
        }
        return s;
    }

    public String greetingToJoe(String name){
        String result="";
        if(name.equals("Joe")){
            result="Hello Joe!";
        }
        return result;
    }

    public int calculateBonus(int i){
        int result=0;
        if(i>1_000_000){
            result= (int) (i*0.1);
        }
        return result;
    }

    public int calculateMeterReadingsDifference(int prev, int next){
        int result=0;
        if(prev<=next){
            result=next-prev;
        }
        else{result= (10000-prev)+next;}
    return result;
    }

    public void printNumbers(int max){
        if(max<0){
            System.out.println("Nem lehet negatív számot megadni!");
        }
        else {
            for (int i = 0; i <= max; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void printNumbersBetween(int min, int max){
        if(min<0 || max<0){
            System.out.println("Az értékek nem lehetnek negatívak");
        }
        else{
            for(int i=min;i<=max;i++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public void printNumbersBetweenAnyDirection(int min, int max){
        if(min<0 || max<0){
            System.out.println("Az értékek nem lehetnek negatívak");
        }
        else{
            if (min<max){
                for(int i=min;i<=max;i++){
                    System.out.print(i+" ");

                }
                System.out.println();
            }
            else if(min>max) {
                for (int i = min; max <= i; i--) {
                    System.out.print(i +" ");

                }
                System.out.println();
            }
            else {System.out.println("A két érték megegyezik;");}

        }
    }

    public void printOddNumbers(int max){
        for(int i=0;i<=max;i++){
            if(i%2!=0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}