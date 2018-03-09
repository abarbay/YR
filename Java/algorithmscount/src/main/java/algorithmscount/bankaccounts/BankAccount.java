package algorithmscount.bankaccounts;

public class BankAccount {
    private String NameOfOwner;
    private String AccountNumber;
    private Integer Balance;

    public BankAccount(String nameOfOwner, String accountNumber, Integer balance) {
        NameOfOwner = nameOfOwner;
        AccountNumber = accountNumber;
        Balance = balance;
    }

    public String getNameOfOwner() {
        return NameOfOwner;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public Integer getBalance() {
        return Balance;
    }
}
