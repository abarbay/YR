package algorithmscount.bankaccounts;

public class Transaction {
    String accountNumber;
    Enum<TransactionType> transactionOperation;
    Integer amount;

    public Transaction(String accountNumber, Enum<TransactionType> transactionOperation, Integer amount) {
        this.accountNumber = accountNumber;
        this.transactionOperation = transactionOperation;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean isCredit() {
        boolean result= false;
        if(transactionOperation== TransactionType.CREDIT){
            result=true;
        }
        return result;
    }

    public boolean isDebit() {
        boolean result= false;
        if(transactionOperation== TransactionType.DEBIT){
            result=true;
        }
        return result;
    }

    public Integer getAmount() {
        return amount;
    }
}
