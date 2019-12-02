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
public class Asset implements HibernateObject{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String assetID;
	private String ticketID;
	private String name;

	public Asset(String ticketID, String name) {
		
		this.ticketID = ticketID;
		this.name = name;
	}

	private Asset() {
		super();
	}

	public Asset(JSONObject nAs) {
		this.ticketID = (String) nAs.get("ticketid");
		this.name = (String) nAs.get("name");
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
	
	public void save() {	//Saves this Ticket
		Session ses = App.createSession();
		Transaction tx = ses.beginTransaction();
    	ses.save(this);
    	tx.commit();
	}

	@Override
	public JSONObject toJSON() {
		JSONObject out = new JSONObject();
		out.put("assetid", this.getAssetID());
		out.put("ticketid", this.getTicketID());
		out.put("name", this.getName());
		
		return out;
	}
}
