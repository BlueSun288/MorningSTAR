package com.hib.morningstar.Tables;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.morningstar.App;

import java.util.Date;

public class Appointment implements HibernateObject{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String appointmentID;
	private String ticketID;
	private Date date;

	public Appointment(String appointmentID, String ticketID, Date date) {
		this.appointmentID = appointmentID;
		this.ticketID = ticketID;
		this.date = date;
	}

	public Appointment() {
		super();
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
	
	public void save() {	//Saves this Ticket
		Session ses = App.createSession();
		Transaction tx = ses.beginTransaction();
    	ses.save(this);
    	tx.commit();
	}
}
