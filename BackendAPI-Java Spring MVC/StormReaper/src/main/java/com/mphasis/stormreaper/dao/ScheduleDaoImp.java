package com.mphasis.stormreaper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.stormreaper.entities.Schedule;

@Repository
public class ScheduleDaoImp implements ScheduleDao {

	@Autowired
	SessionFactory sessionFactory;
	public List<Schedule> getAllSchedules() {
		Session session= sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Schedule> schedules=session.createCriteria(Schedule.class).list();
		tr.commit();
		session.close();
		return schedules;
	}

	public Schedule getScheduleById(int scheduleid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Schedule schedule=(Schedule) session.get(Schedule.class,scheduleid);
		tr.commit();
		session.close();
		return schedule;
	}

	public void addSchedule(Schedule schedule) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(schedule);
		tr.commit();	
		session.close();
	}

	public void deleteSchedule(int scheduleid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Schedule schedule=(Schedule) session.get(Schedule.class ,scheduleid);
		session.delete(schedule);
		tr.commit();
		session.close();

	}

	
	public void editSchedule(Schedule schedule) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(schedule);
		tr.commit();
		session.close();
		
	}

}