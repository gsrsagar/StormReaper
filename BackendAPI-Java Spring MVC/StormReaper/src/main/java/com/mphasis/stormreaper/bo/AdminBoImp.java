package com.mphasis.stormreaper.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.stormreaper.dao.AdminDao;
import com.mphasis.stormreaper.entities.Admin;



@Service
public class AdminBoImp implements AdminBo {

	@Autowired
	 AdminDao adminDao;
	
	

	public void removeAdmin(int aid) {
		  adminDao.removeAdmin(aid);

	}

	
	public Admin getAdminById(int aid) {
		
		return adminDao.getAdminById(aid);
	}

	public void addAdmin(Admin a) {
		 Admin admin=a;
		 try { 
			 if( admin.getAdminpassword().matches("[a-zA-Z0-9]{8,}"))
			 {
				 adminDao.addAdmin(a);
			 }
		 else
			 throw new Exception("invalid Credentials");
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
//			return 1;
	}


	public Admin loginAdmin(int aid, String adminpassword) {
		Admin admin=null;
		try {if( adminpassword.matches("[a-zA-Z0-9]{8,}"))
			admin=adminDao.loginAdmin(aid, adminpassword);
		else	
	    throw new Exception("invalid pattern");
		}
			 catch (Exception e) {
				e.printStackTrace();
			}
		return admin;	
	}

	
}
