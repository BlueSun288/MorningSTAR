package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.time.Instant;
@Entity
public class Ticket {
	@Id
	private String ticketId;		//Unique identifier. Cannot be changed
	private String accountId;		//id of associated account. Can be changed
	private String contactId;		//id of associated contact on account. Can be changed
	private String service;			//Type of service 
	private String status;			//Status of ticket
	private String startDate;		//Date when ticket was created
	private String timeSpent;		//Time spent 
	private double priceRate;		//Rate client pays
	private String branchOfficeId;	//ID ticket was created at and any asset needs to be returned to
	private String technicianId;	//ID of tech currently working on ticket
	
	public Ticket(String ticketId, String accountId, String contactId, String service, String status, String timeSpent,
			double priceRate, String branchOfficeId, String technicianId) {
		super();
		this.ticketId = ticketId;
		this.accountId = accountId;
		this.contactId = contactId;
		this.service = service;
		this.status = status;
		this.startDate = Long.toString(System.currentTimeMillis());
		this.timeSpent = timeSpent;
		this.priceRate = priceRate;
		this.branchOfficeId = branchOfficeId;
		this.technicianId = technicianId;
		
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getTimeSpent() {
		return timeSpent;
	}

	public void incTimeSpent(String timeSpent) {	//Increments total time spent 
		
		this.timeSpent = this.timeSpent + timeSpent;
	}

	public double getPriceRate() {
		return priceRate;
	}

	public void setPriceRate(double priceRate) {
		this.priceRate = priceRate;
	}

	public String getBranchOfficeId() {
		return branchOfficeId;
	}

	public void setBranchOfficeId(String branchOfficeId) {
		this.branchOfficeId = branchOfficeId;
	}

	public String getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}

	public String getTicketId() {
		return ticketId;
	}
	
	
	
	
}
