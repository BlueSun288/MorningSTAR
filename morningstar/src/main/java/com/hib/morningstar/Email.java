package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Email {
	@Id
	private String contactID;
	private String email;

	public Email(String contactID, String email) {
		this.contactID = contactID;
		this.email = email;
	}

	public Email() {

	}

	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
