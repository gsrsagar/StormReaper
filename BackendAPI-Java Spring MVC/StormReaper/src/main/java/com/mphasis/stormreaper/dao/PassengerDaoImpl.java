package com.mphasis.stormreaper.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.stormreaper.entities.Passenger;


@Repository
public class PassengerDaoImpl implements PassengerDao {
    
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List addPassenger(Passenger p) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		long c=p.getContactno();
		tr.commit();
		Transaction tr1=session.beginTransaction();
		session.save(p);
		tr1.commit();
		Criteria cr = session.createCriteria(Passenger.class);
		cr.add(Restrictions.eq("contactno", c));
		List results = cr.list();
		//Passenger p1=(Passenger) session.createCriteria(Passenger.class).add(Restrictions.eq("contactno",c));
		
	  session.close();
		return results;
	}

	public void deletePassenger(String id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Passenger p=(Passenger) session.get(Passenger.class, id);
		session.delete(p);
		tr.commit();
		session.close();
	}

	public void editPassenger(Passenger p) {
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(p);
		tr.commit();
		session.close();
	   
	}

	public Passenger getPassengerById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Passenger p=(Passenger) session.get(Passenger.class, id);
		tr.commit();
		session.close();
		return p;
		
	}

	public List<Passenger> getAllPassengers() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Passenger> p=session.createCriteria(Passenger.class).list();
		tr.commit();
		session.close();
		return p;
		
	}

	
}
