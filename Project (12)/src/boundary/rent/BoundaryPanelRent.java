package boundary.rent;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import entity.Session;
import entity.Tenant;
import entity.properties.ApartmentStudents;
import entity.properties.HouseStudents;
import entity.properties.Property;
import entity.properties.RoomStudents;
import exception.AlreadyRegisteredException;
import exception.FileException;
import exception.RoomsNotAvailableException;
import exception.UserNotFoundException;

public abstract class BoundaryPanelRent extends JPanel {

	private static final long serialVersionUID = 1L;
	private Property property;
	private JPanel fieldsPanel;
	private JDialog dialog;
	protected JLabel lblSingleRoomWC;
	protected JComboBox<String> cbSingleRoomWC;
	protected JLabel lblSingleRoom;
	protected JComboBox<String> cbSingleRoom;
	protected JLabel lblDoubleRoomWC;
	protected JComboBox<String> cbDoubleRoomWC;
	protected JLabel lblDoubleRoom;
	protected JComboBox<String> cbDoubleRoom;
	protected JLabel lblRoomType;
	protected JTextField tfRoomType;
	protected DefaultComboBoxModel<String> model;
	protected JButton btnRent;
	protected JButton btnCancel;

	public BoundaryPanelRent(JDialog dialog, Property property) {
		super(new BorderLayout());
		this.dialog = dialog;
		this.property = property;

		// Fields
		fieldsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;

		lblSingleRoomWC = new JLabel();
		cs.gridx = 0;
		cs.gridwidth = 1;
		cs.gridy = 17;
		fieldsPanel.add(lblSingleRoomWC, cs);

		cbSingleRoomWC = new JComboBox<String>();
		cs.gridx = 1;
		cs.gridy = 17;
		// cbSingleRoomWC.addItemListener(new ItemListenerSingleRoomWC());
		cs.gridwidth = 2;
		fieldsPanel.add(cbSingleRoomWC, cs);

		lblSingleRoom = new JLabel();
		cs.gridx = 0;
		cs.gridy = 19;
		cs.gridwidth = 1;
		fieldsPanel.add(lblSingleRoom, cs);

		cbSingleRoom = new JComboBox<String>();
		cs.gridx = 1;
		cs.gridy = 19;
		// cbSingleRoom.addItemListener(new ItemListenerSingleRoom());
		cs.gridwidth = 2;
		fieldsPanel.add(cbSingleRoom, cs);

		lblDoubleRoomWC = new JLabel();
		cs.gridx = 0;
		cs.gridy = 21;
		cs.gridwidth = 1;
		fieldsPanel.add(lblDoubleRoomWC, cs);

		cbDoubleRoomWC = new JComboBox<String>();
		cs.gridx = 1;
		cs.gridy = 21;
		// cbDoubleRoomWC.addItemListener(new ItemListenerDoubleRoomWC());
		cs.gridwidth = 2;
		fieldsPanel.add(cbDoubleRoomWC, cs);

		lblDoubleRoom = new JLabel();
		cs.gridx = 0;
		cs.gridy = 23;
		cs.gridwidth = 1;
		fieldsPanel.add(lblDoubleRoom, cs);

		cbDoubleRoom = new JComboBox<String>();
		cs.gridx = 1;
		cs.gridy = 23;
		cs.gridwidth = 2;
		// cbDoubleRoom.addItemListener(new ItemListenerDoubleRoom());
		fieldsPanel.add(cbDoubleRoom, cs);

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

		if (property instanceof RoomStudents) {
			lblDoubleRoom.setVisible(false);
			lblDoubleRoomWC.setVisible(false);
			lblSingleRoom.setVisible(false);
			lblSingleRoomWC.setVisible(false);
			cbDoubleRoom.setVisible(false);
			cbDoubleRoomWC.setVisible(false);
			cbSingleRoom.setVisible(false);
			cbSingleRoomWC.setVisible(false);
		}

		if (property instanceof ApartmentStudents) {
			ApartmentStudents apartment = (ApartmentStudents) property;

			for (int i = 0; i <= apartment.getNumRoomSingleAvailability(); i++) {
				cbSingleRoom.addItem(String.valueOf(i));
			}

			for (int i = 0; i <= apartment.getNumRoomDoubleAvailability(); i++) {
				cbDoubleRoom.addItem(String.valueOf(i));
			}

			for (int i = 0; i <= apartment.getNumRoomSingleWCAvailability(); i++) {
				cbSingleRoomWC.addItem(String.valueOf(i));
			}

			for (int i = 0; i <= apartment.getNumRoomDoubleWCAvailability(); i++) {
				cbDoubleRoomWC.addItem(String.valueOf(i));
			}

			lblRoomType.setVisible(false);
			tfRoomType.setVisible(false);
		}

		if (property instanceof HouseStudents) {
			HouseStudents house = (HouseStudents) property;

			for (int i = 0; i <= house.getNumRoomSingleAvailability(); i++) {
				cbSingleRoom.addItem(String.valueOf(i));
			}

			for (int i = 0; i <= house.getNumRoomDoubleAvailability(); i++) {
				cbDoubleRoom.addItem(String.valueOf(i));
			}

			for (int i = 0; i <= house.getNumRoomSingleWCAvailability(); i++) {
				cbSingleRoomWC.addItem(String.valueOf(i));
			}

			for (int i = 0; i <= house.getNumRoomDoubleWCAvailability(); i++) {
				cbDoubleRoomWC.addItem(String.valueOf(i));
			}

			lblRoomType.setVisible(false);
			tfRoomType.setVisible(false);
		}

		// Buttons
		btnRent = new JButton();
		btnRent.addActionListener(new ButtonRentListener());

		btnCancel = new JButton();
		btnCancel.addActionListener(new ButtonCancelListener());

		// Panel Buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btnRent);
		buttonsPanel.add(btnCancel);

		this.add(fieldsPanel, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.PAGE_END);

		// Escape key listener
		EscapeKeyListener escListener = new EscapeKeyListener();
		dialog.getRootPane().registerKeyboardAction(escListener, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				JComponent.WHEN_IN_FOCUSED_WINDOW);

		// Enter key listener
		this.dialog.getRootPane().setDefaultButton(btnRent);
	}

	// Listeners
	private class EscapeKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
	}

	private class ButtonRentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!(Session.getSessionInstance().getCustomer() instanceof Tenant)) {
				notLoggedErrorMessage();
			} else {
				if (property instanceof ApartmentStudents) {
					ApartmentStudents apartment = (ApartmentStudents) property;

					int numOfSingleRoom = cbSingleRoom.getSelectedIndex();
					int numOfSingleRoomWC = cbSingleRoomWC.getSelectedIndex();
					int numOfDoubleRoom = cbDoubleRoom.getSelectedIndex();
					int numOfDoubleRoomWC = cbDoubleRoomWC.getSelectedIndex();

					try {
						apartment.rentRooms(numOfSingleRoom, numOfDoubleRoom, numOfSingleRoomWC, numOfDoubleRoomWC);
					} catch (ClassNotFoundException | RoomsNotAvailableException | IOException
							| AlreadyRegisteredException | UserNotFoundException | FileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (property instanceof HouseStudents) {
					HouseStudents house = (HouseStudents) property;

					int numOfSingleRoom = cbSingleRoom.getSelectedIndex();
					int numOfSingleRoomWC = cbSingleRoomWC.getSelectedIndex();
					int numOfDoubleRoom = cbDoubleRoom.getSelectedIndex();
					int numOfDoubleRoomWC = cbDoubleRoomWC.getSelectedIndex();

					try {
						house.rentRooms(numOfSingleRoom, numOfDoubleRoom, numOfSingleRoomWC, numOfDoubleRoomWC);
					} catch (ClassNotFoundException | RoomsNotAvailableException | IOException
							| AlreadyRegisteredException | UserNotFoundException | FileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (property instanceof RoomStudents) {
					RoomStudents room = (RoomStudents) property;

					try {
						room.rent();
					} catch (ClassNotFoundException | IOException | AlreadyRegisteredException | UserNotFoundException
							| FileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				successfulRentMessage();
			}
			((JDialog) dialog.getParent()).dispose();
		}
	}

	private class ButtonCancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}

	}
	
	protected abstract void notLoggedErrorMessage();

	protected abstract void successfulRentMessage();
}
