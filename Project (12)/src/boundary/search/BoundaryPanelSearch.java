package boundary.search;

import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.properties.Property;

public abstract class BoundaryPanelSearch extends JPanel {
	private static final long serialVersionUID = 1L;
	protected Window window;

	public BoundaryPanelSearch(Window window, ArrayList<Property> properties) {
		super();
		this.window = window;

		// Get list of properties not valued
		for (Property property : properties) {
			addProperty(property);
		}

		this.setVisible(true);
	}

	protected abstract void addProperty(Property property);

	protected abstract void fileReadErrorMessage();
}
