package boundary.search.properties;

import java.awt.Dialog;
import java.awt.Window;

import javax.swing.JDialog;

import control.Factory;
import control.LanguageManager;
import entity.properties.Property;

public class BoundarySearchPropertyDialog extends JDialog{
	private static final long serialVersionUID = 1L;

	public BoundarySearchPropertyDialog(Window window, Property property) {
		super(window, "Title", Dialog.ModalityType.APPLICATION_MODAL);
		
        //Registration Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        BoundaryPanelSearchProperty panelProperty = factory.createPanelLanguage(language).createPanelSearchProperty(this, property);
        this.add(panelProperty);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(window);
		
	}

}
