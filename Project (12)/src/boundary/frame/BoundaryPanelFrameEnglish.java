package boundary.frame;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.Factory;
import entity.properties.Property;
import entity.strings.StringsEnglish;

public class BoundaryPanelFrameEnglish extends BoundaryPanelFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;

	public BoundaryPanelFrameEnglish(JFrame frame) {
		super(frame);
		this.frame = frame;

		// Title and Buttons Text
		lblTitle.setText(StringsEnglish.TITLE_TEXT);
		btnAlreadyRegistered.setText(StringsEnglish.BUTTON_ALREADY_REGISTERED);
		btnRegistration.setText(StringsEnglish.BUTTON_REGISTRATION_TEXT);
		btnLogin.setText(StringsEnglish.BUTTON_LOGIN_TEXT);
		lblMunicipality.setText(StringsEnglish.STR_MUN);
		lblUniversity.setText(StringsEnglish.STR_UNIV);
		lblPropertyType.setText(StringsEnglish.STR_PROP);
		lblSingleRoom.setText(StringsEnglish.STR_SR);
		lblDoubleRoom.setText(StringsEnglish.STR_SD);
		lblParkingSpace.setText(StringsEnglish.STR_CAR);
		lblBestAppliances.setText(StringsEnglish.STR_WM);
		lblWifi.setText(StringsEnglish.STR_WIFI);
		lblMaxMonthlyFee.setText(StringsEnglish.STR_MAX);
		btnSearch.setText(StringsEnglish.STR_SEARCHB);
		titledBorder.setTitle(StringsEnglish.STR_SEARCH);

		// Removing old data
		model.removeAllElements();

		model.addElement(StringsEnglish.STR_STUD_ROOM);
		model.addElement(StringsEnglish.STR_STUD_H);
		model.addElement(StringsEnglish.STR_STUD_AP);

		// Setting model with new data
		cbPropertyType.setModel(model);
	}

	@Override
	protected void fileReadErrorMessage() {
		JOptionPane.showMessageDialog(frame, StringsEnglish.STR_FILE_READ_ERROR, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected JPanel createPanelResults(ArrayList<Property> properties) {
		return Factory.getFactoryInstance().createPanelLanguage(0).createPanelSearch(frame, properties);
	}

	@Override
	protected int confirmRegLandLordMessage() {
		return JOptionPane.showConfirmDialog(frame, StringsEnglish.STR_CONFIRM_REG_LANDLORD, StringsEnglish.STR_SIGNUP,
				JOptionPane.YES_NO_OPTION);
	}

	@Override
	protected int confirmRegTenantMessage() {
		return JOptionPane.showConfirmDialog(frame, StringsEnglish.STR_CONFIRM_REG_TENANT, StringsEnglish.STR_SIGNUP,
				JOptionPane.YES_NO_OPTION);
	}

	@Override
	protected void successfulRegistrationMessage() {
		JOptionPane.showMessageDialog(frame, StringsEnglish.STR_LAND_TEN, StringsEnglish.STR_SIGNUP,
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	protected void alreadyRegisteredMessage() {
		JOptionPane.showMessageDialog(frame, StringsEnglish.STR_EMAIL_ALREADY_REGISTERED, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void errorMessage() {
		JOptionPane.showMessageDialog(frame, StringsEnglish.STR_ERROR_REGISTRATION, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void userNotFoundMessage() {
		JOptionPane.showMessageDialog(frame, StringsEnglish.STR_USER_NOT_FOUND, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);		
	}

	@Override
	protected void emptyFieldMessage() {
		JOptionPane.showMessageDialog(frame, StringsEnglish.STR_EMPTY_FIELD, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}

	@Override
	protected void numberFormatMessage() {
		JOptionPane.showMessageDialog(frame, StringsEnglish.STR_NOT_VALID_FIELD, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}

	@Override
	protected void noRoomSelected() {
		JOptionPane.showMessageDialog(frame, StringsEnglish.STR_NOT_SELECTED_ROOMS, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}

}
