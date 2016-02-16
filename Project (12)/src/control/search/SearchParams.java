package control.search;

import java.util.HashMap;

public abstract class SearchParams {
	protected HashMap<String, String> searchParams = new HashMap<String, String>();
	
	public abstract HashMap<String, String> getParams();
}
