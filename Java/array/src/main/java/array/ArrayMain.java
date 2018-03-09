package array;

public class ArrayMain {
    public static void main(String[] args) {
        String[] daysOfTheWeek = {"Hétfő","Kedd","Szerda","Csütörtök","Péntek","Szombat","Vasárnap"};
        int[] power= new int[5];
        boolean[] bool= new boolean[6];

        System.out.println(daysOfTheWeek[1]);
        System.out.println(daysOfTheWeek.length);

        for(int i=0;i<5;i++){
            power[i]=(int) Math.pow(2, i);
            System.out.print(power[i]+" ");
        }
        System.out.println("");

        for(int i=0;i<6;i++){
            if(i%2!=0){
                bool[i]=true;}
            else{
                bool[i]=false;}

            System.out.print(bool[i]+" ");
        }
        System.out.println();
    }
}
