package com.mphasis.stormreaper.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.stormreaper.util.StringPrefixedSequenceIdGenerator;

@Entity(name="ShipPassenger")
@Table(name="ShipPassenger")
public class Passenger implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ship_seq")
    @GenericGenerator(
             name = "ship_seq",
             strategy = "com.mphasis.stormreaper.util.StringPrefixedSequenceIdGenerator",
             parameters = {
                       @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                       @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "1000"),
                       @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")})
	private  String pid;
	 @Column(nullable=false)
	private String pname;
	 @Column(nullable=false)
	private int age;
	 @Column(nullable=false)
	private String gender;
	 @Column(insertable=false,columnDefinition="date default sysdate")
	private String bookingdate;
	 @Column(length=10,nullable=false,unique=true)
	 private long contactno;
	public long getContactno() {
		return contactno;
	}

	public void setContactno(long contactno) {
		this.contactno = contactno;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ship_id",nullable=false) 
	private Ship ship;
	 
   

	



	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}

	
	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	
	

}
