package nestedclasses.webshop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebShop {

    private List<Product> products = new ArrayList<>();

    public void addProducts(Product product) {
        products.add(product);
    }

    public List<Product> getProductsOrderByName() {
        List<Product> result = new ArrayList<>(products);
        result.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().toLowerCase()
                        .compareTo(p2.getName().toLowerCase());
            }
        });
        return result;
    }

    public List<Product> getProductsOrderByPrice() {
        List<Product> result = new ArrayList<>(products);

        result.sort(new Comparator<Product>() {
            private byte result2 = 0;

            public int compare(Product p1, Product p2) {
                if (p1.getPrice() > p2.getPrice()) {
                    result2 = 1;
                }
                if (p2.getPrice() > p1.getPrice()) {
                    result2 = -1;
                }
                if (p2.getPrice() == p1.getPrice()) {
                    result2 = 0;
                }
                return result2;
            }

        });
        return result;
    }

    public List<Product> getProductsOrderByFrom() {
        List<Product> result = new ArrayList<>(products);
        result.sort(new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return p1.getFrom()
                        .compareTo(p2.getFrom());
            }
        });
        return result;
    }

}
