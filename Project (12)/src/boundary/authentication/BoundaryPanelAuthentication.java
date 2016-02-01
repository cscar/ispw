package boundary.authentication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import control.Login;
import exception.EmptyFieldException;
import exception.UserNotFoundException;

public abstract class BoundaryPanelAuthentication extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JDialog dialog;
    JPasswordField pfPassword;
    protected JLabel lblPassword;
    protected JButton btnCancel;
    boolean succeeded;
    JPanel fieldsPanel;
    JPanel bp;
	protected JLabel lblEmail;
	JTextField tfEmail;
	protected JButton btnAuthentication;
	
	public BoundaryPanelAuthentication(JDialog dialog) {
		super(new BorderLayout());
    	this.dialog = dialog;
    	
        //Fields
    	fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        lblEmail = new JLabel();
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        fieldsPanel.add(lblEmail, cs);
 
        tfEmail = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        fieldsPanel.add(tfEmail, cs);
 
        lblPassword = new JLabel();
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        fieldsPanel.add(lblPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        fieldsPanel.add(pfPassword, cs);
        fieldsPanel.setBorder(new LineBorder(Color.GRAY));

        
        //Buttons
        btnAuthentication = new JButton();
        btnAuthentication.addActionListener(new ButtonAuthenticationListener());
        
        btnCancel = new JButton();
        btnCancel.addActionListener(new ButtonCancelListener());
        
        //Panel Buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btnAuthentication);
        buttonsPanel.add(btnCancel);
        
        this.add(fieldsPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.PAGE_END);
        
        //Escape key listener
        dialog.getRootPane().registerKeyboardAction(new EscapeKeyListener(), 
        		KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), 
        		JComponent.WHEN_IN_FOCUSED_WINDOW);

        //Enter key listener
        this.dialog.getRootPane().setDefaultButton(btnAuthentication);
	}
	
	public String getEmail() {
        return tfEmail.getText().trim();
    }
 
    public String getPassword() {
        return new String(pfPassword.getPassword());
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
    
    private class ButtonAuthenticationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
            try {
            	Login.authenticate(getEmail(), getPassword());
				succeeded = true;
				dialog.dispose();
			} catch (ClassNotFoundException | IOException e1) {
				fileReadErrorMessage();
			} catch (EmptyFieldException e2) {
				emptyFieldMessage();
			} catch (UserNotFoundException e3) {
			    invalidAuthenticationMessage();
			    succeeded = false;
			    //Reset email and password
			    tfEmail.setText("");
			    pfPassword.setText("");
			}
		}
    }
    
    private class ButtonCancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
    	
    }
    
    protected abstract void invalidAuthenticationMessage();
    
    protected abstract void fileReadErrorMessage();
    
    protected abstract void emptyFieldMessage();
}
