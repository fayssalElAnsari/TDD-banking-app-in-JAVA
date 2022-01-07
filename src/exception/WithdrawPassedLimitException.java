package exception;

public class WithdrawPassedLimitException extends BankAccountException {

	public WithdrawPassedLimitException(String msg) {
		super(msg + " : passed limit of withdraw");
	}
}
