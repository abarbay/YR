package polimorfizmus;

public class Land_Vehicle extends Vehicle implements Turning {

    String ID="Land Vehicle";

    @Override
    public  void forward(int distance){
        System.out.println("Land vehicle going forward:" + distance);
    }

    public void left_turn() {
        System.out.println("Land vehicle turning left");
    }

    public void right_turn() {
        System.out.println("Land vehicle turning right");
        System.out.println(ID);
    }
}
