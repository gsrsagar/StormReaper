package com.mphasis.stormreaper.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.stormreaper.dao.TicketDao;
import com.mphasis.stormreaper.entities.Ticket;
@Service
public class TicketBoImp implements TicketBo {

	@Autowired
TicketDao ticketDao;

 public Ticket getByTicketno(String ticketno) {
	return ticketDao.getByTicketno(ticketno);
}

public void addTicket(Ticket ticket) {
	 ticketDao.addTicket(ticket);
	
}

public void editTicket(Ticket t) {
	 ticketDao.editTicket(t);
}

public void deleteTicket(String ticketno) {
	 ticketDao.deleteTicket(ticketno);
	
}

public List<Ticket> getAllTickets() {
	return ticketDao.getAllTickets();
}


}

