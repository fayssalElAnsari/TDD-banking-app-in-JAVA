package exception;

public class AccountDoesntExistException extends BankAccountException {

	public AccountDoesntExistException(String msg) {
		super(msg);
	}
}
