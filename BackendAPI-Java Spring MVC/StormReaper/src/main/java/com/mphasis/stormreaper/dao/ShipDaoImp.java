package com.mphasis.stormreaper.dao;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.stormreaper.entities.Passenger;
import com.mphasis.stormreaper.entities.Route;
import com.mphasis.stormreaper.entities.Schedule;
import com.mphasis.stormreaper.entities.Ship;
import com.mphasis.stormreaper.entities.Ticket;

@Repository
public class ShipDaoImp implements ShipDao {

@Autowired
	SessionFactory sessionFactory;
	
	public int addShip(Ship sh) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		   session.save(sh);
		   tr.commit();
		   session.close();
			return 1;
		}
   public void editShip(Ship sh) {
	   Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		   session.update(sh);
		   tr.commit();
		   session.close();
}
   public void deleteShip(int shipid) {
	Session session=sessionFactory.openSession();
	Transaction tr=session.beginTransaction();
		Ship ship=(Ship) session.get(Ship.class,shipid); 
	   session.delete(ship);
		   tr.commit();
		   session.close();
	}

public Ship getShipById(int shipid) {
	Session session=sessionFactory.openSession();
	Transaction tr=session.beginTransaction();
	   Ship s=(Ship)session.get(Ship.class,shipid);
		tr.commit();
		session.close();
		return s;
	}
public List getShipByName(String shipname) {
	Session session=sessionFactory.openSession();
	Transaction tr=session.beginTransaction();
	/*Ship s=(Ship) session.createCriteria(Ship.class)
			.add(Restrictions.eq("shipname", shipname));*/
	/*
	NativeQuery query = session.createSQLQuery("select journeydate, seat_no, passenger_id from"
			+ " shipticket where passenger_id=:passenger_id ");
	//.addEntity(Ship.class).addScalar("journeydate").
			//addScalar("passenger_id").addScalar("seat_no");
	quer9y.setParameter("passenger_id", passenger_id);
	Passenger rows = (Passenger) query.getSingleResult();*/  
	/*Ship s=(Ship) session.createCriteria(Ship.class).add(Restrictions.eq("shipname", shipname));*/
	//Ship c=session.get(Ship.class,shipname);
 /*Ship s=(Ship) c;*/
/* tr.commit();
 session.close();
return rows;*/                         //      this is reference
	
	
	NativeQuery query = session.createSQLQuery("select * from shipprojectship where shipname=:shipname");
	query.setParameter("shipname", shipname);
	List rows = query.list();
	tr.commit();
	session.close();
	return rows;              // this is correct


}

public List<Ship> getAllShips(){
	
	Session session=sessionFactory.openSession();
	Transaction tr=session.beginTransaction();
	List<Ship> ships=(List<Ship>) session.createCriteria(Ship.class).list();
	tr.commit();
	session.close();
	return ships; 
}
public List<Ship> getShipByRouteId(int route_id) {
	Session session=sessionFactory.openSession();
	Transaction tr=session.beginTransaction();

    System.out.println(route_id);
	 TypedQuery query = session.createQuery(" from ShipProjectShip where route_id=:route_id");		
     query.setParameter("route_id",route_id);

List<Ship> rows=  query.getResultList();
//System.out.println("Ticket details are"+ rows);
//Ticket t=(Ticket) session.get("passenger_id","passenger_id");		
tr.commit();
//	Ship s=(Ship) cr1.uniqueResult();
    System.out.println(rows);
	
	session.close();
	
	return rows;
}


}

