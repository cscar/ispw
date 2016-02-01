package boundary.tenant.changeprofile;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.strings.StringsEnglish;

public class BoundaryPanelChangeProfileTenantEnglish extends BoundaryPanelChangeProfileTenant {
	private static final long serialVersionUID = 1L;
	private JDialog dialog;

	public BoundaryPanelChangeProfileTenantEnglish(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;

		this.lblFax.setText(StringsEnglish.STR_FAX);
		this.lblAddress.setText(StringsEnglish.STR_ADDR);
		this.lblWebSite.setText(StringsEnglish.STR_WEBSITE);
		this.lblTaxCode.setText(StringsEnglish.STR_TAX_CODE);
		this.lblPhone.setText(StringsEnglish.STR_PHONE);
		this.lblTitle.setText(StringsEnglish.STR_MY_PROFILE);
		this.lblSecurityQuestion.setText(StringsEnglish.STR_QUESTION + " ");
		this.lblSecurityAnswer.setText(StringsEnglish.STR_ANSWER + " ");

		this.cbSecurityQuestion.addItem(StringsEnglish.STR_Q1);
		this.cbSecurityQuestion.addItem(StringsEnglish.STR_Q2);
		this.cbSecurityQuestion.addItem(StringsEnglish.STR_Q3);

		this.btnConfirm.setText(StringsEnglish.STR_CHANGE_PROFILE);
		this.btnReset.setText(StringsEnglish.STR_RESET);
		this.btnCancel.setText(StringsEnglish.STR_CANCEL);
	}

	@Override
	protected void successfulChangeMessage() {
		JOptionPane.showMessageDialog(dialog, 
				StringsEnglish.STR_SUCCESSFUL_CHANGE_PROFILE,
				StringsEnglish.STR_CHANGE_PROFILE, 
				JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	protected void fileReadErrorMessage(String filename) {
		JOptionPane.showMessageDialog(dialog, 
				StringsEnglish.STR_FILE_READ_ERROR, 
				StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void emptyFieldErrorMessage() {
		JOptionPane.showMessageDialog(dialog, 
				StringsEnglish.STR_EMPTY_FIELD, 
				StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void alreadyRegisteredErrorMessage() {
		JOptionPane.showMessageDialog(dialog, 
				StringsEnglish.STR_EMAIL_ALREADY_REGISTERED, 
				StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void userNotFoundMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_USER_NOT_FOUND, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);		
	}

}
