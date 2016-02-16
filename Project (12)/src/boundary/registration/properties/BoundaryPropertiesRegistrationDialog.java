package boundary.registration.properties;

import java.io.Serializable;

import javax.swing.JDialog;
import javax.swing.JFrame;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;

public class BoundaryPropertiesRegistrationDialog extends JDialog implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public BoundaryPropertiesRegistrationDialog(JFrame parent) {
        super(parent, StringsEnglish.STR_BTN_PROP, true);

        //Registration Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        BoundaryPanelRegistrationProperties panelRegistration = factory.createPanelLanguage(language).createPanelRegistrationProperties(this);
        this.add(panelRegistration);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    
} 


