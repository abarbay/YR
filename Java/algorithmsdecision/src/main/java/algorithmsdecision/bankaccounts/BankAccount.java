package algorithmsdecision.bankaccounts;

public class BankAccount {
    private String nameOfOwner;
    private String accountNumber;
    private int balance;

    public BankAccount(String nameOfOwner, String accountNumber, int balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(int amount){
        boolean result=false;
        if(amount<balance){
            result=true;
            balance=balance-amount;
        }
        return result;
    }

    public boolean deposit(int amount){
        boolean result=false;
        if(amount>0){
            result=true;
            balance=balance+amount;
        }
        return result;
    }
}
