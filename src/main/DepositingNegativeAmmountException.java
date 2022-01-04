package main;

public class DepositingNegativeAmmountException extends Exception {
	
	public DepositingNegativeAmmountException(String msg) {
		super(msg + " : can't deposit negative ammount");
	}
}
