package boundary.tenant.changepassword;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.strings.StringsItalian;

public class BoundaryPanelChangePasswordTenantItalian extends BoundaryPanelChangePasswordTenant {
	private static final long serialVersionUID = 1L;
	private JDialog dialog;

	public BoundaryPanelChangePasswordTenantItalian(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;

		this.lblPassword.setText(StringsItalian.STR_PASSWORD);
		this.lblPasswordConfirm.setText(StringsItalian.STR_CONFIRM_PASSWORD);
		this.btnConfirm.setText(StringsItalian.STR_CHANGE_PASSWORD);
		this.btnReset.setText(StringsItalian.STR_RESET);
		this.btnCancel.setText(StringsItalian.STR_CANCEL);
	}

	@Override
	protected void successfulRegistrationMessage() {
		JOptionPane.showMessageDialog(dialog, 
				StringsItalian.STR_SUCCESSFUL_CHANGE_PROFILE, 
				StringsItalian.STR_CHANGE_PASSWORD,
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	protected void alreadyRegisteredMessage() {
		JOptionPane.showMessageDialog(dialog, 
				StringsItalian.STR_EMAIL_ALREADY_REGISTERED, 
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
	protected void passwordMismatchMessage() {
		JOptionPane.showMessageDialog(dialog, 
				StringsItalian.STR_PASSWORD_MISMATCH,
				StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void userNotFoundMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_USER_NOT_FOUND, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);		
	}

}
