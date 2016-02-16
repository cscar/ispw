package boundary.scout.properties;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import entity.persistence.SaveProperties;
import entity.persistence.SavePropertiesValued;
import entity.properties.ApartmentStudents;
import entity.properties.HouseStudents;
import entity.properties.Property;
import entity.properties.RoomStudents;
import exception.AlreadyRegisteredException;
import exception.FileException;
import exception.UserNotFoundException;

public abstract class BoundaryPanelProperty extends JPanel {
	private static final long serialVersionUID = 1L;

	protected JFormattedTextField tfHouseNumber;
	protected JLabel lblHouseNumber;
	protected JButton btnAccept;
	protected JButton btnCancel;
	private JPanel panelButtons;

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
	protected JTextField tfSingleRoomWC;
	protected JLabel lblSingleRoomWCPrice;
	protected JFormattedTextField tfSingleRoomWCPrice;

	protected JLabel lblSingleRoom;
	protected JTextField tfSingleRoom;
	protected JLabel lblSingleRoomPrice;
	protected JFormattedTextField tfSingleRoomPrice;

	protected JLabel lblDoubleRoomWC;
	protected JTextField tfDoubleRoomWC;
	protected JLabel lblDoubleRoomWCPrice;
	protected JFormattedTextField tfDoubleRoomWCPrice;

	protected JLabel lblDoubleRoom;
	protected JTextField tfDoubleRoom;
	protected JLabel lblDoubleRoomPrice;
	protected JFormattedTextField tfDoubleRoomPrice;

	protected JLabel lblRoomType;
	protected DefaultComboBoxModel<String> model;
	protected JLabel lblRoomFee;
	protected JFormattedTextField tfRoomFee;

	protected JLabel lblNickname;
	protected JTextField tfNickname;

	protected JLabel lblWifi;
	protected JCheckBox cbWifi;

	protected JLabel lblContract;
	protected DefaultComboBoxModel<String> modelDd;

	protected JDialog dialog;
	protected Property property;
	protected JButton btnRefuse;
	private JPanel panelPropertyType;
	protected JTextField tfRoomType;
	private JTextField tfContractTerm1;
	protected JTextField tfContractTerm2;

	private boolean accepted = false;
	private boolean refused = false; 

	public BoundaryPanelProperty(JDialog dialog, Property property) {
		super(new BorderLayout());
		this.dialog = dialog;
		this.property = property;

		panelPropertyType = new JPanel();
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;

		rdRegRoom = new JRadioButton();
		cs.gridx = 0;
		cs.gridy = 2;
		rdRegRoom.setEnabled(false);
		panelPropertyType.add(rdRegRoom, cs);

		rdRegHouse = new JRadioButton();
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		rdRegHouse.setEnabled(false);
		panelPropertyType.add(rdRegHouse, cs);

		rdRegApartment = new JRadioButton();
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		rdRegApartment.setEnabled(false);
		panelPropertyType.add(rdRegApartment, cs);

		bgRegistrationProperties = new ButtonGroup();
		bgRegistrationProperties.add(rdRegApartment);
		bgRegistrationProperties.add(rdRegHouse);
		bgRegistrationProperties.add(rdRegRoom);

		// Fields Panel
		JPanel fieldsPanel = new JPanel(new GridBagLayout());

		lblNickname = new JLabel();
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		fieldsPanel.add(lblNickname, cs);

		tfNickname = new JTextField();
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		tfNickname.setEditable(false);
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
		tfMunicipality.setEditable(false);
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
		tfProvince.setEditable(false);
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
		tfAddress.setEditable(false);
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
		tfHouseNumber.setEditable(false);
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
		tfMq.setEditable(false);
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
		tfUniversity.setEditable(false);
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
		tfWC.setEditable(false);
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
		cbWifi.setEnabled(false);
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
		cbSpecialGuest.setEnabled(false);
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
		cbBus.setEnabled(false);
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
		cbBestAppliances.setEnabled(false);
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
		cbExpenses.setEnabled(false);
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
		cbOtherStudents.setEnabled(false);
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
		cbAnimals.setEnabled(false);
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
		cbParkingSpace.setEnabled(false);
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
		cbGarden.setEnabled(false);
		fieldsPanel.add(cbGarden, cs);

		lblSingleRoomWC = new JLabel();
		cs.gridx = 0;
		cs.gridwidth = 1;
		cs.gridy = 17;
		fieldsPanel.add(lblSingleRoomWC, cs);

		tfSingleRoomWC = new JTextField();
		cs.gridx = 1;
		cs.gridy = 17;
		cs.gridwidth = 2;
		tfSingleRoomWC.setEditable(false);
		fieldsPanel.add(tfSingleRoomWC, cs);

		lblSingleRoomWCPrice = new JLabel();
		cs.gridx = 0;
		cs.gridwidth = 1;
		cs.gridy = 18;
		fieldsPanel.add(lblSingleRoomWCPrice, cs);

		tfSingleRoomWCPrice = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 18;
		cs.gridwidth = 2;
		tfSingleRoomWCPrice.setEditable(false);
		fieldsPanel.add(tfSingleRoomWCPrice, cs);

		lblSingleRoom = new JLabel();
		cs.gridx = 0;
		cs.gridy = 19;
		cs.gridwidth = 1;
		fieldsPanel.add(lblSingleRoom, cs);

		tfSingleRoom = new JTextField();
		cs.gridx = 1;
		cs.gridy = 19;
		cs.gridwidth = 2;
		tfSingleRoom.setEditable(false);
		fieldsPanel.add(tfSingleRoom, cs);

		lblSingleRoomPrice = new JLabel();
		cs.gridx = 0;
		cs.gridy = 20;
		cs.gridwidth = 1;
		fieldsPanel.add(lblSingleRoomPrice, cs);

		tfSingleRoomPrice = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 20;
		cs.gridwidth = 2;
		tfSingleRoomPrice.setEditable(false);
		fieldsPanel.add(tfSingleRoomPrice, cs);

		lblDoubleRoomWC = new JLabel();
		cs.gridx = 0;
		cs.gridy = 21;
		cs.gridwidth = 1;
		fieldsPanel.add(lblDoubleRoomWC, cs);

		tfDoubleRoomWC = new JTextField();
		cs.gridx = 1;
		cs.gridy = 21;
		cs.gridwidth = 2;
		tfDoubleRoomWC.setEditable(false);
		fieldsPanel.add(tfDoubleRoomWC, cs);

		lblDoubleRoomWCPrice = new JLabel();
		cs.gridx = 0;
		cs.gridy = 22;
		cs.gridwidth = 1;
		fieldsPanel.add(lblDoubleRoomWCPrice, cs);

		tfDoubleRoomWCPrice = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 22;
		cs.gridwidth = 2;
		tfDoubleRoomWCPrice.setEditable(false);
		fieldsPanel.add(tfDoubleRoomWCPrice, cs);

		lblDoubleRoom = new JLabel();
		cs.gridx = 0;
		cs.gridy = 23;
		cs.gridwidth = 1;
		fieldsPanel.add(lblDoubleRoom, cs);

		tfDoubleRoom = new JTextField();
		cs.gridx = 1;
		cs.gridy = 23;
		cs.gridwidth = 2;
		tfDoubleRoom.setEditable(false);
		fieldsPanel.add(tfDoubleRoom, cs);

		lblDoubleRoomPrice = new JLabel();
		cs.gridx = 0;
		cs.gridy = 24;
		cs.gridwidth = 1;
		fieldsPanel.add(lblDoubleRoomPrice, cs);

		tfDoubleRoomPrice = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 24;
		cs.gridwidth = 2;
		tfDoubleRoomPrice.setEditable(false);
		fieldsPanel.add(tfDoubleRoomPrice, cs);

		lblOtherStudentPrice = new JLabel();
		cs.gridx = 0;
		cs.gridy = 25;
		cs.gridwidth = 1;
		fieldsPanel.add(lblOtherStudentPrice, cs);

		tfOtherStudentPrice = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 25;
		cs.gridwidth = 2;
		tfOtherStudentPrice.setEditable(false);
		fieldsPanel.add(tfOtherStudentPrice, cs);

		lblRoomType = new JLabel();
		cs.gridx = 0;
		cs.gridy = 26;
		cs.gridwidth = 1;
		fieldsPanel.add(lblRoomType, cs);

		tfRoomType = new JTextField();
		cs.gridx = 1;
		cs.gridy = 26;
		cs.gridwidth = 2;
		tfRoomType.setEditable(false);
		fieldsPanel.add(tfRoomType, cs);

		lblRoomFee = new JLabel();
		cs.gridx = 0;
		cs.gridy = 27;
		cs.gridwidth = 1;
		fieldsPanel.add(lblRoomFee, cs);

		tfRoomFee = new JFormattedTextField();
		cs.gridx = 1;
		cs.gridy = 27;
		cs.gridwidth = 2;
		tfRoomFee.setEditable(false);
		fieldsPanel.add(tfRoomFee, cs);

		lblContract = new JLabel();
		cs.gridx = 0;
		cs.gridy = 28;
		cs.gridwidth = 1;
		fieldsPanel.add(lblContract, cs);

		tfContractTerm1 = new JTextField();
		cs.gridx = 1;
		cs.gridy = 28;
		cs.gridwidth = 1;
		tfContractTerm1.setEditable(false);
		fieldsPanel.add(tfContractTerm1, cs);

		tfContractTerm2 = new JTextField();
		cs.gridx = 2;
		cs.gridy = 28;
		cs.gridwidth = 1;
		tfContractTerm2.setEditable(false);
		fieldsPanel.add(tfContractTerm2, cs);

		tfAddress.setText(property.getAddress());
		tfHouseNumber.setText(property.getHouseNum());
		tfMq.setText(property.getMq());
		tfMunicipality.setText(property.getMunicipality());
		tfNickname.setText(property.getNickName());

		tfOtherStudentPrice.setText(String.valueOf(property.getSpecialGuestPrice()));
		tfProvince.setText(property.getProvince());
		tfUniversity.setText(property.getUniversity());
		tfWC.setText(property.getNumWC());

		cbAnimals.setSelected(property.getAnimals());
		cbBus.setSelected(property.getBus());
		cbParkingSpace.setSelected(property.getParkingSpace());
		cbGarden.setSelected(property.getGarden());
		tfContractTerm1.setText(String.valueOf(property.getContractTerm1()));
		cbExpenses.setSelected(property.getExpenses());
		cbSpecialGuest.setSelected(property.getSpecialguest());
		cbOtherStudents.setSelected(property.getOtherStudents());
		cbWifi.setSelected(property.getWifi());
		cbBestAppliances.setSelected(property.getBestAppliances());

		if (!cbSpecialGuest.isSelected()) {
			//Hide special guest price field
			lblOtherStudentPrice.setVisible(false);
			tfOtherStudentPrice.setVisible(false);
		}
		
		if (property instanceof ApartmentStudents) {
			ApartmentStudents apartmentStudents = (ApartmentStudents) property;

			rdRegApartment.setSelected(true);

			if (apartmentStudents.getNumRoomDoubleAvailability() <= 0) {
				lblDoubleRoomPrice.setVisible(false);
				tfDoubleRoomPrice.setVisible(false);
			} else {
				tfDoubleRoomPrice.setText(String.valueOf(apartmentStudents.getRoomDoublePrice()));
			}

			if (apartmentStudents.getNumRoomDoubleWCAvailability() <= 0) {
				lblDoubleRoomWCPrice.setVisible(false);
				tfDoubleRoomWCPrice.setVisible(false);
			} else {
				tfDoubleRoomWCPrice.setText(String.valueOf(apartmentStudents.getRoomDoubleWCPrice()));
			}

			if (apartmentStudents.getNumRoomSingleAvailability() <= 0) {
				lblSingleRoomPrice.setVisible(false);
				tfSingleRoomPrice.setVisible(false);
			} else {
				tfSingleRoomPrice.setText(String.valueOf(apartmentStudents.getRoomSinglePrice()));
			}

			if (apartmentStudents.getNumRoomSingleWCAvailability() <= 0) {
				lblSingleRoomWCPrice.setVisible(false);
				tfSingleRoomWCPrice.setVisible(false);
			} else {
				tfSingleRoomWCPrice.setText(String.valueOf(apartmentStudents.getRoomSingleWCPrice()));
			}

			tfDoubleRoom.setText(String.valueOf(apartmentStudents.getNumRoomDoubleAvailability()));
			tfDoubleRoomWC.setText(String.valueOf(apartmentStudents.getNumRoomDoubleWCAvailability()));
			tfSingleRoom.setText(String.valueOf(apartmentStudents.getNumRoomSingleAvailability()));
			tfSingleRoomWC.setText(String.valueOf(apartmentStudents.getNumRoomSingleWCAvailability()));

			// Hide unused fields
			lblRoomType.setVisible(false);
			tfRoomType.setVisible(false);

			lblRoomFee.setVisible(false);
			tfRoomFee.setVisible(false);
		}

		if (property instanceof HouseStudents) {
			HouseStudents homeStudents = (HouseStudents) property;

			rdRegHouse.setSelected(true);

			if (homeStudents.getNumRoomDoubleAvailability() <= 0) {
				lblDoubleRoomPrice.setVisible(false);
				tfDoubleRoomPrice.setVisible(false);
			} else {
				tfDoubleRoomPrice.setText(String.valueOf(homeStudents.getRoomDoublePrice()));
			}

			if (homeStudents.getNumRoomDoubleWCAvailability() <= 0) {
				lblDoubleRoomWCPrice.setVisible(false);
				tfDoubleRoomWCPrice.setVisible(false);
			} else {
				tfDoubleRoomWCPrice.setText(String.valueOf(homeStudents.getRoomDoubleWCPrice()));
			}

			if (homeStudents.getNumRoomSingleAvailability() <= 0) {
				lblSingleRoomPrice.setVisible(false);
				tfSingleRoomPrice.setVisible(false);
			} else {
				tfSingleRoomPrice.setText(String.valueOf(homeStudents.getRoomSinglePrice()));
			}

			if (homeStudents.getNumRoomSingleWCAvailability() <= 0) {
				lblSingleRoomWCPrice.setVisible(false);
				tfSingleRoomWCPrice.setVisible(false);
			} else {
				tfSingleRoomWCPrice.setText(String.valueOf(homeStudents.getRoomSingleWCPrice()));
			}
			
			tfDoubleRoom.setText(String.valueOf(homeStudents.getNumRoomDoubleAvailability()));
			tfDoubleRoomWC.setText(String.valueOf(homeStudents.getNumRoomDoubleWCAvailability()));
			tfSingleRoom.setText(String.valueOf(homeStudents.getNumRoomSingleAvailability()));
			tfSingleRoomWC.setText(String.valueOf(homeStudents.getNumRoomSingleWCAvailability()));

			// Hide unused fields
			lblRoomType.setVisible(false);
			tfRoomType.setVisible(false);

			lblRoomFee.setVisible(false);
			tfRoomFee.setVisible(false);
		}

		if (property instanceof RoomStudents) {
			RoomStudents roomStudents = (RoomStudents) property;

			rdRegRoom.setSelected(true);
			tfRoomFee.setText(String.valueOf(roomStudents.getRoomPrice()));

			// Hide unused fields
			lblSingleRoom.setVisible(false);
			tfSingleRoom.setVisible(false);

			lblDoubleRoom.setVisible(false);
			tfDoubleRoom.setVisible(false);

			lblSingleRoomWC.setVisible(false);
			tfSingleRoomWC.setVisible(false);

			lblDoubleRoomWC.setVisible(false);
			tfDoubleRoomWC.setVisible(false);

			lblSingleRoomPrice.setVisible(false);
			tfSingleRoomPrice.setVisible(false);

			lblDoubleRoomPrice.setVisible(false);
			tfDoubleRoomPrice.setVisible(false);

			lblSingleRoomWCPrice.setVisible(false);
			tfSingleRoomWCPrice.setVisible(false);

			lblDoubleRoomWCPrice.setVisible(false);
			tfDoubleRoomWCPrice.setVisible(false);
		}

		// Buttons
		btnAccept = new JButton();
		btnAccept.addActionListener(new ButtonAcceptListener());

		btnRefuse = new JButton();
		btnRefuse.addActionListener(new ButtonRefuseListener());

		btnCancel = new JButton();
		btnCancel.addActionListener(new ButtonCancelListener());

		// Buttons Panel
		panelButtons = new JPanel();
		panelButtons.add(btnAccept);
		panelButtons.add(btnRefuse);
		panelButtons.add(btnCancel);

		this.add(panelButtons, BorderLayout.PAGE_END);
		this.add(panelPropertyType, BorderLayout.NORTH);
		this.add(fieldsPanel);

		// ENTER key listener
		dialog.getRootPane().setDefaultButton(btnAccept);

		// ESC key listener
		dialog.getRootPane().registerKeyboardAction(new EscapeKeyListener(),
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
	}

	// Listeners
	private class EscapeKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}

	}

	private class ButtonAcceptListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// Save to valued properties file
				SavePropertiesValued.getInstance().insertProperties(property);
				// Delete from not valued properties file
				SaveProperties.getInstance().deleteProperty(property.getMunicipality(), property.getProvince(),
						property.getAddress(), property.getHouseNum());
				successfulAcceptMessage();
				accepted = true;
				dialog.dispose();
			} catch (ClassNotFoundException | IOException e1) {
				fileWriteErrorMessage();
				accepted = false;
			} catch (AlreadyRegisteredException e1) {
				alreadyRegisteredMessage();
				accepted = false;
			} catch (FileException e1) {
				fileWriteErrorMessage();
				accepted = false;
			} catch (UserNotFoundException e1) {
				userNotFoundMessage();
				accepted = false;
			}
		}
	}

	private class ButtonRefuseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// Delete from valued properties file
				SaveProperties.getInstance().deleteProperty(property.getMunicipality(), property.getProvince(),
						property.getAddress(), property.getHouseNum());
				successfulRefuseMessage();
				refused = true;
				dialog.dispose();
			} catch (ClassNotFoundException | IOException e1) {
				fileWriteErrorMessage();
				refused = false;
			} catch (FileException e1) {
				fileWriteErrorMessage();
				refused = false;
			} catch (UserNotFoundException e1) {
				userNotFoundMessage();
				refused = false;
			}
		}
	}

	private class ButtonCancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dialog.dispose();
		}
	}
	
	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isRefused() {
		return refused;
	}

	public void setRefused(boolean refused) {
		this.refused = refused;
	}

	protected abstract void successfulAcceptMessage();
	
	protected abstract void successfulRefuseMessage();

	protected abstract void fileWriteErrorMessage();

	protected abstract void alreadyRegisteredMessage();

	public abstract void userNotFoundMessage();
}
