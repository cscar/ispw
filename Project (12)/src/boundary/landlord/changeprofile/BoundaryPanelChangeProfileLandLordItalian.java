package boundary.landlord.changeprofile;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.strings.StringsItalian;

public class BoundaryPanelChangeProfileLandLordItalian extends BoundaryPanelChangeProfileLandLord {
	private static final long serialVersionUID = 1L;
	private JDialog dialog;

	public BoundaryPanelChangeProfileLandLordItalian(JDialog dialog) {
		super(dialog);
		this.dialog=dialog;
		
		this.lblFax.setText(StringsItalian.STR_FAX);
		this.lblAddress.setText(StringsItalian.STR_ADDR);
		this.lblWebSite.setText(StringsItalian.STR_WEBSITE);
		this.lblIban.setText(StringsItalian.STR_IBAN);
		this.lblTaxCode.setText(StringsItalian.STR_TAX_CODE);
		this.lblPhone.setText(StringsItalian.STR_PHONE);
		this.lblTitle.setText(StringsItalian.STR_MY_PROFILE);
		this.lblSecurityQuestion.setText(StringsItalian.STR_QUESTION + " ");
        this.lblSecurityAnswer.setText(StringsItalian.STR_ANSWER + " ");
		
		this.cbSecurityQuestion.addItem(StringsItalian.STR_Q1);
		this.cbSecurityQuestion.addItem(StringsItalian.STR_Q2);
		this.cbSecurityQuestion.addItem(StringsItalian.STR_Q3);
	
		this.btnConfirm.setText(StringsItalian.STR_CHANGE_PROFILE);
		this.btnReset.setText(StringsItalian.STR_RESET);
		this.btnCancel.setText(StringsItalian.STR_CANCEL);
	}

	@Override
	protected void successfulChangeMessage() {
		JOptionPane.showMessageDialog(dialog, 
				StringsItalian.STR_CHANGE_PROFILE,
				StringsItalian.STR_SUCCESSFUL_CHANGE_PROFILE, 
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	protected void fileReadErrorMessage(String filename) {
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_EMPTY_FIELD,
				StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}

	@Override
	protected void emptyFieldErrorMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_EMPTY_FIELD,
				StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void alreadyRegisteredErrorMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_EMAIL_ALREADY_REGISTERED,
				StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}

	@Override
	public void userNotFoundMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_USER_NOT_FOUND, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);		
	}
}
