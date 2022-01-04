package main;

public class WithdrawingNegativeAmountException extends Exception {

	public WithdrawingNegativeAmountException(String msg) {
		super(msg + " : can't withdraw negative ammount");
		
	}
}
