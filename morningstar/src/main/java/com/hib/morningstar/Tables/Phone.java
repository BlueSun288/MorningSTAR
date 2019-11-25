package com.hib.morningstar.Tables;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.morningstar.App;

@Entity
public class Phone implements HibernateObject{
	@Id
	private String contactID;
	private String phoneNumber;

	public Phone(String contactID, String phoneNumber) {
		this.contactID = contactID;
		this.phoneNumber = phoneNumber;
	}

	public Phone() {
		super();
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
	
	public void save() {	//Saves this Ticket
		Session ses = App.createSession();
		Transaction tx = ses.beginTransaction();
    	ses.save(this);
    	tx.commit();
	}
}
