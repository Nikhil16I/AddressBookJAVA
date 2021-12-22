package com.Addressbook.entity;

import java.util.ArrayList;

public class AddressBListEx {
	public String AddressBookName;
	public ArrayList<ContactDATA> contact;


	public AddressBListEx(String AddressBookName) {
		this.AddressBookName = AddressBookName;
		this.contact = new ArrayList<ContactDATA>();

	}

	public String getAddressBookName() {
		return AddressBookName;
	}

	public void setAddressBookName(String AddressBookName) {
		this.AddressBookName = AddressBookName;
	}

	@Override
	public String toString() {
		return "AddressBookName = " + AddressBookName + "  " + "Contacts- " + contact;
	}
 }