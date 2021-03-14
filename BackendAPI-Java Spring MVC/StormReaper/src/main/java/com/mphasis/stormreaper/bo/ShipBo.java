package com.mphasis.stormreaper.bo;

import java.util.List;

import com.mphasis.stormreaper.entities.Route;
import com.mphasis.stormreaper.entities.Ship;
import com.mphasis.stormreaper.entities.User;

public interface ShipBo {   
  	public int addShip(Ship sh);
  	public void deleteShip(int shipid);
  	public void editShip(Ship sh);
  	public Ship getShipById(int shipid);
  	public List getShipbyName(String shipname);
  	public List<Ship> getAllShips();
	public List<Ship> getShipByRouteId(int routeid); 

}
