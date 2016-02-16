package boundary.registration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import control.registration.RegistrationLandLord;
import control.registration.RegistrationTenant;
import entity.Filepaths;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.PasswordMismatchException;

public abstract class BoundaryPanelRegistration extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected JPasswordField pfPassword;
	protected JLabel lblPassword;
	protected JButton btnOK;
	protected JButton btnCancel;
	private boolean succeeded;
	JPanel selectionPanel;
	JPanel buttonsPanel;

	protected JRadioButton rdRegLandLord;
	protected JRadioButton rdRegTenant;
	protected ButtonGroup bgRegistration;
	protected JLabel lblFirstName;
	protected JTextField tfFirstName;
	protected JLabel lblLastName;
	protected JTextField tfLastName;
	protected JLabel lblEmail;
	protected JTextField tfEmail;
	protected JLabel lblBirthDate;
	protected JTextField tfBirthDate;
	protected JLabel lblBirthPlace;
	protected JTextField tfBirthPlace;
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
	protected JTextField tfSecurityAnswer;
	protected JLabel lblIban;
	protected JTextField tfIban;
	protected JPasswordField pfConfirmPassword;
	protected JLabel lblConfirmPassword;
	protected JLabel lblSecurityQuestion;
	protected JComboBox<String> cbSecurityQuestion;
	protected JCheckBox cbAcceptConditions;
	protected JScrollPane scrollPane;
	
	private JDialog dialog;
	protected JTextArea text;

	
	public BoundaryPanelRegistration(JDialog dialog) {
		super(new BorderLayout());
		this.dialog = dialog;
       
        JPanel panelRegistration = new JPanel(new GridBagLayout());
        
        //Tenant-LandLord Panel
        selectionPanel = new JPanel();
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        rdRegLandLord = new JRadioButton();
        rdRegLandLord.addActionListener(new RadioListener());
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        rdRegLandLord.setSelected(true);
        selectionPanel.add(rdRegLandLord, cs);
        
        rdRegTenant = new JRadioButton();
        rdRegTenant.addActionListener(new RadioListener());
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        selectionPanel.add(rdRegTenant, cs);

        bgRegistration = new ButtonGroup();
        bgRegistration.add(rdRegTenant);
        bgRegistration.add(rdRegLandLord);
        
        //Fields Panel
        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        fieldsPanel.setBorder(new LineBorder(Color.GRAY));
        
        lblFirstName = new JLabel();
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        fieldsPanel.add(lblFirstName, cs);
 
        tfFirstName = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        fieldsPanel.add(tfFirstName, cs);

        lblLastName = new JLabel();
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        fieldsPanel.add(lblLastName, cs);
 
        tfLastName = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        fieldsPanel.add(tfLastName, cs);
        
        lblEmail = new JLabel();
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        fieldsPanel.add(lblEmail, cs);
        
        tfEmail = new JTextField();
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        fieldsPanel.add(tfEmail, cs);
 
        lblPassword = new JLabel();
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        fieldsPanel.add(lblPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        fieldsPanel.add(pfPassword, cs);
 
        lblConfirmPassword = new JLabel();
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 1;
        fieldsPanel.add(lblConfirmPassword, cs);
 
        pfConfirmPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 2;
        fieldsPanel.add(pfConfirmPassword, cs);

        lblBirthDate = new JLabel();
        cs.gridx = 0;
        cs.gridy = 5;
        cs.gridwidth = 1;
        fieldsPanel.add(lblBirthDate, cs);

        tfBirthDate = new JFormattedTextField();
        cs.gridx = 1;
        cs.gridy = 5;
        cs.gridwidth = 2;
        fieldsPanel.add(tfBirthDate, cs);

        lblBirthPlace = new JLabel();
        cs.gridx = 0;
        cs.gridy = 6;
        cs.gridwidth = 1;
        fieldsPanel.add(lblBirthPlace, cs);
 
        tfBirthPlace = new JTextField();
        cs.gridx = 1;
        cs.gridy = 6;
        cs.gridwidth = 2;
        fieldsPanel.add(tfBirthPlace, cs);

        lblPhone = new JLabel();
        cs.gridx = 0;
        cs.gridy = 7;
        cs.gridwidth = 1;
        fieldsPanel.add(lblPhone, cs);

        tfPhone = new JFormattedTextField();
        cs.gridx = 1;
        cs.gridy = 7;
        cs.gridwidth = 2;
        fieldsPanel.add(tfPhone, cs);

        lblTaxCode = new JLabel();
        cs.gridx = 0;
        cs.gridy = 8;
        cs.gridwidth = 1;
        fieldsPanel.add(lblTaxCode, cs);
 
        tfTaxCode = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 8;
        cs.gridwidth = 2;
        fieldsPanel.add(tfTaxCode, cs);

        lblAddress = new JLabel();
        cs.gridx = 0;
        cs.gridy = 9;
        cs.gridwidth = 1;
        fieldsPanel.add(lblAddress, cs);

        tfAddress = new JFormattedTextField();
        cs.gridx = 1;
        cs.gridy = 9;
        cs.gridwidth = 2;
        fieldsPanel.add(tfAddress, cs);

        lblFax = new JLabel();
        cs.gridx = 0;
        cs.gridy = 10;
        cs.gridwidth = 1;
        fieldsPanel.add(lblFax, cs);
 
        tfFax = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 10;
        cs.gridwidth = 2;
        fieldsPanel.add(tfFax, cs);

        lblWebSite = new JLabel();
        cs.gridx = 0;
        cs.gridy = 11;
        cs.gridwidth = 1;
        fieldsPanel.add(lblWebSite, cs);
 
        tfWebSite = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 11;
        cs.gridwidth = 2;
        fieldsPanel.add(tfWebSite, cs);
        
        lblSecurityQuestion = new JLabel();
        cs.gridx = 0;
        cs.gridy = 12;
        cs.gridwidth = 1;
        fieldsPanel.add(lblSecurityQuestion, cs);
        
        cbSecurityQuestion = new JComboBox<String>();
        cs.gridx = 1;
        cs.gridy = 12;
        cs.gridwidth = 2;
        fieldsPanel.add(cbSecurityQuestion, cs);
        
        lblSecurityAnswer = new JLabel();
        cs.gridx = 0;
        cs.gridy = 13;
        cs.gridwidth = 1;
        fieldsPanel.add(lblSecurityAnswer, cs);
 
        tfSecurityAnswer = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 13;
        cs.gridwidth = 2;
        fieldsPanel.add(tfSecurityAnswer, cs);

        lblIban = new JLabel();
        cs.gridx = 0;
        cs.gridy = 14;
        cs.gridwidth = 1;
        fieldsPanel.add(lblIban, cs);
 
        tfIban = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 14;
        cs.gridwidth = 2;
        fieldsPanel.add(tfIban, cs);
        
        //Buttons
        btnOK = new JButton();
        btnOK.addActionListener(new ButtonRegistrationListener());
        btnCancel = new JButton();
        btnCancel.addActionListener(new ButtonCancelListener());
        
        //Buttons Panel
        buttonsPanel = new JPanel();
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnCancel);
        
        cs.fill = GridBagConstraints.VERTICAL;
        cs.gridx = 0;
        cs.gridy = 0;
        panelRegistration.add(selectionPanel, cs);
        cs.gridx = 0;
        cs.gridy = 1;
        panelRegistration.add(fieldsPanel,  cs);
        
        //Conditions
        text = new JTextArea(22, 22);
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setEditable(false);
        
        scrollPane = new JScrollPane(text);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //CheckBox Accept conditions
        cbAcceptConditions = new JCheckBox();
        
        //Conditions Panel
        JPanel conditionsPanel = new JPanel(new GridBagLayout()); 
        
        cs.fill = GridBagConstraints.VERTICAL;
        cs.gridx = 0;
        cs.gridy = 0;
        conditionsPanel.add(scrollPane, cs);
        cs.gridx = 0;
        cs.gridy = 1;
        conditionsPanel.add(cbAcceptConditions, cs);

        this.add(panelRegistration, BorderLayout.WEST);
        this.add(conditionsPanel, BorderLayout.EAST);
        this.add(buttonsPanel, BorderLayout.PAGE_END);
        
        //ENTER key listener
        dialog.getRootPane().setDefaultButton(btnOK);
      
        //ESC key listener
        dialog.getRootPane().registerKeyboardAction(new EscapeKeyListener(), 
        		KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), 
        		JComponent.WHEN_IN_FOCUSED_WINDOW);
	}
	
	public String getName() {
        return tfFirstName.getText().trim();
    }
 
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
 
    public String getConfirmPassword() {
        return new String(pfConfirmPassword.getPassword());
    }

	public String getSurname() {
		return tfLastName.getText().trim();
	}

	public String getEmail() {
		return tfEmail.getText().trim();
	}

	public String getBirthDate() {
		return tfBirthDate.getText().trim();
	}

	public String getBirthPlace() {
		return tfBirthPlace.getText().trim();
	}

	public String getPhone() {
		return tfPhone.getText().trim();
	}

	public String getTaxCode() {
		return tfTaxCode.getText().trim();
	}

	public String getAddress() {
		return tfAddress.getText().trim();
	}

	public String getFax() {
		return tfFax.getText().trim();
	}

	public String getWebSite() {
		return tfWebSite.getText().trim();
	}

	public String getSecurityQuestion() {
		return cbSecurityQuestion.getSelectedItem().toString().trim();
	}
	
	public String getSecurityAnswer() {
		return tfSecurityAnswer.getText().trim();
	}

	public String getIban() {
		return tfIban.getText().trim();
	}

	public boolean isSucceeded() {
        return succeeded;
    }
	
	//Listeners
    private class EscapeKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
    	
    }
    
    private class RadioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (rdRegTenant.isSelected()) {
				lblIban.setEnabled(false);
				tfIban.setEnabled(false);				
			}
			else {
				lblIban.setEnabled(true);
				tfIban.setEnabled(true);				
			}
		}
    	
    }
    
    private class ButtonRegistrationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!cbAcceptConditions.isSelected()) {
				conditionsMessage();
			}
				
			else {
				if (rdRegTenant.isSelected()) {
					//If registration as Tenant
					try {
						//Try to create a new Tenant
						RegistrationTenant.registerUser(getName(), 
								getSurname(), getPassword(), getConfirmPassword(), 
								getEmail(), getAddress(), getPhone(), getBirthDate(), 
								getBirthPlace(), getTaxCode(), getFax(), 
								getWebSite(), getSecurityQuestion(), getSecurityAnswer());					
						successfulLoginMessage();
						succeeded = true;
						dialog.dispose();
					} catch (PasswordMismatchException e1) {
						passwordMismatchMessage();
						succeeded = false;
						pfPassword.setText("");
						pfConfirmPassword.setText("");
					} catch(IOException e2) {
						fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
						succeeded = false;
					} catch(EmptyFieldException e3) {
						emptyFieldErrorMessage();
						succeeded = false;				
					} catch (ClassNotFoundException e1) {
						fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
						succeeded = false;
					} catch (AlreadyRegisteredException e1) {
						alreadyRegisteredErrorMessage();
						succeeded = false;
						pfPassword.setText("");
						pfConfirmPassword.setText("");
					} catch (FileException e1) {
						fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
					}
				} else {
					//Registration as LandLord
					try {
						//Try to create a new LandLord
						RegistrationLandLord.registerUser(getName(), 
								getSurname(), getPassword(), getConfirmPassword(), 
								getEmail(), getAddress(), getPhone(), getBirthDate(), 
								getBirthPlace(), getTaxCode(), getFax(), getWebSite(), 
								getSecurityQuestion(), getSecurityAnswer(), getIban());
						successfulLoginMessage();
						succeeded = true;
						dialog.dispose();
					} catch (PasswordMismatchException e1) {
						passwordMismatchMessage();
						succeeded = false;
						pfPassword.setText("");
						pfConfirmPassword.setText("");
					} catch(IOException e2) {
						fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
						succeeded = false;
					} catch(EmptyFieldException e3) {
						emptyFieldErrorMessage();
						succeeded = false;				
					} catch (ClassNotFoundException e1) {
						fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
						succeeded = false;
					} catch (AlreadyRegisteredException e1) {
						alreadyRegisteredErrorMessage();
						succeeded = false;
						pfPassword.setText("");
						pfConfirmPassword.setText("");
					} catch (FileException e1) {
						fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
					}
				}
			}
		}
    }
    
    private class ButtonCancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
    	
    }
    
    protected abstract void conditionsMessage();
    protected abstract void successfulLoginMessage();
    protected abstract void passwordMismatchMessage();
    protected abstract void fileReadErrorMessage(String filename);
    protected abstract void emptyFieldErrorMessage();
    protected abstract void alreadyRegisteredErrorMessage();
}
