package bank;

import java.util.List;

public class Bank {
    private List<Account> accounts;


    public Bank(List<Account> accounts) {
        if(accounts==null){throw new IllegalArgumentException();}
        this.accounts = accounts;
    }

    public void payment(String accountNumber, double amount){
        if(accountNumber==null){throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_ACCOUNTNUMBER);}
        int cnt=0;
        for(Account account:accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                account.subtract(amount);
                cnt++;
            }
        }
        if (cnt==0){throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_ACCOUNTNUMBER);};

    }


    public void deposit(String accountNumber, double amount){
        if(accountNumber==null){throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_ACCOUNTNUMBER);}
        int cnt=0;
        for(Account account:accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                account.subtract(amount);
                cnt++;
            }
        }
        if (cnt==0){throw new InvalidBankOperationException(InvalidBankOperationException.ErrorCode.INVALID_ACCOUNTNUMBER);};

    }


}
