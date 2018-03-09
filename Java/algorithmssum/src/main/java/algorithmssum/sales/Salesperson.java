package algorithmssum.sales;

public class Salesperson {
    private String name;
    private Integer amount;

    public Salesperson(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }
}
