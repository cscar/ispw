package exception;

import entity.strings.StringsEnglish;

public class RoomsNotAvailableException extends Exception{
	private static final long serialVersionUID = 1L;

	public RoomsNotAvailableException() {
		super(StringsEnglish.EX_NO_ROOMS);
	}
	
}
