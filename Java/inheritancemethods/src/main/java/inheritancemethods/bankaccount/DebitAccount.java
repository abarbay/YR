package inheritancemethods.bankaccount;

public class DebitAccount {
    private String accountNumber;
    private long balance;
    private final double COST= -3.0;
    private final long MIN_COST= -200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;

    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }


    public void balanceToZero(){
        balance = 0;
    }

    public final long costOfTransaction(long amount){
        if (amount * Math.abs(COST) / 100 > Math.abs(MIN_COST)) {
            return (long) Math.abs(amount * COST / 100);
        } else return Math.abs(MIN_COST);
    }

    public boolean transaction(long amount){
        Boolean result=false;
        if ((balance - costOfTransaction(amount) - amount) > 0) {
            balance -= (amount + costOfTransaction(amount));
            result=true;
        }
        return result;
    }

}
