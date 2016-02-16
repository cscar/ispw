package boundary.authentication;

import java.awt.Frame;

import javax.swing.JDialog;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;
 
public class BoundaryAuthenticationDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;

    BoundaryPanelAuthentication authenticationPanel;
    
    public BoundaryAuthenticationDialog(Frame parent) {
        super(parent, StringsEnglish.STR_AUTHENTICATION, true);
        
        //Authentication Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        authenticationPanel = factory.createPanelLanguage(language).createPanelAuthentication(this);
        this.add(authenticationPanel);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    
    public boolean isSucceeded() {
    	return authenticationPanel.isSucceeded();
    }
}