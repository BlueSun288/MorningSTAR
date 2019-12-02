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
public class TicketUpdate implements HibernateObject{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ticketUpdateId;
	private String ticketId;
	private String body;
	private String technicianId;
	
	public TicketUpdate() {
		super();
	}
	public TicketUpdate(String ticketUpdateId, String ticketId, String body, String technicianId) {
		super();
		this.ticketUpdateId = ticketUpdateId;
		this.ticketId = ticketId;
		this.body = body;
		this.technicianId = technicianId;
	}

	public TicketUpdate(JSONObject nUp) {
		this.ticketUpdateId = (String) nUp.get("ticketupdateid");
		this.ticketId = (String) nUp.get("ticketid");
		this.body = (String) nUp.get("body");
		this.technicianId = (String) nUp.get("technicianid");

	}
	public String getTicketUpdateId() {
		return ticketUpdateId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
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
		out.put("ticketupdateid", this.getTicketUpdateId());
		out.put("ticketid", this.getTicketId());
		out.put("body", this.getBody());
		out.put("technicianid", this.getTechnicianId());

		return out;
	}
	
}
