package control.search;

import java.util.HashMap;

import entity.strings.StringsEnglish;

public class SingleRoomDecorator extends OptionalFields {

	public SingleRoomDecorator(SearchParams search) {
		super(search);
	}

	@Override
	public HashMap<String, String> getParams() {
		HashMap<String, String> params = super.getParams();
		params.put(StringsEnglish.STR_SR, String.valueOf(true));
		return params;		
	}
}