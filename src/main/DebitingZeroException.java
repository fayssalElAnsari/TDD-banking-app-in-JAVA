package main;

public class DebitingZeroException extends Exception {

	public DebitingZeroException(String msg) {
		super(msg + " : can't debit 0 ammount");
	}
}
