
package control.properties;

import java.io.IOException;

import entity.Customer;
import entity.persistence.SaveProperties;
import entity.properties.RoomStudents;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.UserNotFoundException;

public class RegistrationRoom {

	public static void registrationRoom(Customer customer, String nickName, String municipality, String province,
			String address, String houseNumber, String mq, String university, String wc, boolean specialGuest,
			boolean parkingSpace, boolean bestAppliances, boolean expenses, boolean bus, boolean otherStudents,
			boolean animals, boolean garden, boolean wifi, double specialGuestPrice, int contractTerm2,
			int contractTerm1, int type, double roomPrice) throws EmptyFieldException, ClassNotFoundException,
					IOException, AlreadyRegisteredException, FileException, UserNotFoundException {

		if (nickName.equals("") || municipality.equals("") || province.equals("") || address.equals("")
				|| houseNumber.equals("") || mq.equals("") || university.equals("") || wc.equals("")
				|| (specialGuest == true && specialGuestPrice == 0) || roomPrice == 0) {
			throw new EmptyFieldException();
		} else {

			RoomStudents room = new RoomStudents(customer, nickName, municipality, province, address, houseNumber, mq,
					university, wc, specialGuest, parkingSpace, specialGuestPrice, wifi, bestAppliances, expenses, bus,
					otherStudents, animals, garden, type, contractTerm2, contractTerm1, roomPrice);
			SaveProperties.getInstance().insertProperties(room);
/*
			LandLord landlord = (LandLord) Session.getSessionInstance().getCustomer();
			Save.getInstance().deleteUser(landlord.getEmail());
			landlord.addProperty(room);
			Save.getInstance().insertCustomer(landlord);
*/
		}

	}

}
