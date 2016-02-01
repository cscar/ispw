package boundary.landlord.changeprofile;

import java.io.Serializable;

import javax.swing.JDialog;
import javax.swing.JFrame;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;

public class BoundaryChangeProfileLandLordDialog extends JDialog implements Serializable{
	private static final long serialVersionUID = 1L;
	private BoundaryPanelChangeProfileLandLord panel;

	public BoundaryChangeProfileLandLordDialog(JFrame parent) {
        super(parent, StringsEnglish.STR_CHANGE_PROFILE, true);

        //Registration Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        panel = factory.createPanelLanguage(language).createPanelChangeProfileLandLord(this);
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
