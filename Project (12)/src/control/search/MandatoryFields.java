package control.search;

import java.util.HashMap;

import entity.strings.StringsEnglish;

public class MandatoryFields extends SearchParams {

	public MandatoryFields(String mun, String uni, String fee, int propertyType) {
		searchParams.put(StringsEnglish.STR_MUNIC, mun);
		searchParams.put(StringsEnglish.STR_UNIV_FAC, uni);
		searchParams.put(StringsEnglish.STR_PRICE, fee);
		searchParams.put(StringsEnglish.STR_PROP, String.valueOf(propertyType));
	}

	@Override
	public HashMap<String, String> getParams() {
		return searchParams;
	}

}
