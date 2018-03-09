package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
     List<Item>items ;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(String barcode){
        Item result=null;
        for(Item item:items){
            if(item.getBarcode()==barcode){
                result=item;
            }
        }
        if(result!=null){
            items.remove(result);
        }
    }

    public void clearBasket(){
        items.clear();
    }

    public List<Item> getItems() {
        return items;
    }
}
