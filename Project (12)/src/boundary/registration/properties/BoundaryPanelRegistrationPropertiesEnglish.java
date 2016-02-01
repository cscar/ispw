package boundary.registration.properties;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.strings.StringsEnglish;

public class BoundaryPanelRegistrationPropertiesEnglish extends BoundaryPanelRegistrationProperties {
	private static final long serialVersionUID = 1L;
	private JDialog dialog;

	public BoundaryPanelRegistrationPropertiesEnglish(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;
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
		this.lblSingleRoomWC.setText(StringsEnglish.STR_SINGLEROOM_WC);
		this.lblSingleRoom.setText(StringsEnglish.STR_SINGLEROOM);
		this.lblDoubleRoomWC.setText(StringsEnglish.STR_DOUBLEROOM_WC);
		this.lblDoubleRoom.setText(StringsEnglish.STR_DOUBLEROOM);
		this.lblSingleRoomWCPrice.setText(StringsEnglish.STR_PRICE);
		this.lblSingleRoomPrice.setText(StringsEnglish.STR_PRICE);
		this.lblDoubleRoomWCPrice.setText(StringsEnglish.STR_PRICE);
		this.lblDoubleRoomPrice.setText(StringsEnglish.STR_PRICE);
		this.lblBus.setText(StringsEnglish.STR_BUS);
		this.lblOtherStudents.setText(StringsEnglish.STR_OTHER_STUDENTS);
		this.lblPropertyType.setText(StringsEnglish.STR_PROP);
		this.lblRoomFee.setText(StringsEnglish.STR_PRICE);
		this.lblNickname.setText(StringsEnglish.STR_NICKNAME);
		this.lblWifi.setText(StringsEnglish.STR_WIFI);
		this.btnOK.setText(StringsEnglish.STR_BTN_PROP);
		this.btnCancel.setText(StringsEnglish.STR_RESET);
		this.lblContract.setText(StringsEnglish.STR_CONTRACT);

		// removing old data from JCombo model
		model.removeAllElements();

		model.addElement(StringsEnglish.STR_SR_WC);
		model.addElement(StringsEnglish.STR_SR_);
		model.addElement(StringsEnglish.STR_DR_WC);
		model.addElement(StringsEnglish.STR_DR_);
		// setting model with new data
		cbRoomType.setModel(model);

		modelDd.removeAllElements();

		modelDd.addElement(StringsEnglish.STR_MONTH);
		modelDd.addElement(StringsEnglish.STR_DAY);
		modelDd.addElement(StringsEnglish.STR_YEAR);
		// setting model with new data
		cbContractTerm2.setModel(modelDd);
	}

	@Override
	protected void fileReadErrorMessage(String filename) {

		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_FILE_READ_ERROR + " " + filename,
				StringsEnglish.STR_ERROR, JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void emptyFieldMessage() {

		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_EMPTY_FIELD, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void alreadyRegisteredMessage() {

		JOptionPane.showMessageDialog(dialog, StringsEnglish.EX_PROPERTIESREGISTERED, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void successfulRegistrationMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_SUCCESSFULL_PROPERTIES, StringsEnglish.STR_INSERT_PROP,
				JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	protected void noRoomErrorMessage() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(dialog, StringsEnglish.EX_NO_ROOMS, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void numberFormatMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_NOT_VALID_FIELD, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void unexpectedErrorMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.EX_UNEXPECTED, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

}
