package exception;

public class WithdrawingZeroException extends Exception {

	public WithdrawingZeroException(String msg) {
		super(msg + " : can't withdraw 0 ammount");
	}
}
