package boundary.scout;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JScrollPane;

import control.Factory;
import control.LanguageManager;
import entity.strings.StringsEnglish;

public class BoundaryScoutDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	BoundaryPanelScout scoutPanel;
    
    public BoundaryScoutDialog(Frame parent) {
        super(parent, StringsEnglish.STR_WELCOME_SCOUT, true);

        //Set dialog size
        this.setPreferredSize(new Dimension(700, 200));
        
        //Scout Panel
        Factory factory = Factory.getFactoryInstance();
        int language = LanguageManager.getCurrentLanguageInstance().getCurrentLanguage();
        scoutPanel = factory.createPanelLanguage(language).createPanelScout(BoundaryScoutDialog.this);
        JScrollPane scrollPane = new JScrollPane(scoutPanel);
        this.add(scrollPane);
        
        //Dialog properties
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    
    public boolean isReloadDialog() {
    	return scoutPanel.isReloadDialog();
    }
    
}

