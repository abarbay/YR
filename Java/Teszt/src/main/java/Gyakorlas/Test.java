package Gyakorlas;

public class Test {
    private static int count=0;
    int length;
    int height=10;

    public Test(){
        count++;
        length=5;
    }

    public Test(int height){
        this();
        this.height=height;
    }

    public int getCount() {
        return count;
    }
}
