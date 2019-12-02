package Top.Tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;

import Top.App;

@Entity
public class PurchaseOrder implements HibernateObject{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String purchaseOrderId;		//Unique Identifier
	private String ticketId;			//ID of associated ticket
	private String description;			//Description of purchase. 
	private double price;				//Price to customer
	
	public PurchaseOrder() {
		super();
	}
	
	public PurchaseOrder(String ticketId, String description, double price) {
		super();
		
		this.ticketId = ticketId;
		this.description = description;
		this.price = price;
	}


	public PurchaseOrder(JSONObject nPO) {
		this.ticketId = (String) nPO.get("ticketid");
		this.description = (String) nPO.get("description");
		this.price = (double) nPO.get("price");
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
	
	public void save() {	//Saves this Ticket
		Session ses = App.createSession();
		Transaction tx = ses.beginTransaction();
    	ses.save(this);
    	tx.commit();
	}

	@Override
	public JSONObject toJSON() {
		JSONObject out = new JSONObject();
		out.put("purchaseorderid", this.getPurchaseOrderId());
		out.put("ticketid", this.getTicketId());
		out.put("description", this.getDescription());
		out.put("price", this.getPrice());
		
		return out;
	}
	
	
}
