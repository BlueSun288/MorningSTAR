package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BranchOffice {
	@Id
	private String branchOfficeID;
	private String branchName;
	private String branchAddress;

	public BranchOffice(String branchOfficeID, String branchName, String branchAddress) {
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

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
}
