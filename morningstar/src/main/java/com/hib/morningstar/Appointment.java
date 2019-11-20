package com.hib.morningstar;

import javax.persistence.Id;
import java.util.Date;

public class Appointment {
	@Id
	private String appointmentID;
	private String ticketID;
	private Date date;

	public Appointment(String appointmentID, String ticketID, Date date) {
		this.appointmentID = appointmentID;
		this.ticketID = ticketID;
		this.date = date;
	}

	private Appointment() {

	}

	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
