package com.mphasis.stormreaper.entities;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="ShipSchedule")
@Table(name="ShipSchedule")
public class Schedule  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int scheduleid;
    @Column(nullable=false)
	private String arrivaldetails;
    @Column(nullable=false)
	private String departuredetails;
	
//	@OneToOne
//	@JoinColumn(name="ship_id",nullable=false)
//	private Ship ship;
	
//	public Ship getShip() {
//		return ship;
//	}
//	public void setShip(Ship ship) {
//		this.ship = ship;
//	}
	
	public int getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(int scheduleid) {
		this.scheduleid = scheduleid;
	}
	public String getArrivaldetails() {
		return arrivaldetails;
	}
	public void setArrivaldetails(String arrivaldetails) {
		this.arrivaldetails = arrivaldetails;
	}
	public String getDeparturedetails() {
		return departuredetails;
	}
	public void setDeparturedetails(String departuredetails) {
		this.departuredetails = departuredetails;
	}
	
	
	
	
	

}
