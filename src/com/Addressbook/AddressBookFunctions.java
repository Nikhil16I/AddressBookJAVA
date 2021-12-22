package com.Addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.Addressbook.entity.AddressBListEx;
import com.Addressbook.entity.ContactDATA;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class AddressBookFunctions {

	static Scanner input = new Scanner(System.in);

	static ArrayList<AddressBListEx> ListAddressBookname = new ArrayList<>();
	File file = new File("C:/Users/DELL/eclipse-workspace/AddressBookJAVA/src/com/IOfile-Addressbook.txt");
	File CSVfile = new File("C:/Users/DELL/eclipse-workspace/AddressBookJAVA/src/com/IOfile-Addressbook.csv");
	File JSONfile = new File("C:/Users/DELL/eclipse-workspace/AddressBookJAVA/src/com/IOfile-Addressbook.json");

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

						/*
						 * for (ContactDATA Contactname : Adbookname.contact) { }
						 */
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

		Dictionary DictforCityState = new Hashtable();

		for (AddressBListEx Adbookname : ListAddressBookname) {
			for (ContactDATA User : Adbookname.contact) {
				if (city.equals(User.City)) {
					DictforCityState.put(User.FirstName, city);

					if (state.equals(User.State)) {
						DictforCityState.put(User.FirstName, state);

						System.out.println("\n -> The Contact you are Searching by City - " + city + " &  State - "
								+ state + " Is - " + User.FirstName + ". \n");
					} else {
						continue;
					}
				}
			}
			System.out.println("Showing persons by State- " + state + " City- " + city);
			System.out.println("The Persons with Same City and State Are :- ");
			for (Enumeration i = DictforCityState.keys(); i.hasMoreElements();) {
				System.out.println(i.nextElement());
			}
		}
	}

	public void CountbyCityandState() {
		System.out.println("Input the name of City And State to Count Persons - ");
		System.out.println(" Enter the City Name - ");
		String city = input.next();
		int Countcity = 0;
		System.out.println(" Enter the State Name - ");
		String state = input.next();
		int Countstate = 0;

		for (AddressBListEx Adbookname : ListAddressBookname) {
			for (ContactDATA User : Adbookname.contact) {
				if (city.equals(User.City)) {
					Countcity++;
					if (state.equals(User.State)) {
						Countstate++;
					}
				}
			}
			System.out.println("Showing persons by State- " + city + " " + Countcity + " " + state + " " + Countstate);
		}
	}

	public void SortContactByLocation() {
		AddressBListEx addressBListEx = FindAddressBook();
		int Press = input.nextInt();
		switch (Press) {
		case 1:
			addressBListEx.contact.stream()
					.sorted((contact1, contact2) -> contact1.getFirstName().compareTo(contact2.getFirstName()))
					.forEach(contact -> System.out.println(contact));
			break;
		case 2:
			addressBListEx.contact.stream()
					.sorted((contact1, contact2) -> contact1.getCity().compareTo(contact2.getCity()))
					.forEach(contact -> System.out.println(contact));
			break;
		case 3:
			addressBListEx.contact.stream()
					.sorted((contact1, contact2) -> contact1.getState().compareTo(contact2.getState()))
					.forEach(contact -> System.out.println(contact));
			break;
		case 4:
			addressBListEx.contact.stream().sorted(
					(contact1, contact2) -> Integer.valueOf(contact1.getZipCode()).compareTo(contact2.getZipCode()))
					.forEach(contact -> System.out.println(contact));
			break;
		default:
			System.out.println("Press Valid Button Only");

		}
	}

	public void ContactSorting() {
		AddressBListEx adbook = FindAddressBook();
		adbook.contact.stream()
				.sorted((contact1, contact2) -> contact1.getFirstName().compareTo(contact2.getFirstName()))
				.forEach(contact -> System.out.println(contact));

	}

	public AddressBListEx FindAddressBook() {
		if (ListAddressBookname.isEmpty()) {
			System.out.println("Create an AddresBook First :-");
			return null;
		}
		System.out.println("Enter the Name of new Addressbook");
		String newaddedADBook = input.next();
		for (AddressBListEx addressBListEx : ListAddressBookname) {
			if (newaddedADBook.equals(addressBListEx.AddressBookName)) {
				return addressBListEx;
			}
		}
		System.out.println("This AddressBook Doesnt Exist");
		return null;
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

	public void ReadTheFile() throws IOException {
		System.out.println("\n Yes, Reading the context of the file ");
		System.out.println("Done ! , Showing Details\n");
		FileReader OurIOfile = new FileReader(file);
		int i;
		while ((i = OurIOfile.read()) != -1)
			System.out.print((char) i);
		OurIOfile.close();
	}

	public void WriteToFile() {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file);
			String OurIOfile = ListAddressBookname.toString();

			for (int i = 0; i < OurIOfile.length(); i++) {
				fileWriter.write(OurIOfile.charAt(i));
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n Context Has been Written To IO files \n Press '11' to read Context \n");
	}

	public void WriteCSVfile() throws IOException {
		FileWriter fileWriter;
		try {
			FileWriter outputFile = new FileWriter(CSVfile);
			CSVWriter csvWriter = new CSVWriter(outputFile);

			for (AddressBListEx addressBookList : ListAddressBookname) {
				for (ContactDATA User : addressBookList.contact) {
					String[] contact = {
							addressBookList.getAddressBookName() + "," + User.getFirstName() + "," + User.getLastName()
									+ "," + User.getAddress() + "," + User.getCity() + "," + User.getState() + ","
									+ String.valueOf(User.getPhoneNumber()) + "," + User.getEmail() + "\n" };
					csvWriter.writeNext(contact);
				}
			}
			csvWriter.close();
			System.out.println("\n Context Has been Written To CSV files \n Press '13' to read Context \n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ReadCSVFile() throws IOException, CsvValidationException {
		System.out.println("\n Yes, Reading the context of the file ");
		System.out.println("Done ! , Showing Details\n");
		FileReader fileReader = new FileReader(CSVfile);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] nextString;
		try {
			while ((nextString = csvReader.readNext()) != null) {
				if (nextString != null) {
					System.out.print(Arrays.toString(nextString));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void WirteToJsonFile() throws IOException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String string = gson.toJson(ListAddressBookname);
		FileWriter outputFile = new FileWriter(JSONfile);

		outputFile.write(string);
		outputFile.close();

		System.out.println("\n Context Has been Written To JSON files \n Press '15' to read Context \n");	}

	public void Read_JSON_File() throws IOException {

		System.out.println("\n Yes, Reading the context of the file ");
		System.out.println("Done !, Showing Details\n");

		FileReader fileReader = new FileReader(JSONfile);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		Object object = gson.fromJson(fileReader, Object.class);
		System.out.println(object);

	}
}