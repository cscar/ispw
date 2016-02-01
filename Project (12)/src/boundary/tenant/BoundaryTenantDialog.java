package boundary.tenant;

import java.awt.Frame;

import javax.swing.JDialog;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;

public class BoundaryTenantDialog extends JDialog {
	private static final long serialVersionUID = 1L;

    BoundaryPanelTenant panelTenant;
    
    public BoundaryTenantDialog(Frame parent) {
        super(parent, StringsEnglish.STR_WELCOME_LANDLORD, true);
        
        //Login Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        panelTenant = factory.createPanelLanguage(language).createPanelTenant(this);
        this.add(panelTenant);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
}

