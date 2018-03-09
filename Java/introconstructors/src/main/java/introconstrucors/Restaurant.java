package introconstrucors;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<String> menu= new ArrayList<>();
    private String name;
    private int capacity;

    public Restaurant(String name, int capacity) {
        this.name = name;
        this.capacity = capacity*4;
        this.menu=fillMenu();
    }

    private List<String> fillMenu(){
        List<String> costesmenu= new ArrayList<>();
        costesmenu.add("Párolt ürücomb");
        costesmenu.add("Krionikus fagylalt");
        costesmenu.add("Pángalaktikus Gégepukkasztó");
        return costesmenu;
    }

    // A getterek az ellenőrzés miatt vannak
    public int getCapacity() {
        return capacity;
    }

    public List<String> getMenu() {
        return menu;
    }

    public static void main(String[] args) {
        Restaurant r1=new Restaurant("Costes",25);
        System.out.println("A capacity*4:"+r1.getCapacity()+ "fő");
        System.out.println("a menü:"+r1.getMenu().toString());
    }
}
