package com.hib.morningstar.Tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.morningstar.App;

@Entity
public class Asset implements HibernateObject{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String assetID;
	private String ticketID;
	private String name;

	public Asset(String assetID, String ticketID, String name) {
		this.assetID = assetID;
		this.ticketID = ticketID;
		this.name = name;
	}

	private Asset() {
		super();
	}

	public String getAssetID() {
		return assetID;
	}

	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void save() {	//Saves this Ticket
		Session ses = App.createSession();
		Transaction tx = ses.beginTransaction();
    	ses.save(this);
    	tx.commit();
	}
}
