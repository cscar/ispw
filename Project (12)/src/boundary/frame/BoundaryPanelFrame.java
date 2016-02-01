package boundary.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import boundary.administrator.BoundaryAdministratorDialog;
import boundary.authentication.BoundaryAuthenticationDialog;
import boundary.iban.BoundaryIbanDialog;
import boundary.landlord.BoundaryLandLordDialog;
import boundary.login.BoundaryLoginDialog;
import boundary.registration.BoundaryRegistrationDialog;
import boundary.scout.BoundaryScoutDialog;
import boundary.tenant.BoundaryTenantDialog;
import control.search.BestAppliancesDecorator;
import control.search.DoubleRoomDecorator;
import control.search.MandatoryFields;
import control.search.ParkingSpaceDecorator;
import control.search.SingleRoomDecorator;
import control.search.WifiDecorator;
import entity.LandLord;
import entity.Session;
import entity.Styles;
import entity.persistence.Save;
import entity.persistence.SavePropertiesValued;
import entity.properties.Property;
import entity.strings.StringsEnglish;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.NoRoomException;
import exception.UserNotFoundException;

public abstract class BoundaryPanelFrame extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel titlePanel, btnSearchPanel;
	private JPanel buttonsPanel;
	private JPanel searchPanel;

	protected JButton btnLogin;
	protected JButton btnRegistration;
	protected JLabel lblTitle;
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

	private JFrame frame;

	private ArrayList<Property> properties;

	private JScrollPane scrollPane;

	private Dimension screenSize;

	protected JButton btnAlreadyRegistered;

	private JPanel rightPanel;

	public BoundaryPanelFrame(JFrame frame) {
		super(new BorderLayout());
		this.frame = frame;

		// Get Screen Size
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Title
		titlePanel = new JPanel();
		titlePanel.setMaximumSize(new Dimension(screenSize.width, Styles.TITLE_SIZE));
		lblTitle = new JLabel();
		lblTitle.setFont(new Font(Styles.TITLE_FONT, Styles.TITLE_STYLE, Styles.TITLE_SIZE));
		titlePanel.add(lblTitle);

		// Right panel
		rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		// Fields
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;

		JPanel fieldsPanel = new JPanel(new GridBagLayout());
		titledBorder = BorderFactory.createTitledBorder(StringsEnglish.STR_SEARCH);
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

		// Search Button
		btnSearchPanel = new JPanel();
		btnSearch = new JButton();
		btnSearch.addActionListener(new ButtonSearchActionListener());
		btnSearchPanel.add(btnSearch, cs);

		// Search Panel
		searchPanel = new JPanel(new GridBagLayout());

		cs.fill = GridBagConstraints.VERTICAL;
		cs.gridx = 0;
		cs.gridy = 1;
		searchPanel.add(fieldsPanel, cs);

		cs.gridx = 0;
		cs.gridy = 2;
		searchPanel.add(btnSearchPanel, cs);

		// Buttons
		// Registration Button
		btnRegistration = new JButton();
		btnRegistration.addActionListener(new ButtonRegistrationListener());
		btnRegistration
				.setPreferredSize(new Dimension(Styles.BUTTON_REGISTRATION_WIDTH, Styles.BUTTON_REGISTRATION_HEIGHT));
		btnRegistration.setFont(new Font(Styles.BUTTON_REGISTRATION_FONT, Styles.BUTTON_REGISTRATION_STYLE,
				Styles.BUTTON_REGISTRATION_TEXT_SIZE));

		// Login Button
		btnLogin = new JButton();
		btnLogin.setPreferredSize(new Dimension(Styles.BUTTON_LOGIN_WIDTH, Styles.BUTTON_LOGIN_HEIGHT));
		btnLogin.addActionListener(new ButtonLoginListener());
		btnLogin.setFont(new Font(Styles.BUTTON_LOGIN_FONT, Styles.BUTTON_LOGIN_STYLE, Styles.BUTTON_LOGIN_TEXT_SIZE));

		// Buttons Panel
		buttonsPanel = new JPanel();
		buttonsPanel.add(btnRegistration);
		buttonsPanel.add(Box.createHorizontalStrut(Styles.SPACE_BETWEEN_BUTTONS));
		buttonsPanel.add(btnLogin);

		// Already Registered Button
		// JPanel btnAlreadyRegisteredPanel = new JPanel();
		btnAlreadyRegistered = new JButton();
		btnAlreadyRegistered.addActionListener(new ButtonAlreadyRegisteredListener());
		// btnAlreadyRegisteredPanel.add(btnAlreadyRegistered);
		rightPanel.add(btnAlreadyRegistered);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		// Add to Main Panel
		this.add(titlePanel, BorderLayout.PAGE_START);
		this.add(rightPanel, BorderLayout.EAST);
		// this.add(btnAlreadyRegisteredPanel, BorderLayout.EAST);
		this.add(searchPanel, BorderLayout.WEST);
		this.add(buttonsPanel, BorderLayout.PAGE_END);
	}

	private class ButtonRegistrationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			BoundaryRegistrationDialog registrationDialog = new BoundaryRegistrationDialog(frame);
			registrationDialog.setVisible(true);
		}

	}

	private class ButtonLoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			BoundaryLoginDialog loginDialog = new BoundaryLoginDialog(frame);
			loginDialog.setVisible(true);

			// Get results from login dialog
			if (loginDialog.isSucceeded()) {
				// If successfully logged in
				boolean isTenant = Session.getSessionInstance().isTenant();
				boolean isLandLord = Session.getSessionInstance().isLandLord();
				boolean isAdministrator = Session.getSessionInstance().isAdministrator();
				boolean isScout = Session.getSessionInstance().isScout();

				if (isLandLord) {
					// User authenticated as landlord
					BoundaryLandLordDialog landDialog = new BoundaryLandLordDialog(frame);
					landDialog.setVisible(true);
					// Logout when user exit dialog
					Session.getSessionInstance().logout();
				} else {
					if (isTenant) {
						// User authenticated as tenant
						BoundaryTenantDialog tenantDialog = new BoundaryTenantDialog(frame);
						tenantDialog.setVisible(true);
						// Logout when user exit dialog
						Session.getSessionInstance().logout();
					} else if (isAdministrator) {
						// User authenticated as administrator
						BoundaryAdministratorDialog adminDialog = new BoundaryAdministratorDialog(frame);
						adminDialog.setVisible(true);
						// Logout when user exit dialog
						Session.getSessionInstance().logout();
					} else if (isScout) {
						// User authenticated as scout
						BoundaryScoutDialog scoutDialog;
						do {
							scoutDialog = new BoundaryScoutDialog(frame);
							scoutDialog.setVisible(true);
						} while (scoutDialog.isReloadDialog());
						// Logout when user exit dialog
						Session.getSessionInstance().logout();
					}
				}
			}
		}
	}

	private class ButtonSearchActionListener implements ActionListener {

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
				properties = SavePropertiesValued.getInstance().searchProperties(
						searchParams.getParams().get(StringsEnglish.STR_MUNIC),
						searchParams.getParams().get(StringsEnglish.STR_UNIV_FAC),
						Double.valueOf(searchParams.getParams().get(StringsEnglish.STR_PRICE)),
						Integer.valueOf(searchParams.getParams().get(StringsEnglish.STR_PROP)),
						Boolean.valueOf(params.get(StringsEnglish.STR_CAR)),
						Boolean.valueOf(params.get(StringsEnglish.STR_WIFI)),
						Boolean.valueOf(params.get(StringsEnglish.STR_WM)),
						Boolean.valueOf(params.get(StringsEnglish.STR_SR)),
						Boolean.valueOf(params.get(StringsEnglish.STR_SD)));
				if (scrollPane != null) {
					// Remove old scroll pane
					rightPanel.remove(scrollPane);
					// BoundaryPanelFrame.this.remove(scrollPane);
				}
				scrollPane = new JScrollPane(createPanelResults(properties));
				scrollPane.setPreferredSize(new Dimension(getWidth() / 2, getHeight()));
				rightPanel.add(scrollPane);
				// BoundaryPanelFrame.this.add(scrollPane, BorderLayout.EAST);
				BoundaryPanelFrame.this.revalidate();
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

	private class ButtonAlreadyRegisteredListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			BoundaryAuthenticationDialog authenticationDialog = new BoundaryAuthenticationDialog(frame);
			authenticationDialog.setVisible(true);

			// Get results from login dialog
			if (authenticationDialog.isSucceeded()) {
				// If successfully logged in
				boolean isTenant = Session.getSessionInstance().isTenant();
				boolean isLandLord = Session.getSessionInstance().isLandLord();

				if (isLandLord) {
					// User authenticated as landlord
					if (!isTenant) {
						// LandLord, not Tenant
						if (confirmRegTenantMessage() == JOptionPane.YES_OPTION) {
							// Register as Tenant
							LandLord landLord = (LandLord) Session.getSessionInstance().getCustomer();
							try {
								Save.getInstance().deleteUser(landLord.getEmail());
								landLord.setTenant(true);
								Save.getInstance().insertCustomer(landLord);
								successfulRegistrationMessage();
							} catch (ClassNotFoundException | IOException e) {
								fileReadErrorMessage();
							} catch (AlreadyRegisteredException e) {
								alreadyRegisteredMessage();
							} catch (FileException e) {
								fileReadErrorMessage();
							} catch (UserNotFoundException e) {
								userNotFoundMessage();
							}
						}
					} else {
						// LandLord and Tenant
						// Cannot register
						errorMessage();
					}
				} else {
					if (isTenant) {
						// User authenticated as tenant
						if (confirmRegLandLordMessage() == JOptionPane.YES_OPTION) {
							// Register as Tenant
							BoundaryIbanDialog ibanDialog = new BoundaryIbanDialog(frame);
							ibanDialog.setVisible(true);
						}
					} else {
						// Administrator or scout or others
						errorMessage();
					}
				}
			}
		}
	}

	protected abstract void emptyFieldMessage();

	protected abstract void numberFormatMessage();

	protected abstract void noRoomSelected();

	protected abstract void errorMessage();

	public abstract void userNotFoundMessage();

	protected abstract int confirmRegLandLordMessage();

	protected abstract int confirmRegTenantMessage();

	protected abstract void successfulRegistrationMessage();

	protected abstract void fileReadErrorMessage();

	protected abstract void alreadyRegisteredMessage();

	protected abstract JPanel createPanelResults(ArrayList<Property> properties);

}
