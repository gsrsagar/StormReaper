package com.mphasis.stormreaper.bo;

import com.mphasis.stormreaper.entities.Admin;

public interface AdminBo {
	
	public  void addAdmin(Admin a);
	public void removeAdmin(int  aid);
	public Admin getAdminById(int aid);
	public Admin  loginAdmin(int aid, String adminpassword);

}
