package singleton.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class LocalStore implements Store {
    public static final LocalStore INSTANCE = new LocalStore();
    final static int CAPACITY = 3000;
    private List<Product> products = new ArrayList<>();

    public LocalStore(List<Product> products) {
        this.products = products;
    }

    private LocalStore() {
    }

    public static LocalStore getInstance() {
        return INSTANCE;
    }


    @Override
    public void add(Product product) {
        if (this.getProductCount() < CAPACITY) {
            products.add(product);
        }


    }

    @Override
    public Product remove() {

        if (this.getProductCount() == 0) {
            throw new IllegalStateException("Store is empty");
        }
        return products.remove(this.getProductCount() - 1);


    }

    @Override
    public void reset() {
        products.clear();
    }

    @Override
    public int getProductCount() {
        return products.size();
    }
}
