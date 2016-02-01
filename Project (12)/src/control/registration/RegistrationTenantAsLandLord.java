package control.registration;

import java.io.IOException;

import entity.LandLord;
import entity.Session;
import entity.Tenant;
import entity.persistence.Save;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.UnexpectedException;
import exception.UserNotFoundException;

public class RegistrationTenantAsLandLord {

	public static void registerTenantAsLandLord(Tenant tenant, String iban) throws EmptyFieldException,
			ClassNotFoundException, IOException, AlreadyRegisteredException, UnexpectedException, FileException, UserNotFoundException {

		if (iban.equals("")) {
			throw new EmptyFieldException();

		} else {
			if (!Session.getSessionInstance().isTenant()) {
				throw new UnexpectedException();
			} else {
				LandLord landlord = new LandLord(tenant.getFirstName(), tenant.getLastName(), tenant.getPassword(),
						tenant.getEmail(), tenant.getAddress(), tenant.getPhone(), tenant.getBirthDate(),
						tenant.getBirthPlace(), tenant.getTaxCode(), tenant.getFax(), tenant.getWebsite(),
						tenant.getSecurityQuestion(), tenant.getSecurityAnswer(), iban);
				landlord.setTenant(true);
				Save.getInstance().deleteUser(tenant.getEmail());
				Save.getInstance().insertCustomer(landlord);
			}
		}
	}
}