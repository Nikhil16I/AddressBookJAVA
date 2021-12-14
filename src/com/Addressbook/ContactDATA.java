package com.Addressbook;

public class ContactDATA {

	String FirstName;
	String LastName;
	String Address;
	String City;
	String State;
	String Email;
	int ZipCode;
	int PhoneNumber;

	public ContactDATA(String firstName, String lastName, String add, String city, String state, int zipCode,
			int phoneNumber, String email) {
		// TODO Auto-generated constructor stub
	}

	public void AddressBookEx(String Name, String Surname, String address, String city, String state, int zip,
			int contact, String mail) {

		this.FirstName = Name;
		this.LastName = Surname;
		this.Address = address;
		this.City = city;
		this.State = state;
		this.Email = mail;
		this.ZipCode = zip;
		this.PhoneNumber = contact;

	}

	public String tostring() {
		return String.format(FirstName + "," + LastName + "," + Address + "," + City + "," + State + "," + ZipCode + ","
				+ PhoneNumber + "," + Email);
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getZipCode() {
		return ZipCode;
	}

	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}

	public int getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ContactDATA [FirstName=" + FirstName + ", LastName=" + LastName + ", Address=" + Address + ", City="
				+ City + ", State=" + State + ", Email=" + Email + ", ZipCode=" + ZipCode + ", PhoneNumber="
				+ PhoneNumber + "]";
	}

	public void setFirstName(java.lang.String newFirstName) {
		// TODO Auto-generated method stub

	}
}
