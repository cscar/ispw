package control;

public class LanguageManager {
	
	private static LanguageManager instance = null;
	private int language;
	
	private LanguageManager(int language) {
		this.language = language;
	}
	
	public synchronized static final LanguageManager getCurrentLanguageInstance() {
		if (LanguageManager.instance == null) {
			LanguageManager.instance = new LanguageManager(0);
		}
		return instance;
	}

	public int getCurrentLanguage() {
		return this.language;
	}
	
	public void setCurrentLanguage(int language) {
		instance.language = language;
	}
	
}
