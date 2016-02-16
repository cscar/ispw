package boundary.scout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import boundary.scout.properties.BoundaryPropertyDialog;
import entity.Constants;
import entity.properties.ApartmentStudents;
import entity.properties.HouseStudents;
import entity.properties.Property;
import entity.properties.RoomStudents;
import entity.strings.StringsItalian;

public class BoundaryPanelScoutItalian extends BoundaryPanelScout {
	private static final long serialVersionUID = 1L;

	private JPanel fieldsPanel;
	private JPanel btnEvaluatePanel;
	private JButton btnEvaluate;
	private JLabel lblPropertyType;
	private JTextField tfPropertyType;
	private JLabel lblUniversity;
	private JTextField tfUniversity;
	private JLabel lblMunicipality;
	private JTextField tfMunicipality;
	private JLabel lblMq;
	private JTextField tfMq;
	private JLabel lblMonthlyFee;
	private JTextField tfMonthlyFee;
	
	public BoundaryPanelScoutItalian(JDialog dialog) {
		super(dialog);
		dialog.setTitle(StringsItalian.STR_WELCOME_SCOUT);
	}

	protected void addProperty(Property property) {
		JPanel propertyPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.VERTICAL;

		// Add fields and buttons to property panel
		fieldsPanel = new JPanel(new GridBagLayout());
		fieldsPanel.setBorder(BorderFactory.createEtchedBorder());
		constraints.gridy = 0;
		propertyPanel.add(fieldsPanel, constraints);
		btnEvaluatePanel = new JPanel();
		constraints.gridy = 1;
		propertyPanel.add(btnEvaluatePanel, constraints);

		// Evaluate button
		btnEvaluate = new JButton(StringsItalian.STR_BTN_EVALUATE);
		btnEvaluate.addActionListener(new ButtonEvaluateListener(property));
		btnEvaluatePanel.add(btnEvaluate, constraints);

		// Fields
		constraints.anchor = GridBagConstraints.WEST;

		lblPropertyType = new JLabel(StringsItalian.STR_PROP);
		constraints.gridx = 0;
		constraints.gridy = 0;
		fieldsPanel.add(lblPropertyType, constraints);

		tfPropertyType = new JTextField();
		tfPropertyType.setEditable(false);

		constraints.gridx = 1;
		constraints.gridy = 0;
		fieldsPanel.add(tfPropertyType, constraints);

		lblUniversity = new JLabel(StringsItalian.STR_UNIV_FAC);
		constraints.gridx = 0;
		constraints.gridy = 1;
		fieldsPanel.add(lblUniversity, constraints);

		tfUniversity = new JTextField();
		tfUniversity.setEditable(false);
		tfUniversity.setText(property.getUniversity());
		constraints.gridx = 1;
		constraints.gridy = 1;
		fieldsPanel.add(tfUniversity, constraints);

		lblMunicipality = new JLabel(StringsItalian.STR_MUNIC);
		constraints.gridx = 0;
		constraints.gridy = 2;
		fieldsPanel.add(lblMunicipality, constraints);

		tfMunicipality = new JTextField();
		tfMunicipality.setEditable(false);
		tfMunicipality.setText(property.getMunicipality());
		constraints.gridx = 1;
		constraints.gridy = 2;
		fieldsPanel.add(tfMunicipality, constraints);

		lblMq = new JLabel(StringsItalian.STR_MQ);
		constraints.gridx = 0;
		constraints.gridy = 3;
		fieldsPanel.add(lblMq, constraints);

		tfMq = new JTextField();
		tfMq.setEditable(false);
		tfMq.setText(property.getMq());
		constraints.gridx = 1;
		constraints.gridy = 3;
		fieldsPanel.add(tfMq, constraints);

		lblMonthlyFee = new JLabel(StringsItalian.STR_MAX);
		constraints.gridx = 0;
		constraints.gridy = 4;
		fieldsPanel.add(lblMonthlyFee, constraints);

		tfMonthlyFee = new JTextField();
		tfMonthlyFee.setEditable(false);
		constraints.gridx = 1;
		constraints.gridy = 4;
		fieldsPanel.add(tfMonthlyFee, constraints);

		// Get Property Type
		switch (property.getPropertyType()) {
		case Constants.ROOM_STUDENTS:
			tfPropertyType.setText(StringsItalian.STR_STUD_ROOM);
			tfMonthlyFee.setText(String.valueOf(((RoomStudents) property).getRoomPrice()));
			break;
		case Constants.HOUSE_STUDENTS:
			tfPropertyType.setText(StringsItalian.STR_STUD_H);
			HouseStudents houseStudents = (HouseStudents) property;
			double singleRoomPrice = houseStudents.getRoomSinglePrice();
			double singleRoomWCPrice = houseStudents.getRoomSingleWCPrice();
			double doubleRoomPrice = houseStudents.getRoomDoublePrice();
			double doubleRoomWCPrice = houseStudents.getRoomDoubleWCPrice();
			double maxFee = Double.max(singleRoomPrice, singleRoomWCPrice);
			maxFee = Double.max(maxFee, doubleRoomPrice);
			maxFee = Double.max(maxFee, doubleRoomWCPrice);
			tfMonthlyFee.setText(String.valueOf(maxFee));
			break;
		case Constants.APARTMENT_STUDENTS:
			tfPropertyType.setText(StringsItalian.STR_STUD_H);
			ApartmentStudents apartmentStudents = (ApartmentStudents) property;
			singleRoomPrice = apartmentStudents.getRoomSinglePrice();
			singleRoomWCPrice = apartmentStudents.getRoomSingleWCPrice();
			doubleRoomPrice = apartmentStudents.getRoomDoublePrice();
			doubleRoomWCPrice = apartmentStudents.getRoomDoubleWCPrice();
			maxFee = Double.max(singleRoomPrice, singleRoomWCPrice);
			maxFee = Double.max(maxFee, doubleRoomPrice);
			maxFee = Double.max(maxFee, doubleRoomWCPrice);
			tfMonthlyFee.setText(String.valueOf(maxFee));
			break;
		}

		this.add(propertyPanel);
	}

	@Override
	protected void fileReadErrorMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_FILE_READ_ERROR, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	private class ButtonEvaluateListener implements ActionListener {

		Property property;

		public ButtonEvaluateListener(Property property) {
			this.property = property;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			BoundaryPropertyDialog propertyDialog = new BoundaryPropertyDialog(BoundaryPanelScoutItalian.this.dialog,
					property);
			propertyDialog.setVisible(true);
			if (propertyDialog.isAccepted() || propertyDialog.isRefused()) {
				// If property has been accepted or refused, reopen dialog
				dialog.dispose();
				reloadDialog = true;
			}
		}
	}
}
