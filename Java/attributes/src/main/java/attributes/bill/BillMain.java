package attributes.bill;


public class BillMain {
    public static void main(String[] args) {
        Bill b1= new Bill();

        b1.addItem(new Item("Tej",2,300));
        b1.addItem(new Item("Kenyér",1,300));
        b1.addItem(new Item("Herz szalámi",1,2000));
        // a getItems egy listát ad vissza itemekkel és a calculateTotalPrice egy listát vár, a lista elemeit valamiért nem tudom kiiratni
        System.out.println("A Végösszeg:"+b1.calculateTotalPrice(b1.getItems()));
    }
}
