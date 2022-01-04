package exception;

public class SavingsAccountBelowZeroBalanceException extends Exception {

	public SavingsAccountBelowZeroBalanceException(String msg) {
		super(msg + " : impossible to withdraw this amount");
		
		
	}
}
