package templatemethod.bank;

import java.math.BigDecimal;

public class LoanProduct extends GeneralProduct {
    public LoanProduct(int price) {
        super(price);
    }

    @Override
    protected int round(double newPrice) {
        return (int) Math.ceil(newPrice);


    }
}
