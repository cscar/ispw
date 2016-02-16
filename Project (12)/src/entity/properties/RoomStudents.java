package entity.properties;

import java.io.IOException;

import entity.Constants;
import entity.Customer;
import entity.persistence.SavePropertiesRent;
import entity.persistence.SavePropertiesValued;
import exception.AlreadyRegisteredException;
import exception.FileException;
import exception.UserNotFoundException;

public class RoomStudents extends Property {

	private static final long serialVersionUID = 1L;

	private int roomType;
	private double roomPrice;

	public RoomStudents(Customer customer, String nickName, String municipaliy, String province, String address,
			String houseNum, String mq, String university, String numWC, boolean specialGuest, boolean parkingSpace,
			double specialGuestPrice, boolean wifi, boolean bestAppliances, boolean expenses, boolean bus,
			boolean otherStudents, boolean animals, boolean garden, int roomType, int contractTerm2, int contractTerm1,
			double roomPrice) {
		super(customer, nickName, municipaliy, province, address, houseNum, mq, university, numWC, specialGuest,
				parkingSpace, specialGuestPrice, wifi, bestAppliances, expenses, bus, otherStudents, animals, garden,
				contractTerm2, contractTerm1);

		this.propertyType = Constants.ROOM_STUDENTS;

		this.roomType = roomType;
		this.roomPrice = roomPrice;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getRoomType() {
		return roomType;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void rent() throws ClassNotFoundException, IOException, AlreadyRegisteredException, UserNotFoundException,
			FileException {
		SavePropertiesValued.getInstance().deleteProperty(getMunicipality(), getProvince(), getAddress(),
				getHouseNum());
		SavePropertiesRent.getInstance().insertProperties(RoomStudents.this);
	}
}