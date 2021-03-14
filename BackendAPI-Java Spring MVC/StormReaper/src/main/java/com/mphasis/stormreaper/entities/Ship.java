package com.mphasis.stormreaper.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.engine.internal.Cascade;

@Entity(name="ShipProjectShip")
@Table(name="ShipProjectShip")
public class Ship implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int shipid;
	@Column(nullable=false,unique=true)
	private String shipname;
	@Column(nullable=false)
	private String source;
	@Override
	public String toString() {
		return "Ship [shipid=" + shipid + ", shipname=" + shipname + ", source=" + source + ", destination="
				+ destination + ", travelduration=" + travelduration + ", seatingcapacity=" + seatingcapacity
				+ ", reservationcapacityregular=" + reservationcapacityregular + ", reservationcapacityworkload="
				+ reservationcapacityworkload + "]";
	}

	@Column(nullable=false)
	private String destination;
	@Column(nullable=false)
	private String travelduration;
	@Column(nullable=false)
	private int seatingcapacity;
	@Column(nullable=false)
	private int reservationcapacityregular;
	@Column(nullable=false)
	private int reservationcapacityworkload;
	
	 @OneToOne
	 @JoinColumn(name="schedule_id",nullable=false)
	 private Schedule schedule;
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	private Route route;
	

	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="route_id",nullable=false)
	private Route route;

	public int getShipid() {
		return shipid;
	}

	public void setShipid(int shipid) {
		this.shipid = shipid;
	}

	public String getShipname() {
		return shipname;
	}

	public void setShipname(String shipname) {
		this.shipname = shipname;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTravelduration() {
		return travelduration;
	}

	public void setTravelduration(String travelduration) {
		this.travelduration = travelduration;
	}

	public int getSeatingcapacity() {
		return seatingcapacity;
	}

	public void setSeatingcapacity(int seatingcapacity) {
		this.seatingcapacity = seatingcapacity;
	}

	public int getReservationcapacityregular() {
		return reservationcapacityregular;
	}

	public void setReservationcapacityregular(int reservationcapacityregular) {
		this.reservationcapacityregular = reservationcapacityregular;
	}

	public int getReservationcapacityworkload() {
		return reservationcapacityworkload;
	}

	public void setReservationcapacityworkload(int reservationcapacityworkload) {
		this.reservationcapacityworkload = reservationcapacityworkload;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}



	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}



	

	
	
}
