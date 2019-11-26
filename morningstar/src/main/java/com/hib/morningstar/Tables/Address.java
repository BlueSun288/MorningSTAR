package com.hib.morningstar.Tables;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;

import com.hib.morningstar.App;

public class Address implements HibernateObject{
	private int buildingNumber;
	private String street;
	private String city;
	private String state;
	private int zip;

	public Address(int buildingNumber, String street, String city, String state, int zip) {
		this.buildingNumber = buildingNumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Address() {
		super();
	}

	public int getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address{" +
				"buildingNumber=" + buildingNumber +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zip=" + zip +
				'}';
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
		/*
		 * out.put("aaaaaa", this.getaaaaa); out.put("aaaaaa", this.getaaaaa);
		 * out.put("aaaaaa", this.getaaaaa); out.put("aaaaaa", this.getaaaaa);
		 * out.put("aaaaaa", this.getaaaaa); out.put("aaaaaa", this.getaaaaa);
		 */
		return out;
	}
}
