package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TicketUpdate {
	@Id
	private String ticketUpdateId;
	private String ticketId;
	private String body;
	private String technicianId;
	
	public TicketUpdate(String ticketUpdateId, String ticketId, String body, String technicianId) {
		super();
		this.ticketUpdateId = ticketUpdateId;
		this.ticketId = ticketId;
		this.body = body;
		this.technicianId = technicianId;
	}

	public String getTicketUpdateId() {
		return ticketUpdateId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}
	
	
	
}
