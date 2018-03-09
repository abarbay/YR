package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;

public class Transaction {
    private String accountNumber;
    private char creditOrDebit;
    private Enum<TransactionOperation>  transactionOperation;
    private int amount;
    private LocalDateTime dateOfTransaction;
    private Enum<StatusOperation> status;


    public Transaction(String accountNumber, Enum<TransactionOperation> transactionOperation, int amount, LocalDateTime dateOfTransaction) {
        this.accountNumber = accountNumber;
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.dateOfTransaction = dateOfTransaction;
        this.status=StatusOperation.CREATED;

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDateOfTransaction() {
        return dateOfTransaction;
    }

    public boolean isCredit() {
        boolean result= false;
        if(transactionOperation== TransactionOperation.CREDIT){
            result=true;
        }
        return result;
    }

    public boolean isDebit() {
        boolean result = false;
        if (transactionOperation == TransactionOperation.DEBIT) {
            result = true;
        }
        return result;
    }

    public Enum<StatusOperation> succeeded(){
        return StatusOperation.SUCCEEDED;
    }
    public Enum<StatusOperation> pending(){
        return StatusOperation.PENDING;
    }





//    public char creditOrDebit(){
//
//    }
}
