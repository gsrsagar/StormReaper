package com.mphasis.stormreaper.entities;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity(name="ShipAdmin")
@Table(name="ShipAdmin")
public class Admin  implements Serializable{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
  private  int aid;
  @Column(nullable=false)
  private String adminname;
  @Column(nullable=false)
  private String adminpassword;


  
  public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAdminname() {
	return adminname;
}
public void setAdminname(String adminname) {
	this.adminname = adminname;
}

public String getAdminpassword() {
	return adminpassword;
}
public void setAdminpassword(String adminpassword) {
	this.adminpassword = adminpassword;
}

  
 
  
  
  
  
}
