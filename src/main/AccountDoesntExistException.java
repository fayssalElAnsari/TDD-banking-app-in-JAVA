package main;

public class AccountDoesntExistException extends Exception {

	public AccountDoesntExistException(String msg) {
		super(msg);
	}
}
