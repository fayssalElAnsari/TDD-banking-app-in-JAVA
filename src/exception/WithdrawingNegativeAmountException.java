package exception;

public class WithdrawingNegativeAmountException extends BankAccountException {

	public WithdrawingNegativeAmountException(String msg) {
		super(msg + " : can't withdraw negative ammount");
		
	}
}
