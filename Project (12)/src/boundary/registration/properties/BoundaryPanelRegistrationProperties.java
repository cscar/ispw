package boundary.registration.properties;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import control.properties.RegistrationApartment;
import control.properties.RegistrationHouse;
import control.properties.RegistrationRoom;
import entity.Constants;
import entity.Filepaths;
import entity.Session;
import entity.strings.StringsEnglish;
import entity.strings.StringsItalian;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.NoRoomException;
import exception.UserNotFoundException;

public abstract class BoundaryPanelRegistrationProperties extends JPanel {

	private static final long serialVersionUID = 1L;

	protected JFormattedTextField tfHouseNumber;
	protected JLabel lblHouseNumber;
	protected JButton btnOK;
	protected JButton btnCancel;
	private boolean succeeded;
	private JPanel selectionPanel;
	private JPanel buttonsPanel;

	protected JRadioButton rdRegHouse;
	protected JRadioButton rdRegApartment;
	protected JRadioButton rdRegRoom;
	protected ButtonGroup bgRegistrationProperties;
	protected JLabel lblMunicipality;
	protected JTextField tfMunicipality;
	protected JLabel lblProvince;
	protected JTextField tfProvince;
	protected JLabel lblAddress;
	protected JTextField tfAddress;
	protected JLabel lblUniversity;
	protected JTextField tfUniversity;
	protected JLabel lblWC;
	protected JTextField tfWC;
	protected JLabel lblSpecialGuest;
	protected JCheckBox cbSpecialGuest;
	protected JLabel lblParkingSpace;
	protected JCheckBox cbParkingSpace;
	protected JLabel lblBestAppliances;
	protected JCheckBox cbBestAppliances;
	protected JLabel lblExpenses;
	protected JCheckBox cbExpenses;
	protected JLabel lblBus;
	protected JLabel lblOtherStudents;
	private JCheckBox cbOtherStudents;

	protected JLabel lblAnimals;
	protected JCheckBox cbAnimals;
	protected JFormattedTextField tfMq;
	protected JLabel lblMq;
	protected JLabel lblGarden;
	protected JCheckBox cbGarden;
	protected JCheckBox cbBus;
	protected JFormattedTextField tfOtherStudentPrice;
	protected JLabel lblOtherStudentPrice;

	protected JLabel lblSingleRoomWC;
	protected JComboBox<String> cbSingleRoomWC;
	protected JLabel lblSingleRoomWCPrice;
	protected JFormattedTextField tfSingleRoomWCPrice;

	protected JLabel lblSingleRoom;
	protected JComboBox<String> cbSingleRoom;
	protected JLabel lblSingleRoomPrice;
	protected JFormattedTextField tfSingleRoomPrice;

	protected JLabel lblDoubleRoomWC;
	protected JComboBox<String> cbDoubleRoomWC;
	protected JLabel lblDoubleRoomWCPrice;
	protected JFormattedTextField tfDoubleRoomWCPrice;

	protected JLabel lblDoubleRoom;
	protected JComboBox<String> cbDoubleRoom;
	protected JLabel lblDoubleRoomPrice;
	protected JFormattedTextField tfDoubleRoomPrice;

	protected JLabel lblPropertyType;
	protected JComboBox<String> cbRoomType;
	protected DefaultComboBoxModel<String> model;
	protected JLabel lblRoomFee;
	protected JFormattedTextField tfRoomFee;

	protected JLabel lblNickname;
	protected JTextField tfNickname;

	protected JLabel lblWifi;
	protected JCheckBox cbWifi;

	protected JLabel lblContract;
	protected JComboBox<String> cbContractTerm1;
	protected JComboBox<String> cbContractTerm2;
	protected DefaultComboBoxModel<String> modelDd;

	private JDialog dialog;

	public BoundaryPanelRegistrationProperties(JDialog dialog) {
		super(new BorderLayout());
		this.dialog = dialog;

		// Tenant-LandLord Panel
		selectionPanel = new JPanel();
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;

		RadioListener rdListener = new RadioListener();

		rdRegRoom = new JRadioButton();
		rdRegRoom.addActionListener(rdListener);
		cs.gridx = 0;
		cs.gridy = 2;
		rdRegRoom.setSelected(true);
		selectionPanel.add(rdRegRoom, cs);

		rdRegHouse = new JRadioButton();
		rdRegHouse.addActionListener(rdListener);
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		selectionPanel.add(rdRegHouse, cs);

		rdRegApartment = new JRadioButton();
		rdRegApartment.addActionListener(rdListener);
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		selectionPanel.add(rdRegApartment, cs);

		bgRegistrationProperties = new ButtonGroup();
		bgRegistrationProperties.add(rdRegApartment);
		bgRegistrationProperties.add(rdRegHouse);
		bgRegistrationProperties.add(rdRegRoom);

		// Fields Panel
		JPanel fieldsPanel = new JPanel(new GridBagLayout());
		fieldsPanel.setBorder(new LineBorder(Color.GRAY));

		lblNickname = new JLabel();
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		fieldsPanel.add(lblNickname, cs);

		tfNickname = new JTextField();
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		fieldsPanel.add(tfNickname, cs);

		lblMunicipality = new JLabel();
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		fieldsPanel.add(lblMunicipality, cs);

		tfMunicipality = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		fieldsPanel.add(tfMunicipality, cs);

		lblProvince = new JLabel();
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		fieldsPanel.add(lblProvince, cs);

		tfProvince = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 2;
		fieldsPanel.add(tfProvince, cs);

		lblAddress = new JLabel();
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 1;
		fieldsPanel.add(lblAddress, cs);

		tfAddress = new JTextField();
		cs.gridx = 1;
		cs.gridy = 3;
		cs.gridwidth = 2;
		fieldsPanel.add(tfAddress, cs);

		lblHouseNumber = new JLabel();
		cs.gridx = 0;
		cs.gridy = 4;
		cs.gridwidth = 1;
		fieldsPanel.add(lblHouseNumber, cs);

		tfHouseNumber = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 4;
		cs.gridwidth = 2;
		fieldsPanel.add(tfHouseNumber, cs);

		lblMq = new JLabel();
		cs.gridx = 0;
		cs.gridy = 5;
		cs.gridwidth = 1;
		fieldsPanel.add(lblMq, cs);

		tfMq = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 5;
		cs.gridwidth = 2;
		fieldsPanel.add(tfMq, cs);

		lblUniversity = new JLabel();
		cs.gridx = 0;
		cs.gridy = 6;
		cs.gridwidth = 1;
		fieldsPanel.add(lblUniversity, cs);

		tfUniversity = new JTextField();
		cs.gridx = 1;
		cs.gridy = 6;
		cs.gridwidth = 2;
		fieldsPanel.add(tfUniversity, cs);

		lblWC = new JLabel();
		cs.gridx = 0;
		cs.gridy = 7;
		cs.gridwidth = 1;
		fieldsPanel.add(lblWC, cs);

		tfWC = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 7;
		cs.gridwidth = 2;
		fieldsPanel.add(tfWC, cs);

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

		lblSpecialGuest = new JLabel();
		cs.gridx = 0;
		cs.gridy = 9;
		cs.gridwidth = 1;
		fieldsPanel.add(lblSpecialGuest, cs);

		cbSpecialGuest = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 9;
		cs.gridwidth = 2;
		cbSpecialGuest.addItemListener(new ItemListenerSpecialGuest());
		fieldsPanel.add(cbSpecialGuest, cs);

		lblBus = new JLabel();
		cs.gridx = 0;
		cs.gridy = 10;
		cs.gridwidth = 1;
		fieldsPanel.add(lblBus, cs);

		cbBus = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 10;
		cs.gridwidth = 2;
		fieldsPanel.add(cbBus, cs);

		lblBestAppliances = new JLabel();
		cs.gridx = 0;
		cs.gridy = 11;
		cs.gridwidth = 1;
		fieldsPanel.add(lblBestAppliances, cs);

		cbBestAppliances = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 11;
		cs.gridwidth = 2;
		fieldsPanel.add(cbBestAppliances, cs);

		lblExpenses = new JLabel();
		cs.gridx = 0;
		cs.gridy = 12;
		cs.gridwidth = 1;
		fieldsPanel.add(lblExpenses, cs);

		cbExpenses = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 12;
		cs.gridwidth = 2;
		fieldsPanel.add(cbExpenses, cs);

		lblOtherStudents = new JLabel();
		cs.gridx = 0;
		cs.gridy = 13;
		cs.gridwidth = 1;
		fieldsPanel.add(lblOtherStudents, cs);

		cbOtherStudents = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 13;
		cs.gridwidth = 2;
		fieldsPanel.add(cbOtherStudents, cs);

		lblAnimals = new JLabel();
		cs.gridx = 0;
		cs.gridy = 14;
		cs.gridwidth = 1;
		fieldsPanel.add(lblAnimals, cs);

		cbAnimals = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 14;
		cs.gridwidth = 2;
		fieldsPanel.add(cbAnimals, cs);

		lblParkingSpace = new JLabel();
		cs.gridx = 0;
		cs.gridy = 15;
		cs.gridwidth = 1;
		fieldsPanel.add(lblParkingSpace, cs);

		cbParkingSpace = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 15;
		cs.gridwidth = 2;
		fieldsPanel.add(cbParkingSpace, cs);

		lblGarden = new JLabel();
		cs.gridx = 0;
		cs.gridy = 16;
		cs.gridwidth = 1;
		fieldsPanel.add(lblGarden, cs);

		cbGarden = new JCheckBox();
		cs.gridx = 1;
		cs.gridy = 16;
		cs.gridwidth = 2;
		fieldsPanel.add(cbGarden, cs);

		String[] num = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		lblSingleRoomWC = new JLabel();
		cs.gridx = 0;
		cs.gridwidth = 1;
		cs.gridy = 17;
		fieldsPanel.add(lblSingleRoomWC, cs);

		cbSingleRoomWC = new JComboBox<String>(num);
		cs.gridx = 1;
		cs.gridy = 17;
		cbSingleRoomWC.addItemListener(new ItemListenerSingleRoomWC());
		cs.gridwidth = 2;
		fieldsPanel.add(cbSingleRoomWC, cs);

		lblSingleRoomWCPrice = new JLabel();
		cs.gridx = 0;
		cs.gridwidth = 1;
		cs.gridy = 18;
		fieldsPanel.add(lblSingleRoomWCPrice, cs);

		tfSingleRoomWCPrice = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 18;
		cs.gridwidth = 2;
		fieldsPanel.add(tfSingleRoomWCPrice, cs);

		lblSingleRoom = new JLabel();
		cs.gridx = 0;
		cs.gridy = 19;
		cs.gridwidth = 1;
		fieldsPanel.add(lblSingleRoom, cs);

		cbSingleRoom = new JComboBox<String>(num);
		cs.gridx = 1;
		cs.gridy = 19;
		cbSingleRoom.addItemListener(new ItemListenerSingleRoom());
		cs.gridwidth = 2;
		fieldsPanel.add(cbSingleRoom, cs);

		lblSingleRoomPrice = new JLabel();
		cs.gridx = 0;
		cs.gridy = 20;
		cs.gridwidth = 1;
		fieldsPanel.add(lblSingleRoomPrice, cs);

		tfSingleRoomPrice = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 20;
		cs.gridwidth = 2;
		fieldsPanel.add(tfSingleRoomPrice, cs);

		lblDoubleRoomWC = new JLabel();
		cs.gridx = 0;
		cs.gridy = 21;
		cs.gridwidth = 1;
		fieldsPanel.add(lblDoubleRoomWC, cs);

		cbDoubleRoomWC = new JComboBox<String>(num);
		cs.gridx = 1;
		cs.gridy = 21;
		cbDoubleRoomWC.addItemListener(new ItemListenerDoubleRoomWC());
		cs.gridwidth = 2;
		fieldsPanel.add(cbDoubleRoomWC, cs);

		lblDoubleRoomWCPrice = new JLabel();
		cs.gridx = 0;
		cs.gridy = 22;
		cs.gridwidth = 1;
		fieldsPanel.add(lblDoubleRoomWCPrice, cs);

		tfDoubleRoomWCPrice = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 22;
		cs.gridwidth = 2;
		fieldsPanel.add(tfDoubleRoomWCPrice, cs);

		lblDoubleRoom = new JLabel();
		cs.gridx = 0;
		cs.gridy = 23;
		cs.gridwidth = 1;
		fieldsPanel.add(lblDoubleRoom, cs);

		cbDoubleRoom = new JComboBox<String>(num);
		cs.gridx = 1;
		cs.gridy = 23;
		cs.gridwidth = 2;
		cbDoubleRoom.addItemListener(new ItemListenerDoubleRoom());
		fieldsPanel.add(cbDoubleRoom, cs);

		lblDoubleRoomPrice = new JLabel();
		cs.gridx = 0;
		cs.gridy = 24;
		cs.gridwidth = 1;
		fieldsPanel.add(lblDoubleRoomPrice, cs);

		tfDoubleRoomPrice = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 24;
		cs.gridwidth = 2;
		fieldsPanel.add(tfDoubleRoomPrice, cs);

		lblOtherStudentPrice = new JLabel();
		cs.gridx = 0;
		cs.gridy = 25;
		cs.gridwidth = 1;
		lblOtherStudentPrice.setEnabled(false);
		fieldsPanel.add(lblOtherStudentPrice, cs);

		tfOtherStudentPrice = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 25;
		cs.gridwidth = 2;
		tfOtherStudentPrice.setEnabled(false);
		fieldsPanel.add(tfOtherStudentPrice, cs);

		lblPropertyType = new JLabel();
		cs.gridx = 0;
		cs.gridy = 26;
		cs.gridwidth = 1;
		fieldsPanel.add(lblPropertyType, cs);

		cbRoomType = new JComboBox<String>();
		model = (DefaultComboBoxModel<String>) cbRoomType.getModel();
		cs.gridx = 1;
		cs.gridy = 26;
		cs.gridwidth = 2;
		fieldsPanel.add(cbRoomType, cs);

		lblRoomFee = new JLabel();
		cs.gridx = 0;
		cs.gridy = 27;
		cs.gridwidth = 1;
		fieldsPanel.add(lblRoomFee, cs);

		tfRoomFee = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 27;
		cs.gridwidth = 2;
		fieldsPanel.add(tfRoomFee, cs);

		lblContract = new JLabel();
		cs.gridx = 0;
		cs.gridy = 28;
		cs.gridwidth = 1;
		fieldsPanel.add(lblContract, cs);

		String[] value = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
		cbContractTerm1 = new JComboBox<String>(value);
		cs.gridx = 1;
		cs.gridy = 28;
		cs.gridwidth = 1;
		fieldsPanel.add(cbContractTerm1, cs);

		cbContractTerm2 = new JComboBox<String>();
		modelDd = (DefaultComboBoxModel<String>) cbContractTerm2.getModel();
		cs.gridx = 2;
		cs.gridy = 28;
		cs.gridwidth = 1;
		fieldsPanel.add(cbContractTerm2, cs);

		enableDisableFields();

		// Buttons
		btnOK = new JButton();
		btnOK.addActionListener(new ButtonRegistrationListener());

		btnCancel = new JButton();
		btnCancel.addActionListener(new ButtonCancelListener());

		// Buttons Panel
		buttonsPanel = new JPanel();
		buttonsPanel.add(btnOK);
		buttonsPanel.add(btnCancel);

		JPanel registrationPanel = new JPanel(new GridBagLayout());
		cs.fill = GridBagConstraints.VERTICAL;
		cs.gridx = 0;
		cs.gridy = 0;
		registrationPanel.add(selectionPanel, cs);
		cs.gridx = 0;
		cs.gridy = 1;
		registrationPanel.add(fieldsPanel, cs);

		this.add(registrationPanel, BorderLayout.WEST);
		this.add(buttonsPanel, BorderLayout.PAGE_END);

		// ENTER key listener
		dialog.getRootPane().setDefaultButton(btnOK);

		// ESC key listener
		dialog.getRootPane().registerKeyboardAction(new EscapeKeyListener(),
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
	}

	public String getNickname() {
		return tfNickname.getText().trim();
	}

	public String getMunicipality() {
		return tfMunicipality.getText().trim();
	}

	public String getHouseNumber() {
		return tfHouseNumber.getText().trim();
	}

	public String getMq() {
		return tfMq.getText().trim();
	}

	public String getProvince() {
		return tfProvince.getText().trim();
	}

	public String getAddress() {
		return tfAddress.getText().trim();
	}

	public String getUniversity() {
		return tfUniversity.getText().trim();
	}

	public String getWC() {
		return tfWC.getText().trim();
	}

	public boolean getSpecialGuest() {
		if (cbSpecialGuest.isSelected()) {
			return true;
		}
		return false;
	}

	public boolean getParkingSpace() {
		if (cbParkingSpace.isSelected()) {
			return true;
		}
		return false;
	}

	public boolean getBestAppliances() {
		if (cbBestAppliances.isSelected()) {
			return true;
		}

		return false;
	}

	public boolean getExpenses() {
		if (cbExpenses.isSelected()) {
			return true;
		}
		return false;
	}

	public boolean getBus() {
		if (cbBus.isSelected()) {
			return true;
		}
		return false;
	}

	public boolean getWifi() {
		if (cbWifi.isSelected()) {
			return true;
		}
		return false;
	}

	public boolean getOtherStudents() {
		if (cbOtherStudents.isSelected()) {
			return true;
		}
		return false;
	}

	public boolean getAnimals() {
		if (cbAnimals.isSelected()) {
			return true;
		}
		return false;
	}

	public boolean getGarden() {
		if (cbGarden.isSelected()) {
			return true;
		}
		return false;
	}

	public int getNumSingleRoomWC() {
		if (rdRegApartment.isSelected() || rdRegHouse.isSelected()) {
			return Integer.valueOf(cbSingleRoomWC.getSelectedItem().toString());
		}
		return 0;
	}

	public double getSingleRoomWCPrice() {
		if (getNumSingleRoomWC() == 0) {
			return 0;
		}
		return Double.valueOf(tfSingleRoomWCPrice.getText().trim());
	}

	public int getNumSingleRoom() {
		if (rdRegApartment.isSelected() || rdRegHouse.isSelected()) {
			return Integer.valueOf(cbSingleRoom.getSelectedItem().toString());
		}
		return 0;
	}

	public double getSingleRoomPrice() {
		if (getNumSingleRoom() == 0) {
			return 0;
		}
		return Double.valueOf(tfSingleRoomPrice.getText().trim());
	}

	public int getNumDoubleRoom() {
		if (rdRegApartment.isSelected() || rdRegHouse.isSelected()) {
			return Integer.valueOf(cbDoubleRoom.getSelectedItem().toString());
		}
		return 0;
	}

	public double getDoubleRoomPrice() {
		if (getNumDoubleRoom() == 0) {
			return 0;
		}
		return Double.valueOf(tfDoubleRoomPrice.getText().trim());
	}

	public int getNumDoubleRoomWC() {
		if (rdRegApartment.isSelected() || rdRegHouse.isSelected()) {
			return Integer.valueOf(cbDoubleRoomWC.getSelectedItem().toString());
		}
		return 0;
	}

	public double getDoubleRoomWCPrice() {
		if (getNumDoubleRoomWC() == 0) {
			return 0;
		}
		return Double.valueOf(tfDoubleRoomWCPrice.getText().trim());
	}

	public double getSpecialGuestPrice() {
		if (cbSpecialGuest.isSelected()) {
			return Double.valueOf(tfOtherStudentPrice.getText().trim());
		}
		return 0;
	}

	public int getContractTerm1() {
		return Integer.valueOf(cbContractTerm1.getSelectedItem().toString());
	}

	public int getContractTerm2() {
		String a = cbContractTerm2.getSelectedItem().toString();
		if (a == StringsEnglish.STR_MONTH || a == StringsItalian.STR_MONTH) {
			return Constants.CONTRACT_TERM_MONTHS;
		} else if (a == StringsEnglish.STR_DAY || a == StringsItalian.STR_DAY) {
			return Constants.CONTRACT_TERM_DAYS;
		} else {
			return Constants.CONTRACT_TERM_YEARS;
		}
	}

	public int getPropertyType() {
		String a = cbRoomType.getSelectedItem().toString();
		if (a == StringsEnglish.STR_SR_WC || a == StringsItalian.STR_SR_WC) {
			return Constants.ROOM_TYPE_SINGLEWC;
		} else if (a == StringsEnglish.STR_SR_ || a == StringsItalian.STR_SR_) {
			return Constants.ROOM_TYPE_SINGLEWC;
		} else if (a == StringsEnglish.STR_DR_WC || a == StringsItalian.STR_DR_WC) {
			return Constants.ROOM_TYPE_DOUBLEWC;
		} else {
			return Constants.ROOM_TYPE_DOUBLE;
		}
	}

	public double getRoomFee() {
		if (rdRegRoom.isSelected()) {
			return Double.valueOf(tfRoomFee.getText().trim());
		}
		return 0;
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	// Listeners
	private class EscapeKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}

	}

	private class RadioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			enableDisableFields();
		}

	}

	private void enableDisableFields() {
		if (rdRegApartment.isSelected() || rdRegHouse.isSelected()) {
			lblSingleRoomWC.setEnabled(true);
			cbSingleRoomWC.setEnabled(true);
			lblSingleRoom.setEnabled(true);
			cbSingleRoom.setEnabled(true);

			lblDoubleRoomWC.setEnabled(true);
			cbDoubleRoomWC.setEnabled(true);

			lblDoubleRoom.setEnabled(true);
			cbDoubleRoom.setEnabled(true);

			lblPropertyType.setEnabled(false);
			cbRoomType.setEnabled(false);
			lblRoomFee.setEnabled(false);
			tfRoomFee.setEnabled(false);
		} else {
			lblSingleRoomWC.setEnabled(false);
			cbSingleRoomWC.setEnabled(false);
			lblSingleRoom.setEnabled(false);
			cbSingleRoom.setEnabled(false);
			lblSingleRoomWCPrice.setEnabled(false);
			tfSingleRoomWCPrice.setEnabled(false);
			lblSingleRoomPrice.setEnabled(false);
			tfSingleRoomPrice.setEnabled(false);
			lblDoubleRoomWC.setEnabled(false);
			cbDoubleRoomWC.setEnabled(false);
			lblDoubleRoomWCPrice.setEnabled(false);
			tfDoubleRoomWCPrice.setEnabled(false);
			lblDoubleRoom.setEnabled(false);
			cbDoubleRoom.setEnabled(false);
			lblDoubleRoomPrice.setEnabled(false);
			tfDoubleRoomPrice.setEnabled(false);

			lblPropertyType.setEnabled(true);
			cbRoomType.setEnabled(true);
			lblRoomFee.setEnabled(true);
			tfRoomFee.setEnabled(true);
		}
	}

	private class ButtonRegistrationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (rdRegApartment.isSelected()) {
				try {
					RegistrationApartment.registrationApartment(Session.getSessionInstance().getCustomer(),
							getNickname(), getMunicipality(), getProvince(), getAddress(), getHouseNumber(), getMq(),
							getUniversity(), getWC(), getSpecialGuest(), getParkingSpace(), getBestAppliances(),
							getExpenses(), getBus(), getOtherStudents(), getAnimals(), getGarden(), getWifi(),
							getNumSingleRoomWC(), getSingleRoomWCPrice(), getNumSingleRoom(), getSingleRoomPrice(),
							getNumDoubleRoomWC(), getDoubleRoomWCPrice(), getNumDoubleRoom(), getDoubleRoomPrice(),
							getSpecialGuestPrice(), getContractTerm2(), getContractTerm1());
					successfulRegistrationMessage();
					dialog.dispose();
				} catch (IOException e1) {
					fileReadErrorMessage(Filepaths.PROPERTIES_VALUE_DATABASE_FILENAME);
				} catch (EmptyFieldException e2) {
					emptyFieldMessage();
				} catch (ClassNotFoundException e3) {
					fileReadErrorMessage(Filepaths.PROPERTIES_VALUE_DATABASE_FILENAME);
				} catch (AlreadyRegisteredException e4) {
					alreadyRegisteredMessage();
				} catch (NoRoomException e5) {
					noRoomErrorMessage();
				} catch (FileException e1) {
					fileReadErrorMessage(Filepaths.PROPERTIES_VALUE_DATABASE_FILENAME);
				} catch (NumberFormatException e1) {
					numberFormatMessage();
				} catch (UserNotFoundException e1) {
					unexpectedErrorMessage();
				}
			} else if (rdRegHouse.isSelected()) {
				try {
					RegistrationHouse.registrationHouse(Session.getSessionInstance().getCustomer(), getNickname(),
							getMunicipality(), getProvince(), getAddress(), getHouseNumber(), getMq(), getUniversity(),
							getWC(), getSpecialGuest(), getParkingSpace(), getBestAppliances(), getExpenses(), getBus(),
							getOtherStudents(), getAnimals(), getGarden(), getWifi(), getNumSingleRoomWC(),
							getSingleRoomWCPrice(), getNumSingleRoom(), getSingleRoomPrice(), getNumDoubleRoomWC(),
							getDoubleRoomWCPrice(), getNumDoubleRoom(), getDoubleRoomPrice(), getSpecialGuestPrice(),
							getContractTerm2(), getContractTerm1());
					successfulRegistrationMessage();
					dialog.dispose();
				} catch (IOException e1) {
					fileReadErrorMessage(Filepaths.PROPERTIES_VALUE_DATABASE_FILENAME);
				} catch (EmptyFieldException e2) {
					emptyFieldMessage();
				} catch (ClassNotFoundException e3) {
					fileReadErrorMessage(Filepaths.PROPERTIES_VALUE_DATABASE_FILENAME);
				} catch (AlreadyRegisteredException e4) {
					alreadyRegisteredMessage();
				} catch (NoRoomException e5) {
					noRoomErrorMessage();
				} catch (FileException e1) {
					fileReadErrorMessage(Filepaths.PROPERTIES_VALUE_DATABASE_FILENAME);
				} catch (NumberFormatException e1) {
					numberFormatMessage();
				} catch (UserNotFoundException e1) {
					unexpectedErrorMessage();
				}
			} else {
				try {
					RegistrationRoom.registrationRoom(Session.getSessionInstance().getCustomer(), getNickname(),
							getMunicipality(), getProvince(), getAddress(), getHouseNumber(), getMq(), getUniversity(),
							getWC(), getSpecialGuest(), getParkingSpace(), getBestAppliances(), getExpenses(), getBus(),
							getOtherStudents(), getAnimals(), getGarden(), getWifi(), getSpecialGuestPrice(),
							getContractTerm2(), getContractTerm1(), getPropertyType(), getRoomFee());
					successfulRegistrationMessage();
					dialog.dispose();
				} catch (IOException e1) {
					fileReadErrorMessage(Filepaths.PROPERTIES_VALUE_DATABASE_FILENAME);
				} catch (EmptyFieldException e2) {
					emptyFieldMessage();
				} catch (ClassNotFoundException e3) {
					fileReadErrorMessage(Filepaths.PROPERTIES_VALUE_DATABASE_FILENAME);
				} catch (AlreadyRegisteredException e4) {
					alreadyRegisteredMessage();
				} catch (FileException e1) {
					fileReadErrorMessage(Filepaths.PROPERTIES_VALUE_DATABASE_FILENAME);
				} catch (NumberFormatException e1) {
					numberFormatMessage();
				} catch (UserNotFoundException e1) {
					unexpectedErrorMessage();
				}
			}
		}
	}

	private class ButtonCancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}

	}

	private class ItemListenerSingleRoomWC implements java.awt.event.ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				switch (cbSingleRoomWC.getSelectedItem().toString()) {
				case "0":
					lblSingleRoomWCPrice.setEnabled(false);
					tfSingleRoomWCPrice.setEnabled(false);
					break;
				default:
					lblSingleRoomWCPrice.setEnabled(true);
					tfSingleRoomWCPrice.setEnabled(true);
					break;
				}
			}
		}
	}

	private class ItemListenerSingleRoom implements java.awt.event.ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				switch (cbSingleRoom.getSelectedItem().toString()) {
				case "0":
					lblSingleRoomPrice.setEnabled(false);
					tfSingleRoomPrice.setEnabled(false);
					break;
				default:
					lblSingleRoomPrice.setEnabled(true);
					tfSingleRoomPrice.setEnabled(true);
					break;
				}
			}
		}
	}

	private class ItemListenerDoubleRoomWC implements java.awt.event.ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				switch (cbDoubleRoomWC.getSelectedItem().toString()) {
				case "0":
					lblDoubleRoomWCPrice.setEnabled(false);
					tfDoubleRoomWCPrice.setEnabled(false);
					break;
				default:
					lblDoubleRoomWCPrice.setEnabled(true);
					tfDoubleRoomWCPrice.setEnabled(true);
					break;
				}
			}
		}
	}

	private class ItemListenerDoubleRoom implements java.awt.event.ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				switch (cbDoubleRoom.getSelectedItem().toString()) {
				case "0":
					lblDoubleRoomPrice.setEnabled(false);
					tfDoubleRoomPrice.setEnabled(false);
					break;
				default:
					lblDoubleRoomPrice.setEnabled(true);
					tfDoubleRoomPrice.setEnabled(true);
					break;
				}
			}
		}
	}

	private class ItemListenerSpecialGuest implements java.awt.event.ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (cbSpecialGuest.isSelected()) {
				tfOtherStudentPrice.setEnabled(true);
				lblOtherStudentPrice.setEnabled(true);

			} else {
				tfOtherStudentPrice.setEnabled(false);
				lblOtherStudentPrice.setEnabled(false);
			}
		}
	}

	protected abstract void successfulRegistrationMessage();

	protected abstract void fileReadErrorMessage(String filename);

	protected abstract void emptyFieldMessage();

	protected abstract void alreadyRegisteredMessage();

	protected abstract void noRoomErrorMessage();

	protected abstract void numberFormatMessage();

	protected abstract void unexpectedErrorMessage();

}