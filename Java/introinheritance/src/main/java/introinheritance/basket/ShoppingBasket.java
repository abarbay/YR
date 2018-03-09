package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket extends Basket {
    //List<Item> items= new ArrayList<>();


    public ShoppingBasket() {
        super();
    }

//    @Override
//    public void addItem(Item item){
//        items.add(item);
//    }

//    @Override
//    public void removeItem(String barcode) {
//        for (Item item : items) {
//            if (item.getBarcode() == barcode) {
//                items.remove(item);
//            }
//        }
//    }

    public double sumNettoPrice(){
       double sum=0;
        for(Item item:items){
           sum+=item.getNettoPrice();
       }
       return sum;
    }
    public double sumTaxValue(){
        double sum=0;
        for(Item item:items){
            sum+=item.getTaxAmount();
        }
        return sum;
    }
    public double sumBruttoPrice(){
        double sum=0;
        for(Item item:items){
            sum+=item.getNettoPrice()+item.getTaxAmount();
        }
        return sum;
    };
     public void checkout(){
         items.clear();
     };
     public void removeMostExpensiveItem(){
         Item mostExpensiveItem=null;
         int index=-1;
             for (int i = 0; i <items.size() ; i++) {
                 if(mostExpensiveItem==null || items.get(i).getNettoPrice()>mostExpensiveItem.getNettoPrice()){
                     mostExpensiveItem=items.get(i);
                     index=i;
             }
         }
         items.remove(index);
     }

}
