package boundary.tenant.changepassword;

import java.io.Serializable;

import javax.swing.JDialog;
import javax.swing.JFrame;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;

public class BoundaryChangePasswordTenantDialog extends JDialog implements Serializable{
	private static final long serialVersionUID = 1L;
	private BoundaryPanelChangePasswordTenant panel;
	
	public BoundaryChangePasswordTenantDialog(JFrame parent) {
		super(parent, StringsEnglish.STR_CHANGE_PASSWORD, true);

        //Change Password Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        panel = factory.createPanelLanguage(language).createPanelChangePasswordTenant(this);
        this.add(panel);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
	
	public boolean isSucceeded(){
    	return panel.isSucceeded();
    }
}


