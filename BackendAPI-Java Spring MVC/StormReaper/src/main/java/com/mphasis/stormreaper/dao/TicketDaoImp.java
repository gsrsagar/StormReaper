package com.mphasis.stormreaper.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.mphasis.stormreaper.entities.Passenger;
import com.mphasis.stormreaper.entities.Schedule;
import com.mphasis.stormreaper.entities.Ship;
import com.mphasis.stormreaper.entities.Ticket;

@Repository
public class TicketDaoImp implements TicketDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	
	public void addTicket(Ticket t) {	
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		
		Passenger p2=t.getPassenger();
		 Criteria cr2=session.createCriteria(Ticket.class);
		 Criterion pass1 = Restrictions.eq("passenger", p2);
		 Criterion jd1 = Restrictions.eq("journeydate",t.getJourneydate());
		 
		 LogicalExpression orExp1 = Restrictions.and(pass1, jd1);
		 cr2.add( orExp1 );
		 
		Ticket ticket1= (Ticket) cr2.uniqueResult();
		 if(pass1==null)
		 {
		session.save(t);
		 tr.commit();
		 Passenger p1=t.getPassenger();
		 Criteria cr=session.createCriteria(Ticket.class);
		 Criterion pass = Restrictions.eq("passenger", p1);
		 Criterion jd = Restrictions.eq("journeydate",t.getJourneydate());
		 
		 LogicalExpression orExp = Restrictions.and(pass, jd);
		 cr.add( orExp );
		 
		Ticket ticket= (Ticket) cr.uniqueResult();
		System.out.println(ticket.getTicketno());
		
		
		Schedule sc1=ticket.getSchedule();
		Criteria cr1=session.createCriteria(Ship.class);
		cr1.add(Restrictions.eq("schedule", sc1));
		
		Ship s=(Ship) cr1.uniqueResult();
		System.out.println("subquery called"); 
		
			int seats= s.getSeatingcapacity();
			try{
				if(seats>0)
				{
			seats--;
			Transaction tr1=session.beginTransaction();
			 s.setSeatingcapacity(seats);
			 session.saveOrUpdate(s);
			// session.save(t);
			 tr1.commit();
			session.close();
			
				}
				else
				{
					throw new Exception("Seats are not available ");
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
		 }
		 else
		 {
			 System.out.println("Already passenger is there");
		 }
	}
			
			
			
			/*///*Query<Ship> query=session.createSQLQuery("select * from ShipProjectShip where shipid=(select shipid from ShipProjectShip where schedule_id=(select schedule_id from ShipTicket where ticketno=:ticketno1 ) ) ");						
		       query.setParameter("ticketno1", ticket.getTicketno());
		       System.out.println("subquery called");
		       List<Ship> ships=query.list();
		   //    List<Ship> ships=query.setResultTransformer(new AliasToBeanResultTransformer(Ship.class)).list();
		       Ship s=ships.get(0);
		       System.out.println(s);*/
//		       for(Ship ship:shs) {
//		    	   
//		       }
//		     List s1= (List) query.setResultTransformer(Transformers.aliasToBean(Ship.class)).list();
//		       Ship s= query.uniqueResult();
//		        
			
			
			
			
			
			
			
			
			
			
	 /*  NativeQuery q1=session.createSQLQuery("select * from shipticket where passenger_id=:passid and journeydate=:jdate");
	   Passenger p1=t.getPassenger();
	   System.out.println("controller called "+p1.getAge());
	   String pid=p1.getPid();
	   q1.setParameter("passid", pid);
	   q1.setParameter("jdate", t.getJourneydate());
	  //System.out.println(q1.uniqueResult());
	Object object=q1.list().stream().findFirst();*/
	//Ticket ticket=(Ticket) object;
	  // System.out.println(ticket.getTicketno());
		 
//        String ticketno1=t.getTicketno();
//       System.out.println(ticketno1);
    /*  Query query=session.createSQLQuery("select * from ShipProjectShip where shipid=(select shipid from ShipProjectShip where schedule_id=(select schedule_id from ShipTicket where ticketno=:ticketno1 ) ) ");						
       query.setParameter("ticketno1", ticketno1);
      List s1= (List) query.setResultTransformer(Transformers.aliasToBean(Ship.class)).getSingleResult();
       Ship s= (Ship) query.getSingleResult();
        
		int seats= s.getSeatingcapacity();
		try{
			if(seats>0)
			{
		seats--;
		
		 s.setSeatingcapacity(seats);
		 session.saveOrUpdate(s);
		 session.save(t);
		 tr.commit();
		session.close();
		
			}
			else
			{
				throw new Exception("Seats are not available ");
			}
	}catch (Exception e) {
		e.printStackTrace();
	}*/
		
		
	
	
	/*sqlQuery.setResultTransformer(Transformers.aliasToBean(MYEngityName.class));
    sqlQuery.addScalar("txnId",Hibernate.LONG)
            .addScalar("merchantId",Hibernate.INTEGER)
            .addScalar("count",Hibernate.BYTE)
            .addScalar("retryReason")
            .addScalar("langCode");
    sqlQuery.setMaxResults(maxLimit);
    return sqlQuery.list();
	*/
	
	
	
	
	
	/*
	Query.setParameter("passenger_id", passenger_id);
	Passenger rows = (Passenger) query.getSingleResult();*/
	/*SQLQuery query2 = session.createSQLQuery( " select shipprojectship.shipid from  shipprojectship,"
	+ " shipticket where shipprojectship.schedule_id=shipticket.schedule_id");
//Ship  s=(Ship)session.get(Ship.class, );
* 
* /*SQLQuery query1 = session.createSQLQuery( "select schedule_id from shipticket where ticketno=ticketno1");
SQLQuery query1=session.createSQLQuery("((select shipprojectship.shipid from shipprojectship"
	+ "where shipprojectship.schedule_id=(select schedule_id from shipticket where ticketno=ticketno1)))");
//SQLQuery query2=("(select * from shipprojectship where shipid=(select shipprojectship.shipid from shipprojectship" + 
					+ "where shipprojectship.schedule_id=(select schedule_id from shipticket where ticketno=ticketno1)))");*/
/*Ship s=(Ship) session.get(Ship.class,"schedule_id");
Ship s1=s;*/
	
	public void editTicket(Ticket t) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(t);
		tr.commit();
		session.close();

	}

	public void deleteTicket(String ticketno) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Ticket  t=(Ticket) session.get(Ticket.class, ticketno);
		session.delete(t);
		tr.commit();
		session.close();
	}

	public Ticket getByTicketno(String ticketno) {
		Session session=sessionFactory.openSession(); 
		Transaction tr=session.beginTransaction();
		Ticket ticket=(Ticket) session.get(Ticket.class,ticketno);	
		tr.commit();
		session.close();
		return ticket;
	}

	public List<Ticket> getAllTickets() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Ticket> tickets=session.createCriteria(Ticket.class).list();
		tr.commit();
		session.close();
		return tickets;
	}

}
