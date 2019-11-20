package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.time.Instant;
@Entity
public class Ticket {
	@Id
	private String ticketId;
	private String accountId;
	private String contactId;
	private String service;
	private String status;
	private String startDate;
	private String timeSpent;
	private double priceRate;
	private String branchOfficeId;
	private String technicianId;
	
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
