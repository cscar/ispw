package boundary.registration;

import java.awt.Frame;
import java.io.Serializable;

import javax.swing.JDialog;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;

public class BoundaryRegistrationDialog extends JDialog implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public BoundaryRegistrationDialog(Frame parent) {
        super(parent, StringsEnglish.STR_SIGNUP, true);

        //Registration Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        BoundaryPanelRegistration panelRegistration = factory.createPanelLanguage(language).createPanelRegistration(this);
        this.add(panelRegistration);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    
}