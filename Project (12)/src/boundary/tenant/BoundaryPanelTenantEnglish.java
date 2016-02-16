package boundary.tenant;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Session;
import entity.Tenant;
import entity.strings.StringsEnglish;

public class BoundaryPanelTenantEnglish extends BoundaryPanelTenant {

	private static final long serialVersionUID = 1L;
	private JDialog dialog;

	public BoundaryPanelTenantEnglish(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;

		Tenant tenant = (Tenant) Session.getSessionInstance().getCustomer();

		// Title and Buttons Text
		lblTitle.setText(StringsEnglish.STR_WELCOME_TITLE + " " + tenant.getFirstName());
		btnMyProfile.setText(StringsEnglish.STR_MY_PROFILE);
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

		// removing old data
		model.removeAllElements();

		model.addElement(StringsEnglish.STR_STUD_ROOM);
		model.addElement(StringsEnglish.STR_STUD_AP);
		model.addElement(StringsEnglish.STR_STUD_H);
		// setting model with new data
		cbPropertyType.setModel(model);

		titledBorder.setTitle(StringsEnglish.STR_SEARCH);
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
