package entity;

import java.util.List;

import entity.properties.Property;

public class Tenant extends Customer{

	private static final long serialVersionUID = 1L;
	
	String firstName, lastName, email, 
		birthDate, birthPlace, phone, taxCode, address, fax, 
		website, securityQuestion, securityAnswer;
	List<Property> rentProperties;
	
	public Tenant(String firstName, String lastName, 
			String password, String email, 
			String address, String phone, String birthDate, String birthPlace, 
			String taxCode, String fax, String website, 
			String securityQuestion, String securityAnswer) {
		
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

	public void setCod(String taxCode) {
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
	
	public void rentProperty(Property property) {
		rentProperties.add(property);
	}

}
