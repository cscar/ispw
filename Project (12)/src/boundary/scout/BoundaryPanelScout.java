package boundary.scout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import entity.persistence.SaveProperties;
import entity.properties.Property;

public abstract class BoundaryPanelScout extends JPanel {
	private static final long serialVersionUID = 1L;
	protected JDialog dialog;
	private ArrayList<Property> properties;

	protected boolean reloadDialog = false;
	
	public BoundaryPanelScout(JDialog dialog) {
		super();
		this.dialog = dialog;

		// Get list of properties not valued
		try {
			properties = SaveProperties.getInstance().getListOfProperties();
		} catch (ClassNotFoundException | IOException e) {
			fileReadErrorMessage();
		}

		for (Property property : properties) {
			addProperty(property);
		}

		// ESC key listener
		dialog.getRootPane().registerKeyboardAction(new EscapeKeyListener(),
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

		this.setVisible(true);
	}

	// Listeners
	private class EscapeKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}

	}
	
	public boolean isReloadDialog() {
		return reloadDialog;
	}
	
	protected abstract void addProperty(Property property);

	protected abstract void fileReadErrorMessage();

}
