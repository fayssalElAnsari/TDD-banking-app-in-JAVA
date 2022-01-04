package main;

public class WithdrawingNegativeAmmountException extends Exception {

	public WithdrawingNegativeAmmountException(String msg) {
		super(msg + " : can't withdraw negative ammount");
		
	}
}
