package boundary.administrator;

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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import control.registration.RegistrationAdministrator;
import control.registration.RegistrationScout;
import entity.Styles;
import entity.strings.StringsEnglish;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.PasswordMismatchException;

public abstract class BoundaryPanelAdministrator extends JPanel {

private static final long serialVersionUID = 1L;
	
	private JDialog dialog;
    private JPanel panelFieldsAdministrator;
    private JPanel panelFieldsScout;
    private JPanel panelAdministrator;
    private JPanel panelScout;
	protected JLabel lblTitle;
	private JPasswordField pfPasswordAdministrator;
	private JPasswordField pfPasswordScout;
    protected JLabel lblPasswordAdministrator;
    protected JLabel lblPasswordScout;
    private JPasswordField pfConfirmPasswordAdministrator;
    private JPasswordField pfConfirmPasswordScout;
    protected JLabel lblConfirmPasswordAdministrator;
    protected JLabel lblConfirmPasswordScout;
    protected JButton btnResetAdministrator;
    protected JButton btnResetScout;
	protected JLabel lblEmailAdministrator;
	protected JLabel lblEmailScout;
	private JTextField tfEmailAdministrator;
	private JTextField tfEmailScout;
	protected JButton btnAddAdministrator;
	protected JButton btnAddScout;
	protected TitledBorder titledBorderAdministrator;
	protected TitledBorder titledBorderScout;
	
	public BoundaryPanelAdministrator(JDialog dialog) {
		super(new BorderLayout());
    	this.dialog = dialog;
		
		//Title
    	JPanel panelTitle = new JPanel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		panelTitle.setMaximumSize(new Dimension(screenSize.width, Styles.TITLE_SIZE_WELCOME));

		lblTitle = new JLabel();
		lblTitle.setFont(new Font(Styles.TITLE_FONT_WELCOME, Styles.TITLE_STYLE_WELCOME, Styles.TITLE_SIZE_WELCOME));
		
		panelTitle.add(lblTitle);
    	
        //Administrator Fields
    	panelFieldsAdministrator = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        lblEmailAdministrator = new JLabel();
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panelFieldsAdministrator.add(lblEmailAdministrator, cs);
 
        tfEmailAdministrator = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panelFieldsAdministrator.add(tfEmailAdministrator, cs);
 
        lblPasswordAdministrator = new JLabel();
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panelFieldsAdministrator.add(lblPasswordAdministrator, cs);
 
        pfPasswordAdministrator = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panelFieldsAdministrator.add(pfPasswordAdministrator, cs);
        
        lblConfirmPasswordAdministrator=new JLabel();
        cs.gridx=0;
        cs.gridy=2;
        cs.gridwidth=1;
        panelFieldsAdministrator.add(lblConfirmPasswordAdministrator,cs);
        
        pfConfirmPasswordAdministrator=new JPasswordField(20);
        cs.gridx=1;
        cs.gridy=2;
        cs.gridwidth=2;
        panelFieldsAdministrator.add(pfConfirmPasswordAdministrator,cs);
        panelFieldsAdministrator.setBorder(new LineBorder(Color.GRAY));
        
        //Administrator Buttons
        btnAddAdministrator = new JButton();
        btnAddAdministrator.addActionListener(new ButtonAddAdministratorListener());
        btnResetAdministrator = new JButton();
        btnResetAdministrator.addActionListener(new ButtonResetAdministratorListener());
        
        JPanel panelButtonsAdministrator = new JPanel();
        panelButtonsAdministrator.add(btnAddAdministrator);
        panelButtonsAdministrator.add(btnResetAdministrator);
        
        panelAdministrator=new JPanel(new BorderLayout());
        
        panelAdministrator.add(panelFieldsAdministrator, BorderLayout.CENTER);
        panelAdministrator.add(panelButtonsAdministrator, BorderLayout.PAGE_END);
        titledBorderAdministrator=BorderFactory.createTitledBorder(StringsEnglish.STR_ADD_ADMINISTRATOR);
        panelAdministrator.setBorder(titledBorderAdministrator);
 
        
        //Scout Fields
    	panelFieldsScout = new JPanel(new GridBagLayout());
        GridBagConstraints css = new GridBagConstraints();
        css.fill = GridBagConstraints.HORIZONTAL;
        
        lblEmailScout = new JLabel();
        css.gridx = 0;
        css.gridy = 0;
        css.gridwidth = 1;
        panelFieldsScout.add(lblEmailScout, css);
 
        tfEmailScout = new JTextField(20);
        css.gridx = 1;
        css.gridy = 0;
        css.gridwidth = 2;
        panelFieldsScout.add(tfEmailScout, css);
 
        lblPasswordScout = new JLabel();
        css.gridx = 0;
        css.gridy = 1;
        css.gridwidth = 1;
        panelFieldsScout.add(lblPasswordScout, css);
 
        pfPasswordScout = new JPasswordField(20);
        css.gridx = 1;
        css.gridy = 1;
        css.gridwidth = 2;
        panelFieldsScout.add(pfPasswordScout, css);
        
        lblConfirmPasswordScout=new JLabel();
        css.gridx=0;
        css.gridy=2;
        css.gridwidth=1;
        panelFieldsScout.add(lblConfirmPasswordScout,css);
        
        pfConfirmPasswordScout=new JPasswordField(20);
        css.gridx=1;
        css.gridy=2;
        css.gridwidth=2;
        panelFieldsScout.add(pfConfirmPasswordScout,css);
        panelFieldsScout.setBorder(new LineBorder(Color.GRAY));
        
        
        //Scout Buttons
        btnAddScout = new JButton();
        btnAddScout.addActionListener(new ButtonAddScoutListener());
        btnResetScout = new JButton();
        btnResetScout.addActionListener(new ButtonResetScoutListener());
        
        JPanel panelButtonsScout = new JPanel();
        panelButtonsScout.add(btnAddScout);
        panelButtonsScout.add(btnResetScout);
        
        panelScout=new JPanel(new BorderLayout());
        
        panelScout.add(panelFieldsScout, BorderLayout.CENTER);
        panelScout.add(panelButtonsScout, BorderLayout.PAGE_END);
        titledBorderScout=BorderFactory.createTitledBorder(StringsEnglish.STR_ADD_SCOUT);
        panelScout.setBorder(titledBorderScout);
        
        this.add(panelAdministrator,BorderLayout.WEST);
        this.add(panelScout,BorderLayout.EAST);
        this.add(panelTitle,BorderLayout.PAGE_START);
        
        //ESC key listener
        dialog.getRootPane().registerKeyboardAction(new EscapeKeyListener(), 
        		KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), 
        		JComponent.WHEN_IN_FOCUSED_WINDOW);
	}
	
	public String getEmailAdministrator() {
        return tfEmailAdministrator.getText().trim();
    }
 
    public String getPasswordAdministrator() {
        return new String(pfPasswordAdministrator.getPassword());
    }
    
    public String getConfirmPasswordAdministrator(){
    	return new String(pfConfirmPasswordAdministrator.getPassword());
    }
    
    public String getEmailScout() {
        return tfEmailScout.getText().trim();
    }
 
    public String getPasswordScout() {
        return new String(pfPasswordScout.getPassword());
    }
    
    public String getConfirmPasswordScout(){
    	return new String(pfConfirmPasswordScout.getPassword());
    }

    //Listeners
    private class EscapeKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
    }
    
    private class ButtonAddAdministratorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
            try {
				 RegistrationAdministrator.registerAdministrator(getPasswordAdministrator(), 
						 getConfirmPasswordAdministrator(), 
						 getEmailAdministrator());
				    successfulRegistrationMessage();
				    //Reset email and password
				    tfEmailAdministrator.setText("");
				    pfPasswordAdministrator.setText("");
				    pfConfirmPasswordAdministrator.setText("");
			} catch (ClassNotFoundException | IOException e1) {
				fileReadErrorMessage();
			    //Reset email and password
			    tfEmailAdministrator.setText("");
			    pfPasswordAdministrator.setText("");
			    pfConfirmPasswordAdministrator.setText("");
			} catch (EmptyFieldException e2) {
				emptyFieldErrorMessage();
			} catch (PasswordMismatchException e3){
				 passwordMismatchMessage();
			    //Reset email and password
			    tfEmailAdministrator.setText("");
			    pfPasswordAdministrator.setText("");
			    pfConfirmPasswordAdministrator.setText("");
			} catch (AlreadyRegisteredException e4) {
				alreadyRegisteredMessage();
			} catch (FileException e5) {
				fileReadErrorMessage();
			}
		}
    }
    
    private class ButtonAddScoutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
            try {
				 RegistrationScout.registerScout(getPasswordScout(),
						 getConfirmPasswordScout(),
						 getEmailScout());
				    successfulRegistrationMessage();
				    //Reset email and password
				    tfEmailScout.setText("");
				    pfPasswordScout.setText("");
				    pfConfirmPasswordScout.setText("");
			} catch (ClassNotFoundException | IOException e1) {
				fileReadErrorMessage();
			    //Reset email and password
			    tfEmailScout.setText("");
			    pfPasswordScout.setText("");
			    pfConfirmPasswordScout.setText("");
			} catch (EmptyFieldException e2) {
				emptyFieldErrorMessage();
			} catch (PasswordMismatchException e3){
				passwordMismatchMessage();
			    //Reset email and password
			    tfEmailScout.setText("");
			    pfPasswordScout.setText("");
			    pfConfirmPasswordScout.setText("");
			} catch (AlreadyRegisteredException e4) {
				alreadyRegisteredMessage();
			} catch (FileException e5) {
				fileReadErrorMessage();
			}
		}
    }
    
    private class ButtonResetAdministratorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			tfEmailAdministrator.setText("");
			pfPasswordAdministrator.setText("");
			pfConfirmPasswordAdministrator.setText("");
		}
    }
    
    private class ButtonResetScoutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			tfEmailScout.setText("");
			pfPasswordScout.setText("");
			pfConfirmPasswordScout.setText("");
		}
    }
    
    protected abstract void successfulRegistrationMessage();
    
    protected abstract void passwordMismatchMessage();
    
    protected abstract void fileReadErrorMessage();
    
    protected abstract void emptyFieldErrorMessage();
    
    protected abstract void alreadyRegisteredMessage();
}