package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transations, int amount){
        int sum=0;
        for(Transaction transaction:transations){
            if(transaction.getAmount()<amount){
                sum++;
            }
        }
        return sum;
    }
}
