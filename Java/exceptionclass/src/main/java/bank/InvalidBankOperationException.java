package bank;

public class InvalidBankOperationException extends RuntimeException {
    public ErrorCode errorCode;


    public enum ErrorCode {
        LOW_BALANCE, INVALID_AMOUNT, INVALID_ACCOUNTNUMBER;
    }

    public InvalidBankOperationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
