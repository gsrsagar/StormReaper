package com.mphasis.stormreaper.dao;

import java.util.List;


import com.mphasis.stormreaper.entities.Schedule;

public interface ScheduleDao {
	public List<Schedule> getAllSchedules();
	public Schedule getScheduleById(int scheduleid);
	public void addSchedule(Schedule schedule);
	public void deleteSchedule(int scheduleid);
	public void editSchedule(Schedule schedule);
}
