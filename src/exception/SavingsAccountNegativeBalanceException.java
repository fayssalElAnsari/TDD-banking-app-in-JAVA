package exception;

public class SavingsAccountNegativeBalanceException extends Exception {

	public SavingsAccountNegativeBalanceException(String msg) {
		super(msg + " : impossible to withdraw this amount");
		
		
	}
}
