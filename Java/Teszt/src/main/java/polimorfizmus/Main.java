package polimorfizmus;

public class Main {
    public static void main(String[] args) {
        Land_Vehicle lv= new Land_Vehicle();
        System.out.println(lv.ID);
        lv.forward(5);

        Vehicle v= new Land_Vehicle(); // polimorfizmus a superclassra
        System.out.println(v.ID);
        v.forward(6);

        Car c= new Car();
        System.out.println(c.ID);


        Turning c2= c;
        c2.left_turn();
        c2.right_turn();

        Turning t=lv;
        lv.left_turn();
        lv.right_turn();

        Turning t2=(Turning) v;
        ((Turning) v).left_turn();
        ((Turning) v).right_turn();
        System.out.println(v.ID);


    }
}
