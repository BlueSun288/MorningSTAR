package Top.Tables;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;

import Top.App;

@Entity
public class Email implements HibernateObject{
	@Id
	private String contactID;
	private String email;

	public Email(String contactID, String email) {
		this.contactID = contactID;
		this.email = email;
	}

	public Email() {
		super();
	}

	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		out.put("contactid", this.getContactID());
		out.put("email", this.getEmail());

		return out;
	}
}
