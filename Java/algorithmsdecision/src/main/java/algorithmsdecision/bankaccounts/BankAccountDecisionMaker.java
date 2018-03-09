package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {
    public boolean containsBalanceGreaterThan(List<BankAccount> accounts,int value){
        boolean result=false;
        for(BankAccount account:accounts){
            if(account.getBalance()>value){
                result=true;
            }
        }
        return result;
    }
}
