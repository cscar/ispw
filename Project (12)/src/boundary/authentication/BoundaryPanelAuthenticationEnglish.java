package boundary.authentication;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Filepaths;
import entity.strings.StringsEnglish;

public class BoundaryPanelAuthenticationEnglish extends BoundaryPanelAuthentication {

	private static final long serialVersionUID = 1L;
	
	JDialog dialog;
	
	public BoundaryPanelAuthenticationEnglish(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;
		
		//Title and Buttons Text
		this.dialog.setTitle(StringsEnglish.STR_AUTHENTICATION);
		this.lblEmail.setText(StringsEnglish.STR_EMAIL + " ");
		this.lblPassword.setText(StringsEnglish.STR_PASSWORD + " ");
		this.btnAuthentication.setText(StringsEnglish.BTN_AUTHENTICATE);
		this.btnCancel.setText(StringsEnglish.STR_CANCEL);
	}    

	@Override
	protected void invalidAuthenticationMessage() {
	    JOptionPane.showMessageDialog(dialog,
	            StringsEnglish.STR_INVALID_LOGIN,
	            StringsEnglish.STR_LOGIN,
	            JOptionPane.ERROR_MESSAGE);
	}
	

	@Override
	protected void fileReadErrorMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsEnglish.STR_FILE_READ_ERROR + " " + Filepaths.USERS_DATABASE_FILENAME,
				StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}
	

	@Override
	protected void emptyFieldMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsEnglish.STR_EMPTY_FIELD,
				StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}
	
}
