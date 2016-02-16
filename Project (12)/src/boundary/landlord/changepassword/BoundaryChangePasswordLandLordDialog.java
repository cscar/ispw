package boundary.landlord.changepassword;

import java.io.Serializable;

import javax.swing.JDialog;
import javax.swing.JFrame;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;

public class BoundaryChangePasswordLandLordDialog extends JDialog implements Serializable{
	private static final long serialVersionUID = 1L;
	private BoundaryPanelChangePasswordLandLord panel;
	
	public BoundaryChangePasswordLandLordDialog(JFrame parent) {
		super(parent, StringsEnglish.STR_CHANGE_PASSWORD, true);

        //Change Password Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        panel = factory.createPanelLanguage(language).createPanelChangePasswordLandLord(this);
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


