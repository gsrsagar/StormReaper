package com.mphasis.stormreaper.bo;

import java.util.List;

import com.mphasis.stormreaper.entities.Route;
import com.mphasis.stormreaper.entities.Schedule;

public interface ScheduleBo {
	public List<Schedule> getAllSchedules();
	public Schedule getScheduleById(int scheduleid);
	public void addSchedule(Schedule schedule);
	public void editSchedule(Schedule schedule);
	public void deleteSchedule(int scheduleid);

}
