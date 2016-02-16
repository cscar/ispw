package control.changepassword;

import java.io.IOException;

import entity.Session;
import entity.Tenant;
import entity.persistence.Save;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.PasswordMismatchException;
import exception.UserNotFoundException;

public class ChangePasswordTenant {

	public static void change(String password, String confirmPassword) throws EmptyFieldException,
			PasswordMismatchException, ClassNotFoundException, IOException, AlreadyRegisteredException, FileException, UserNotFoundException {
		if (password.equals("") || confirmPassword.equals("")) {
			throw new EmptyFieldException();
		}
		if (!password.equals(confirmPassword)) {
			throw new PasswordMismatchException();
		} else {

			Tenant tenant = (Tenant) Session.getSessionInstance().getCustomer();
			Save.getInstance().deleteUser(tenant.getEmail());
			tenant.setPassword(password);
			Save.getInstance().insertCustomer(tenant);
			Session.getSessionInstance().loginAsTenant(tenant);
		}
	}
}
