package algorithmssum.sales;

import java.util.List;

public class SalesAmountSumCalculator {

    public int sumSalesAmount(List<Salesperson> salesPersons){
        int sum=0;
        for(Salesperson salesPerson:salesPersons){
            sum+=salesPerson.getAmount();
        }
        return sum;
    }

}
