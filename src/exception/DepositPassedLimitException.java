package exception;

public class DepositPassedLimitException extends BankAccountException {
	
	public DepositPassedLimitException(String msg) {
		super(msg + " : passed limit of deposit");
	}

}
