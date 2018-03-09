package polimorfizmus;

public class Car extends Land_Vehicle {
    String ID="Car";

    @Override
    public void forward(int distance) {
        super.forward(distance);
    }

    @Override
    public void left_turn() {
        System.out.println("Car left turn");
    }
}
