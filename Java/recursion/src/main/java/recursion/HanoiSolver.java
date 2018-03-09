package recursion;

public class HanoiSolver {
    String result="";
    public void moveDisks(int discNumber, char from, char to, char with){

        if(discNumber==1){
            result+=from+"->"+to;
            return;}
        moveDisks(discNumber-1,from,with,to);
        result+=from+"->"+to;
        moveDisks(discNumber-1,with,to,from);


    }

    public String getResultOfGame(){
        return result;

    }
}
