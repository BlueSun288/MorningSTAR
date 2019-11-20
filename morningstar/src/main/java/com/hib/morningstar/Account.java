package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private int accountId;		//Unique Identifier
	private String type;		//Residential or Business
	private String business;	//If type == business then name of business otherwise null
	private String address;		//Address
	
	public Account(int newID, String newType, String newBusiness, String newAddress ) {
		accountId = newID;
		type = newType;
		address = newAddress;
		
		if(type == "Residential") {
			business = null;
		}else {
			business = newBusiness;
		}
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
