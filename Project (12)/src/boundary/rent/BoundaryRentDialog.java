package boundary.rent;

import javax.swing.JDialog;

import control.Factory;
import control.LanguageManager;
import entity.properties.Property;
import entity.strings.StringsEnglish;
 
public class BoundaryRentDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;

    BoundaryPanelRent panelRent;
    
    public BoundaryRentDialog(JDialog dialog, Property property) {
        super(dialog, StringsEnglish.STR_LOGIN, true);
        
        //Login Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        panelRent = factory.createPanelLanguage(language).createPanelRent(this, property);
        this.add(panelRent);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(dialog);
    }
    
}