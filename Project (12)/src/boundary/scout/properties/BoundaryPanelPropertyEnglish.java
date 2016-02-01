package boundary.scout.properties;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Constants;
import entity.properties.Property;
import entity.properties.RoomStudents;
import entity.strings.StringsEnglish;

public class BoundaryPanelPropertyEnglish extends BoundaryPanelProperty {
	private static final long serialVersionUID = 1L;

	public BoundaryPanelPropertyEnglish(JDialog dialog, Property property) {
		super(dialog, property);

		this.rdRegHouse.setText(StringsEnglish.STR_STUD_H);
		this.rdRegApartment.setText(StringsEnglish.STR_STUD_AP);
		this.rdRegRoom.setText(StringsEnglish.STR_STUD_ROOM);
		this.lblMunicipality.setText(StringsEnglish.STR_MUNIC);
		this.lblProvince.setText(StringsEnglish.STR_PROV);
		this.lblAddress.setText(StringsEnglish.STR_ADDR);
		this.lblHouseNumber.setText(StringsEnglish.STR_CIV);
		this.lblUniversity.setText(StringsEnglish.STR_UNIV_FAC);
		this.lblWC.setText(StringsEnglish.STR_NUM_WC);
		this.lblSpecialGuest.setText(StringsEnglish.STR_SPECIALGUEST);
		this.lblParkingSpace.setText(StringsEnglish.STR_CAR);
		this.lblBestAppliances.setText(StringsEnglish.STR_WM);
		this.lblExpenses.setText(StringsEnglish.STR_SALE);
		this.lblOtherStudentPrice.setText(StringsEnglish.STR_PRICE_SPECIAL);
		this.lblAnimals.setText(StringsEnglish.STR_ANIMALS);
		this.lblMq.setText(StringsEnglish.STR_MQ);
		this.lblGarden.setText(StringsEnglish.STR_GARDEN);
		this.lblSingleRoomWC.setText(StringsEnglish.STR_SINGLEROOM_WC_AVAILABILITY);
		this.lblSingleRoom.setText(StringsEnglish.STR_SINGLEROOM_AVAILABILITY);
		this.lblDoubleRoomWC.setText(StringsEnglish.STR_DOUBLEROOM_WC_AVAILABILITY);
		this.lblDoubleRoom.setText(StringsEnglish.STR_DOUBLEROOM_AVAILABILITY);
		this.lblSingleRoomWCPrice.setText(StringsEnglish.STR_PRICE);
		this.lblSingleRoomPrice.setText(StringsEnglish.STR_PRICE);
		this.lblDoubleRoomWCPrice.setText(StringsEnglish.STR_PRICE);
		this.lblDoubleRoomPrice.setText(StringsEnglish.STR_PRICE);
		this.lblBus.setText(StringsEnglish.STR_BUS);
		this.lblOtherStudents.setText(StringsEnglish.STR_OTHER_STUDENTS);
		this.lblRoomType.setText(StringsEnglish.STR_PROP);
		this.lblRoomFee.setText(StringsEnglish.STR_PRICE);
		this.lblNickname.setText(StringsEnglish.STR_NICKNAME);
		this.lblWifi.setText(StringsEnglish.STR_WIFI);
		this.btnAccept.setText(StringsEnglish.STR_BTN_ACCEPT);
		this.btnRefuse.setText(StringsEnglish.STR_BTN_REFUSE);
		this.btnCancel.setText(StringsEnglish.STR_CANCEL);
		this.lblContract.setText(StringsEnglish.STR_CONTRACT);

		// Contract term
		switch (property.getContractTerm2()) {
		case Constants.CONTRACT_TERM_DAYS:
			tfContractTerm2.setText(StringsEnglish.STR_DAY);
			break;
		case Constants.CONTRACT_TERM_MONTHS:
			tfContractTerm2.setText(StringsEnglish.STR_MONTH);
			break;
		case Constants.CONTRACT_TERM_YEARS:
			tfContractTerm2.setText(StringsEnglish.STR_YEAR);
			break;
		}

		if (property instanceof RoomStudents) {
			RoomStudents roomStudents = (RoomStudents) property;

			// Property type
			switch (roomStudents.getRoomType()) {
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
	protected void fileWriteErrorMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.FILE_WRITE_ERROR, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void alreadyRegisteredMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_EMAIL_ALREADY_REGISTERED, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void userNotFoundMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_USER_NOT_FOUND, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void successfulAcceptMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_SUCCESSFUL_ACCEPT, StringsEnglish.STR_EVALUATE,
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	protected void successfulRefuseMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_SUCCESSFUL_REFUSE, StringsEnglish.STR_EVALUATE,
				JOptionPane.INFORMATION_MESSAGE);
	}

}
