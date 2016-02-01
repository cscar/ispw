package control.properties;

import java.io.IOException;

import entity.Customer;
import entity.persistence.SaveProperties;
import entity.properties.ApartmentStudents;
import exception.AlreadyRegisteredException;
import exception.EmptyFieldException;
import exception.FileException;
import exception.NoRoomException;
import exception.UserNotFoundException;

public class RegistrationApartment {

	public static void registrationApartment(Customer customer, String nickName, String municipality, String province,
			String address, String houseNumber, String mq, String university, String wc, boolean specialGuest,
			boolean parkingSpace, boolean bestAppliances, boolean expenses, boolean bus, boolean otherStudents,
			boolean animals, boolean garden, boolean wifi, int singleRoomWC, double singleRoomWCPrice, int singleRoom,
			double singleRoomPrice, int doubleRoomWC, double doubleRoomWCPrice, int doubleRoom, double doubleRoomPrice,
			double specialGuestPrice, int contractTerm2, int contractTerm1)
					throws EmptyFieldException, ClassNotFoundException, IOException, AlreadyRegisteredException,
					NoRoomException, FileException, UserNotFoundException {

		if (nickName.equals("") || municipality.equals("") || province.equals("") || address.equals("")
				|| houseNumber.equals("") || mq.equals("") || university.equals("") || wc.equals("")
				|| (specialGuest == true && specialGuestPrice == 0) || (!(singleRoomWC == 0) && singleRoomWCPrice == 0)
				|| (!(singleRoom == 0) && singleRoomPrice == 0) || (!(doubleRoomWC == 0) && doubleRoomWCPrice == 0)
				|| (!(doubleRoom == 0) && doubleRoomPrice == 0)) {
			throw new EmptyFieldException();
		} else if (singleRoomWC == 0 && singleRoom == 0 && doubleRoomWC == 0 && doubleRoom == 0) {
			throw new NoRoomException();
		} else {
			ApartmentStudents apartment = new ApartmentStudents(customer, nickName, municipality, province, address,
					houseNumber, mq, university, wc, specialGuest, parkingSpace, specialGuestPrice, bestAppliances,
					expenses, bus, otherStudents, wifi, animals, garden, contractTerm2, contractTerm1, singleRoomWC,
					doubleRoomWC, singleRoom, doubleRoom, singleRoomWCPrice, doubleRoomWCPrice, singleRoomPrice,
					doubleRoomPrice);
			SaveProperties.getInstance().insertProperties(apartment);
/*
			LandLord landlord = (LandLord) Session.getSessionInstance().getCustomer();
			Save.getInstance().deleteUser(landlord.getEmail());
			landlord.addProperty(apartment);
			Save.getInstance().insertCustomer(landlord);
*/
		}
	}
}