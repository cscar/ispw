package boundary.landlord;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.LandLord;
import entity.Session;
import entity.strings.StringsEnglish;

public class BoundaryPanelLandLordEnglish extends BoundaryPanelLandLord {
	private static final long serialVersionUID = 1L;
	private JDialog dialog;

	public BoundaryPanelLandLordEnglish(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;

		LandLord landLord = (LandLord) Session.getSessionInstance().getCustomer();

		// Title and Buttons Text
		dialog.setTitle(StringsEnglish.STR_WELCOME_LANDLORD);
		lblTitle.setText(StringsEnglish.STR_WELCOME_TITLE + " " + landLord.getFirstName());
		btnAddProperty.setText(StringsEnglish.STR_BTN_PROP);
		btnManageProperty.setText(StringsEnglish.STR_BTN_MAN);
		btnModifyProfile.setText(StringsEnglish.STR_MY_PROFILE);
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

		// removing old data
		model.removeAllElements();

		model.addElement(StringsEnglish.STR_STUD_ROOM);
		model.addElement(StringsEnglish.STR_STUD_H);
		model.addElement(StringsEnglish.STR_STUD_AP);

		// setting model with new data
		cbPropertyType.setModel(model);
	}

	@Override
	protected void fileReadErrorMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_FILE_READ_ERROR, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void emptyFieldMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_EMPTY_FIELD, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void numberFormatMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_NOT_VALID_FIELD, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void noRoomSelected() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_NOT_SELECTED_ROOMS, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}
}
