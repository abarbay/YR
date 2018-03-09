package bank;

public class Account {
    private String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if(accountNumber==null){throw new IllegalArgumentException();}
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.maxSubtract = 100000;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double maxSubtract) {
        if(maxSubtract<0.0){throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_AMOUNT);}
        this.maxSubtract = maxSubtract;
    }

    public double subtract(double amount){
        if(amount<0){throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_AMOUNT);}
        if(balance<amount  && amount>0){throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.LOW_BALANCE);}

        return balance-=amount;
    }

    public double deposit(double amount){
        if(amount<0){
            throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_AMOUNT);}
        else{return balance+=amount;}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        if (Double.compare(account.maxSubtract, maxSubtract) != 0) return false;
        return accountNumber != null ? accountNumber.equals(account.accountNumber) : account.accountNumber == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountNumber != null ? accountNumber.hashCode() : 0;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxSubtract);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
