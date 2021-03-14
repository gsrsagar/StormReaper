package com.mphasis.stormreaper.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.stormreaper.dao.ShipDao;
import com.mphasis.stormreaper.entities.Route;
import com.mphasis.stormreaper.entities.Ship;


@Service
public class ShipBoImp implements ShipBo {
  
	 @Autowired
	 ShipDao shipDao;
	
	
	public int addShip(Ship sh) {
		
		shipDao.addShip(sh);
		return 1;
		
	}

	public void deleteShip(int shipid) {
		shipDao.deleteShip(shipid);
   
	}

	public void editShip(Ship sh) {
		
      shipDao.editShip(sh);
	}

	public Ship getShipById(int shipid) {
		
		
		return shipDao.getShipById(shipid);
	}

	public List getShipbyName(String shipname) {
		
		return shipDao.getShipByName(shipname);
	}
	
	public List<Ship> getAllShips()
	{
		return shipDao.getAllShips();
	}

	public List<Ship> getShipByRouteId(int routeid) {
		return shipDao.getShipByRouteId(routeid);
		
	}
	

}
