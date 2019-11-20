package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BranchOffice {
	@Id
	private String branchOfficeID;
	private String branchName;
	private Address branchAddress;

	public BranchOffice(String branchOfficeID, String branchName, Address branchAddress) {
		this.branchOfficeID = branchOfficeID;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
	}

	public BranchOffice() {

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

	public Address getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(Address branchAddress) {
		this.branchAddress = branchAddress;
	}
}
