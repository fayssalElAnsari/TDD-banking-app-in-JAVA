package exception;

public class DepositingZeroException extends Exception {
	
	public DepositingZeroException(String msg) {
		super(msg + " : can't deposit 0 ammount");
	}

}
