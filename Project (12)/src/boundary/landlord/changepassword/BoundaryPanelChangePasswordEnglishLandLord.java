package boundary.landlord.changepassword;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.strings.StringsEnglish;

public class BoundaryPanelChangePasswordEnglishLandLord extends BoundaryPanelChangePasswordLandLord{
	private static final long serialVersionUID = 1L;
	private JDialog dialog;

	public BoundaryPanelChangePasswordEnglishLandLord(JDialog dialog) {
		super(dialog);
		this.dialog=dialog;
		
		this.lblPassword.setText(StringsEnglish.STR_PASSWORD);
		this.lblPasswordConfirm.setText(StringsEnglish.STR_CONFIRM_PASSWORD);
		this.btnConfirm.setText(StringsEnglish.STR_CHANGE_PASSWORD);
		this.btnReset.setText(StringsEnglish.STR_RESET);
		this.btnCancel.setText(StringsEnglish.STR_CANCEL);
	}

	@Override
	protected void successfulRegistrationMessage() {
		JOptionPane.showMessageDialog(dialog, 
				StringsEnglish.STR_SUCCESSFUL_CHANGE_PROFILE,
				StringsEnglish.STR_SIGNUP, 
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	protected void alreadyRegisteredMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsEnglish.STR_EMAIL_ALREADY_REGISTERED,
				StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}

	@Override
	protected void fileReadErrorMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsEnglish.STR_FILE_READ_ERROR ,
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
	protected void passwordMismatchMessage() {
		JOptionPane.showMessageDialog(dialog, 
				StringsEnglish.STR_PASSWORD_MISMATCH, 
				StringsEnglish.STR_ERROR, 
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void userNotFoundMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_USER_NOT_FOUND, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);		
	}

}
