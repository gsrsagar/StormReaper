package com.mphasis.stormreaper.bo;

import java.util.List;

import com.mphasis.stormreaper.entities.Ticket;
import com.mphasis.stormreaper.entities.Ticket;
import com.mphasis.stormreaper.entities.User;

public interface TicketBo {
	public Ticket getByTicketno(String ticketno);
	public void addTicket(Ticket t);
	public void editTicket(Ticket t);
	public void deleteTicket(String id);
	public List<Ticket> getAllTickets();

}
