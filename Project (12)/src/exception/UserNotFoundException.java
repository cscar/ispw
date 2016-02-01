package exception;

import entity.strings.StringsEnglish;

public class UserNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super(StringsEnglish.EX_WRONG_LOGIN);
	}
}
