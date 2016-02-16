package exception;

import entity.strings.StringsEnglish;

public class FileException extends Exception{
	private static final long serialVersionUID = 1L;

	public FileException() {
		super(StringsEnglish.EX_INSERT_CUSTOMER);
	}
	
}
