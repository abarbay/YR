package methodstructure.pendrives;

import java.math.BigDecimal;

public class Pendrive {
    private String name;
    private int capacity;
    private int price;


    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public void risePrice(int percent){
        price+=price*percent/100;
    }

    public int comparePricePerCapacity(Pendrive pendrv){
       return new BigDecimal((double) price/capacity).compareTo(new BigDecimal((double) pendrv.price/pendrv.capacity));
    }

    public boolean cheaperThan(Pendrive pendrv){
        return price<pendrv.getPrice();
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
