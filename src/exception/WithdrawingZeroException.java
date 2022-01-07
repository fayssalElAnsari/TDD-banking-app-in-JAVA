package exception;

public class WithdrawingZeroException extends BankAccountException {

	public WithdrawingZeroException(String msg) {
		super(msg + " : can't withdraw 0 ammount");
	}
}
