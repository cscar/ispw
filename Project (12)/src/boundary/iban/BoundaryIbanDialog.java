package boundary.iban;

import java.io.Serializable;

import javax.swing.JDialog;
import javax.swing.JFrame;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;

public class BoundaryIbanDialog extends JDialog implements Serializable {
	private static final long serialVersionUID = 1L;
	private BoundaryPanelIban panel;

	public BoundaryIbanDialog(JFrame parent) {
		super(parent, StringsEnglish.STR_SIGNUP, true);

		// Registration Panel
		Factory factory = Factory.getFactoryInstance();
		int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
		panel = factory.createPanelLanguage(language).createPanelIban(this);
		this.add(panel);

		// Dialog properties
		pack();
		setResizable(false);
		setLocationRelativeTo(parent);
	}

	public boolean isSucceeded() {
		return panel.isSucceeded();
	}
}
