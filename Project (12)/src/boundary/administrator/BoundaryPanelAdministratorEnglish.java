package boundary.administrator;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.strings.StringsEnglish;

public class BoundaryPanelAdministratorEnglish extends BoundaryPanelAdministrator {
	private static final long serialVersionUID = 1L;
	private JDialog dialog;
	

	public BoundaryPanelAdministratorEnglish(JDialog dialog) {
		super(dialog);
		this.dialog=dialog;
		
		lblTitle.setText(StringsEnglish.STR_WELCOME_ADMIN);
		lblEmailAdministrator.setText(StringsEnglish.STR_EMAIL);
		lblPasswordAdministrator.setText(StringsEnglish.STR_PASSWORD);
		lblConfirmPasswordAdministrator.setText(StringsEnglish.STR_CONFIRM_PASSWORD);
		lblEmailScout.setText(StringsEnglish.STR_EMAIL);
		lblPasswordScout.setText(StringsEnglish.STR_PASSWORD);
		lblConfirmPasswordScout.setText(StringsEnglish.STR_CONFIRM_PASSWORD);
		btnAddAdministrator.setText(StringsEnglish.STR_ADD_ADMINISTRATOR);
		btnResetAdministrator.setText(StringsEnglish.STR_RESET);
		btnAddScout.setText(StringsEnglish.STR_ADD_SCOUT);
		btnResetScout.setText(StringsEnglish.STR_RESET);
		
		titledBorderAdministrator.setTitle(StringsEnglish.STR_ADD_ADMINISTRATOR);
		titledBorderScout.setTitle(StringsEnglish.STR_ADD_SCOUT);
		
	}

	@Override
	protected void successfulRegistrationMessage() {
		JOptionPane.showMessageDialog(dialog, 
				StringsEnglish.STR_SUCCESSFUL_REGISTRATION,
				StringsEnglish.STR_SIGNUP, 
				JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	protected void passwordMismatchMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsEnglish.STR_PASSWORD_MISMATCH,
				StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void fileReadErrorMessage() {
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
	protected void alreadyRegisteredMessage() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(dialog,
				StringsEnglish.STR_EMAIL_ALREADY_REGISTERED,
				StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}
}
