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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="ShipRoute")
@Table(name="ShipRoute")
public class Route  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int routeid;
    @Column(nullable=false)
	private  String source;
    @Column(nullable=false)
	private String destination;
    @Column(nullable=false)
	private int distance;
    @Column(nullable=false)
	private String duration;
    @Column(nullable=false)
	private int costperkm;
  
//  @OneToMany(mappedBy="route")
//  private List<Ship> ships;
  
  
  @OneToMany(mappedBy="route", cascade=CascadeType.ALL,fetch=FetchType.LAZY )
  @Column(nullable=false)
  @JsonIgnore
  private List<Ship> ships;
  
  
public List<Ship> getShips() {
	return ships;
}

public void setShips(List<Ship> ships) {
	this.ships = ships;
}

public int getRouteid() {
	return routeid;
}

public void setRouteid(int routeid) {
	this.routeid = routeid;
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

public int getDistance() {
	return distance;
}

public void setDistance(int distance) {
	this.distance = distance;
}

public String getDuration() {
	return duration;
}

public void setDuration(String duration) {
	this.duration = duration;
}

public int getCostperkm() {
	return costperkm;
}

public void setCostperkm(int costperkm) {
	this.costperkm = costperkm;
}



  
  
  
  
}
