package boundary.administrator;

import java.awt.Frame;

import javax.swing.JDialog;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;

public class BoundaryAdministratorDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private BoundaryPanelAdministrator panelAdministrator;
    
    public BoundaryAdministratorDialog(Frame parent) {
        super(parent, StringsEnglish.STR_WELCOME_ADMIN, true);
        
        //Administrator Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        panelAdministrator = factory.createPanelLanguage(language).createPanelAdministrator(this);
        this.add(panelAdministrator);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
}
