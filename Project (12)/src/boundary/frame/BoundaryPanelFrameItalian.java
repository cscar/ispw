package boundary.frame;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.Factory;
import entity.properties.Property;
import entity.strings.StringsItalian;

public class BoundaryPanelFrameItalian extends BoundaryPanelFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;

	public BoundaryPanelFrameItalian(JFrame frame) {
		super(frame);
		this.frame = frame;

		// Title and Buttons Text
		lblTitle.setText(StringsItalian.TITLE_TEXT);
		btnAlreadyRegistered.setText(StringsItalian.BUTTON_ALREADY_REGISTERED);
		btnRegistration.setText(StringsItalian.BUTTON_REGISTRATION_TEXT);
		btnLogin.setText(StringsItalian.BUTTON_LOGIN_TEXT);
		lblMunicipality.setText(StringsItalian.STR_MUN);
		lblUniversity.setText(StringsItalian.STR_UNIV);
		lblPropertyType.setText(StringsItalian.STR_PROP);
		lblSingleRoom.setText(StringsItalian.STR_SR);
		lblDoubleRoom.setText(StringsItalian.STR_SD);
		lblParkingSpace.setText(StringsItalian.STR_CAR);
		lblBestAppliances.setText(StringsItalian.STR_WM);
		lblWifi.setText(StringsItalian.STR_WIFI);
		lblMaxMonthlyFee.setText(StringsItalian.STR_MAX);
		btnSearch.setText(StringsItalian.STR_SEARCHB);
		titledBorder.setTitle(StringsItalian.STR_SEARCH);

		// Removing old data
		model.removeAllElements();

		model.addElement(StringsItalian.STR_STUD_ROOM);
		model.addElement(StringsItalian.STR_STUD_H);
		model.addElement(StringsItalian.STR_STUD_AP);

		// Setting model with new data
		cbPropertyType.setModel(model);
	}

	@Override
	protected void fileReadErrorMessage() {
		JOptionPane.showMessageDialog(frame, StringsItalian.STR_FILE_READ_ERROR, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected JPanel createPanelResults(ArrayList<Property> properties) {
		return Factory.getFactoryInstance().createPanelLanguage(0).createPanelSearch(frame, properties);
	}

	@Override
	protected int confirmRegLandLordMessage() {
		return JOptionPane.showConfirmDialog(frame, StringsItalian.STR_CONFIRM_REG_LANDLORD, StringsItalian.STR_SIGNUP,
				JOptionPane.YES_NO_OPTION);
	}

	@Override
	protected int confirmRegTenantMessage() {
		return JOptionPane.showConfirmDialog(frame, StringsItalian.STR_CONFIRM_REG_TENANT, StringsItalian.STR_SIGNUP,
				JOptionPane.YES_NO_OPTION);
	}

	@Override
	protected void successfulRegistrationMessage() {
		JOptionPane.showMessageDialog(frame, StringsItalian.STR_LAND_TEN, StringsItalian.STR_SIGNUP,
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	protected void alreadyRegisteredMessage() {
		JOptionPane.showMessageDialog(frame, StringsItalian.STR_EMAIL_ALREADY_REGISTERED, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void errorMessage() {
		JOptionPane.showMessageDialog(frame, StringsItalian.STR_ERROR_REGISTRATION, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void userNotFoundMessage() {
		JOptionPane.showMessageDialog(frame, StringsItalian.STR_USER_NOT_FOUND, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);		
	}

	@Override
	protected void emptyFieldMessage() {
		JOptionPane.showMessageDialog(frame, StringsItalian.STR_EMPTY_FIELD, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}

	@Override
	protected void numberFormatMessage() {
		JOptionPane.showMessageDialog(frame, StringsItalian.STR_NOT_VALID_FIELD, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}

	@Override
	protected void noRoomSelected() {
		JOptionPane.showMessageDialog(frame, StringsItalian.STR_NOT_SELECTED_ROOMS, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}

}
