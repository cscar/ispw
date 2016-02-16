package control.registration;

import java.io.IOException;

import entity.LandLord;
import entity.persistence.Save;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.PasswordMismatchException;

public class RegistrationLandLord {

	public static void registerUser(String firstName, String lastName, String password, String confirmPassword, String email,
			String address, String phone, String birthDate, String birthPlace, String taxCode, String fax, String website, String securityQuestion,
			String securityAnswer, String iban) throws EmptyFieldException, PasswordMismatchException, IOException,
					AlreadyRegisteredException, ClassNotFoundException, FileException {

		if (firstName.equals("") || lastName.equals("") || password.equals("") || confirmPassword.equals("")
				|| email.equals("") || address.equals("") || phone.equals("") || birthDate.equals("") || birthPlace.equals("")
				|| taxCode.equals("") || fax.equals("") || website.equals("") || securityQuestion.equals("") || securityAnswer.equals("")
				|| iban.equals("")) {
			// At least an empty field
			throw new EmptyFieldException();
		} else {
			// All fields have been filled
			if (!password.equals(confirmPassword)) {
				// Password and ConfirmPassword don't match
				throw new PasswordMismatchException();
			} else {
				LandLord landLord = new LandLord(firstName, lastName, password, email, address, phone, birthDate, birthPlace, taxCode, fax,
						website, securityQuestion, securityAnswer, iban);
				Save.getInstance().insertCustomer(landLord);
			}
		}
	}
}
