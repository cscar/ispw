package control.changeprofile;

import java.io.IOException;

import entity.Session;
import entity.Tenant;
import entity.persistence.Save;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.UserNotFoundException;

public class ChangeProfileTenant {

	public static void changeProfile(String phone, String tax, String address, String fax, String website,
			String securityQuestion, String securityAnswer)
					throws EmptyFieldException, ClassNotFoundException, IOException, AlreadyRegisteredException, FileException, UserNotFoundException {

		if (phone.equals("") && tax.equals("") && address.equals("") && fax.equals("") && website.equals("")
				&& securityAnswer.equals("")) {
			throw new EmptyFieldException();

		} else {
			String myPhone;
			String myTaxCode;
			String myAddress;
			String myFax;
			String myWebsite;
			String mySecurityAnswer;
			String mySecurityQuestion;

			Tenant tenant = (Tenant) Session.getSessionInstance().getCustomer();

			if (phone.equals("")) {
				myPhone = tenant.getPhone();
			} else {
				myPhone = phone;
			}
			if (tax.equals("")) {
				myTaxCode = tenant.getTaxCode();
			} else {
				myTaxCode = tax;
			}
			if (address.equals("")) {
				myAddress = tenant.getAddress();
			} else {
				myAddress = address;
			}
			if (fax.equals("")) {
				myFax = tenant.getFax();
			} else {
				myFax = fax;
			}
			if (website.equals("")) {
				myWebsite = tenant.getWebsite();
			} else {
				myWebsite = website;

			}
			if (securityAnswer.equals("")) {
				mySecurityAnswer = tenant.getSecurityAnswer();
				mySecurityQuestion = tenant.getSecurityQuestion();
			} else {
				mySecurityAnswer = securityAnswer;
				mySecurityQuestion = securityQuestion;
			}

			Save.getInstance().deleteUser(tenant.getEmail());
			tenant.setAddress(myAddress);
			tenant.setCod(myTaxCode);
			tenant.setPhone(myPhone);
			tenant.setWebsite(myWebsite);
			tenant.setWebsite(myFax);
			tenant.setSecurityQuestion(mySecurityQuestion);
			tenant.setSecurityAnswer(mySecurityAnswer);
			Save.getInstance().insertCustomer(tenant);
			Session.getSessionInstance().loginAsTenant(tenant);
		}

	}

}
