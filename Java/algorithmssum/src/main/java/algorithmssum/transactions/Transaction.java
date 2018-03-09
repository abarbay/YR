package algorithmssum.transactions;

public class Transaction {
    String accountNumber;
    Enum<TransactionOperation> transactionOperation;
    Integer amount;

    public Transaction(String accountNumber, Enum<TransactionOperation> transactionOperation, Integer amount) {
        this.accountNumber = accountNumber;
        this.transactionOperation = transactionOperation;
        this.amount = amount;
    }


    public boolean isCredit() {
        boolean result= false;
        if(transactionOperation==TransactionOperation.CREDIT){
            result=true;
        }
        return result;
    }

    public boolean isDebit() {
        boolean result= false;
        if(transactionOperation==TransactionOperation.DEBIT){
            result=true;
        }
        return result;
    }

    public Integer getAmount() {
        return amount;
    }
}
