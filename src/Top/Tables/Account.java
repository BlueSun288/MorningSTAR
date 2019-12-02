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
public class Account implements HibernateObject{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String accountId;		//Unique Identifier
	private String type;		//Residential or Business
	private String business;	//If type == business then name of business otherwise null
	private String address;		//Address
	
	public Account(String newID, String newType, String newBusiness, String newAddress ) {
		accountId = newID;
		type = newType;
		address = newAddress;
		
		if(type == "Residential") {
			business = null;
		}else {
			business = newBusiness;
		}
	}
	
	public Account() {
		super();
	}
	
	public Account(JSONObject nAc) {
		accountId = (String) nAc.get("accountid");
		type = (String) nAc.get("type");
		address = (String) nAc.get("address");
		
		if(type == "Residential") {
			business = null;
		}else {
			business = (String) nAc.get("business");
		}

	}

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
		out.put("accountid", this.getAccountId());
		out.put("type", this.getType());
		out.put("business", this.getBusiness());
		out.put("address", this.getAddress());
		return out;
	}
	
}
