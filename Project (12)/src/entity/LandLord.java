package entity;

import java.util.ArrayList;

import entity.properties.Property;
import exception.PropertyNotFoundException;

public class LandLord extends Customer {

	private static final long serialVersionUID = 1L;

	String firstName, lastName, email, birthDate, birthPlace, phone, taxCode, address, fax, website, securityQuestion,
			securityAnswer, iban;
	ArrayList<Property> acceptedProperties, refusedProperties, notValuedProperties, rentProperties;
	boolean isTenant;

	public LandLord(String firstName, String lastName, String password, String email, String address, String phone,
			String birthDate, String birthPlace, String taxCode, String fax, String website, String securityQuestion,
			String securityAnswer, String iban) {

		super(email, password);
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.taxCode = taxCode;
		this.fax = fax;
		this.website = website;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.iban = iban;
		
		acceptedProperties = new ArrayList<Property>();
		refusedProperties = new ArrayList<Property>();
		notValuedProperties = new ArrayList<Property>();
		rentProperties = new ArrayList<Property>();
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public boolean isTenant() {
		return isTenant;
	}

	public void setTenant(boolean isTenant) {
		this.isTenant = isTenant;
	}
	
	public void addProperty(Property property) {
		notValuedProperties.add(property);
	}

	public void acceptProperty(Property property) throws PropertyNotFoundException {
		if (!notValuedProperties.remove(property)) {
			// Property not found
			throw new PropertyNotFoundException();			
		}
		acceptedProperties.add(property);
	}

	public void refuseProperty(Property property) throws PropertyNotFoundException {
		if (!notValuedProperties.remove(property)) {
			// Property not found
			throw new PropertyNotFoundException();			
		}
		refusedProperties.add(property);
	}
	
	public void rentProperty(Property property) throws PropertyNotFoundException {
		if (!acceptedProperties.remove(property)) {
			// Property not found
			throw new PropertyNotFoundException();
		}
		rentProperties.add(property);
	}
}
