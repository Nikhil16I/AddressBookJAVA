package com.Addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner input = new Scanner(System.in);

	static ArrayList<AddressBListEx> ListAddressBookname = new ArrayList<>();

	public void AddContact() {
		if (ListAddressBookname.isEmpty()) {
			System.out.println("Add AddressBook :- ");
			return;
		} else {
			System.out.println("Please Enter The Name of Addressbook in list  to add Contacts- ");
			String Bookname = input.next();

			System.out.print("Enter First Name = ");
			String firstName = input.next();

			System.out.print("Enter Last Name = ");
			String lastName = input.next();

			System.out.print("Enter Address = ");
			String address = input.next();

			System.out.print("Enter City = ");
			String city = input.next();

			System.out.print("Enter State = ");
			String state = input.next();

			System.out.print("Enter Zip Code = ");
			int zipCode = input.nextInt();

			System.out.print("Enter Phone Number = ");
			long phoneNumber = input.nextLong();

			System.out.print("Enter E-mail = ");
			String email = input.next();

			ContactDATA contactx = new ContactDATA(firstName, lastName, address, city, state, zipCode, phoneNumber,
					email);
			if (CheckDuplicateContact(Bookname, firstName)) {

				for (AddressBListEx Adbookname : ListAddressBookname) {
					if (Adbookname.AddressBookName.contains(Bookname)) {
						Adbookname.contact.add(contactx);

						for (ContactDATA Contactname : Adbookname.contact) {
						}
					}
				}

				System.out.println("\n -Contact added Successfully.\n");
			} else {
				System.out.println("\n --> This Conatct with Name -> " + firstName
						+ " <- Already Exist, please Input Another Name \n ");
				return;
			}
		}
	}

	public void AddMultipleContact() {
		System.out.println("Enter Number of Multiple Contacts to be added");
		int multi = input.nextInt();
		for (int i = 1; i <= multi; i++) {
			AddContact();
		}
	}

	public boolean CheckDuplicateContact(String Bookname, String firstName) {
		for (AddressBListEx Adbookname : ListAddressBookname) {
			if (Bookname.equals(Adbookname.AddressBookName)) {
				for (ContactDATA User : Adbookname.contact) {
					if (firstName.equals(User.FirstName)) {
						return false;
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}
		return true;
	}

	public void EditContact() {
		System.out.println("Enter New Changes to Update in Name contact -");
		String Name = input.next();
		System.out.println("Enter Mail Id to edit Contact :- ");
		String email = input.next();
		for (AddressBListEx Adbookname : ListAddressBookname) {
			if (Name.equals(Adbookname.AddressBookName)) {
				for (ContactDATA User : Adbookname.contact) {
					if (email.equals(User.Email)) {

						System.out.println("Select Option to Update" + "FirstName" + "LastName" + "Address" + "City"
								+ "State " + "Email" + "ZipCode" + "PhoneNumber");
						int option = input.nextInt();
						switch (option) {
						case 1:
							System.out.println("Enter new FirstName");
							String newFirstName = input.next();
							User.setFirstName(newFirstName);
							System.out.println("Name Updated");
							break;

						case 2:
							System.out.println("Enter new Last Name");
							String newLastName = input.next();
							User.setLastName(newLastName);
							System.out.println("Name Updated");
							break;

						case 3:
							System.out.println("Enter New Address");
							String newAddress = input.next();
							User.setAddress(newAddress);
							System.out.println("Address Updated");
							break;

						case 4:
							System.out.println("Enter new State name");
							String newState = input.next();
							User.setState(newState);
							System.out.println("State location updated ");
							break;

						case 5:
							System.out.println("Enter Updating city");
							String newCity = input.next();
							User.setCity(newCity);
							System.out.println("City Location Updated");
							break;

						case 6:
							System.out.println("Enter new ZipCode");
							int newzip = input.nextInt();
							User.setZipCode(newzip);
							System.out.println("ZipCode Updated");
							break;

						case 7:
							System.out.println("Update PhoneNumber");
							int newphone = input.nextInt();
							User.setPhoneNumber(newphone);
							System.out.println("PhoneNumber Update");
							break;

						case 8:
							System.out.println("Update Email");
							String newMail = input.next();
							User.setEmail(newMail);
							System.out.println("Mail updated");
							break;

						default:
							System.out.println("Choose a number for Credential/Option to 1-8");
						}
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}
	}

	public void DeleteContact() {
		System.out.println("Enter AddressBook Name  from which you want to Delete Contact ");
		String DeleteContact = input.next();
		System.out.println("Enter Inputed Email To Delete COntact:-");
		String email = input.next();

		for (AddressBListEx Adbookname : ListAddressBookname) {
			if (DeleteContact.equals(Adbookname.AddressBookName)) {
				for (ContactDATA User : Adbookname.contact) {
					if (email.equals(User.Email)) {
						Adbookname.contact.remove(User);
						System.out.println("Contact Deleted Suucessfully");
						break;

					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}
	}

	public void SearchPersoninContact() {
		System.out.println("Input the name of City And State to search person in the List ");
		System.out.println(" Enter the City Name - ");
		String city = input.next();
		System.out.println(" Now Enter the State Name - ");
		String state = input.next();
		for (AddressBListEx Adbookname : ListAddressBookname) {
			for (ContactDATA User : Adbookname.contact) {
				if (city.equals(User.City)) {
					if (state.equals(User.State)) {
						System.out.println("\n -> The Contact you are Searching by City - "+city+" &  State - "+state+" Is - "+User.FirstName+". \n");
					} else {
						continue;
					}
				}
			}
		}

	}

	public boolean Uniquename(String AddressBookName) {
		if (ListAddressBookname.isEmpty()) {
			return true;
		}

		for (int i = 0; i < ListAddressBookname.size(); i++) {
			String getName = ListAddressBookname.get(i).AddressBookName;
			if (getName.equals(AddressBookName)) {
				return false;
			}
		}
		return true;
	}

	public void NewAddressBook() {
		System.out.println(" Input Name of AddressBook - ");
		String AddressBookName = input.next();

		if (!Uniquename(AddressBookName)) {
			System.out.println("The AddressBook with this Name Already Exist");
			return;
		}
		AddressBListEx AddressBookObj = new AddressBListEx(AddressBookName);
		ListAddressBookname.add(AddressBookObj);

		System.out.println("\n New Address Book Name is added to list.\n");
	}

	public void DisplayAddressBook() {
		for (AddressBListEx DisplayADbook : ListAddressBookname) {
			System.out.println(DisplayADbook);
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome To AddressBook ");
		System.out.println();// space
		AddressBookMain obj = new AddressBookMain();

		System.out.print("*AddressBook Application* \n-Enter an option \n  Press 1 = Enter. \n  Press 2 = Exit.");
		System.out.println();// space
		int enterExit = input.nextInt();
		if (enterExit == 1) {

			while (enterExit != 2) {
				System.out.println("Select and Press an Option you want to Perform from below list -->> ");
				System.out.println(" 1.Add New Contact.");
				System.out.println(" 2.Edit the Contact");
				System.out.println(" 3.Delete the Contact");
				System.out.println(" 4.Add New AddressBook in List");
				System.out.println(" 5.Display the Address Book.");
				System.out.println(" 6.Search Person By City or State");
				System.out.println(" 7.Exit from the Adressbook Application");
				
				System.out.println();// Space
				System.out.println("Enter your choice - ");
				int UserChoice = input.nextInt();

				switch (UserChoice) {
				case 1:
					obj.AddMultipleContact();
					break;
				case 2:
					obj.EditContact();
					break;
				case 3:
					obj.DeleteContact();
					break;
				case 4:
					obj.NewAddressBook();
					break;
				case 5:
					obj.DisplayAddressBook();
					break;
				case 6:
                    obj.SearchPersoninContact();
                    break;
				default:
					System.out.println("Press valid button To choose option ");
				}
				if (UserChoice == 8) {
					System.out.println("You are Exited from Addressbook");
					break;
				}
			}
		} else if (enterExit == 2) {
			System.out.println("Exited from Addressbook");
		} else {
			System.out.println("Press Valid button Enter=1 , Exit=2");
		}
	}
 }
