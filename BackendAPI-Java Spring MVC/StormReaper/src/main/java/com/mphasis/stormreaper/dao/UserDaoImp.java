package com.mphasis.stormreaper.dao;

import java.util.List;
import java.util.Objects;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.stormreaper.entities.Passenger;
import com.mphasis.stormreaper.entities.Schedule;
import com.mphasis.stormreaper.entities.Ship;
import com.mphasis.stormreaper.entities.Ticket;
import com.mphasis.stormreaper.entities.User;

@Repository
public class UserDaoImp implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public int addUser(User u) {
		 Session session= sessionFactory.openSession();
		 Transaction tr=session.beginTransaction();
		   session.save(u);
		     tr.commit();
		     session.close();
			return 1;
	}

	public void deleteUser(String emailid) {
		 Session session= sessionFactory.openSession();
		 Transaction tr=session.beginTransaction();
		  User u=(User) session.get(User.class, emailid);
		 session.delete(u);
		   session.close();
		   tr.commit();

	}

	public User getUserByEmailId(String emailid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		 User u=(User) session.get(User.class, emailid);
		tr.commit();
		session.close();
		return u;
	}

	public void editUser(User u) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(u);
		tr.commit();
		session.close();
		
	}

	public User loginUser(String emailid, String password) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		 User u=(User) session.get(User.class, emailid);
		tr.commit();
		session.close();
		return u;
		
	}

	public List getScheduleDetails(int schedule_id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		/*NativeQuery query = session.createSQLQuery("select shipprojectship.source,"
				+ "shipprojectship.destination, "
				+ "shipticket.journeydate from shipprojectship join "
				+ "shipticket on"
				+ " shipprojectship.schedule_id=shipticket.schedule_id"
				+ " where shipprojectship.schedule_id=:schedule_id");*/
				//.addEntity(Ship.class).addEntity(Ticket.class).addEntity(Schedule.class);
				/*.addScalar("source")
				.addScalar("destination")
				.addScalar("journeydate");*/
		NativeQuery query = session.createSQLQuery("select shipprojectship.source,"
				+ "shipprojectship.destination, "
				+ "shipticket.journeydate from shipprojectship join "
				+ "shipticket on"
				+ " shipprojectship.schedule_id=shipticket.schedule_id"
				+ " where shipprojectship.schedule_id=:schedule_id");
		query.setParameter("schedule_id", schedule_id);
		List rows = query.list();
		System.out.println("details are"+rows);
		tr.commit();
		session.close();
		return rows;
		
		/*
		Criteria c=session.createCriteria(Ship.class).add(Restrictions.eq("schedule",schedule_id));
		List c1=c;*/
		/*Schedule schedul=s.getSchedule();
	 Criteria cr=session.createCriteria(Ship.class).add(Restrictions.eq("schedule", schedul));*/
	  
		
		
	}

	public List<Ticket> getViewReservedTicket(int passenger_id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		//NativeQuery query = session.createSQLQuery("select * from"
			//	+ " shipticket where passenger_id=:passenger_id ");	
//				+ " shipticket where passenger_id=:passenger_id ");
	 TypedQuery query = session.createQuery(" from ShipTicket where passenger_id=:passenger_id");
// NativeQuery query = session.createSQLQuery("select journeydate, seat_no, passenger_id from"
//				+ " shipticket where passenger_id=:passenger_id ");		
	/*.addEntity(Ship.class).addScalar("journeydate").*/
	
			//addScalar("passenger_id").addScalar("seat_no");		
	 query.setParameter("passenger_id", passenger_id);
		//Passenger rows = (Passenger) query.getSingleResult();*/
		List<Ticket> rows=  query.getResultList();
		//System.out.println("Ticket details are"+ rows);
		//Ticket t=(Ticket) session.get("passenger_id","passenger_id");		
		tr.commit();
	 session.close();
	return rows;
		
		
	
		
		//to practise one and only for sagar
		
		/*Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();*/
		/*NativeQuery query = session.createSQLQuery("select journeydate, seat_no, passenger_id from"
				+ " shipticket where passenger_id=:passenger_id ");
		//.addEntity(Ship.class).addScalar("journeydate").
				//addScalar("passenger_id").addScalar("seat_no");
		query.setParameter("passenger_id", passenger_id);
		Passenger rows = (Passenger) query.getSingleResult();
		List rows=  query.list();
		System.out.println("Ticket details are"+ rows);
		tr.commit();*/
		
		
	}
	
    
	

}
