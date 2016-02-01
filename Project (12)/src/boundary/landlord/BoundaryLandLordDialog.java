package boundary.landlord;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;

public class BoundaryLandLordDialog extends JDialog{
		private static final long serialVersionUID = 1L;
		
		JPanel panel;
	    JPanel bp;

	    BoundaryPanelLandLord landLordPanel;
	    
	    public BoundaryLandLordDialog(Frame parent) {
	        super(parent, StringsEnglish.STR_WELCOME_LANDLORD, true);
	        
	        //LandLord Panel
	        Factory factory = Factory.getFactoryInstance();
	        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
	        landLordPanel = factory.createPanelLanguage(language).createPanelLandLord(this);
	        this.add(landLordPanel);
	        
	        //Dialog properties
	        pack();
	        setResizable(false);
	        setLocationRelativeTo(parent);
	    }
	}

