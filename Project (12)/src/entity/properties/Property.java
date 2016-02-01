package entity.properties;

import java.io.Serializable;

import entity.Customer;

public class Property implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mq;
	private boolean specialGuest;
	private String numWC;
	private boolean parkingSpace;
	private boolean bestAppliances;
	private boolean expenses;
	private boolean wifi;
	private boolean bus;
	private boolean otherStudents;
	private String address;
	private String houseNum;
	private String municipality;
	private String province;
	private boolean animals;
	private String university;
	private boolean garden;
	private double specialGuestPrice;
	private int contractTerm2;
	private int contractTerm1;
	private String nickName;
	protected int propertyType;
	private Customer customer;

	public Property(Customer customer, String nickName, String municipality, String province, String address,
			String houseNum, String mq, String university, String numWC, boolean specialGuest, boolean parkingSpace,
			double specialGuestPrice, boolean wifi, boolean bestAppliances, boolean expenses, boolean bus,
			boolean otherStudents, boolean animals, boolean garden, int contractTerm2, int contractTerm1) {

		this.municipality = municipality;
		this.province = province;
		this.address = address;
		this.houseNum = houseNum;
		this.mq = mq;
		this.numWC = numWC;
		this.specialGuest = specialGuest;
		this.parkingSpace = parkingSpace;
		this.bestAppliances = bestAppliances;
		this.wifi = wifi;
		this.expenses = expenses;
		this.bus = bus;
		this.otherStudents = otherStudents;
		this.animals = animals;
		this.university = university;
		this.garden = garden;
		this.specialGuestPrice = specialGuestPrice;
		this.contractTerm2 = contractTerm2;
		this.contractTerm1 = contractTerm1;
		this.nickName = nickName;

		this.customer = customer;

	}

	public int getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(int propertyType) {
		this.propertyType = propertyType;
	}

	public boolean getExpenses() {
		return expenses;
	}

	public void setSale(boolean sale) {
		this.expenses = sale;
	}

	public boolean getWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getContractTerm2() {
		return contractTerm2;
	}

	public void setContractTerm2(int contractTerm2) {
		this.contractTerm2 = contractTerm2;
	}

	public int getContractTerm1() {
		return contractTerm1;
	}

	public void setContractTerm1(int contractTerm1) {
		this.contractTerm1 = contractTerm1;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public void setMq(String mq) {
		this.mq = mq;
	}

	public void setNumWC(String numWC) {
		this.numWC = numWC;
	}

	public void setSpecialguest(boolean specialGuest) {
		this.specialGuest = specialGuest;
	}

	public void setParkingSpace(boolean parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public void setBestAppliances(boolean bestAppliances) {
		this.bestAppliances = bestAppliances;
	}

	public void setBus(boolean bus) {
		this.bus = bus;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public void setOtherStudents(boolean otherStudents) {
		this.otherStudents = otherStudents;
	}

	public void setAnimals(boolean animals) {
		this.animals = animals;
	}

	public void setGarden(boolean garden) {
		this.garden = garden;
	}

	public void setSpecialGuestPrice(double specialGuestPrice) {
		this.specialGuestPrice = specialGuestPrice;
	}

	public String getMunicipality() {
		return municipality;
	}

	public String getProvince() {
		return province;
	}

	public String getAddress() {
		return address;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public String getMq() {
		return mq;
	}

	public String getNumWC() {
		return numWC;
	}

	public boolean getSpecialguest() {
		return specialGuest;
	}

	public boolean getParkingSpace() {
		return parkingSpace;
	}

	public boolean getBestAppliances() {
		return bestAppliances;
	}

	public boolean getBus() {
		return bus;
	}

	public String getUniversity() {
		return university;
	}

	public boolean getOtherStudents() {
		return otherStudents;
	}

	public boolean getAnimals() {
		return animals;
	}

	public boolean getGarden() {
		return garden;
	}

	public double getSpecialGuestPrice() {
		return specialGuestPrice;
	}

}
