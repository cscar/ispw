package boundary.search;

import java.awt.Dimension;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JScrollPane;

import control.Factory;
import control.LanguageManager;
import entity.properties.Property;
import entity.strings.StringsEnglish;

public class BoundarySearchDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	BoundaryPanelSearch scoutPanel;
    
    public BoundarySearchDialog(JDialog parent, ArrayList<Property> properties) {
        super(parent, StringsEnglish.STR_WELCOME_SCOUT, true);

        //Set dialog size
        this.setPreferredSize(new Dimension(700, 200));
        
        //Scout Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        scoutPanel = factory.createPanelLanguage(language).createPanelSearch((Window) BoundarySearchDialog.this, properties);
        JScrollPane scrollPane = new JScrollPane(scoutPanel);
        this.add(scrollPane);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
}

