package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PurchaseOrder {
	@Id
	private String purchaseOrderId;		//Unique Identifier
	private String ticketId;			//ID of associated ticket
	private String description;			//Description of purchase. 
	private double price;				//Price to customer
	
	
	public PurchaseOrder(String purchaseOrderId, String ticketId, String description, double price) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.ticketId = ticketId;
		this.description = description;
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}


	public String getTicketId() {
		return ticketId;
	}
	
	
	
	
}
