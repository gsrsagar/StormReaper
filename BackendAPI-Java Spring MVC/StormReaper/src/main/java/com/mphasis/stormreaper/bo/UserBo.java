package com.mphasis.stormreaper.bo;

import java.util.List;

import com.mphasis.stormreaper.entities.Admin;
import com.mphasis.stormreaper.entities.Passenger;
import com.mphasis.stormreaper.entities.Ticket;
import com.mphasis.stormreaper.entities.User;

public interface UserBo {
	
	public int addUser(User u);
	public void deleteUser(String emailid);
	public User getUserByEmailId(String emailid);
	public void editUser(User u);
	public User loginUser(String emailid, String password);
	public List getScheduleDetails(int schedule_id);
	public List<Ticket> getViewReservedTicket(int passenger_id);

}
