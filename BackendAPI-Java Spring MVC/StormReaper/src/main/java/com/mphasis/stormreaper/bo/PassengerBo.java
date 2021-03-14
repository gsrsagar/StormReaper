package com.mphasis.stormreaper.bo;

import java.util.List;

import com.mphasis.stormreaper.entities.Passenger;
import com.mphasis.stormreaper.entities.User;

public interface PassengerBo {
	public List addPassenger(Passenger p);
	public void deletePassenger(String id);
	public void editPassenger(Passenger p);
	public Passenger getPassengerById(String id);
	public List<Passenger> getAllPassengers();
}
