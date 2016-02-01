package boundary.rent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Constants;
import entity.properties.Property;
import entity.properties.RoomStudents;
import entity.strings.StringsEnglish;

public class BoundaryPanelRentEnglish extends BoundaryPanelRent {

	private static final long serialVersionUID = 1L;

	JDialog dialog;

	public BoundaryPanelRentEnglish(JDialog dialog, Property property) {
		super(dialog, property);
		this.dialog = dialog;

		// Title and Buttons Text
		this.dialog.setTitle(StringsEnglish.STR_BTN_RENT);
		this.btnRent.setText(StringsEnglish.STR_BTN_RENT);
		this.btnCancel.setText(StringsEnglish.STR_CANCEL);
		this.lblSingleRoomWC.setText(StringsEnglish.STR_SINGLEROOM_WC);
		this.lblSingleRoom.setText(StringsEnglish.STR_SINGLEROOM);
		this.lblDoubleRoomWC.setText(StringsEnglish.STR_DOUBLEROOM_WC);
		this.lblDoubleRoom.setText(StringsEnglish.STR_DOUBLEROOM);
		this.lblRoomType.setText(StringsEnglish.STR_PROP);

		if (property instanceof RoomStudents) {
			RoomStudents room = (RoomStudents) property;

			switch (room.getRoomType()) {
			case Constants.ROOM_TYPE_DOUBLE:
				tfRoomType.setText(StringsEnglish.STR_DR_);
				break;
			case Constants.ROOM_TYPE_SINGLE:
				tfRoomType.setText(StringsEnglish.STR_SR_);
				break;
			case Constants.ROOM_TYPE_DOUBLEWC:
				tfRoomType.setText(StringsEnglish.STR_DR_WC);
				break;
			case Constants.ROOM_TYPE_SINGLEWC:
				tfRoomType.setText(StringsEnglish.STR_SR_WC);
				break;
			}
		}
	}

	@Override
	protected void successfulRentMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsEnglish.STR_SUCCESSFUL_RENT,
				StringsEnglish.STR_ERROR, JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	protected void notLoggedErrorMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsEnglish.STR_NOT_LOGGED_AS_TENANT,
				StringsEnglish.STR_ERROR, JOptionPane.ERROR_MESSAGE);
	}

}
