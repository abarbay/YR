package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecutor {
    public void executeTransactions(List<Transaction> transactions, List<BankAccount> accounts){
           for (BankAccount account:accounts) {
            for(Transaction transaction:transactions){
                if(account.getAccountNumber()==transaction.getAccountNumber()){
                    if(transaction.isCredit()){
                        account.deposit(transaction.getAmount());
                        transaction.succeeded();
                    }
                    else if(transaction.isDebit()){
                        if(transaction.getAmount()<account.getBalance()) {
                            account.withdraw(transaction.getAmount());
                        }
                        else{transaction.pending();}

                    }
                }
            }
        }
        //return result;
    }
}
