package exception;

import entity.strings.StringsEnglish;

public class PasswordMismatchException extends Exception {

	private static final long serialVersionUID = 1L;

	public PasswordMismatchException() {
		super(StringsEnglish.STR_PASSWORD_MISMATCH);
	}
	
}
