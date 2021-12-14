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
			
		  ContactDATA contact = new ContactDATA(FirstName , LastName , Add , City , State , ZipCode , PhoneNumber , Email);
		  		contactBook.add(contact);
		  		
		  		System.out.println("Contact added Successfully.");
			}
				

		public void DisplayContacts() {
			System.out.println("Contacts in Address Book");
				for(ContactDATA person : contactBook) {
					System.out.println(person.toString());
				}
			}
	
			public static void main(String[] args) {
				System.out.println("Welcome to AddressBook");
				AddressBookMain obj = new AddressBookMain();
				obj.AddContact();
				obj.DisplayContacts();
		}


}
