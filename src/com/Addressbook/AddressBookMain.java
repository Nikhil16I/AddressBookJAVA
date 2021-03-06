package com.Addressbook;

import java.io.IOException;
import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;

public class AddressBookMain {

	public static void main(String[] args)  {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome To AddressBook ");
		System.out.println();// space
		AddressBookFunctions obj = new AddressBookFunctions();

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
				System.out.println(" 7.Count Contact By City or State");
				System.out.println(" 8. Sort Contact by Name");
				System.out.println(" 9. Sort Contact by State And City");
				System.out.println(" 10.Write To IO File");
				System.out.println(" 11.Read The IO File");
				System.out.println(" 12.Write To CSV File");
				System.out.println(" 13.Read The CSV File");
				System.out.println(" 14.Write To JSON File");
				System.out.println(" 15.Read The JSON File");
				System.out.println(" 16.Exit from the Adressbook Application");

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
				case 7:
					obj.CountbyCityandState();
					break;
				case 8:
					obj.ContactSorting();
					break;
				case 9:
					obj.SortContactByLocation();
					break;
				case 10:
					obj.WriteToFile();
				    break;
				case 11:
					try {
						obj.ReadTheFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    break;
				case 12:
					try {
						obj.WriteCSVfile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    break;
				case 13:
					try {
						obj.ReadCSVFile();
					} catch (CsvValidationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				case 14:
					try {
						obj.WirteToJsonFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    break;
				case 15:
					try {
						obj.Read_JSON_File();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
					
				default:
					System.out.println("Press valid button To choose option ");
				}
				if (UserChoice == 16) {
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

