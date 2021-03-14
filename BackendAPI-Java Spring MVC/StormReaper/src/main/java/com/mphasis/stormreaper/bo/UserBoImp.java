package com.mphasis.stormreaper.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.stormreaper.dao.UserDao;
import com.mphasis.stormreaper.entities.Admin;
import com.mphasis.stormreaper.entities.Passenger;
import com.mphasis.stormreaper.entities.Ticket;
import com.mphasis.stormreaper.entities.User;


@Service
public class UserBoImp implements UserBo {

@Autowired
UserDao userDao;
	 public int addUser(User u) {
		  User user=u;
		 try {
		  if(u.getEmailid().matches("([a-zA-Z0-9]{8,})@gmail.com") && u.getPassword().matches("[a-zA-Z0-9]{8,}"))
			  userDao.addUser(u);
			  else
			  throw new Exception("Invalid Credentials");
			  
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		
		return 1;
	 }
   
	 
	 
	public void deleteUser(String emailid) {
		userDao.deleteUser(emailid);
	}

	public User getUserByEmailId(String emailid) {
		User user=userDao.getUserByEmailId(emailid);
		return user;
	}

	public void editUser(User u) {
		userDao.editUser(u);
		
	}

	public User loginUser(String emailid, String password) {
		
		User user=null;
		try{if(emailid.matches("([a-zA-Z0-9]{8,})@gmail.com") && password.matches("[a-zA-Z0-9]{8,}"))
			user=userDao.loginUser(emailid, password);
		else
			throw new Exception("invalid pattern");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	
}



	public List getScheduleDetails(int schedule_id) {
		 return userDao.getScheduleDetails(schedule_id);
		
	}



	public List<Ticket> getViewReservedTicket(int passenger_id) {
		return userDao.getViewReservedTicket(passenger_id);
		
	}




}




































/*public User login(String email, String pass) throws Exception{
		User user=null;
		if(email.matches("([a-zA-Z0-9]{8,})@gmail.com") && pass.matches("[a-zA-Z]{8,}"))
			user=userDao.login(email, pass);
		else
			throw new Exception("invalid pattern");
		return user;
	} */
 
 

