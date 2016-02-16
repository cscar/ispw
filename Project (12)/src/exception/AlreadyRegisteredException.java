package exception;

import entity.strings.StringsEnglish;

public class AlreadyRegisteredException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public AlreadyRegisteredException() {
		super(StringsEnglish.STR_EMAIL_ALREADY_REGISTERED);
	}
	
}
