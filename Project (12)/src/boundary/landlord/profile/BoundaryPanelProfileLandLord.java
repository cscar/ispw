package boundary.landlord.profile;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.KeyStroke;

import boundary.landlord.changepassword.BoundaryChangePasswordLandLordDialog;
import boundary.landlord.changeprofile.BoundaryChangeProfileLandLordDialog;
import entity.SingletonFrame;
import entity.Styles;

public class BoundaryPanelProfileLandLord extends JPanel {

private static final long serialVersionUID = 1L;
	
	protected JPasswordField pfPassword;
	protected JLabel lblPassword;
	protected JButton btnModifyProfile;
	protected JButton btnModifyPassword;	
	protected ButtonGroup bgRegistration;
	protected JLabel lblFirstName;
	protected JLabel lblFirstNameValue;
	protected JLabel lblLastName;
	protected JLabel lblLastNameValue;
	protected JLabel lblEmail;
	protected JLabel lblEmailValue;
	protected JLabel lblBirthDate;
	protected JLabel lblBirthDateValue;
	protected JLabel lblBirthPlace;
	protected JLabel lblBirthPlaceValue;
	protected JLabel lblPhone;
	protected JLabel lblPhoneValue;
	protected JLabel lblTaxCode;
	protected JLabel lblTaxCodeValue;
	protected JLabel lblAddress;
	protected JLabel lblAddressValue;
	protected JLabel lblFax;
	protected JLabel lblFaxValue;
	protected JLabel lblWebSite;
	protected JLabel lblWebSiteValue;
	protected JLabel lblSecurityAnswer;
	protected JLabel lblSecurityAnswerValue;
	protected JLabel lblIban;
	protected JLabel lblIbanValue;
	private JPanel panelTitle;
	protected JLabel lblTitle;

	
	private JDialog dialog;
	
	
	public BoundaryPanelProfileLandLord(JDialog dialog) {
		super(new BorderLayout());
		this.dialog = dialog;
       
		//Get screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
        
		//Title		
		panelTitle = new JPanel();
		panelTitle.setMaximumSize(new Dimension(screenSize.width, Styles.TITLE_SIZE_WELCOME));
		lblTitle = new JLabel();
		lblTitle.setFont(new Font(Styles.TITLE_FONT_WELCOME, Styles.TITLE_STYLE_WELCOME, Styles.TITLE_SIZE_WELCOME));
		panelTitle.add(lblTitle);
		
		
        //Profile Panel
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;

        //Fields Panel
        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        
        lblFirstName = new JLabel();
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        fieldsPanel.add(lblFirstName, cs);
 
        lblFirstNameValue = new JLabel();
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        fieldsPanel.add(lblFirstNameValue, cs);

        lblLastName = new JLabel();
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        fieldsPanel.add(lblLastName, cs);
 
        lblLastNameValue = new JLabel();
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        fieldsPanel.add(lblLastNameValue, cs);
        
        lblEmail = new JLabel();
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        fieldsPanel.add(lblEmail, cs);
        
        lblEmailValue = new JLabel();
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        fieldsPanel.add(lblEmailValue, cs);
 
     
        lblBirthDate = new JLabel();
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        fieldsPanel.add(lblBirthDate, cs);

        lblBirthDateValue = new JLabel();
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        fieldsPanel.add(lblBirthDateValue, cs);

        lblBirthPlace = new JLabel();
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 1;
        fieldsPanel.add(lblBirthPlace, cs);
 
        lblBirthPlaceValue = new JLabel();
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 2;
        fieldsPanel.add(lblBirthPlaceValue, cs);

        lblPhone = new JLabel();
        cs.gridx = 0;
        cs.gridy = 5;
        cs.gridwidth = 1;
        fieldsPanel.add(lblPhone, cs);

        lblPhoneValue = new JLabel();
        cs.gridx = 1;
        cs.gridy = 5;
        cs.gridwidth = 2;
        fieldsPanel.add(lblPhoneValue, cs);

        lblTaxCode = new JLabel();
        cs.gridx = 0;
        cs.gridy = 6;
        cs.gridwidth = 1;
        fieldsPanel.add(lblTaxCode, cs);
 
        lblTaxCodeValue = new JLabel();
        cs.gridx = 1;
        cs.gridy = 6;
        cs.gridwidth = 2;
        fieldsPanel.add(lblTaxCodeValue, cs);

        lblAddress = new JLabel();
        cs.gridx = 0;
        cs.gridy = 7;
        cs.gridwidth = 1;
        fieldsPanel.add(lblAddress, cs);

        lblAddressValue = new JLabel();
        cs.gridx = 1;
        cs.gridy = 7;
        cs.gridwidth = 2;
        fieldsPanel.add(lblAddressValue, cs);

        lblFax = new JLabel();
        cs.gridx = 0;
        cs.gridy = 8;
        cs.gridwidth = 1;
        fieldsPanel.add(lblFax, cs);
 
        lblFaxValue = new JLabel();
        cs.gridx = 1;
        cs.gridy = 8;
        cs.gridwidth = 2;
        fieldsPanel.add(lblFaxValue, cs);

        lblWebSite = new JLabel();
        cs.gridx = 0;
        cs.gridy = 9;
        cs.gridwidth = 1;
        fieldsPanel.add(lblWebSite, cs);
 
        lblWebSiteValue = new JLabel();
        cs.gridx = 1;
        cs.gridy = 9;
        cs.gridwidth = 2;
        fieldsPanel.add(lblWebSiteValue, cs);

        lblIban = new JLabel();
        cs.gridx = 0;
        cs.gridy = 10;
        cs.gridwidth = 1;
        fieldsPanel.add(lblIban, cs);
 
        lblIbanValue = new JLabel();
        cs.gridx = 1;
        cs.gridy = 10;
        cs.gridwidth = 2;
        fieldsPanel.add(lblIbanValue, cs);

        
        //Buttons
        btnModifyProfile = new JButton();
        btnModifyProfile.addActionListener(new ButtonModifyProfileListener());

        btnModifyPassword = new JButton();
        btnModifyPassword.addActionListener(new ButtonModifyPasswordListener());
        
        //Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btnModifyProfile);
        buttonsPanel.add(btnModifyPassword);
        
        
       this.add(fieldsPanel,BorderLayout.CENTER);
       this.add(buttonsPanel,BorderLayout.PAGE_END);
       this.add(panelTitle,BorderLayout.PAGE_START);
       
       
       //ENTER key listener
       dialog.getRootPane().setDefaultButton(btnModifyProfile);
     
       //ESC key listener
       EscapeKeyListener escListener = new EscapeKeyListener();
       dialog.getRootPane().registerKeyboardAction(escListener, 
       		KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), 
       		JComponent.WHEN_IN_FOCUSED_WINDOW);
	
} 
	
	
	//Listeners
    private class EscapeKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
    	
    }	
    
    private class ButtonModifyProfileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			BoundaryChangeProfileLandLordDialog modifyProfileDialog = new BoundaryChangeProfileLandLordDialog(SingletonFrame.getFrameInstance().getFrame());
			modifyProfileDialog.setVisible(true);
			if (modifyProfileDialog.isSucceeded()){
				dialog.dispose();
			}
		}
	}
    
    private class ButtonModifyPasswordListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			BoundaryChangePasswordLandLordDialog modifyPasswordDialog = new BoundaryChangePasswordLandLordDialog(SingletonFrame.getFrameInstance().getFrame());
			modifyPasswordDialog.setVisible(true);
			if(modifyPasswordDialog.isSucceeded()){
				dialog.dispose();
			}
		}
    }	
}
