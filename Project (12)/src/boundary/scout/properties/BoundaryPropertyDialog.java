package boundary.scout.properties;

import javax.swing.JDialog;

import control.Factory;
import control.LanguageManager;
import entity.properties.Property;

public class BoundaryPropertyDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	private BoundaryPanelProperty panelProperty;

	public BoundaryPropertyDialog(JDialog parent, Property property) {
		super(parent, "Title", true);
		
        //Registration Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        panelProperty = factory.createPanelLanguage(language).createPanelProperty(this, property);
        this.add(panelProperty);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
	}

	public boolean isAccepted() {
		return panelProperty.isAccepted();
	}

	public void setAccepted(boolean accepted) {
		panelProperty.setAccepted(accepted);
	}

	public boolean isRefused() {
		return panelProperty.isRefused();
	}

	public void setRefused(boolean refused) {
		panelProperty.setRefused(refused);
	}
}
