 package boundary.registration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Filepaths;
import entity.strings.StringsEnglish;

public class BoundaryPanelRegistrationEnglish extends BoundaryPanelRegistration {
	private static final long serialVersionUID = 1L;
	
	private JDialog dialog;
	
	public BoundaryPanelRegistrationEnglish(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;
        
		//Title and Buttons Text
		this.dialog.setTitle(StringsEnglish.STR_SIGNUP);
        this.rdRegLandLord.setText(StringsEnglish.STR_REG_PROPRIETARIO);
        this.rdRegTenant.setText(StringsEnglish.STR_REG_AFFITTUARIO);
        this.lblFirstName.setText(StringsEnglish.STR_NAME + " ");
        this.lblLastName.setText(StringsEnglish.STR_SURNAME + " ");
        this.lblEmail.setText(StringsEnglish.STR_EMAIL + " ");
        this.lblPassword.setText(StringsEnglish.STR_PASSWORD + " ");
        this.lblConfirmPassword.setText(StringsEnglish.STR_CONFIRM_PASSWORD + " ");
        this.lblBirthDate.setText(StringsEnglish.STR_DATE + " ");
        this.lblBirthPlace.setText(StringsEnglish.STR_PLACE + " ");
        this.lblPhone.setText(StringsEnglish.STR_PHONE + " ");
        this.lblTaxCode.setText(StringsEnglish.STR_TAX_CODE + " ");
        this.lblAddress.setText(StringsEnglish.STR_RES + " ");
        this.lblFax.setText(StringsEnglish.STR_FAX + " ");
        this.lblWebSite.setText(StringsEnglish.STR_WEBSITE + " ");
        this.lblSecurityQuestion.setText(StringsEnglish.STR_QUESTION + " ");
        this.cbSecurityQuestion.addItem(StringsEnglish.STR_Q1);
        this.cbSecurityQuestion.addItem(StringsEnglish.STR_Q2);
        this.cbSecurityQuestion.addItem(StringsEnglish.STR_Q3);
        this.lblSecurityAnswer.setText(StringsEnglish.STR_ANSWER + " ");
        this.lblIban.setText(StringsEnglish.STR_IBAN + " ");
        this.cbAcceptConditions.setText(StringsEnglish.STR_ACCEPT_CONDITIONS);
        this.btnOK.setText(StringsEnglish.STR_SIGNUP);
        this.btnCancel.setText(StringsEnglish.STR_CANCEL);
        
        //Read conditions from file
        File file = new File(Filepaths.CONDITIONS_ENGLISH_FILENAME);
        BufferedReader in = null;
        
        try {
            in = new BufferedReader(new FileReader(file));
	        String line = in.readLine();
	        while(line != null){
	          text.append(line + "\n");
	          line = in.readLine();
	        }
	        text.setCaretPosition(0);
        } catch(IOException e) {
        	fileReadErrorMessage(Filepaths.CONDITIONS_ENGLISH_FILENAME);
        } finally {
        	//Close stream
        	if (in != null) {
        		try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
	}
	
 
	@Override
	protected void conditionsMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsEnglish.EX_CONDITIONS,
				StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void successfulLoginMessage() {
		JOptionPane.showMessageDialog(dialog, 
			StringsEnglish.STR_HI + " " + getName() + "! " + StringsEnglish.STR_SUCCESSFUL_REGISTRATION,
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
	protected void fileReadErrorMessage(String filename) {
		JOptionPane.showMessageDialog(dialog,
				StringsEnglish.STR_FILE_READ_ERROR + " " + filename,
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
	protected void alreadyRegisteredErrorMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsEnglish.STR_EMAIL_ALREADY_REGISTERED,
				StringsEnglish.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}
	
}
