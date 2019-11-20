package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Asset {
	@Id
	private String assetID;
	private String ticketID;
	private String name;

	public Asset(String assetID, String ticketID, String name) {
		this.assetID = assetID;
		this.ticketID = ticketID;
		this.name = name;
	}

	private Asset() {

	}

	public String getAssetID() {
		return assetID;
	}

	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
