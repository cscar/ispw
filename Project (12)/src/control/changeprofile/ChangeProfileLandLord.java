package control.changeprofile;

import java.io.IOException;

import entity.LandLord;
import entity.Session;
import entity.persistence.Save;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.UserNotFoundException;

public class ChangeProfileLandLord {

	public static void changeProfile(String phone, String tax, String address, String fax, String website,
			String securityQuestion, String securityAnswer, String iban)
					throws EmptyFieldException, ClassNotFoundException, IOException, AlreadyRegisteredException, FileException, UserNotFoundException {

		if (phone.equals("") && tax.equals("") && address.equals("") && fax.equals("") && website.equals("")
				&& securityAnswer.equals("") && iban.equals("")) {
			throw new EmptyFieldException();

		} else {
			String myPhone;
			String myTaxCode;
			String myAddress;
			String myFax;
			String myWebsite;
			String mySecurityAnswer;
			String myIban;
			String mySecurityQuestion;

			LandLord landlord = (LandLord) Session.getSessionInstance().getCustomer();

			if (phone.equals("")) {
				myPhone = landlord.getPhone();
			} else {
				myPhone = phone;
			}
			if (tax.equals("")) {
				myTaxCode = landlord.getTaxCode();
			} else {
				myTaxCode = tax;
			}
			if (address.equals("")) {
				myAddress = landlord.getAddress();
			} else {
				myAddress = address;
			}
			if (fax.equals("")) {
				myFax = landlord.getFax();
			} else {
				myFax = fax;
			}
			if (website.equals("")) {
				myWebsite = landlord.getWebsite();
			} else {
				myWebsite = website;

			}
			if (securityAnswer.equals("")) {
				mySecurityAnswer = landlord.getSecurityAnswer();
				mySecurityQuestion = landlord.getSecurityQuestion();
			} else {
				mySecurityAnswer = securityAnswer;
				mySecurityQuestion = securityQuestion;
			}
			if (iban.equals("")) {
				myIban = landlord.getIban();
			} else {
				myIban = iban;
			}

			Save.getInstance().deleteUser(landlord.getEmail());
			landlord.setAddress(myAddress);
			landlord.setTaxCode(myTaxCode);
			landlord.setPhone(myPhone);
			landlord.setWebsite(myWebsite);
			landlord.setWebsite(myFax);
			landlord.setSecurityQuestion(mySecurityQuestion);
			landlord.setSecurityAnswer(mySecurityAnswer);
			landlord.setIban(myIban);
			Save.getInstance().insertCustomer(landlord);
			Session.getSessionInstance().loginAsLandLord(landlord);
		}
	}
}
