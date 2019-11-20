package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
	private String contactID;
	private String accountID;
	private boolean isPrimary;
	private String firstName;
	private String lastName;

	public Contact(String contactID, String accountID, boolean isPrimary, String firstName, String lastName) {
		this.contactID = contactID;
		this.accountID = accountID;
		this.isPrimary = isPrimary;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean primary) {
		isPrimary = primary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
