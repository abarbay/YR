

public class Lnko {
    public int GCD(int a, int b)
    {
        while (a != 0 && b != 0)
        {
            if (a > b)
                a %= b;
            else
                b %= a;
        }

        if (a == 0)
            return b;
        else
            return a;
    }

    public int GCD2(int a, int b){
        for(int i=a; i>0;i--){
            if(b%i==0 && a%i==0 ){
                return i;
            }
        }
        return 0;
    }


    public int LCM(int a, int b){

        for(int i = 1; i <= b; i++) {
            if(i*a % b == 0)
                return Math.abs(i*a);
        }
        return 0;
    }


}
