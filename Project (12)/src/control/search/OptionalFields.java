package control.search;

import java.util.HashMap;

public class OptionalFields extends SearchParams {

	SearchParams search;
	
	public OptionalFields(SearchParams search) {
		this.search = search;
	}
	
	@Override
	public HashMap<String, String> getParams() {
		return search.getParams();
	}

}
