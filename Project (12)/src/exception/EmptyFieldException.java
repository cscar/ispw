package exception;

import entity.strings.StringsEnglish;

public class EmptyFieldException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyFieldException() {
		super(StringsEnglish.STR_EMPTY_FIELD);
	}
	
}
