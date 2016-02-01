 package boundary.registration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Filepaths;
import entity.strings.StringsItalian;

public class BoundaryPanelRegistrationItalian extends BoundaryPanelRegistration {
	private static final long serialVersionUID = 1L;
	
	private JDialog dialog;
	
	public BoundaryPanelRegistrationItalian(JDialog dialog) {
		super(dialog);
		this.dialog = dialog;
        
		//Title and Buttons Text
		this.dialog.setTitle(StringsItalian.STR_SIGNUP);
        this.rdRegLandLord.setText(StringsItalian.STR_REG_PROPRIETARIO);
        this.rdRegTenant.setText(StringsItalian.STR_REG_AFFITTUARIO);
        this.lblFirstName.setText(StringsItalian.STR_NAME + " ");
        this.lblLastName.setText(StringsItalian.STR_SURNAME + " ");
        this.lblEmail.setText(StringsItalian.STR_EMAIL + " ");
        this.lblPassword.setText(StringsItalian.STR_PASSWORD + " ");
        this.lblConfirmPassword.setText(StringsItalian.STR_CONFIRM_PASSWORD + " ");
        this.lblBirthDate.setText(StringsItalian.STR_DATE + " ");
        this.lblBirthPlace.setText(StringsItalian.STR_PLACE + " ");
        this.lblPhone.setText(StringsItalian.STR_PHONE + " ");
        this.lblTaxCode.setText(StringsItalian.STR_TAX_CODE + " ");
        this.lblAddress.setText(StringsItalian.STR_RES + " ");
        this.lblFax.setText(StringsItalian.STR_FAX + " ");
        this.lblWebSite.setText(StringsItalian.STR_WEBSITE + " ");
        this.lblSecurityQuestion.setText(StringsItalian.STR_QUESTION + " ");
        this.cbSecurityQuestion.addItem(StringsItalian.STR_Q1);
        this.cbSecurityQuestion.addItem(StringsItalian.STR_Q2);
        this.cbSecurityQuestion.addItem(StringsItalian.STR_Q3);
        this.lblSecurityAnswer.setText(StringsItalian.STR_ANSWER + " ");
        this.lblIban.setText(StringsItalian.STR_IBAN + " ");
        this.cbAcceptConditions.setText(StringsItalian.STR_ACCEPT_CONDITIONS);
        this.btnOK.setText(StringsItalian.STR_SIGNUP);
        this.btnCancel.setText(StringsItalian.STR_CANCEL);
        
        //Read conditions from file
        File file = new File(Filepaths.CONDITIONS_ITALIAN_FILENAME);
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
        	fileReadErrorMessage(Filepaths.CONDITIONS_ITALIAN_FILENAME);
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
				StringsItalian.EX_CONDITIONS,
				StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	protected void successfulLoginMessage() {
		JOptionPane.showMessageDialog(dialog, 
			StringsItalian.STR_HI + " " + getName() + "! " + StringsItalian.STR_SUCCESSFUL_REGISTRATION,
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
	protected void fileReadErrorMessage(String filename) {
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_FILE_READ_ERROR + " " + filename,
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
	protected void alreadyRegisteredErrorMessage() {
		JOptionPane.showMessageDialog(dialog,
				StringsItalian.STR_EMAIL_ALREADY_REGISTERED,
				StringsItalian.STR_ERROR,
				JOptionPane.ERROR_MESSAGE);	
	}
	
}
