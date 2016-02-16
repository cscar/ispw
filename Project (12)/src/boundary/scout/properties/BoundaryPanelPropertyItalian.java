package boundary.scout.properties;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Constants;
import entity.properties.Property;
import entity.properties.RoomStudents;
import entity.strings.StringsItalian;

public class BoundaryPanelPropertyItalian extends BoundaryPanelProperty {
	private static final long serialVersionUID = 1L;

	public BoundaryPanelPropertyItalian(JDialog dialog, Property property) {
		super(dialog, property);

		this.rdRegHouse.setText(StringsItalian.STR_STUD_H);
		this.rdRegApartment.setText(StringsItalian.STR_STUD_AP);
		this.rdRegRoom.setText(StringsItalian.STR_STUD_ROOM);
		this.lblMunicipality.setText(StringsItalian.STR_MUNIC);
		this.lblProvince.setText(StringsItalian.STR_PROV);
		this.lblAddress.setText(StringsItalian.STR_ADDR);
		this.lblHouseNumber.setText(StringsItalian.STR_CIV);
		this.lblUniversity.setText(StringsItalian.STR_UNIV_FAC);
		this.lblWC.setText(StringsItalian.STR_NUM_WC);
		this.lblSpecialGuest.setText(StringsItalian.STR_SPECIALGUEST);
		this.lblParkingSpace.setText(StringsItalian.STR_CAR);
		this.lblBestAppliances.setText(StringsItalian.STR_WM);
		this.lblExpenses.setText(StringsItalian.STR_SALE);
		this.lblOtherStudentPrice.setText(StringsItalian.STR_PRICE_SPECIAL);
		this.lblAnimals.setText(StringsItalian.STR_ANIMALS);
		this.lblMq.setText(StringsItalian.STR_MQ);
		this.lblGarden.setText(StringsItalian.STR_GARDEN);
		this.lblSingleRoomWC.setText(StringsItalian.STR_SINGLEROOM_WC_AVAILABILITY);
		this.lblSingleRoom.setText(StringsItalian.STR_SINGLEROOM_AVAILABILITY);
		this.lblDoubleRoomWC.setText(StringsItalian.STR_DOUBLEROOM_WC_AVAILABILITY);
		this.lblDoubleRoom.setText(StringsItalian.STR_DOUBLEROOM_AVAILABILITY);
		this.lblSingleRoomWCPrice.setText(StringsItalian.STR_PRICE);
		this.lblSingleRoomPrice.setText(StringsItalian.STR_PRICE);
		this.lblDoubleRoomWCPrice.setText(StringsItalian.STR_PRICE);
		this.lblDoubleRoomPrice.setText(StringsItalian.STR_PRICE);
		this.lblBus.setText(StringsItalian.STR_BUS);
		this.lblOtherStudents.setText(StringsItalian.STR_OTHER_STUDENTS);
		this.lblRoomType.setText(StringsItalian.STR_PROP);
		this.lblRoomFee.setText(StringsItalian.STR_PRICE);
		this.lblNickname.setText(StringsItalian.STR_NICKNAME);
		this.lblWifi.setText(StringsItalian.STR_WIFI);
		this.btnAccept.setText(StringsItalian.STR_BTN_ACCEPT);
		this.btnRefuse.setText(StringsItalian.STR_BTN_REFUSE);
		this.btnCancel.setText(StringsItalian.STR_CANCEL);
		this.lblContract.setText(StringsItalian.STR_CONTRACT);

		// Contract term
		switch (property.getContractTerm2()) {
		case Constants.CONTRACT_TERM_DAYS:
			tfContractTerm2.setText(StringsItalian.STR_DAY);
			break;
		case Constants.CONTRACT_TERM_MONTHS:
			tfContractTerm2.setText(StringsItalian.STR_MONTH);
			break;
		case Constants.CONTRACT_TERM_YEARS:
			tfContractTerm2.setText(StringsItalian.STR_YEAR);
			break;
		}

		if (property instanceof RoomStudents) {
			RoomStudents roomStudents = (RoomStudents) property;

			// Property type
			switch (roomStudents.getRoomType()) {
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
	protected void fileWriteErrorMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.FILE_WRITE_ERROR, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void alreadyRegisteredMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_EMAIL_ALREADY_REGISTERED, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void userNotFoundMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_USER_NOT_FOUND, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void successfulAcceptMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_SUCCESSFUL_ACCEPT, StringsItalian.STR_EVALUATE,
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	protected void successfulRefuseMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_SUCCESSFUL_REFUSE, StringsItalian.STR_EVALUATE,
				JOptionPane.INFORMATION_MESSAGE);
	}

}
