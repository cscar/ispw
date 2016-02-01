package boundary.landlord;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.LandLord;
import entity.Session;
import entity.strings.StringsItalian;

public class BoundaryPanelLandLordItalian extends BoundaryPanelLandLord {
	private static final long serialVersionUID = 1L;
	private JDialog dialog;

	public BoundaryPanelLandLordItalian(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;

		LandLord landLord = (LandLord) Session.getSessionInstance().getCustomer();

		// Title and Buttons Text
		dialog.setTitle(StringsItalian.STR_WELCOME_LANDLORD);
		lblTitle.setText(StringsItalian.STR_WELCOME_TITLE + " " + landLord.getFirstName());
		btnAddProperty.setText(StringsItalian.STR_BTN_PROP);
		btnManageProperty.setText(StringsItalian.STR_BTN_MAN);
		btnModifyProfile.setText(StringsItalian.STR_MY_PROFILE);
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

		// removing old data
		model.removeAllElements();

		model.addElement(StringsItalian.STR_STUD_ROOM);
		model.addElement(StringsItalian.STR_STUD_H);
		model.addElement(StringsItalian.STR_STUD_AP);

		// setting model with new data
		cbPropertyType.setModel(model);
	}

	@Override
	protected void fileReadErrorMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_FILE_READ_ERROR, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void emptyFieldMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_EMPTY_FIELD, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void numberFormatMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_NOT_VALID_FIELD, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void noRoomSelected() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_NOT_SELECTED_ROOMS, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}
}
