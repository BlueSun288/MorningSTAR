package com.hib.morningstar;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hib.morningstar.Tables.Account;
import com.hib.morningstar.Tables.Appointment;
import com.hib.morningstar.Tables.Asset;
import com.hib.morningstar.Tables.Contact;
import com.hib.morningstar.Tables.PurchaseOrder;
import com.hib.morningstar.Tables.Ticket;
import com.hib.morningstar.Tables.TicketUpdate;


@SuppressWarnings("unchecked")
public class App 
{
    public static void main( String[] args ) throws JsonProcessingException{
        App ap = new App();
        
        JSONArray tl = ap.getAllOpenTickets();
        //for(Object cur : tl) {
        //	System.out.println(cur);
        //}
        
        try (FileWriter file = new FileWriter("tickets.json")) {
        	 
            file.write(tl.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Ticket tk = new Ticket("1","1","Remote", "Open", "1", "1");
        //tk.save();
    }
    
    public static Session createSession() {	//Creates Hibernate session 
    	Configuration con = new Configuration().configure().addAnnotatedClass(Ticket.class);
		SessionFactory sf = con.buildSessionFactory();
		return sf.openSession();

    }
    class SortTicketsByStartDate implements Comparator<Ticket>{
		
		public int compare(Ticket a, Ticket b) {
			return (int) (Long.parseLong(a.getStartDate()) - Long.parseLong(b.getStartDate()));
		}
		
	}
    
    ////////////////Create Objects
    ////////////////
    
	public void createAccount(JSONObject nAc) {
		Account ac = new Account(nAc);
		ac.save();
	}
	public void createTicket(JSONObject nTk) {
		
		Ticket tk = new Ticket(nTk);
		tk.save();
	}
	public void createContact(JSONObject nCo) {
		Contact co = new Contact(nCo);
		co.save();
	}
	public void createAsset(JSONObject nAs) {
		Asset as = new Asset(nAs);
		as.save();
	}
	public void createAppointment(JSONObject nAp) {
		Appointment ap = new Appointment(nAp);
		ap.save();
	}
	public void createPurchaseOrder(JSONObject nPO) {
		PurchaseOrder po = new PurchaseOrder(nPO);
		po.save();
	}
	public void createTicketUpdate(JSONObject nUp) {
		TicketUpdate up = new TicketUpdate(nUp);
		up.save();
	}
	
	////////////////Get Objects
	////////////////
	
	public JSONArray getAllOpenTickets() throws JsonProcessingException {		
		//Returns a list of all tickets where status != "Closed"
		//Sorted by startDate
		List<Ticket> ticketList;	//List of all open tickets
		JSONArray out = new JSONArray();
		
		Session ses = createSession();
		
		Criteria cri = ses.createCriteria(Ticket.class);
		cri.add(Restrictions.not(
		Restrictions.in("status", "Closed")
				));
		
		ticketList = cri.list();
		
		Collections.sort(ticketList, new SortTicketsByStartDate());
				
		for (Ticket tk : ticketList) {
			
			JSONObject cur = new JSONObject();
			cur.put("ticketid", tk.getTicketId());
			cur.put("accountid", tk.getAccountId());
			cur.put("contactid", tk.getContactId());
			cur.put("service", tk.getService());
			cur.put("status", tk.getStatus());
			cur.put("startdate", tk.getStartDate());
			cur.put("timespent", tk.getTimeSpent());
			cur.put("pricerate", tk.getPriceRate());
			cur.put("branchofficeid", tk.getBranchOfficeId());
			cur.put("technicianid", tk.getTechnicianId());
			out.add(cur);
		}
		
		return out;
	}

	public JSONObject getAccount(JSONObject tgt) {
		Session ses = createSession();
		Account acc = (Account) ses.get(Account.class, (String) tgt.get("accountid"));
		
		return acc.toJSON();
	}
	public JSONObject getContact(JSONObject tgt) {
		Session ses = createSession();
		Contact con = (Contact) ses.get(Contact.class, (String) tgt.get("contactid"));
		
		return con.toJSON();
	}
	public JSONArray getTicketAssets(JSONObject tgt) {
		JSONArray out = new JSONArray();
		List<Asset> ticketList;	//List of all account's tickets
		
		
		Session ses = createSession();
		
		Criteria cri = ses.createCriteria(Asset.class);
		cri.add(Restrictions.not(
		Restrictions.in("ticketid", tgt.get("ticketid"))
				));
		
		ticketList = cri.list();
		
		for (Asset tk : ticketList) {
			out.add(tk.toJSON());
		}
		return out;
	}
	public JSONArray getTicketAppointments(JSONObject tgt) {
		JSONArray out = new JSONArray();
		List<Appointment> appointmentList;	//List of all account's tickets
		
		
		Session ses = createSession();
		
		Criteria cri = ses.createCriteria(Appointment.class);
		cri.add(Restrictions.not(
		Restrictions.in("ticketid", tgt.get("ticketid"))
				));
		
		appointmentList = cri.list();
		
		
		
		for (Appointment tk : appointmentList) {
			out.add(tk.toJSON());
		}
		return out;
	}
	public JSONArray getTicketPurchaseOrders(JSONObject tgt) {
		JSONArray out = new JSONArray();
		List<PurchaseOrder> pruchaseOrderList;	//List of all account's tickets
		
		
		Session ses = createSession();
		
		Criteria cri = ses.createCriteria(PurchaseOrder.class);
		cri.add(Restrictions.not(
		Restrictions.in("ticketid", tgt.get("ticketid"))
				));
		
		pruchaseOrderList = cri.list();
					
		for (PurchaseOrder tk : pruchaseOrderList) {
			out.add(tk.toJSON());
		}
		return out;
	}
	public JSONArray getAccountTickets(JSONObject tgt) {
		JSONArray out = new JSONArray();
		List<Ticket> ticketList;	//List of all account's tickets
		
		
		Session ses = createSession();
		
		Criteria cri = ses.createCriteria(Ticket.class);
		cri.add(Restrictions.not(
		Restrictions.in("account", tgt.get("accountid"))
				));
		
		ticketList = cri.list();
		
		Collections.sort(ticketList, new SortTicketsByStartDate());
		
		for (Ticket tk : ticketList) {
			out.add(tk.toJSON());
		}
		return out;
	}
	public JSONObject getTicket(JSONObject tgt) throws JsonProcessingException {	//Returns all the data for a single ticket
		Session ses = createSession();
		Ticket tk = (Ticket) ses.get(Ticket.class, (String) tgt.get("ticketid"));
		
		
		return tk.toJSON();
	}
	
	
	
	
	
	
	
	
	    
}
