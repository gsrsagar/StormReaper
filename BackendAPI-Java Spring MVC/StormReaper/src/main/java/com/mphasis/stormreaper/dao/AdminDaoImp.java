package com.mphasis.stormreaper.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.stormreaper.entities.Admin;
import com.mphasis.stormreaper.entities.Route;

@Repository
public class AdminDaoImp implements AdminDao {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addAdmin(Admin a) {
	    Session session= sessionFactory.openSession();
	   Transaction tr=session.beginTransaction();
	    session.save(a);
	    tr.commit();
	   session.close();
	  
//		return 1;
	    
	}

	public void removeAdmin(int  aid) {
		Session session= sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
	    Admin a=(Admin) session.get(Admin.class, aid); 
		session.delete(a);
		   tr.commit();
		   session.close();


	}

	public Admin getAdminById(int aid) {
		Session session= sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Admin admin = (Admin) session.get(Admin.class,aid);
		tr.commit();
	   session.close();
	   return admin;
	}

	public Admin loginAdmin(int aid, String adminpassword) {
		Session session= sessionFactory.openSession();
		 Transaction tr=session.beginTransaction();
		 // Admin admin=(Admin) session.createCriteria(Admin.class).add(Restrictions.eq("aid",aid));
		 Criteria cr= session.createCriteria(Admin.class);
		 Criterion name = Restrictions.eq("aid", aid);
		 Criterion pass = Restrictions.eq("adminpassword",adminpassword);
		 
		 LogicalExpression andExp = Restrictions.and(name, pass);
		 cr.add( andExp );
		 Admin admin=(Admin) cr.uniqueResult();
		/*TypedQuery<Admin> query= session.createQuery("from Admin where aid=:aid and adminpassword=:adminpassword");
		query.setParameter("aid", aid) ;
		query.setParameter("adminpassword", adminpassword);*/
		/*Admin admin=query.getSingleResult();*/
		tr.commit();
		  
		   return admin;
	
	}
	

}
