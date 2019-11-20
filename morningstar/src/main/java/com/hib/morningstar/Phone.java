package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone {
	@Id
	private String contactID;
	private String phoneNumber;

	public Phone(String contactID, String phoneNumber) {
		this.contactID = contactID;
		this.phoneNumber = phoneNumber;
	}

	public Phone() {

	}

	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
