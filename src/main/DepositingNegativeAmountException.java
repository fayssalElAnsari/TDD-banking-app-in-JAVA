package main;

public class DepositingNegativeAmountException extends Exception {
	
	public DepositingNegativeAmountException(String msg) {
		super(msg + " : can't deposit negative ammount");
	}
}
