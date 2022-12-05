package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Repository.AdminRepository;
import com.spring.model.Admin;
import com.spring.model.User;

@Service
public class Adminservice {

	@Autowired
	private AdminRepository arepo;
	
	public boolean adminlogin(Admin admin)
	{
		List<Admin> admins = arepo.findAll();
		boolean result=false;
		
		if(admins.size()==0)
		{
			arepo.save(admin);
			return true;
		}
		else
		{
			for(Admin a:admins)
			{
				if((a.getUsername().equalsIgnoreCase(admin.getUsername())) && (a.getPassword().equalsIgnoreCase(admin.getPassword())))
				{
					result = true;
				}
			}
			if(result)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public void changepassword(String password)
	{
		List<Admin> admin = arepo.findAll();
		for(Admin a:admin)
		{
			a.setPassword(password);
			arepo.save(a);
		}
		
	}
	
}
