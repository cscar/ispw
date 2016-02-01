package boundary.tenant;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;

import boundary.search.BoundarySearchDialog;
import boundary.tenant.profile.BoundaryProfileTenantDialog;
import control.search.BestAppliancesDecorator;
import control.search.DoubleRoomDecorator;
import control.search.MandatoryFields;
import control.search.ParkingSpaceDecorator;
import control.search.SingleRoomDecorator;
import control.search.WifiDecorator;
import entity.SingletonFrame;
import entity.Styles;
import entity.persistence.SavePropertiesValued;
import entity.properties.Property;
import entity.strings.StringsEnglish;
import entity.strings.StringsItalian;
import exception.EmptyFieldException;
import exception.NoRoomException;

public abstract class BoundaryPanelTenant extends JPanel {
	private static final long serialVersionUID = 1L;

	private JDialog dialog;
	private JPanel titlePanel;
	protected JButton btnManager;
	protected JButton btnProperties;
	protected JLabel lblTitle, lblSubTitle;
	protected JLabel lblMunicipality;
	private JTextField tfMunicipality;
	protected JLabel lblUniversity;
	private JTextField tfUniversity;
	protected JLabel lblPropertyType;
	protected JComboBox<String> cbPropertyType;
	protected JLabel lblSingleRoom;
	private JCheckBox cbSingleRoom;
	protected JLabel lblDoubleRoom;
	private JCheckBox cbDoubleRoom;
	protected JLabel lblParkingSpace;
	private JCheckBox cbParkingSpace;
	protected JLabel lblBestAppliances;
	private JCheckBox cbBestAppliances;
	protected JLabel lblWifi;
	private JCheckBox cbWifi;
	protected JLabel lblMaxMonthlyFee;
	private JTextField tfMaxMonthlyFee;
	protected JButton btnSearch;
	protected DefaultComboBoxModel<String> model;
	protected TitledBorder titledBorder;

	private JPanel btnSearchPanel;

	private JPanel btnMyProfilePanel;

	protected JButton btnMyProfile;

	private JPanel searchPanel;

	public BoundaryPanelTenant(JDialog dialog) {
		super(new BorderLayout());
		this.dialog = dialog;

		// Get screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Title
		titlePanel = new JPanel();
		titlePanel.setMaximumSize(new Dimension(screenSize.width, Styles.TITLE_SIZE_WELCOME));
		lblTitle = new JLabel();
		lblTitle.setFont(new Font(Styles.TITLE_FONT_WELCOME, Styles.TITLE_STYLE_WELCOME, Styles.TITLE_SIZE_WELCOME));
		titlePanel.add(lblTitle);

		// Fields
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;

		JPanel fieldsPanel = new JPanel(new GridBagLayout());
		titledBorder = BorderFactory.createTitledBorder(StringsItalian.STR_SEARCH);
		fieldsPanel.setBorder(titledBorder);

		lblMunicipality = new JLabel();
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		fieldsPanel.add(lblMunicipality, cs);

		tfMunicipality = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		fieldsPanel.add(tfMunicipality, cs);

		lblUniversity = new JLabel();
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		fieldsPanel.add(lblUniversity, cs);

		tfUniversity = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		fieldsPanel.add(tfUniversity, cs);

		lblMaxMonthlyFee = new JLabel();
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		fieldsPanel.add(lblMaxMonthlyFee, cs);

		tfMaxMonthlyFee = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 2;
		fieldsPanel.add(tfMaxMonthlyFee, cs);

		lblPropertyType = new JLabel();
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 1;
		fieldsPanel.add(lblPropertyType, cs);

		cbPropertyType = new JComboBox<String>();
		model = (DefaultComboBoxModel<String>) cbPropertyType.getModel();
		cs.gridx = 1;
		cs.gridy = 3;
		cs.gridwidth = 2;
		fieldsPanel.add(cbPropertyType, cs);

		lblSingleRoom = new JLabel();
		cs.gridx = 0;
		cs.gridy = 4;
		cs.gridwidth = 1;
		fieldsPanel.add(lblSingleRoom, cs);

		cbSingleRoom = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 4;
		cs.gridwidth = 2;
		fieldsPanel.add(cbSingleRoom, cs);

		lblDoubleRoom = new JLabel();
		cs.gridx = 0;
		cs.gridy = 5;
		cs.gridwidth = 1;
		fieldsPanel.add(lblDoubleRoom, cs);

		cbDoubleRoom = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 5;
		cs.gridwidth = 2;
		fieldsPanel.add(cbDoubleRoom, cs);

		lblParkingSpace = new JLabel();
		cs.gridx = 0;
		cs.gridy = 6;
		cs.gridwidth = 1;
		fieldsPanel.add(lblParkingSpace, cs);

		cbParkingSpace = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 6;
		cs.gridwidth = 2;
		fieldsPanel.add(cbParkingSpace, cs);

		lblBestAppliances = new JLabel();
		cs.gridx = 0;
		cs.gridy = 7;
		cs.gridwidth = 1;
		fieldsPanel.add(lblBestAppliances, cs);

		cbBestAppliances = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 7;
		cs.gridwidth = 2;
		fieldsPanel.add(cbBestAppliances, cs);

		lblWifi = new JLabel();
		cs.gridx = 0;
		cs.gridy = 8;
		cs.gridwidth = 1;
		fieldsPanel.add(lblWifi, cs);

		cbWifi = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 8;
		cs.gridwidth = 2;
		fieldsPanel.add(cbWifi, cs);

		// Buttons
		// Search Button
		btnSearchPanel = new JPanel();
		btnSearch = new JButton();
		btnSearch.addActionListener(new ButtonSearchListener());
		btnSearchPanel.add(btnSearch, cs);

		// Profile Button
		btnMyProfilePanel = new JPanel();
		btnMyProfile = new JButton();
		btnMyProfile.addActionListener(new ButtonProfile());
		btnMyProfilePanel.add(btnMyProfile);

		// Search Panel
		cs.fill = GridBagConstraints.VERTICAL;
		searchPanel = new JPanel(new GridBagLayout());
		cs.gridx = 0;
		cs.gridy = 1;
		searchPanel.add(fieldsPanel, cs);
		cs.gridx = 0;
		cs.gridy = 2;
		searchPanel.add(btnSearchPanel, cs);

		this.add(titlePanel, BorderLayout.PAGE_START);
		this.add(searchPanel, BorderLayout.WEST);
		this.add(btnMyProfilePanel, BorderLayout.EAST);

		// ESC key listener
		EscapeKeyListener escListener = new EscapeKeyListener();
		dialog.getRootPane().registerKeyboardAction(escListener, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				JComponent.WHEN_IN_FOCUSED_WINDOW);
	}

	private class EscapeKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}

	}

	private class ButtonProfile implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			BoundaryProfileTenantDialog myProfileDialog = new BoundaryProfileTenantDialog(
					SingletonFrame.getFrameInstance().getFrame());
			myProfileDialog.setVisible(true);
		}
	}

	private class ButtonSearchListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Get form input fields
			String municipality = tfMunicipality.getText().toString();
			String university = tfUniversity.getText().toString();
			String maxMonthlyFee = tfMaxMonthlyFee.getText().toString();
			int propertyType = cbPropertyType.getSelectedIndex();
			boolean singleRoom = cbSingleRoom.isSelected();
			boolean doubleRoom = cbDoubleRoom.isSelected();
			boolean parkingSpace = cbParkingSpace.isSelected();
			boolean bestAppliances = cbBestAppliances.isSelected();
			boolean wifi = cbWifi.isSelected();

			// Set search parameters
			MandatoryFields searchParams = new MandatoryFields(municipality, university, maxMonthlyFee, propertyType);
			if (singleRoom) {
				(new SingleRoomDecorator(searchParams)).getParams();
			}
			if (doubleRoom) {
				(new DoubleRoomDecorator(searchParams)).getParams();
			}
			if (parkingSpace) {
				(new ParkingSpaceDecorator(searchParams)).getParams();
			}
			if (bestAppliances) {
				(new BestAppliancesDecorator(searchParams)).getParams();
			}
			if (wifi) {
				(new WifiDecorator(searchParams)).getParams();
			}

			HashMap<String, String> params = searchParams.getParams();

			try {
				// Search for properties
				ArrayList<Property> properties = SavePropertiesValued.getInstance().searchProperties(
						searchParams.getParams().get(StringsEnglish.STR_MUNIC),
						searchParams.getParams().get(StringsEnglish.STR_UNIV_FAC),
						Double.valueOf(searchParams.getParams().get(StringsEnglish.STR_PRICE)),
						Integer.valueOf(searchParams.getParams().get(StringsEnglish.STR_PROP)),
						Boolean.valueOf(params.get(StringsEnglish.STR_CAR)),
						Boolean.valueOf(params.get(StringsEnglish.STR_WIFI)),
						Boolean.valueOf(params.get(StringsEnglish.STR_WM)),
						Boolean.valueOf(params.get(StringsEnglish.STR_SR)),
						Boolean.valueOf(params.get(StringsEnglish.STR_SD)));
				JDialog searchDialog = new BoundarySearchDialog(dialog, properties);
				searchDialog.setVisible(true);
			} catch (ClassNotFoundException | IOException e1) {
				fileReadErrorMessage();
			} catch (NumberFormatException e1) {
				numberFormatMessage();
			} catch (EmptyFieldException e1) {
				emptyFieldMessage();
			} catch (NoRoomException e1) {
				noRoomSelected();
			}
		}
	}

	protected abstract void fileReadErrorMessage();

	protected abstract void emptyFieldMessage();

	protected abstract void numberFormatMessage();

	protected abstract void noRoomSelected();

}