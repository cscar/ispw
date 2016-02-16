package entity.properties;

import java.io.IOException;

import entity.Constants;
import entity.Customer;
import entity.persistence.SavePropertiesRent;
import entity.persistence.SavePropertiesValued;
import exception.AlreadyRegisteredException;
import exception.FileException;
import exception.RoomsNotAvailableException;
import exception.UserNotFoundException;

public class ApartmentStudents extends Property {

	private static final long serialVersionUID = 1L;

	private int numRoomSingleWC;
	private int numRoomDoubleWC;
	private int numRoomSingle;
	private int numRoomDouble;

	private int numRoomSingleWCAvailability;
	private int numRoomSingleAvailability;
	private int numRoomDoubleWCAvailability;
	private int numRoomDoubleAvailability;

	private double roomSingleWCPrice;
	private double roomDoubleWCPrice;
	private double roomSinglePrice;
	private double roomDoublePrice;

	public ApartmentStudents(Customer customer, String nickName, String municipality, String province, String address,
			String houseNum, String mq, String university, String numWC, boolean specialGuest, boolean parkingSpace,
			double specialGuestPrice, boolean bestAppliances, boolean expenses, boolean bus, boolean otherStudents,
			boolean wifi, boolean animals, boolean garden, int contractTerm2, int contractTerm1,
			int numRoomSingleWC, int numRoomDoubleWC, int numRoomSingle, int numRoomDouble,
			double roomSingleWCPrice, double roomDoubleWCPrice, double roomSinglePrice, double roomDoublePrice) {
		super(customer, nickName, municipality, province, address, houseNum, mq, university, numWC, specialGuest,
				parkingSpace, specialGuestPrice, wifi, bestAppliances, expenses, bus, otherStudents, animals, garden,
				contractTerm2, contractTerm1);

		this.propertyType = Constants.APARTMENT_STUDENTS;

		this.numRoomSingleWC = numRoomSingleWC;
		this.numRoomDoubleWC = numRoomDoubleWC;
		this.numRoomSingle = numRoomSingle;
		this.numRoomDouble = numRoomDouble;
		this.roomSingleWCPrice = roomSingleWCPrice;
		this.roomDoubleWCPrice = roomDoubleWCPrice;
		this.roomSinglePrice = roomSinglePrice;
		this.roomDoublePrice = roomDoublePrice;

		this.numRoomSingleWCAvailability = Integer.valueOf(numRoomSingleWC);
		this.numRoomSingleAvailability = Integer.valueOf(numRoomSingle);
		this.numRoomDoubleWCAvailability = Integer.valueOf(numRoomDoubleWC);
		this.numRoomDoubleAvailability = Integer.valueOf(numRoomDouble);

	}

	public int getNumRoomSingleWC() {
		return numRoomSingleWC;
	}

	public void setNumRoomSingleWC(int numRoomSingleWC) {
		this.numRoomSingleWC = numRoomSingleWC;
	}

	public int getNumRoomDoubleWC() {
		return numRoomDoubleWC;
	}

	public void setNumRoomDoubleWC(int numRoomDoubleWC) {
		this.numRoomDoubleWC = numRoomDoubleWC;
	}

	public int getNumRoomSingle() {
		return numRoomSingle;
	}

	public void setNumRoomSingle(int numRoomSingle) {
		this.numRoomSingle = numRoomSingle;
	}

	public int getNumRoomDouble() {
		return numRoomDouble;
	}

	public void setNumRoomDouble(int numRoomDouble) {
		this.numRoomDouble = numRoomDouble;
	}

	public int getNumRoomSingleWCAvailability() {
		return numRoomSingleWCAvailability;
	}

	public void setNumRoomSingleWCAvailability(int numRoomSingleWCAvailability) {
		this.numRoomSingleWCAvailability = numRoomSingleWCAvailability;
	}

	public int getNumRoomSingleAvailability() {
		return numRoomSingleAvailability;
	}

	public void setNumRoomSingleAvailability(int numRoomSingleAvailability) {
		this.numRoomSingleAvailability = numRoomSingleAvailability;
	}

	public int getNumRoomDoubleWCAvailability() {
		return numRoomDoubleWCAvailability;
	}

	public void setNumRoomDoubleWCAvailability(int numRoomDoubleWCAvailability) {
		this.numRoomDoubleWCAvailability = numRoomDoubleWCAvailability;
	}

	public int getNumRoomDoubleAvailability() {
		return numRoomDoubleAvailability;
	}

	public void setNumRoomDoubleAvailability(int numRoomDoubleAvailability) {
		this.numRoomDoubleAvailability = numRoomDoubleAvailability;
	}

	public double getRoomSingleWCPrice() {
		return roomSingleWCPrice;
	}

	public void setRoomSingleWCPrice(double roomSingleWCPrice) {
		this.roomSingleWCPrice = roomSingleWCPrice;
	}

	public double getRoomDoubleWCPrice() {
		return roomDoubleWCPrice;
	}

	public void setRoomDoubleWCPrice(double roomDoubleWCPrice) {
		this.roomDoubleWCPrice = roomDoubleWCPrice;
	}

	public double getRoomSinglePrice() {
		return roomSinglePrice;
	}

	public void setRoomSinglePrice(double roomSinglePrice) {
		this.roomSinglePrice = roomSinglePrice;
	}

	public double getRoomDoublePrice() {
		return roomDoublePrice;
	}

	public void setRoomDoublePrice(double roomDoublePrice) {
		this.roomDoublePrice = roomDoublePrice;
	}

	public void rentRooms(int numOfSingleRooms, int numOfDoubleRooms, int numOfSingleWCRooms, int numOfDoubleWCRooms) throws RoomsNotAvailableException, ClassNotFoundException, IOException, AlreadyRegisteredException, UserNotFoundException, FileException {
		if (numOfSingleRooms <= numRoomSingleAvailability && numOfSingleWCRooms <= numRoomSingleWCAvailability
				&& numOfDoubleRooms <= numRoomDoubleAvailability && numOfDoubleWCRooms <= numRoomDoubleWCAvailability) {
	//		LandLord landlord = (LandLord) this.getCustomer();
	//		Save.getInstance().deleteUser(landlord.getEmail());
			
			// Rooms available
			numRoomSingleAvailability -= numOfSingleRooms;
			numRoomSingleWCAvailability -= numOfSingleWCRooms;
			numRoomDoubleAvailability -= numOfDoubleRooms;
			numRoomDoubleWCAvailability -= numOfDoubleWCRooms;
			
			if (numRoomSingleAvailability == 0 && numRoomSingleWCAvailability == 0
				&& numRoomDoubleAvailability == 0 && numRoomDoubleWCAvailability == 0) {
				// All rooms have been rent
				SavePropertiesValued.getInstance().deleteProperty(getMunicipality(), getProvince(), getAddress(), getHouseNum());
				SavePropertiesRent.getInstance().insertProperties(ApartmentStudents.this);
			}
		} else {
			// Rooms not available
			throw new RoomsNotAvailableException();
		}
	}

}
