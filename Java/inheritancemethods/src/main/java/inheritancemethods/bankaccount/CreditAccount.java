package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount {

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }


    @Override
    public boolean transaction(long amount){
        Boolean result=false;
        long sum=0L;
        if (getBalance() - costOfTransaction(amount) > amount) {
            result = super.transaction(amount);
        } else if (amount - (getBalance() + costOfTransaction(amount) + overdraftLimit) < 0) {
            sum = amount - getBalance() + costOfTransaction(amount);
            overdraftLimit=overdraftLimit-sum;
            balanceToZero();
            result=true;
        }
        return result;
    }


    public long getOverdraftLimit() {
        return overdraftLimit;
    }
}
