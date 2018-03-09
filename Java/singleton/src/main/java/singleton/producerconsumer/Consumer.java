package singleton.producerconsumer;

public class Consumer {
    private Store store;

    public Consumer(Store store) {
        if (store.getProductCount() == 0) {
            throw new IllegalStateException("Store is empty");
        } else {
            this.store = store;
        }

    }

    public Store getStore() {
        return store;
    }

    public Product consume() {
        return store.remove();
    }
}
