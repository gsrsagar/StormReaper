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
import org.hibernate.annotations.Parameter;

import com.mphasis.stormreaper.util.StringPrefixedSequenceIdGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="ShipTicket")
@Table(name="ShipTicket")
public class Ticket  implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
    @Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ship_seq")
    @GenericGenerator(
             name = "ship_seq",
             strategy = "com.mphasis.stormreaper.util.StringPrefixedSequenceIdGenerator",
             parameters = {
                       @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                       @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SR00"),
                       @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")})
    
    private String ticketno;
    @OneToOne
    @JoinColumn(name="passenger_id",nullable=false)
    private Passenger passenger;
    @Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int seat_no;
	 @Column(nullable=false)
    private String paymenttype;
	
	 
    @Column(nullable=false)
    private String journeydate;
    @OneToOne
    @JoinColumn(name="schedule_id",nullable=false)
    private Schedule schedule;
    @Column(nullable=false)
	 private long ticketcost;
	 
	public String getTicketno() {
		return ticketno;
	}
	public void setTicketno(String ticketno) {
		this.ticketno = ticketno;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public String getJourneydate() {
		return journeydate;
	}
	public void setJourneydate(String journeydate) {
		this.journeydate = journeydate;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public long getTicketcost() {
		return ticketcost;
	}
	public void setTicketcost(long ticketcost) {
		this.ticketcost = ticketcost;
	}
	

}
    
    
	