package control.search;

import java.util.HashMap;

import entity.strings.StringsEnglish;

public class WifiDecorator extends OptionalFields {

	public WifiDecorator(SearchParams search) {
		super(search);
	}

	@Override
	public HashMap<String, String> getParams() {
		HashMap<String, String> params = super.getParams();
		params.put(StringsEnglish.STR_WIFI, String.valueOf(true));
		return params;		
	}
}