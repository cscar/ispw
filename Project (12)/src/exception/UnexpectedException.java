package exception;

import entity.strings.StringsEnglish;

public class UnexpectedException extends Exception{
	private static final long serialVersionUID = 1L;

	public UnexpectedException() {
		super(StringsEnglish.EX_UNEXPECTED);
	}
}
