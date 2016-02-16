package boundary.iban;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.strings.StringsEnglish;

public class BoundaryPanelIbanEnglish extends BoundaryPanelIban {
	private static final long serialVersionUID = 1L;

	protected JDialog dialog;

	public BoundaryPanelIbanEnglish(JDialog dialog) {

		super(dialog);
		this.dialog = dialog;

		lblIban.setText(StringsEnglish.STR_IBAN);
		btnConfirm.setText(StringsEnglish.BTN_SAVE);
		btnCancel.setText(StringsEnglish.STR_CANCEL);
	}

	@Override
	protected void emptyFieldError() {

		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_EMPTY_FIELD, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void errorMessage() {

		JOptionPane.showMessageDialog(dialog, StringsEnglish.EX_UNEXPECTED, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void alreadyRegisteredUser() {

		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_EMAIL_ALREADY_REGISTERED, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void fileReadErrorMessage(String filename) {

		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_FILE_READ_ERROR + " " + filename,
				StringsEnglish.STR_ERROR, JOptionPane.ERROR_MESSAGE);

	}

	@Override
	protected void succeededMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_LAND_TEN, StringsEnglish.STR_SIGNUP,
				JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void userNotFoundMessage() {
		JOptionPane.showMessageDialog(dialog, StringsEnglish.STR_USER_NOT_FOUND, StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

}
