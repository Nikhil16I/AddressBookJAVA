package com.Addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner input = new Scanner(System.in);
	static ArrayList<ContactDATA> contactBook = new ArrayList<>();

	public void AddContact() {
		System.out.print("Enter First Name = ");
		String FirstName = input.next();

		System.out.print("Enter Last Name = ");
		String LastName = input.next();

		System.out.print("Enter Address = ");
		String Add = input.next();

		System.out.print("Enter City = ");
		String City = input.next();

		System.out.print("Enter State = ");
		String State = input.next();

		System.out.print("Enter Zip Code = ");
		int ZipCode = input.nextInt();

		System.out.print("Enter Phone Number = ");
		int PhoneNumber = input.nextInt();

		System.out.print("Enter E-mail = ");
		String Email = input.next();

		ContactDATA contact = new ContactDATA(FirstName, LastName, Add, City, State, ZipCode, PhoneNumber, Email);
		contactBook.add(contact);

		System.out.println("Contact added Successfully.");
	}

	public void DisplayContacts() {
		System.out.println("Contacts in Address Book");
		for (ContactDATA person : contactBook) {
			System.out.println(person.toString());
		}
	}

	public void EditContact() {
		System.out.println("Enter New Changes to Update in Name");
		var Name = input.next();

		for (ContactDATA person : contactBook) {
			if (Name.equals(person.FirstName)) {
				System.out.println("Select Option to Update" + "FirstName" + "LastName" + "Address" + "City" + "State "
						+ "Email" + "ZipCode" + "PhoneNumber");
				int option = input.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter new FirstName");
					String newFirstName = input.next();
					person.setFirstName(newFirstName);
					System.out.println("Name Updated");
					break;

				case 2:
					System.out.println("Enter new Last Name");
					String newLastName = input.next();
					person.setLastName(newLastName);
					System.out.println("Name Updated");
					break;

				case 3:
					System.out.println("Enter New Address");
					String newAddress = input.next();
					person.setAddress(newAddress);
					System.out.println("Address Updated");
					break;

				case 4:
					System.out.println("Enter new State name");
					String newState = input.next();
					person.setState(newState);
					System.out.println("State location updated ");
					break;

				case 5:
					System.out.println("Enter Updating city");
					String newCity = input.next();
					person.setCity(newCity);
					System.out.println("City Location Updated");
					break;

				case 6:
					System.out.println("Enter new ZipCode");
					int newzip = input.nextInt();
					person.setZipCode(newzip);
					System.out.println("ZipCode Updated");
					break;

				case 7:
					System.out.println("Update PhoneNumber");
					int newphone = input.nextInt();
					person.setPhoneNumber(newphone);
					System.out.println("PhoneNumber Update");
					break;

				case 8:
					System.out.println("Update Email");
					String newMail = input.next();
					person.setEmail(newMail);
					System.out.println("Mail updated");
					break;

				default:
					System.out.println("Choose a number for Credential to 1-8");
				}
			} else {
				continue;
			}
		}
	}

	public void DeleteContact() {
		System.out.println("Delete Contact enter  linked Email to Delete the Contact");
		String DeleteContact = input.next();

		for (int i = 0; i < contactBook.size(); i++) {
			String CheckingMail = contactBook.get(i).getEmail();

			if (DeleteContact.equalsIgnoreCase(CheckingMail)) {
				contactBook.remove(i);
				System.out.println("Contact Deleted Suucessfully");
				break;

			} else {
				continue;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome To AddressBook");
		AddressBookMain obj = new AddressBookMain();
		obj.AddContact();
		obj.DisplayContacts();
		obj.AddContact();
		obj.EditContact();
		obj.DeleteContact();
	}
}
