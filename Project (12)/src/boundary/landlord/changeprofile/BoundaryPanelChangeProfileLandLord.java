package boundary.landlord.changeprofile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import control.changeprofile.ChangeProfileLandLord;
import entity.Filepaths;
import entity.Styles;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.UserNotFoundException;

public abstract class BoundaryPanelChangeProfileLandLord extends JPanel{
	private static final long serialVersionUID = 1L;
	private JDialog dialog;
	
	protected JPasswordField pfPassword;
	protected JLabel lblPassword;
	protected JButton btnConfirm;
	protected JButton btnReset;
	protected JLabel lblPhone;
	protected JTextField tfPhone;
	protected JLabel lblTaxCode;
	protected JTextField tfTaxCode;
	protected JLabel lblAddress;
	protected JTextField tfAddress;
	protected JLabel lblFax;
	protected JTextField tfFax;
	protected JLabel lblWebSite;
	protected JTextField tfWebSite;
	protected JLabel lblSecurityAnswer;
	protected JLabel lblSecurityAnswerValue;
	protected JLabel lblSecurityQuestion;
	protected JComboBox<String> cbSecurityQuestion;
	protected JTextField tfSecurityAnswers;
	protected JLabel lblIban;
	protected JTextField tfIban;
	private JPanel panelTitle;
	protected JLabel lblTitle;
	private boolean succeeded;
	protected JButton btnCancel;
	
	public BoundaryPanelChangeProfileLandLord(JDialog dialog) {
		super(new BorderLayout());
		this.dialog = dialog;
       
		panelTitle = new JPanel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		panelTitle.setMaximumSize(new Dimension(screenSize.width, Styles.TITLE_SIZE_WELCOME));
        
		//Title
		lblTitle = new JLabel();
		lblTitle.setFont(new Font(Styles.TITLE_FONT_WELCOME, Styles.TITLE_STYLE_WELCOME, Styles.TITLE_SIZE_WELCOME));
		
		panelTitle.add(lblTitle);
		
        //Profile Panel
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
 

        //Fields Panel
        JPanel panelFields = new JPanel(new GridBagLayout());
        

        lblPhone = new JLabel();
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panelFields.add(lblPhone, cs);

        tfPhone = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panelFields.add(tfPhone, cs);

        lblTaxCode = new JLabel();
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panelFields.add(lblTaxCode, cs);
 
        tfTaxCode = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panelFields.add(tfTaxCode, cs);

        lblAddress = new JLabel();
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panelFields.add(lblAddress, cs);

        tfAddress = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panelFields.add(tfAddress, cs);

        lblFax = new JLabel();
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panelFields.add(lblFax, cs);
 
        tfFax = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panelFields.add(tfFax, cs);

        lblWebSite = new JLabel();
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 1;
        panelFields.add(lblWebSite, cs);
 
        tfWebSite = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 2;
        panelFields.add(tfWebSite, cs);
        
        lblIban = new JLabel();
        cs.gridx = 0;
        cs.gridy = 5;
        cs.gridwidth = 1;
        panelFields.add(lblIban, cs);
 
        tfIban = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 5;
        cs.gridwidth = 2;
        panelFields.add(tfIban, cs);
        
        lblSecurityQuestion = new JLabel();
        cs.gridx = 0;
        cs.gridy = 6;
        cs.gridwidth = 1;
        panelFields.add(lblSecurityQuestion, cs);
        
        cbSecurityQuestion = new JComboBox<String>();
        cs.gridx = 1;
        cs.gridy = 6;
        cs.gridwidth = 2;
        panelFields.add(cbSecurityQuestion, cs);
        
        lblSecurityAnswer = new JLabel();
        cs.gridx = 0;
        cs.gridy = 7;
        cs.gridwidth = 1;
        panelFields.add(lblSecurityAnswer, cs);
 
        tfSecurityAnswers = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 7;
        cs.gridwidth = 2;
        panelFields.add(tfSecurityAnswers, cs);

        panelFields.setBorder(new LineBorder(Color.GRAY));
        
        //Buttons
        btnConfirm = new JButton();
	    btnConfirm.addActionListener(new ButtonConfirmListener());
        btnReset = new JButton();      
	    btnReset.addActionListener(new ButtonResetListener());
        btnCancel = new JButton();      
        btnCancel.addActionListener(new ButtonCancelListener());
        
        JPanel panelButtons = new JPanel();
        panelButtons.add(btnConfirm);
        panelButtons.add(btnReset);
        panelButtons.add(btnCancel);
        
       
       this.add(panelFields,BorderLayout.WEST);
       this.add(panelButtons,BorderLayout.PAGE_END);
       this.add(panelTitle,BorderLayout.PAGE_START);
       
       
       //Escape key listener
       dialog.getRootPane().registerKeyboardAction(new EscapeKeyListener(), 
       		KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), 
       		JComponent.WHEN_IN_FOCUSED_WINDOW);
	}
	
	
	public String getPhone() {
		return tfPhone.getText().toString().trim();
	}
	

	public String getTaxCode() {
		return tfTaxCode.getText().toString().trim();
	}


	public String getAddress() {
		return tfAddress.getText().toString().trim();
	}


	public String getFax() {
		return tfFax.getText().toString().trim();
	}


	public String getWebSite() {
		return tfWebSite.getText().toString().trim();
	}


	public String getSecurityAnswers() {
		return tfSecurityAnswers.getText().toString().trim();
	}


	public String getIban() {
		return tfIban.getText().toString().trim();
	}
	
	public String getQuestion() {
		return cbSecurityQuestion.getSelectedItem().toString().trim();
	}
	
	public boolean isSucceeded(){
		return succeeded;
	}


	//Listeners
    private class EscapeKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
    	
    }
    
    private class ButtonConfirmListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				ChangeProfileLandLord.changeProfile(getPhone(), getTaxCode(), 
						getAddress(), getFax(), getWebSite(), 
						getQuestion(), getSecurityAnswers(), getIban());
				successfulChangeMessage();
				succeeded=true;
				dialog.dispose();
			} catch (ClassNotFoundException e) {
				fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
				succeeded=false;
			} catch(EmptyFieldException e2){
				emptyFieldErrorMessage();
				succeeded=false;
			} catch(IOException e3){
				fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
				succeeded=false;
			} catch(AlreadyRegisteredException e4){
				alreadyRegisteredErrorMessage();
				succeeded=false;
			} catch (FileException e) {
				fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
			} catch (UserNotFoundException e) {
				userNotFoundMessage();
			}
			
		}
    }
    
	private class ButtonResetListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				tfPhone.setText("");
				tfTaxCode.setText("");
				tfAddress.setText("");
				tfFax.setText("");
				tfWebSite.setText("");
				tfSecurityAnswers.setText("");
				tfIban.setText("");
			}
			
	}

    private class ButtonCancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
    }
    
    protected abstract void successfulChangeMessage();
    protected abstract void fileReadErrorMessage(String filename);
    protected abstract void emptyFieldErrorMessage();
    protected abstract void alreadyRegisteredErrorMessage();
	public abstract void userNotFoundMessage();
    
}
