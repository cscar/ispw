package boundary.registration.properties;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.strings.StringsItalian;

public class BoundaryPanelRegistrationPropertiesItalian extends BoundaryPanelRegistrationProperties {
	private static final long serialVersionUID = 1L;
	private JDialog dialog;

	public BoundaryPanelRegistrationPropertiesItalian(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;
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
		this.lblSingleRoomWC.setText(StringsItalian.STR_SINGLEROOM_WC);
		this.lblSingleRoom.setText(StringsItalian.STR_SINGLEROOM);
		this.lblDoubleRoomWC.setText(StringsItalian.STR_DOUBLEROOM_WC);
		this.lblDoubleRoom.setText(StringsItalian.STR_DOUBLEROOM);
		this.lblSingleRoomWCPrice.setText(StringsItalian.STR_PRICE);
		this.lblSingleRoomPrice.setText(StringsItalian.STR_PRICE);
		this.lblDoubleRoomWCPrice.setText(StringsItalian.STR_PRICE);
		this.lblDoubleRoomPrice.setText(StringsItalian.STR_PRICE);
		this.lblBus.setText(StringsItalian.STR_BUS);
		this.lblOtherStudents.setText(StringsItalian.STR_OTHER_STUDENTS);
		this.lblPropertyType.setText(StringsItalian.STR_PROP);
		this.lblRoomFee.setText(StringsItalian.STR_PRICE);
		this.lblNickname.setText(StringsItalian.STR_NICKNAME);
		this.lblWifi.setText(StringsItalian.STR_WIFI);
		this.btnOK.setText(StringsItalian.STR_BTN_PROP);
		this.btnCancel.setText(StringsItalian.STR_RESET);
		this.lblContract.setText(StringsItalian.STR_CONTRACT);

		// removing old data from JCombo model
		model.removeAllElements();

		model.addElement(StringsItalian.STR_SR_WC);
		model.addElement(StringsItalian.STR_SR_);
		model.addElement(StringsItalian.STR_DR_WC);
		model.addElement(StringsItalian.STR_DR_);
		// setting model with new data
		cbRoomType.setModel(model);

		modelDd.removeAllElements();

		modelDd.addElement(StringsItalian.STR_MONTH);
		modelDd.addElement(StringsItalian.STR_DAY);
		modelDd.addElement(StringsItalian.STR_YEAR);
		// setting model with new data
		cbContractTerm2.setModel(modelDd);
	}

	@Override
	protected void fileReadErrorMessage(String filename) {

		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_FILE_READ_ERROR + " " + filename,
				StringsItalian.STR_ERROR, JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void emptyFieldMessage() {

		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_EMPTY_FIELD, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void alreadyRegisteredMessage() {

		JOptionPane.showMessageDialog(dialog, StringsItalian.EX_PROPERTIESREGISTERED, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void successfulRegistrationMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_SUCCESSFULL_PROPERTIES, StringsItalian.STR_INSERT_PROP,
				JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	protected void noRoomErrorMessage() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(dialog, StringsItalian.EX_NO_ROOMS, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void numberFormatMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_NOT_VALID_FIELD, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void unexpectedErrorMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.EX_UNEXPECTED, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

}
