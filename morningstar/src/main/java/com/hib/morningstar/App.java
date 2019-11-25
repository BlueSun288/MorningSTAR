package com.hib.morningstar;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONObject;

import com.hib.morningstar.Tables.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SuppressWarnings("unchecked")
public class App 
{
    public static void main( String[] args ) throws JsonProcessingException{
        App ap = new App();
        
        List tl = ap.getAllOpenTickets();
        //for(Object cur : tl) {
        //	System.out.println(cur);
        //}
        Ticket tk = new Ticket("1","1","Remote", "Open", "1", "1");
        tk.save();
    }
    
    public static Session createSession() {	//Creates Hibernate session 
    	Configuration con = new Configuration().configure().addAnnotatedClass(Ticket.class);
		SessionFactory sf = con.buildSessionFactory();
		return sf.openSession();

    }
    
    
	public List getAllOpenTickets() throws JsonProcessingException {		
		//Returns a list of all tickets where status != "Closed"
		//Sorted by startDate
		List ticketList;	//List of all open tickets
		
		
		Session ses = createSession();
		
		Criteria cri = ses.createCriteria(Ticket.class);
		cri.add(Restrictions.not(
		Restrictions.in("status", "Closed")
				));
		
		ticketList = cri.list();
		
		Collections.sort(ticketList, new SortTicketsByStartDate());
		ObjectMapper obj = new ObjectMapper();
		
		for (Object cur : ticketList) {
			cur = obj.writeValueAsString(cur);
			System.out.println(cur);
		}
		
		return ticketList;
	}
	
	public static void createAccount(JSONObject nAc) {
		Account ac = new Account(nAc);
		ac.save();
	}
	
	public static String getTicket(String id) throws JsonProcessingException {	//Returns all the data for a single ticket
		Session ses = createSession();
		Ticket tk = (Ticket) ses.get(Ticket.class, id);
		
		return new ObjectMapper().writeValueAsString(tk);
	}
	
	public static void createTicket(JSONObject nTk) {
		
			
		Ticket tk = new Ticket(nTk);
		tk.save();
	}
	
	public static void updateTicket(JSONObject nUp) {
		TicketUpdate Up = new TicketUpdate(nUp);
	}
		
	class SortTicketsByStartDate implements Comparator<Ticket>{
		
		public int compare(Ticket a, Ticket b) {
			return (int) (Long.parseLong(a.getStartDate()) - Long.parseLong(b.getStartDate()));
		}
		
	}    
}
