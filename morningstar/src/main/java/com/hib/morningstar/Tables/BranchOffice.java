package com.hib.morningstar.Tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.morningstar.App;

@Entity
public class BranchOffice implements HibernateObject{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String branchOfficeID;
	private String branchName;
	private String branchAddress;

	public BranchOffice(String branchOfficeID, String branchName, String branchAddress) {
		this.branchOfficeID = branchOfficeID;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
	}

	public BranchOffice() {
		super();
	}

	public String getBranchOfficeID() {
		return branchOfficeID;
	}

	public void setBranchOfficeID(String branchOfficeID) {
		this.branchOfficeID = branchOfficeID;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	public void save() {	//Saves this Ticket
		Session ses = App.createSession();
		Transaction tx = ses.beginTransaction();
    	ses.save(this);
    	tx.commit();
	}
}
