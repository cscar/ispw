package boundary.tenant.profile;

import java.awt.Frame;

import javax.swing.JDialog;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;

public class BoundaryProfileTenantDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public BoundaryProfileTenantDialog(Frame parent) {
        super(parent, StringsEnglish.STR_MY_PROFILE, true);

        //Registration Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        BoundaryPanelProfileTenant panelRegistration = factory.createPanelLanguage(language).createPanelProfileTenant(this);
        this.add(panelRegistration);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
}
