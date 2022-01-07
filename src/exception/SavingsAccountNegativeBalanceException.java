package exception;

public class SavingsAccountNegativeBalanceException extends BankAccountException {

	public SavingsAccountNegativeBalanceException(String msg) {
		super(msg + " : impossible to withdraw this amount");
		
		
	}
}
