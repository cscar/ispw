package boundary.administrator;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.strings.StringsItalian;

public class BoundaryPanelAdministratorItalian extends BoundaryPanelAdministrator {
	private static final long serialVersionUID = 1L;
	private JDialog dialog;
	

	public BoundaryPanelAdministratorItalian(JDialog dialog) {
		super(dialog);
		this.dialog=dialog;
		
		lblTitle.setText(StringsItalian.STR_WELCOME_ADMIN);
		lblEmailAdministrator.setText(StringsItalian.STR_EMAIL);
		lblPasswordAdministrator.setText(StringsItalian.STR_PASSWORD);
		lblConfirmPasswordAdministrator.setText(StringsItalian.STR_CONFIRM_PASSWORD);
		lblEmailScout.setText(StringsItalian.STR_EMAIL);
		lblPasswordScout.setText(StringsItalian.STR_PASSWORD);
		lblConfirmPasswordScout.setText(StringsItalian.STR_CONFIRM_PASSWORD);
		btnAddAdministrator.setText(StringsItalian.STR_ADD_ADMINISTRATOR);
		btnResetAdministrator.setText(StringsItalian.STR_RESET);
		btnAddScout.setText(StringsItalian.STR_ADD_SCOUT);
		btnResetScout.setText(StringsItalian.STR_RESET);
		
		titledBorderAdministrator.setTitle(StringsItalian.STR_ADD_ADMINISTRATOR);
		titledBorderScout.setTitle(StringsItalian.STR_ADD_SCOUT);
		
	}

	@Override
	protected void successfulRegistrationMessage() {
		JOptionPane.showMessageDialog(dialog, 
				StringsItalian.STR_SUCCESSFUL_REGISTRATION,
				StringsItalian.STR_SIGNUP, 
				JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	protected void passwordMismatchMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_PASSWORD_MISMATCH,
				StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void fileReadErrorMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_FILE_READ_ERROR,
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
	protected void alreadyRegisteredMessage() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_EMAIL_ALREADY_REGISTERED,
				StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}
}
