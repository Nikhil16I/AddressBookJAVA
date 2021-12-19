package com.Addressbook.entity;

public class ContactDATA {

	public String FirstName;
	public String LastName;
	public String Address;
	public String City;
	public String State;
	public String Email;
	public int ZipCode;
	public long PhoneNumber;

	public ContactDATA(String firstName, String lastName, String address, String city, String state, int zipCode,
			long phoneNumber, String email) {

		this.FirstName = firstName;
		this.LastName = lastName;
		this.Address = address;
		this.City = city;
		this.State = state;
		this.Email = email;
		this.ZipCode = zipCode;
		this.PhoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		this.State = state;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public int getZipCode() {
		return ZipCode;
	}

	public void setZipCode(int zipCode) {
		this.ZipCode = zipCode;
	}

	public long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ContactDATA :-  \n 1.FirstName = " + FirstName + "\n 2.LastName = " + LastName + "\n 3.Address = " + Address + "\n 4.City = "
				+ City + "\n 5.State = " + State + "\n 6.Email = " + Email + "\n 7.ZipCode = " + ZipCode + "\n 8.PhoneNumber = "
				+ PhoneNumber+"\n";
	}
}