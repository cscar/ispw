package boundary.authentication;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Filepaths;
import entity.strings.StringsItalian;

public class BoundaryPanelAuthenticationItalian extends BoundaryPanelAuthentication {

	private static final long serialVersionUID = 1L;
	
	JDialog dialog;
	
	public BoundaryPanelAuthenticationItalian(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;
		
		//Title and Buttons Text
		this.dialog.setTitle(StringsItalian.STR_AUTHENTICATION);
		this.lblEmail.setText(StringsItalian.STR_EMAIL + " ");
		this.lblPassword.setText(StringsItalian.STR_PASSWORD + " ");
		this.btnAuthentication.setText(StringsItalian.BTN_AUTHENTICATE);
		this.btnCancel.setText(StringsItalian.STR_CANCEL);
	}    

	@Override
	protected void invalidAuthenticationMessage() {
	    JOptionPane.showMessageDialog(dialog,
	            StringsItalian.STR_INVALID_LOGIN,
	            StringsItalian.STR_LOGIN,
	            JOptionPane.ERROR_MESSAGE);
	}
	

	@Override
	protected void fileReadErrorMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_FILE_READ_ERROR + " " + Filepaths.USERS_DATABASE_FILENAME,
				StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}
	

	@Override
	protected void emptyFieldMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_EMPTY_FIELD,
				StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}
	
}
