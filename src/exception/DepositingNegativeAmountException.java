package exception;

public class DepositingNegativeAmountException extends BankAccountException {
	
	public DepositingNegativeAmountException(String msg) {
		super(msg + " : can't deposit negative ammount");
	}
}
