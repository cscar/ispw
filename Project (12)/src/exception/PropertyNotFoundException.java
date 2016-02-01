package exception;

import entity.strings.StringsEnglish;

public class PropertyNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public PropertyNotFoundException() {
		super(StringsEnglish.EX_PROPERTY_NOT_FOUND);
	}
}
