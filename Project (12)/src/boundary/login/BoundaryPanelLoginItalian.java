package boundary.login;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Filepaths;
import entity.strings.StringsItalian;

public class BoundaryPanelLoginItalian extends BoundaryPanelLogin {

	private static final long serialVersionUID = 1L;
	
	JDialog dialog;
	
	public BoundaryPanelLoginItalian(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;
		
		//Title and Buttons Text
		this.dialog.setTitle(StringsItalian.STR_LOGIN);
		this.lblEmail.setText(StringsItalian.STR_EMAIL + " ");
		this.lblPassword.setText(StringsItalian.STR_PASSWORD + " ");
		this.btnLogin.setText(StringsItalian.STR_LOGIN);
		this.btnCancel.setText(StringsItalian.STR_CANCEL);
	}

    @Override
	protected void successfulLoginMessage() {
	    JOptionPane.showMessageDialog(dialog,
	            StringsItalian.STR_HI + " " + getEmail() + "! " + StringsItalian.STR_SUCCESSFUL_LOGIN,
	            StringsItalian.STR_LOGIN,
	            JOptionPane.INFORMATION_MESSAGE);
	}
    

	@Override
	protected void invalidLoginMessage() {
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
