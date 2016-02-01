package control.search;

import java.util.HashMap;

import entity.strings.StringsEnglish;

public class DoubleRoomDecorator extends OptionalFields {

	public DoubleRoomDecorator(SearchParams search) {
		super(search);
	}

	@Override
	public HashMap<String, String> getParams() {
		HashMap<String, String> params = super.getParams();
		params.put(StringsEnglish.STR_SD, String.valueOf(true));
		return params;		
	}
}