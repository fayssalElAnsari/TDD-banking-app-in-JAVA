package main;

public class DebitingNegativeAmmountException extends Exception {
	
	public DebitingNegativeAmmountException(String msg) {
		super(msg + " : can't debit negative ammount");
	}
}
