package boundary.iban;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.strings.StringsItalian;

public class BoundaryPanelIbanItalian extends BoundaryPanelIban {
	private static final long serialVersionUID = 1L;

	protected JDialog dialog;

	public BoundaryPanelIbanItalian(JDialog dialog) {

		super(dialog);
		this.dialog = dialog;

		lblIban.setText(StringsItalian.STR_IBAN);
		btnConfirm.setText(StringsItalian.BTN_SAVE);
		btnCancel.setText(StringsItalian.STR_CANCEL);
	}

	@Override
	protected void emptyFieldError() {

		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_EMPTY_FIELD, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void errorMessage() {

		JOptionPane.showMessageDialog(dialog, StringsItalian.EX_UNEXPECTED, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void alreadyRegisteredUser() {

		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_EMAIL_ALREADY_REGISTERED, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void fileReadErrorMessage(String filename) {

		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_FILE_READ_ERROR + " " + filename,
				StringsItalian.STR_ERROR, JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void succeededMessage() {

		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_LAND_TEN, StringsItalian.STR_SIGNUP,
				JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void userNotFoundMessage() {
		JOptionPane.showMessageDialog(dialog, StringsItalian.STR_USER_NOT_FOUND, StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);		
	}

}
