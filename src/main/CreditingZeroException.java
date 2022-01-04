package main;

public class CreditingZeroException extends Exception {
	
	public CreditingZeroException(String msg) {
		super(msg + " : can't credit 0 ammount");
	}

}
