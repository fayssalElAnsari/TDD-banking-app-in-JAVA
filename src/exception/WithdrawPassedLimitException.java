package exception;

public class WithdrawPassedLimitException extends Exception {

	public WithdrawPassedLimitException(String msg) {
		super(msg + " : passed limit of withdraw");
	}
}
