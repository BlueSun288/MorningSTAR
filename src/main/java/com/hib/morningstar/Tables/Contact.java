package com.hib.morningstar.Tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;

import com.hib.morningstar.App;

@Entity
public class Contact implements HibernateObject{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String contactID;
	private String accountID;
	private boolean isPrimary;
	private String fName;
	private String lName;

	public Contact(String accountID, boolean isPrimary, String firstName, String lastName) {
		
		this.accountID = accountID;
		this.isPrimary = isPrimary;
		this.fName = firstName;
		this.lName = lastName;
	}
	
	public Contact() {
		super();
	}

	public Contact(JSONObject nCo) {
		this.accountID = (String) nCo.get("accountid");
		this.isPrimary = (Boolean) nCo.get("isprimary");
		this.fName = (String) nCo.get("firstname");
		this.lName = (String) nCo.get("lastname");
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

	public boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(boolean primary) {
		isPrimary = primary;
	}

	public String getFirstName() {
		return fName;
	}

	public void setFirstName(String firstName) {
		this.fName = firstName;
	}

	public String getLastName() {
		return lName;
	}

	public void setLastName(String lastName) {
		this.lName = lastName;
	}
	
	public void save() {	//Saves this Ticket
		Session ses = App.createSession();
		Transaction tx = ses.beginTransaction();
    	ses.save(this);
    	tx.commit();
	}

	@Override
	public JSONObject toJSON() {
		JSONObject out = new JSONObject();
		out.put("contactid", this.getContactID());
		out.put("accountid", this.getAccountID());
		out.put("isprimary", this.getIsPrimary());
		out.put("fname", this.getFirstName());
		out.put("lname", this.getLastName());
		
		return out;
	}

}
