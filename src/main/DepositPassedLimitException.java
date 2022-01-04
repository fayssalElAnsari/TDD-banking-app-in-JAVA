package main;

public class DepositPassedLimitException extends Exception {
	
	public DepositPassedLimitException(String msg) {
		super(msg + " : passed limit of deposit");
	}

}
