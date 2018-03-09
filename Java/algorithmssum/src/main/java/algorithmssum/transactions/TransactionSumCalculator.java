package algorithmssum.transactions;


import java.util.List;

public class TransactionSumCalculator {
    public int sumAmountOfCreditEntries(List<Transaction> Transactions){
        int sum=0;
        for(Transaction transaction:Transactions){
            if(transaction.isCredit()==true) {
                sum += transaction.getAmount();
            }
        }
        return sum;
    }
}
