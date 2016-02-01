package exception;

import entity.strings.StringsEnglish;

public class NoRoomException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoRoomException() {
		super(StringsEnglish.EX_ROOM_NOT_AVAILABLE);
	}
	
}
