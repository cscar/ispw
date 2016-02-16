package control;

import java.io.IOException;

import entity.Administrator;
import entity.Customer;
import entity.LandLord;
import entity.Scout;
import entity.Session;
import entity.Tenant;
import entity.persistence.Save;
import exception.EmptyFieldException;
import exception.UserNotFoundException;

public class Login {

	public static void authenticate(String email, String password)
			throws IOException, ClassNotFoundException, EmptyFieldException, UserNotFoundException {
		// Check if email and password are not null
		if (email.equals("") || password.equals("")) {
			throw new EmptyFieldException();
		} else {
			// Search user by email
			Object o = Save.getInstance().searchUser(email);
			if (o == null) {
				// Wrong Email
				throw new UserNotFoundException();
			}
			if (o instanceof Customer) {
				Customer customer = (Customer) o;
				if (customer.getPassword().equals(password)) {
					// succefully logged in
					if (customer instanceof LandLord) {
						LandLord landLord = (LandLord) customer;
						if (landLord.isTenant()) {
							// Customer is both Tenant and LandLord
							Session.getSessionInstance().loginAsTenantAndLandLord(customer);
						} else {
							// Customer is LandLord
							Session.getSessionInstance().loginAsLandLord(landLord);
						}
					} else if (customer instanceof Tenant) {
						// Customer is Tenant
						Session.getSessionInstance().loginAsTenant(customer);
					}
				} else {
					// Wrong password
					throw new UserNotFoundException();
				}

			} else if (o instanceof Administrator) {
				Administrator administrator = (Administrator) o;
				if (administrator.getPassword().equals(password)) {
					Session.getSessionInstance().loginAsAdministrator(administrator);
				} else {
					throw new UserNotFoundException();
				}
			} else if (o instanceof Scout) {
				Scout scout = (Scout) o;
				if (scout.getPassword().equals(password)) {
					Session.getSessionInstance().loginAsScout(scout);
				} else {
					throw new UserNotFoundException();
				}
			} else {
				throw new UserNotFoundException();
			}
		}
	}
}
