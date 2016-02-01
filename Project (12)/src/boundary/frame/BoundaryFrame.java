package boundary.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Factory;
import control.LanguageManager;
import entity.SingletonFrame;
import entity.Styles;
import entity.strings.StringsEnglish;
import entity.strings.StringsItalian;

public class BoundaryFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private BoundaryPanelFrame buttonsPanel;
	private JComboBox<String> cbLanguage;
	private JPanel panel;
	private Factory factory;
	
	public BoundaryFrame() {
		super();
		
		//Get screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Set frame properties
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle(StringsItalian.FRAME_TITLE);
		this.setSize(Styles.FRAME_WIDTH, Styles.FRAME_HEIGHT);
		this.setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);

		SingletonFrame.getFrameInstance().setFrame(BoundaryFrame.this);
		
		//Frame Panel
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		getContentPane().add(panel);
		
		//Language ComboBox
		cbLanguage = new JComboBox<String>();
		cbLanguage.addItem(StringsEnglish.STR_ENGLISH);
		cbLanguage.addItem(StringsEnglish.STR_ITALIAN);
		cbLanguage.setMaximumSize(cbLanguage.getPreferredSize());
		cbLanguage.addItemListener(new ItemListener());
		panel.add(cbLanguage);
		
		//Title and Buttons Panel
		factory = Factory.getFactoryInstance();
		LanguageManager langMan = LanguageManager.getCurrentLanguageInstance();
		int language = langMan.getCurrentLanguage();
		buttonsPanel = factory.createPanelLanguage(language).createMainPanel(this);

		//Add Buttons Panel to Frame Panel
		if (buttonsPanel != null) {
			panel.add(buttonsPanel);
			cbLanguage.addItemListener(new ItemListener());
		}

		this.setVisible(true);
	}

	private class ItemListener implements java.awt.event.ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				//Remove old Buttons Panel
				panel.remove(buttonsPanel);

				//Language selection
				switch (cbLanguage.getSelectedItem().toString()) {
				case "English":
					LanguageManager.getCurrentLanguageInstance().setCurrentLanguage(0);
					buttonsPanel = factory.createPanelLanguage(0).createMainPanel(BoundaryFrame.this);
					break;
				case "Italian":
					LanguageManager.getCurrentLanguageInstance().setCurrentLanguage(1);
					buttonsPanel = factory.createPanelLanguage(1).createMainPanel(BoundaryFrame.this);
					break;
				}
				
				//Add Buttons Panel to Frame Panel
				if (buttonsPanel != null) {
					panel.add(buttonsPanel);
					buttonsPanel.revalidate();
				}
			}
		}
	}
}
