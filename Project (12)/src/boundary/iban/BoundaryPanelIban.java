package boundary.iban;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import control.registration.RegistrationTenantAsLandLord;
import entity.Filepaths;
import entity.Session;
import entity.Tenant;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.UnexpectedException;
import exception.UserNotFoundException;

public abstract class BoundaryPanelIban extends JPanel {
	private static final long serialVersionUID = 1L;

	protected JButton btnCancel;
	boolean succeeded;
	protected JLabel lblIban;
	protected JTextField tfIban;
	protected JButton btnConfirm;
	private JDialog dialog;

	private JPanel fieldsPanel;

	public BoundaryPanelIban(JDialog dialog) {
		super(new BorderLayout());
		this.dialog = dialog;

		// Fields
		fieldsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;

		lblIban = new JLabel();
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		fieldsPanel.add(lblIban, cs);

		tfIban = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		fieldsPanel.add(tfIban, cs);

		// Buttons
		btnConfirm = new JButton();
		btnConfirm.addActionListener(new ButtonConfirmListener());

		btnCancel = new JButton();
		btnCancel.addActionListener(new ButtonCancelListener());

		JPanel panelButtons = new JPanel();
		panelButtons.add(btnConfirm);
		panelButtons.add(btnCancel);

		this.add(fieldsPanel, BorderLayout.CENTER);
		this.add(panelButtons, BorderLayout.PAGE_END);

		// ESC key listener
		dialog.getRootPane().registerKeyboardAction(new EscapeKeyListener(),
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

		// ENTER key listener
		this.dialog.getRootPane().setDefaultButton(btnConfirm);

	}

	public String getIban() {
		return tfIban.getText().toString().trim();
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	private class EscapeKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
	}

	private class ButtonCancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			tfIban.setText("");
		}
	}

	private class ButtonConfirmListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Tenant tenant = (Tenant) Session.getSessionInstance().getCustomer();
				RegistrationTenantAsLandLord.registerTenantAsLandLord(tenant, getIban());
				succeeded = true;
				succeededMessage();
				dialog.dispose();
			} catch (ClassNotFoundException e1) {
				fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
				succeeded = false;
			} catch (EmptyFieldException e1) {
				emptyFieldError();
				succeeded = false;
			} catch (IOException e1) {
				fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
				succeeded = false;
			} catch (AlreadyRegisteredException e1) {
				alreadyRegisteredUser();
			} catch (UnexpectedException e1) {
				errorMessage();
				succeeded = false;
			} catch (FileException e1) {
				fileReadErrorMessage(Filepaths.USERS_DATABASE_FILENAME);
			} catch (UserNotFoundException e1) {
				userNotFoundMessage();
			}

		}

	}

	protected abstract void emptyFieldError();

	protected abstract void errorMessage(); // System's error

	protected abstract void alreadyRegisteredUser();

	protected abstract void fileReadErrorMessage(String filename);

	protected abstract void succeededMessage();

	public abstract void userNotFoundMessage();

}
