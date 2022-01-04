package main;

public class CreditingNegativeAmmountException extends Exception {

	public CreditingNegativeAmmountException(String msg) {
		super(msg + " : can't credit negative ammount");
		
	}
}
