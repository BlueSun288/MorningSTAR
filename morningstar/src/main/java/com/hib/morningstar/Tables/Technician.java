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
public class Technician implements HibernateObject{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String technicianId;
	private String fName;
	private String lName;
	private String branchOfficeId;
	
	public Technician() {
		super();
	}
	
	public Technician(String technicianId, String fName, String lName, String branchOfficeId) {
		super();
		this.technicianId = technicianId;
		this.fName = fName;
		this.lName = lName;
		this.branchOfficeId = branchOfficeId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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
	
	public void save() {	//Saves this Ticket
		Session ses = App.createSession();
		Transaction tx = ses.beginTransaction();
    	ses.save(this);
    	tx.commit();
	}

	@Override
	public JSONObject toJSON() {
		JSONObject out = new JSONObject();
		out.put("technicianid", this.getTechnicianId());
		out.put("fname", this.getfName());
		out.put("lname", this.getlName());
		out.put("branchofficeid", this.getBranchOfficeId());
		
		return out;
	}
	
	
}
