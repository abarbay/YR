package templatemethod.bank;

public abstract class GeneralProduct {
    private int price;

    public GeneralProduct(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    protected abstract int round(double newPrice);

    public int increase(double percent) {

        price = round(this.getPrice() * (1 + (percent / 100)));
        return price;
    }
}
