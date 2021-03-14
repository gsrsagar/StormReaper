package com.mphasis.stormreaper.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="ShipUser")
@Table(name="ShipUser")
public class User implements Serializable {
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
  private String emailid;
  @Column(nullable=false)
  private String name;
  @Column(nullable=false)
  private String gender;
  @Column(nullable=false)
  private String presentaddress;
  @Column(nullable=false)
  private String permanentaddress;
  @Column(length=10,nullable=false)
  private long mobileno;
  @Column(nullable=false)
  private String password;
  
  
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

public long getMobileno() {
	return mobileno;
}
public void setMobileno(long mobileno) {
	this.mobileno = mobileno;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getPresentaddress() {
	return presentaddress;
}
public void setPresentaddress(String presentaddress) {
	this.presentaddress = presentaddress;
}
public String getPermanentaddress() {
	return permanentaddress;
}
public void setPermanentaddress(String permanentaddress) {
	this.permanentaddress = permanentaddress;
}



//  @OneToMany(mappedBy="user")
//   private List<Passenger> passengers;

  
  
 
  
}
