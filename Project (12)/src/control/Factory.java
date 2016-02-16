package control;

import entity.language.Language;
import entity.language.LanguageEnglish;
import entity.language.LanguageItalian;

public class Factory {
	
	private static Factory instance = null;
	
	private Factory() {
	}
	
	public Language createPanelLanguage(int choice){		
		switch(choice) {
		case 0:
			return new LanguageEnglish();
		case 1:
			return new LanguageItalian();
		default:
			return null;
		}
	}
	
	public synchronized static final Factory getFactoryInstance() {
		if (Factory.instance == null) {
			Factory.instance = new Factory();
		}
		return instance;
	}
}
