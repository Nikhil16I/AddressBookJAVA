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

	public String toString() {
		return String.format(FirstName + "," + LastName + "," + Address + "," + City + "," + State + "," + ZipCode + ","
				+ PhoneNumber + "," + Email);

	}
}
