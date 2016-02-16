package control.changepassword;

import java.io.IOException;

import entity.LandLord;
import entity.Session;
import entity.persistence.Save;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.PasswordMismatchException;
import exception.UserNotFoundException;

public class ChangePasswordLandLord {

	public static void change(String password, String confirmPassword) throws EmptyFieldException,
			PasswordMismatchException, ClassNotFoundException, IOException, AlreadyRegisteredException, FileException, UserNotFoundException {
		if (password.equals("") || confirmPassword.equals("")) {
			throw new EmptyFieldException();
		}
		if (!password.equals(confirmPassword)) {
			throw new PasswordMismatchException();
		} else {
			LandLord landlord = (LandLord) Session.getSessionInstance().getCustomer();
			Save.getInstance().deleteUser(landlord.getEmail());
			landlord.setPassword(password);
			Save.getInstance().insertCustomer(landlord);
			Session.getSessionInstance().loginAsLandLord(landlord);
		}
	}
}
