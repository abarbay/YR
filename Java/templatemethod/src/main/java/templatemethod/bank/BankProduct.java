package templatemethod.bank;

public class BankProduct extends GeneralProduct {
    public BankProduct(int price) {
        super(price);
    }

    @Override
    protected int round(double newPrice) {
        return 0;
    }

    @Override
    public int increase(double percent) {
        return super.increase(percent);
    }
}
