package boundary.login;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Filepaths;
import entity.strings.StringsEnglish;

public class BoundaryPanelLoginEnglish extends BoundaryPanelLogin {

	private static final long serialVersionUID = 1L;
	
	JDialog dialog;
	
	public BoundaryPanelLoginEnglish(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;
		
		//Title and Buttons Text
		this.dialog.setTitle(StringsEnglish.STR_LOGIN);
		this.lblEmail.setText(StringsEnglish.STR_EMAIL + " ");
		this.lblPassword.setText(StringsEnglish.STR_PASSWORD + " ");
		this.btnLogin.setText(StringsEnglish.STR_LOGIN);
		this.btnCancel.setText(StringsEnglish.STR_CANCEL);
	}

    @Override
	protected void successfulLoginMessage() {
	    JOptionPane.showMessageDialog(dialog,
	            StringsEnglish.STR_HI + " " + getEmail() + "! " + StringsEnglish.STR_SUCCESSFUL_LOGIN,
	            StringsEnglish.STR_LOGIN,
	            JOptionPane.INFORMATION_MESSAGE);
	}
    

	@Override
	protected void invalidLoginMessage() {
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
