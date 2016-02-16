package control.search;

import java.util.HashMap;

import entity.strings.StringsEnglish;

public class ParkingSpaceDecorator extends OptionalFields {

	public ParkingSpaceDecorator(SearchParams search) {
		super(search);
	}

	@Override
	public HashMap<String, String> getParams() {
		HashMap<String, String> params = super.getParams();
		params.put(StringsEnglish.STR_CAR, String.valueOf(true));
		return params;		
	}
}