package com.mphasis.stormreaper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.stormreaper.bo.AdminBo;
import com.mphasis.stormreaper.bo.PassengerBo;
import com.mphasis.stormreaper.bo.RouteBo;
import com.mphasis.stormreaper.bo.ScheduleBo;
import com.mphasis.stormreaper.bo.ShipBo;
import com.mphasis.stormreaper.entities.Admin;
import com.mphasis.stormreaper.entities.Passenger;
import com.mphasis.stormreaper.entities.Route;
import com.mphasis.stormreaper.entities.Schedule;
import com.mphasis.stormreaper.entities.Ship;
import com.mphasis.stormreaper.entities.User;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminBo adminBo; 
	
	@Autowired
	PassengerBo passengerBo;    
	
	@Autowired
	RouteBo routeBo;
	
	@Autowired
	ScheduleBo scheduleBo;
	
	@Autowired
	ShipBo shipBo; 
	
	@RequestMapping(value="/addroute",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public int addRoute(@RequestBody Route r)
    {
		routeBo.addRoute(r);
		return 1;
		
    }
	
	@RequestMapping(value="/deleteroutebyid/{routeid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public void deleteRoute(@PathVariable("routeid") int routeid)
    {
		routeBo.deleteRoute(routeid);
	
		
    }
	@RequestMapping(value="/updateroute",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	  public  void updateRoute(@RequestBody Route r)
	  {
			routeBo.editRoute(r);
		
		   
		  }
	
	
	@RequestMapping(value="/getallroutes",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Route> getAllRoutes()
    {
		return routeBo.getAllRoutes();
		
	}
	
	@RequestMapping(value="/getroutebyid/{routeid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Route getRouteById(@PathVariable("routeid") int routeid)
    {
		return routeBo.getRouteById(routeid);
			
		
    }
	
	
	@RequestMapping(value="/addadmin",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addAdmin(@RequestBody Admin a)
	{
		 adminBo.addAdmin(a);
	
	}
	
	@RequestMapping(value="/deleteadmin/{aid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeAdmin(@PathVariable("aid")int  aid )
	{
		 adminBo.removeAdmin(aid);
	}
	
	@RequestMapping(value="/getadmin/{aid}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Admin getAdminById(@PathVariable("aid")int aid)
	{ 
		 return adminBo.getAdminById(aid);
	}
	
	@RequestMapping(value="/addschedule",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public void addSchedule(@RequestBody Schedule s)
    {
		scheduleBo.addSchedule(s);
		
		
    }
	
	@RequestMapping(value="/deleteschedule/{scheduleid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public void deleteSchedule(@PathVariable("scheduleid")int scheduleid)
    {
		scheduleBo.deleteSchedule(scheduleid);
	
		
    }
	@RequestMapping(value="/updateschedule",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	  public    void  updateSchedule(@RequestBody Schedule s)
	  {
		
					scheduleBo.editSchedule(s);
		
		   
		  }
	

	@RequestMapping(value="/getallschedules",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Schedule> getAllSchedule()
    {
		return scheduleBo.getAllSchedules();
		
	}
	
	@RequestMapping(value="/getschedulebyid/{scheduleid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Schedule getScheduleById(@PathVariable("scheduleid")int scheduleid)
    {
		return scheduleBo.getScheduleById(scheduleid);
			
		
    }
	
	
	@RequestMapping(value="/addship",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public int addShip(@RequestBody Ship s)
    {
		shipBo.addShip(s);
		return 1;
		
    }
	
	@RequestMapping(value="/deleteship/{shipid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public void deleteShip(@PathVariable("shipid")int shipid)
    {
		shipBo.deleteShip(shipid);
	
		
    }
	@RequestMapping(value="/updateship",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	  public void  updateSchedule(@RequestBody  Ship s)
	  {
		 	
			shipBo.editShip(s);
	
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
	
		
	@RequestMapping(value="/getallships",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Ship> getAllShips()
    {
		return shipBo.getAllShips();
		
		
    }
	
	@RequestMapping(value="/getpassengerbyid/{pid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Passenger getpassengerById(@PathVariable("pid")String pid)
    {
		return passengerBo.getPassengerById(pid);
			
   }
	@RequestMapping(value="/getallpassengers",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Passenger> getAllPassengers()
    {
		return passengerBo.getAllPassengers();
		
		
    }
	
	
	
	@RequestMapping(value="/adminlogin/{aid}/{adminpassword}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean adduser(@PathVariable ("aid") int aid, @PathVariable("adminpassword") String adminpassword )
	{
		Admin a1= adminBo.loginAdmin(aid, adminpassword);
		return true;
	}
	
	}
	
	

	
	
	
	
	
	

