package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {

    public int countWithBalanceGreaterThan(List<BankAccount> accounts, int amount){
        int sum=0;
            for(BankAccount account:accounts){
                if(account.getBalance()>amount){
                    sum++;
                }
            }
        return sum;
    }
}
