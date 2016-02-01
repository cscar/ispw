package boundary.login;

import java.awt.Frame;

import javax.swing.JDialog;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;
 
public class BoundaryLoginDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;

    BoundaryPanelLogin panelLogin;
    
    public BoundaryLoginDialog(Frame parent) {
        super(parent, StringsEnglish.STR_LOGIN, true);
        
        //Login Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        panelLogin = factory.createPanelLanguage(language).createPanelLogin(this);
        this.add(panelLogin);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    
    public boolean isSucceeded() {
    	return panelLogin.isSucceeded();
    }
}