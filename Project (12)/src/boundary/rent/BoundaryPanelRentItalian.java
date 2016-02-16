package boundary.rent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Constants;
import entity.properties.Property;
import entity.properties.RoomStudents;
import entity.strings.StringsItalian;

public class BoundaryPanelRentItalian extends BoundaryPanelRent {

	private static final long serialVersionUID = 1L;

	JDialog dialog;

	public BoundaryPanelRentItalian(JDialog dialog, Property property) {
		super(dialog, property);
		this.dialog = dialog;

		// Title and Buttons Text
		this.dialog.setTitle(StringsItalian.STR_BTN_RENT);
		this.btnRent.setText(StringsItalian.STR_BTN_RENT);
		this.btnCancel.setText(StringsItalian.STR_CANCEL);
		this.lblSingleRoomWC.setText(StringsItalian.STR_SINGLEROOM_WC);
		this.lblSingleRoom.setText(StringsItalian.STR_SINGLEROOM);
		this.lblDoubleRoomWC.setText(StringsItalian.STR_DOUBLEROOM_WC);
		this.lblDoubleRoom.setText(StringsItalian.STR_DOUBLEROOM);
		this.lblRoomType.setText(StringsItalian.STR_PROP);

		if (property instanceof RoomStudents) {
			RoomStudents room = (RoomStudents) property;

			switch (room.getRoomType()) {
			case Constants.ROOM_TYPE_DOUBLE:
				tfRoomType.setText(StringsItalian.STR_DR_);
				break;
			case Constants.ROOM_TYPE_SINGLE:
				tfRoomType.setText(StringsItalian.STR_SR_);
				break;
			case Constants.ROOM_TYPE_DOUBLEWC:
				tfRoomType.setText(StringsItalian.STR_DR_WC);
				break;
			case Constants.ROOM_TYPE_SINGLEWC:
				tfRoomType.setText(StringsItalian.STR_SR_WC);
				break;
			}
		}
	}

	@Override
	protected void successfulRentMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_SUCCESSFUL_RENT,
				StringsItalian.STR_ERROR, JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	protected void notLoggedErrorMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_NOT_LOGGED_AS_TENANT,
				StringsItalian.STR_ERROR, JOptionPane.ERROR_MESSAGE);
	}

}
