package boundary.tenant.changepassword;

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
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import control.changepassword.ChangePasswordTenant;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.PasswordMismatchException;
import exception.UserNotFoundException;

public abstract class BoundaryPanelChangePasswordTenant extends JPanel {
	private static final long serialVersionUID = 1L;

	private JDialog dialog;
	private JPasswordField pfPassword;
	protected JLabel lblPassword;
	protected JButton btnReset;
	boolean succeeded;
	private JPanel panelFields;
	protected JLabel lblPasswordConfirm;
	private JPasswordField pfPasswordConfirm;
	protected JButton btnConfirm;
	protected JButton btnCancel;

	public BoundaryPanelChangePasswordTenant(JDialog dialog) {
		super(new BorderLayout());
		this.dialog = dialog;

		// Fields
		panelFields = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;

		lblPassword = new JLabel();
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panelFields.add(lblPassword, cs);

		pfPassword = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panelFields.add(pfPassword, cs);

		lblPasswordConfirm = new JLabel();
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panelFields.add(lblPasswordConfirm, cs);

		pfPasswordConfirm = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panelFields.add(pfPasswordConfirm, cs);
		panelFields.setBorder(new LineBorder(Color.GRAY));

		// Buttons
		JPanel panelButtons = new JPanel();

		btnConfirm = new JButton();
		btnConfirm.addActionListener(new ButtonConfirmListener());
		panelButtons.add(btnConfirm);

		btnReset = new JButton();
		btnReset.addActionListener(new ButtonResetListener());
		panelButtons.add(btnReset);

		btnCancel = new JButton();
		btnCancel.addActionListener(new ButtonCancelListener());
		panelButtons.add(btnCancel);

		this.add(panelFields, BorderLayout.CENTER);
		this.add(panelButtons, BorderLayout.PAGE_END);

		// ESC key listener
		dialog.getRootPane().registerKeyboardAction(new EscapeKeyListener(),
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

		// ENTER key listener
		this.dialog.getRootPane().setDefaultButton(btnConfirm);
	}

	public String getPassword() {
		return new String(pfPasswordConfirm.getPassword());
	}

	public String getPasswordConfirm() {
		return new String(pfPassword.getPassword());
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	// Listeners
	private class EscapeKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
	}

	private class ButtonConfirmListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				ChangePasswordTenant.change(getPassword(), getPasswordConfirm());
				successfulRegistrationMessage();
				succeeded = true;
				dialog.dispose();
			} catch (ClassNotFoundException e) {
				fileReadErrorMessage();
				succeeded = false;
			} catch (EmptyFieldException e) {
				emptyFieldErrorMessage();
				succeeded = false;
			} catch (PasswordMismatchException e) {
				passwordMismatchMessage();
				succeeded = false;
			} catch (IOException e) {
				fileReadErrorMessage();
				succeeded = false;
			} catch (AlreadyRegisteredException e) {
				alreadyRegisteredMessage();
				succeeded = false;
			} catch (FileException e) {
				fileReadErrorMessage();
			} catch (UserNotFoundException e) {
				userNotFoundMessage();
			}
		}
	}

	private class ButtonResetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			pfPassword.setText("");
			pfPasswordConfirm.setText("");
		}
	}

	private class ButtonCancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
	}

	protected abstract void successfulRegistrationMessage();

	protected abstract void alreadyRegisteredMessage();

	protected abstract void fileReadErrorMessage();

	protected abstract void emptyFieldErrorMessage();

	protected abstract void passwordMismatchMessage();
	public abstract void userNotFoundMessage();
}
