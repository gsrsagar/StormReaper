package com.mphasis.stormreaper.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mphasis.stormreaper.bo.PassengerBo;
import com.mphasis.stormreaper.bo.RouteBo;
import com.mphasis.stormreaper.bo.ScheduleBo;
import com.mphasis.stormreaper.bo.ShipBo;
import com.mphasis.stormreaper.bo.TicketBo;
import com.mphasis.stormreaper.bo.UserBo;
import com.mphasis.stormreaper.entities.Admin;
import com.mphasis.stormreaper.entities.Passenger;
import com.mphasis.stormreaper.entities.Route;
import com.mphasis.stormreaper.entities.Schedule;
import com.mphasis.stormreaper.entities.Ship;
import com.mphasis.stormreaper.entities.Ticket;
import com.mphasis.stormreaper.entities.User;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserBo userBo; 
	
	@Autowired
	PassengerBo passengerBo;
	
	@Autowired
	TicketBo ticketBo;
	
	@Autowired
	ScheduleBo scheduleBo;
	
	
	@Autowired
	RouteBo routeBo;
	
	@Autowired
	ShipBo shipBo;
	/*
	@RequestMapping(value="/viewpassengerschedule/{scheduleid}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
   public int addPassenger(@PathVariable Passenger p)
	{		passengerBo.addPassenger(p);
		return  1;
	
   }*/
	
	@RequestMapping(value="/getpassengerbyid/{pid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Passenger getpassengerById(@PathVariable("pid")String pid)
    {
		return passengerBo.getPassengerById(pid);
			
   }
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public int adduser(@RequestBody User u)
	{   
		 userBo.addUser(u);
		 System.out.println("controlled called");
		 return 1;
		 
	}
	
	@RequestMapping(value="/userlogin/{emailid}/{password}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public User adduser(@PathVariable ("emailid") String emailid, @PathVariable("password") String password )
	{
		return userBo.loginUser(emailid, password);
		
	}
	@RequestMapping(value="/getticketbyid/{ticketno}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket getTicketByNo(@PathVariable("ticketno") String ticketno)
	{
		return ticketBo.getByTicketno(ticketno);
	}
	
	
	
	@RequestMapping(value="/addpassenger",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	   public List addPassenger(@RequestBody Passenger p)
		{		
		System.out.println("Passanger Called");
		 return passengerBo.addPassenger(p);
		
		
	   }
	@RequestMapping(value="/bookticket",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	   public void addTicket(@RequestBody Ticket t)
		{	 	
			 ticketBo.addTicket(t);
		    
	   }	
	
	/*@RequestMapping(value="/getscheduledetails/{schedule_id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	   public List getScheduleDetails(@PathVariable("schedule_id") int schedule_id)
		{	 	
	      return userBo.getScheduleDetails(schedule_id);
		
	   }*/	
	

	@RequestMapping(value="/viewreservedticket/{passenger_id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	   public List<Ticket> getViewReservedTicket(@PathVariable("passenger_id") int passenger_id)
		{	 	
	       return userBo.getViewReservedTicket(passenger_id); 
		
	   }
	
	
	@RequestMapping(value="/getroutebyid/{routeid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Route getRouteById(@PathVariable("routeid") int routeid)
    {
		return routeBo.getRouteById(routeid);
			
		
    }
	
	@RequestMapping(value="/getallroutes",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Route> getAllRoutes()
    {
		return routeBo.getAllRoutes();
		
	}
	
	@RequestMapping(value="/getshipbyid/{shipid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Ship getShipById(@PathVariable("shipid")int shipid)
    {
		return shipBo.getShipById(shipid);
			
		
    }
	@RequestMapping(value="/getshipbyname/{shipname}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List getShipByName(@PathVariable("shipname")String shipname)
    {
		return shipBo.getShipbyName(shipname);
			
		
    }
	@RequestMapping(value="/getallschedules",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Schedule> getAllSchedule()
    {
		return scheduleBo.getAllSchedules();
		
	}
	
//	@RequestMapping(value="/getshipbyscheduleid/{scheduleid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
//    public Ship getShipByScheduleId(@PathVariable("scheduleid") int scheduleid)
//    {
//		return shipBo.getShipByScheduleId(scheduleid);
//			
//		
//    }
//	@RequestMapping(value="/getshipbyrouteid/{routeid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
//    public Ship getShipByRouteId(@RequestBody Route r)
//    {
//		return shipBo.getShipByRouteId(r);
//			
//		
//    }
//	
	
	@RequestMapping(value="/getallships",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Ship> getAllShips()
    {
		return shipBo.getAllShips();
		
		
    }
	
	
	@RequestMapping(value="/getshipbyrouteid/{routeid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Ship> getShipByRouteId(@PathVariable("routeid")int routeid)
    {
		return shipBo.getShipByRouteId(routeid);
			
		
    }
	
	
	
	
//	@RequestMapping(value="/getshipbyrouteid/{routeid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
//	public List getShipByRouteId(@PathVariable("routeid") int routeid)
//	{   System.out.println(routeid);
//		 return getShipByRouteId(routeid);
//	}
}
	
	
	
























	
	
//	@RequestMapping(value="/deleteuser/{emailid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
//    public void deleteUser(@PathVariable("emailid")String emailid)
//    {
//		userBo.deleteUser(emailid);
//		
//		}
//	
//	
//
//	@RequestMapping(value="/cancelticket/{emailid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
//    public void deleteUser(@PathVariable("emailid")String emailid)
//    {
//		userBo.deleteUser(emailid);
//		
//		}
//	
	
	/*
	@RequestMapping(value="/addpassenger",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public int addPassenger(Passenger p)
    {
		passengerBo.addPassenger(p);
		return  1;
		
    }
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public int addUser(User u)
    {
		userBo.addUser(u);
		return 1;
		
    }
	
	
	
	@RequestMapping(value="/edituser", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void editUser(User u)
	{
		 userBo.editUser(u);
	}
	
	@RequestMapping(value="/getuserbyemailid", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public User getByEmailId(String emailid)
	{
		return userBo.getUserByEmailId(emailid);
	}
	
	
	@RequestMapping(value="/deletepassenger",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public void deletePassenger(int pid)
    {
		passengerBo.deletePassenger(pid);
	
    }
	
	@RequestMapping(value="/editpasseneger",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    public void editPassenger(Passenger p)
    {
		passengerBo.editPassenger(p);
		
    }
	*/
	
	
	

