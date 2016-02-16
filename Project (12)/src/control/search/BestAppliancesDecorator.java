package control.search;

import java.util.HashMap;

import entity.strings.StringsEnglish;

public class BestAppliancesDecorator extends OptionalFields {

	public BestAppliancesDecorator(SearchParams search) {
		super(search);
	}

	@Override
	public HashMap<String, String> getParams() {
		HashMap<String, String> params = super.getParams();
		params.put(StringsEnglish.STR_WM, String.valueOf(true));
		return params;		
	}
}